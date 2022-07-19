/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.authors;
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
public class DAOauthors extends ConnectDB {

    public int addAuthor(authors au) {
        int n = 0;
        String sql = "INSERT INTO [authors]"
                + "           ([au_id]"
                + "           ,[au_lname]"
                + "           ,[au_fname]"
                + "           ,[phone]"
                + "           ,[address]"
                + "           ,[city]"
                + "           ,[state]"
                + "           ,[zip]"
                + "           ,[contract])"
                + "     VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, au.getAu_id());
            pre.setString(2, au.getAu_lname());
            pre.setString(3, au.getAu_fname());
            pre.setString(4, au.getPhone());
            pre.setString(5, au.getAddress());
            pre.setString(6, au.getCity());
            pre.setString(7, au.getState());
            pre.setString(8, au.getZip());
            pre.setInt(9, au.getContract());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int updateAuthor(authors au) {
        int n = 0;
        String sql = "update authors set"
                + "[au_lname]=?"
                + ",[au_fname]=?"
                + ",[phone]=?"
                + ",[address]=?"
                + ",[city]=?"
                + ",[state]=?"
                + ",[zip]=?"
                + ",[contract]=?"
                + " where [au_id] = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, au.getAu_lname());
            pre.setString(2, au.getAu_fname());
            pre.setString(3, au.getPhone());
            pre.setString(4, au.getAddress());
            pre.setString(5, au.getCity());
            pre.setString(6, au.getState());
            pre.setString(7, au.getZip());
            pre.setInt(8, au.getContract());
            pre.setString(9, au.getAu_id());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int removeAuthor(String id) {
        int n = 0;
        String sql = "delete from authors where [au_id]=" + "'" + id + "'";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return n;
    }

    public Vector<authors> viewAll() {
        String sql = "select * from authors";
        ResultSet rs = getData(sql);
        Vector<authors> vector = new Vector<>();
        try {
            while (rs.next()) {
                String au_id = rs.getString(1);
                String au_lname = rs.getString(2);
                String au_fname = rs.getString(3);
                String phone = rs.getString(4);
                String address = rs.getString(5);
                String city = rs.getString(6);
                String sate = rs.getString(7);
                String zip = rs.getString(8);
                int contract = rs.getInt(9);
                authors author = new authors(au_id, au_lname, au_fname, phone, address, city, sate, zip, contract);
                vector.add(author);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public Vector<authors> searchName(String name) {
        Vector<authors> vector = new Vector<>();
        String sql = "select * from authors where au_lname like '%" + name + "%'";
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                String au_id = rs.getString(1);
                String au_lname = rs.getString(2);
                String au_fname = rs.getString(3);
                String phone = rs.getString(4);
                String address = rs.getString(5);
                String city = rs.getString(6);
                String sate = rs.getString(7);
                String zip = rs.getString(8);
                int contract = rs.getInt(9);
                authors author = new authors(au_id, au_lname, au_fname, phone, address, city, sate, zip, contract);
                vector.add(author);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }
}
