/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.pub_info;
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
public class DAOpub_info extends ConnectDB {

    public int addPub_info(pub_info pub) {
        int n = 0;
        String sql = "INSERT INTO [pub_info]"
                + "           ([pub_id]"
                //+ "           ,[logo]"
                + "           ,[pr_info])"
                + "     VALUES(?,?)";
                //+ "     VALUES(?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, pub.getPub_id());
            //pre.setString(2, pub.getLogo());
            pre.setString(2, pub.getPr_info());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int updatePub_info(pub_info pu) {
        int n = 0;
        String sql = "update pub_info set "
                //+ "            [logo]=?"
                + "           [pr_info]=?"
                + " where pub_id=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            //pre.setString(1, pu.getLogo());
            pre.setString(1, pu.getPr_info());
            pre.setString(2, pu.getPub_id());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int removepub_info(String id) {
        int n = 0;
        String sql = "delete from pub_info where pub_id = '" + id + "'";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public Vector<pub_info> viewAll() {
        Vector<pub_info> vector = new Vector<>();
        String slq = "select * from pub_info";
        ResultSet rs = getData(slq);
        try {
            while (rs.next()) {
                String pub_id = rs.getString(1);
                String logo = rs.getString("logo");
                String pr_info = rs.getString(3);
                pub_info ps = new pub_info(pub_id, logo, pr_info);
                vector.add(ps);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public Vector<pub_info> searchIdPub(String id) {
        Vector<pub_info> vector = new Vector<>();
        String sql = "select * from pub_info where pub_id like '%" + id + "%'";
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                String pub_id = rs.getString(1);
                String logo = rs.getString("logo");
                String pr_info = rs.getString(3);
                pub_info ps = new pub_info(pub_id, logo, pr_info);
                vector.add(ps);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

}
