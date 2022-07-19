/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.sales;
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
public class DAOsales extends ConnectDB {

    public int addSales(sales sal) {
        int n = 0;
        String sql = "INSERT INTO [sales]"
                + "           ([stor_id]"
                + "           ,[ord_num]"
                + "           ,[ord_date]"
                + "           ,[qty]"
                + "           ,[payterms]"
                + "           ,[title_id])"
                + "           ,[status]"
                + "     VALUES(?,?,?,?,?,?,?)";
        PreparedStatement pre;
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, sal.getStor_id());
            pre.setString(2, sal.getOrd_num());
            pre.setString(3, sal.getOrd_date());
            pre.setInt(4, sal.getQty());
            pre.setString(5, sal.getPayterms());
            pre.setString(6, sal.getTitle_id());
            pre.setInt(7, sal.getStatus());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int updateSales(sales sal) {
        int n = 0;
        String sql = "update sales set "
                + "            [ord_date]=?"
                + "           ,[qty]=?"
                + "           ,[payterms]=?"
                + "           ,[status]=? "
                + " where [stor_id]=? and [ord_num]=? and [title_id]=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, sal.getOrd_date());
            pre.setInt(2, sal.getQty());
            pre.setString(3, sal.getPayterms());
            pre.setInt(4, sal.getStatus());
            pre.setString(5, sal.getStor_id());
            pre.setString(6, sal.getOrd_num());
            pre.setString(7, sal.getTitle_id());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int deleteSales(String id) {
        int n = 0;
        String sql = "delete from sales where stor_id ='" + id + "'";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public Vector<sales> viewAll() {
        Vector<sales> vector = new Vector<>();
        String sql = "select * from sales";
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                String stor_id = rs.getString(1);
                String ord_num = rs.getString(2);
                String ord_dat = rs.getString(3);
                int qty = rs.getInt(4);
                String payterms = rs.getString(5);
                String title_id = rs.getString(6);
                int status = rs.getInt(7);
                sales sal = new sales(stor_id, ord_num, ord_dat, qty, payterms, title_id,status);
                vector.add(sal);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public Vector<sales> searchStoID(String id) {
        Vector<sales> vector = new Vector<>();
        String sql = "select * from sales where stor_id ='" + id + "'";
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                String stor_id = rs.getString(1);
                String ord_num = rs.getString(2);
                String ord_dat = rs.getString(3);
                int qty = rs.getInt(4);
                String payterms = rs.getString(5);
                String title_id = rs.getString(6);
                int status = rs.getInt(7);
                sales sal = new sales(stor_id, ord_num, ord_dat, qty, payterms, title_id,status);
                vector.add(sal);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public Vector<String> SaleDetail() {
        Vector<String> vector = new Vector<>();
        String sql = "select * from sales sal inner join stores sto \n"
                + "on sal.stor_id = sto.stor_id inner join titles tile\n"
                + "on sal.title_id = tile.title_id inner join publishers pu\n"
                + "on pu.pub_id = tile.pub_id inner join titleauthor tileau \n"
                + "on tile.title_id = tileau.title_id inner join authors au\n"
                + "on au.au_id = tileau.au_id";
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                String stor_id = rs.getString(1);
                String ord_num = rs.getString(2);
                String ord_date = rs.getString(3);
                String qty = rs.getString(4);
                String stor_name = rs.getString(8);
                String stor_address = rs.getString(9);

                String title_name = rs.getString(14);
                String type = rs.getString(15);
                String price = rs.getString(17);
                String advance = rs.getString(18);

                String pubdate = rs.getString(22);
                String pubname = rs.getString(24);

                String au_id = rs.getString(28);

                String result = "" + stor_id + "\t" + ord_num + "\t" + ord_date + "\t" + qty + "\t" + stor_name + "\t" + stor_address + "\t" + title_name + "\t" + type + "\t" + price + "\t" + advance + "\t" + pubdate + "\t" + pubname;
                vector.add(result);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;

    }
}
