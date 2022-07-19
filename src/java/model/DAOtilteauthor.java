/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.tileauthor;
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
public class DAOtilteauthor extends ConnectDB {

    public int addTileAuthor(tileauthor tilau) {
        int n = 0;
        String sql = "INSERT INTO [titleauthor]"
                + "           ([au_id]"
                + "           ,[title_id]"
                + "           ,[au_ord]"
                + "           ,[royaltyper])"
                + "     VALUES(?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, tilau.getAu_id());
            pre.setString(2, tilau.getTitle_id());
            pre.setInt(3, tilau.getAu_rod());
            pre.setInt(4, tilau.getRoyltyper());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return n;
    }

    public int updateTileAuthor(tileauthor tilau) {
        int n = 0;
        String sql = "update titleauthor set "
                + "            [au_ord]=?"
                + "           ,[royaltyper]=?"
                + " where au_id =? and title_id =?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, tilau.getAu_rod());
            pre.setInt(2, tilau.getRoyltyper());
            pre.setString(3, tilau.getAu_id());
            pre.setString(4, tilau.getTitle_id());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int deleteTileAu(String idAuthor, String idTile) {
        int n = 0;
        String sql = "delete from titleauthor where au_id ='" + idAuthor + "'" + " and " + "title_id ='" + idTile + "'";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public Vector<tileauthor> viewAll() {
        Vector<tileauthor> vector = new Vector<>();
        String sql = "select * from titleauthor";
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                String au_id = rs.getString(1);
                String title_id = rs.getString(2);
                int au_ord = rs.getInt(3);
                int royaltyper = rs.getInt(4);
                tileauthor obj = new tileauthor(au_id, title_id, au_ord, royaltyper);
                vector.add(obj);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public Vector<tileauthor> searchIDAu(String IDAu) {
        Vector<tileauthor> vector = new Vector<tileauthor>();
        String sql = "select * from titleauthor where au_id like '%" + IDAu + "%'";
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                String au_id = rs.getString(1);
                String title_id = rs.getString(2);
                int au_ord = rs.getInt(3);
                int royaltyper = rs.getInt(4);
                tileauthor obj = new tileauthor(au_id, title_id, au_ord, royaltyper);
                vector.add(obj);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

}
