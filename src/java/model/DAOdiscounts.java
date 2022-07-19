/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.discounts;
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
public class DAOdiscounts extends ConnectDB {

    public int addDiscounts(discounts dis) {
        int n = 0;
        String sql = "INSERT INTO [discounts]"
                + "           ([discounttype]"
                + "           ,[stor_id]"
                + "           ,[lowqty]"
                + "           ,[highqty]"
                + "           ,[discount])"
                + "     VALUES(?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, dis.getDiscounttype());
            pre.setString(2, dis.getStor_id());
            pre.setInt(3, dis.getLowqty());
            pre.setInt(4, dis.getHighqty());
            pre.setDouble(5, dis.getDiscount());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int updateDiscount(discounts dis) {
        int n = 0;
        String sql = "update discounts set "
                + " [discounttype]=?"
                + " ,[lowqty]=?"
                + " ,[highqty]=?"
                + " ,[discount]=?"
                + " where [stor_id]=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, dis.getDiscounttype());
            pre.setInt(2, dis.getLowqty());
            pre.setInt(3, dis.getHighqty());
            pre.setDouble(4, dis.getDiscount());
            pre.setString(5, dis.getStor_id());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int removeDicount(String id) {
        int n = 0;
        String sql = "delete from discounts where stor_id like '%" + id + "%'";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public Vector<discounts> viewAll() {
        Vector<discounts> vector  = new Vector<>();
        String sql = "select * from discounts";
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                String discounttype = rs.getString(1);
                String stor_id = rs.getString(2);
                int lowqty = rs.getInt(3);
                int highqty = rs.getInt(4);
                double discount = rs.getDouble(5);
                discounts dis = new discounts(discounttype, stor_id, lowqty, highqty, discount);
                vector.add(dis);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public Vector<discounts> searchDicount(double k) {
        Vector<discounts> vector = new Vector<>();
        String sql = "select * from discounts where discount  = " + k;
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {

                String discounttype = rs.getString(1);
                String stor_id = rs.getString(2);
                int lowqty = rs.getInt(3);
                int highqty = rs.getInt(4);
                double discount = rs.getDouble(5);
                discounts dis = new discounts(discounttype, stor_id, lowqty, highqty, discount);
                vector.add(dis);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }
}
