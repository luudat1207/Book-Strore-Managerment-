/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.tiltes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.security.rsa.RSACore;

/**
 *
 * @author ptuan
 */
public class DAOtiltes extends ConnectDB {

    public int addTiles(tiltes til) {
        int n = 0;
        String sql = "INSERT INTO [titles]"
                + "           ([title_id]"
                + "           ,[title]"
                + "           ,[type]"
                + "           ,[pub_id]"
                + "           ,[price]"
                + "           ,[advance]"
                + "           ,[royalty]"
                + "           ,[ytd_sales]"
                + "           ,[notes]"
                + "           ,[pubdate]"
                + "            ,[image])"
                + "     VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, til.getTitle_id());
            pre.setString(2, til.getTitle());
            pre.setString(3, til.getType());
            pre.setString(4, til.getPub_id());
            pre.setDouble(5, til.getPrice());
            pre.setDouble(6, til.getAdvance());
            pre.setInt(7, til.getRoyalty());
            pre.setInt(8, til.getYtd_sales());
            pre.setString(9, til.getNotes());
            pre.setString(10, til.getPubdate());
            pre.setString(11, til.getImage());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public Vector<tiltes> seachPrice(double from, double to) {
        Vector<tiltes> vector = new Vector<>();
        String sql = "select * from titles where price between " + from + " and " + to;
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {

                String tile_id = rs.getString("title_id"); // rs.getString(1);
                String title = rs.getString(2);
                String type = rs.getString(3);
                String pub_id = rs.getString(4);
                double pricers = rs.getDouble("price");
                double advance = rs.getDouble(6);
                int royalty = rs.getInt("royalty");
                int ytd_sales = rs.getInt(8);
                String notes = rs.getString(9);
                String pubdate = rs.getString(10);
                String image = rs.getString(11);
                tiltes obj = new tiltes(tile_id, title, type, pub_id, pricers, advance, royalty, ytd_sales, notes, pubdate,image);
                vector.add(obj);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public Vector<tiltes> searchName(String titleNAme) {
        Vector<tiltes> vector = new Vector<tiltes>();
        String sql = "Select * from titles where title like '%" + titleNAme + "%'";
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                //Tu tren xuong duoi
                //dataType varName = rs.getDataType(fileNAme,index = 1);
                String tile_id = rs.getString("title_id"); // rs.getString(1);
                String title = rs.getString(2);
                String type = rs.getString(3);
                String pub_id = rs.getString(4);
                double pricers = rs.getDouble("price");
                double advance = rs.getDouble(6);
                int royalty = rs.getInt("royalty");
                int ytd_sales = rs.getInt(8);
                String notes = rs.getString(9);
                String pubdate = rs.getString(10);
                String image = rs.getString(11);
                tiltes obj = new tiltes(tile_id, title, type, pub_id, pricers, advance, royalty, ytd_sales, notes, pubdate,image);
                vector.add(obj);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public Vector<tiltes> viewAllTiles() {
        Vector vector = new Vector<>();
        String sql = "Select * from titles";
        try {
//            Statement state1 = conn.createStatement();
//            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
//                    ResultSet.CONCUR_UPDATABLE);
//            //Concur_Updatetable: co kha nang sua du lieu (chuan 4)
//            //Type_Forward_Only
//            //Type_Scroll_Sensitive : Thread safe(chuan 4)
//            //Type_Scroll_InSensitive;
//            ResultSet rs = state.executeQuery(sql);
            ResultSet rs = getData(sql);
            while (rs.next()) {
                //Tu tren xuong duoi
                //dataType varName = rs.getDataType(fileNAme,index = 1);
                String tile_id = rs.getString("title_id"); // rs.getString(1);
                String title = rs.getString(2);
                String type = rs.getString(3);
                String pub_id = rs.getString(4);
                double pricers = rs.getDouble("price");
                double advance = rs.getDouble(6);
                int royalty = rs.getInt("royalty");
                int ytd_sales = rs.getInt(8);
                String notes = rs.getString(9);
                String pubdate = rs.getString(10);
               String image = rs.getString(11);
                tiltes obj = new tiltes(tile_id, title, type, pub_id, pricers, advance, royalty, ytd_sales, notes, pubdate,image);
                vector.add(obj);
            }
//            while (rs.previous()){
//                //Tu duoi len tren
//            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public int updateTitle(tiltes til) {
        int n = 0;
        String sql = "update titles set "
                + "            [title]=?"
                + "           ,[type]=?"
                + "           ,[pub_id]=?"
                + "           ,[price]=?"
                + "           ,[advance]=?"
                + "           ,[royalty]=?"
                + "           ,[ytd_sales]=?"
                + "           ,[notes]=?"
                + "           ,[pubdate]=?"
                + "           ,[image] =?"
                + " where [title_id] =?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, til.getTitle());
            pre.setString(2, til.getType());
            pre.setString(3, til.getPub_id());
            pre.setDouble(4, til.getPrice());
            pre.setDouble(5, til.getAdvance());
            pre.setInt(6, til.getRoyalty());
            pre.setInt(7, til.getYtd_sales());
            pre.setString(8, til.getNotes());
            pre.setString(9, til.getPubdate());
            pre.setString(10, til.getImage());
            pre.setString(11, til.getTitle_id());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return n;
    }

    public int deleteTile(String id) {
        int n = 0;
        String sql = "delete from titles where title_id = '" + id + "'";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
}
