/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.sun.corba.se.spi.orbutil.fsm.FSMTest;
import entity.pub_info;
import entity.publishers;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ptuan
 */
public class DAOpublishers extends ConnectDB {

    public int addPublicsher(publishers publ) {
        int n = 0;
        String sql = "INSERT INTO [publishers]"
                + "           ([pub_id]"
                + "           ,[pub_name]"
                + "           ,[city]"
                + "           ,[state]"
                + "           ,[country]"
                + "            ,[image])"
                + "     VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, publ.getPub_id());
            pre.setString(2, publ.getPub_name());
            pre.setString(3, publ.getCity());
            pre.setString(4, publ.getState());
            pre.setString(5, publ.getCountry());
            pre.setString(6, publ.getImage());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int updatePublisher(publishers pub) {
        int n = 0;
        String sql = "update publishers set "
                + "            [pub_name]=?"
                + "           ,[city]=?"
                + "           ,[state]=?"
                + "           ,[country]=?"
                + "            ,[image] =?"
                + " where pub_id = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, pub.getPub_name());
            pre.setString(2, pub.getCity());
            pre.setString(3, pub.getState());
            pre.setString(4, pub.getCountry());
            pre.setString(5, pub.getImage());
            pre.setString(6, pub.getPub_id());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int removePublisher(String id) {
        int n = 0;
        String sql = "delete from publishers where pub_id ='" + id + "'";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return n;
    }

    public Vector<publishers> viewAll() {
        Vector<publishers> vector = new Vector<>();
        String sql = "select * from publishers";
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                String pub_id = rs.getString(1);
                String pub_name = rs.getString(2);
                String city = rs.getString(3);
                String state = rs.getString(4);
                String country = rs.getString(5);
                String image = rs.getString(6);
                publishers publ = new publishers(pub_id, pub_name, city, state, country,image);
                vector.add(publ);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public Vector<publishers> searchCity(String city) {
        Vector<publishers> vector = new Vector<>();
        String sql = "select * from publishers where city ='" + city + "'";
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                String pub_id = rs.getString(1);
                String pub_name = rs.getString(2);
                String City = rs.getString(3);
                String state = rs.getString(4);
                String country = rs.getString(5);
                String image = rs.getString(6);
                publishers publ = new publishers(pub_id, pub_name, City, state, country,image);
                vector.add(publ);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }
}
