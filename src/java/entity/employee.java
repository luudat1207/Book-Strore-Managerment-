/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author ptuan
 */
public class employee {
   private String emp_id;
   private String fname;
   private String minit;
   private String lname;
   private int job_id;
   private int job_lvl;
   private String pub_id;
   private String hire_date;

    public employee() {
    }

    @Override
    public String toString() {
        return "employee{" + "emp_id=" + emp_id + ", fname=" + fname + ", minit=" + minit + ", lname=" + lname + ", job_id=" + job_id + ", job_lvl=" + job_lvl + ", pub_id=" + pub_id + ", hire_date=" + hire_date + '}';
    }

    public employee(String emp_id, String fname, String minit, String lname, int job_id, int job_lvl, String pub_id, String hire_date) {
        this.emp_id = emp_id;
        this.fname = fname;
        this.minit = minit;
        this.lname = lname;
        this.job_id = job_id;
        this.job_lvl = job_lvl;
        this.pub_id = pub_id;
        this.hire_date = hire_date;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMinit() {
        return minit;
    }

    public void setMinit(String minit) {
        this.minit = minit;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public int getJob_lvl() {
        return job_lvl;
    }

    public void setJob_lvl(int job_lvl) {
        this.job_lvl = job_lvl;
    }

    public String getPub_id() {
        return pub_id;
    }

    public void setPub_id(String pub_id) {
        this.pub_id = pub_id;
    }

    public String getHire_date() {
        return hire_date;
    }

    public void setHire_date(String hire_date) {
        this.hire_date = hire_date;
    }
   
}
