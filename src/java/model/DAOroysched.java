/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.roysched;
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
public class DAOroysched extends ConnectDB {

    public int addRoyshed(roysched roy) {
        int n = 0;
        String sql = "INSERT INTO [roysched]"
                + "           ([title_id]"
                + "           ,[lorange]"
                + "           ,[hirange]"
                + "           ,[royalty])"
                + "     VALUES(?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, roy.getTitle_id());
            pre.setInt(2, roy.getLorange());
            pre.setInt(3, roy.getHirange());
            pre.setInt(4, roy.getRoyalty());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int updateRoyshed(roysched roy) {
        int n = 0;
        String sql = "update roysched set"
                + "            [lorange]=?"
                + "           ,[hirange]=?"
                + "           ,[royalty]=?"
                + " where [title_id] =?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, roy.getLorange());
            pre.setInt(2, roy.getHirange());
            pre.setInt(3, roy.getRoyalty());
            pre.setString(4, roy.getTitle_id());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int delete(String id) {
        int n = 0;
        String sql = "delete from roysched where title_id = '" + id + "'";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public Vector<roysched> viewAll() {
        Vector<roysched> vector = new Vector<>();
        String sql = "select * from roysched";
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                String title_id = rs.getString(1);
                int lorange = rs.getInt("lorange");
                int hirange = rs.getInt("hirange");
                int royalty = rs.getInt(4);
                roysched roy = new roysched(title_id, lorange, hirange, royalty);
                vector.add(roy);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public Vector<roysched> searchHiran(int hir) {
        Vector<roysched> vector = new Vector<>();
        String sql = "select * from roysched where hirange = " + hir;
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                String title_id = rs.getString(1);
                int lorange = rs.getInt("lorange");
                int hirange = rs.getInt("hirange");
                int royalty = rs.getInt(4);
                roysched roy = new roysched(title_id, lorange, hirange, royalty);
                vector.add(roy);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOroysched.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;

    }
}
