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
public class jobs {

    private int job_id;
    private String job_desc;
    private int min_lv;
    private int max_lv;

    public jobs() {
    }

    @Override
    public String toString() {
        return "jobs{" + "job_id=" + job_id + ", job_desc=" + job_desc + ", min_lv=" + min_lv + ", max_lv=" + max_lv + '}';
    }

    public jobs(int job_id, String job_desc, int min_lv, int max_lv) {
        this.job_id = job_id;
        this.job_desc = job_desc;
        this.min_lv = min_lv;
        this.max_lv = max_lv;
    }

    public jobs(String job_desc, int min_lv, int max_lv) {
        this.job_desc = job_desc;
        this.min_lv = min_lv;
        this.max_lv = max_lv;
    }
    

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public String getJob_desc() {
        return job_desc;
    }

    public void setJob_desc(String job_desc) {
        this.job_desc = job_desc;
    }

    public int getMin_lv() {
        return min_lv;
    }

    public void setMin_lv(int min_lv) {
        this.min_lv = min_lv;
    }

    public int getMax_lv() {
        return max_lv;
    }

    public void setMax_lv(int max_lv) {
        this.max_lv = max_lv;
    }
}
