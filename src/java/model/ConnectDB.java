package model;

import java.sql.*;

public class ConnectDB {

    public Connection conn = null;

    public ConnectDB() {
        //string connectiong: jdbc:sqlserver://localhost:1433;databaseName=SE1609
        //as know as URL
        this("jdbc:sqlserver://localhost:1433;databaseName=SE1609", "sa1", "123456");
    }

    public ConnectDB(String URL, String username, String password) {
        try {
            //  call driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //  com.microsoft.

            //  connection
            conn = DriverManager.getConnection(URL, username, password);
            System.out.println("Connected!");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ResultSet getData(String sql) {
        ResultSet rs = null;
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = state.executeQuery(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rs;
    }
    public static void main(String[] args) {
        new ConnectDB();
    }

}
