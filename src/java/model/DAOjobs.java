/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.jobs;
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
public class DAOjobs extends ConnectDB {

    public int addJobs(jobs jo) {
        int n = 0;
        String sql = "INSERT INTO [jobs]"
                + "           ([job_desc]"
                + "           ,[min_lvl]"
                + "           ,[max_lvl])"
                + "     VALUES(?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, jo.getJob_desc());
            pre.setInt(2, jo.getMin_lv());
            pre.setInt(3, jo.getMax_lv());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int updateJobs(jobs jp) {
        int n = 0;
        String sql = "update jobs set "
                + "            [job_desc]=?"
                + "           ,[min_lvl]=?"
                + "           ,[max_lvl]=?"
                + " where job_id =?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, jp.getJob_desc());
            pre.setInt(2, jp.getMin_lv());
            pre.setInt(3, jp.getMax_lv());
            pre.setInt(4, jp.getJob_id());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int removeJobs(int id) {
        int n = 0;
        String sql = "delete from jobs where job_id = '" + id + "'";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return n;
    }

    public Vector<jobs> viewAll() {
        String sql = "select * from jobs";
        Vector<jobs> vector = new Vector<>();
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                int job_id = rs.getInt(1);
                String job_desc = rs.getString("job_desc");
                int min_lvl = rs.getInt(3);
                int max_lvl = rs.getInt(4);
                jobs job = new jobs(job_id, job_desc, min_lvl, max_lvl);
                vector.add(job);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public Vector<jobs> searchId(int id) {
        Vector<jobs> vector = new Vector<>();
        String sql = "select * from jobs where job_id = " + id;
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                int job_id = rs.getInt(1);
                String job_desc = rs.getString("job_desc");
                int min_lvl = rs.getInt(3);
                int max_lvl = rs.getInt(4);
                jobs job = new jobs(job_id, job_desc, min_lvl, max_lvl);
                vector.add(job);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

}
