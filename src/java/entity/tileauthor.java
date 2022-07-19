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
public class tileauthor {
    private String au_id;
    private String title_id;
    private int au_rod;
    private int royltyper;

    public tileauthor() {
    }

    public tileauthor(String au_id, String title_id, int au_rod, int royltyper) {
        this.au_id = au_id;
        this.title_id = title_id;
        this.au_rod = au_rod;
        this.royltyper = royltyper;
    }

    public String getAu_id() {
        return au_id;
    }

    @Override
    public String toString() {
        return "tileauthor{" + "au_id=" + au_id + ", title_id=" + title_id + ", au_rod=" + au_rod + ", royltyper=" + royltyper + '}';
    }

    public void setAu_id(String au_id) {
        this.au_id = au_id;
    }

    public String getTitle_id() {
        return title_id;
    }

    public void setTitle_id(String title_id) {
        this.title_id = title_id;
    }

    public int getAu_rod() {
        return au_rod;
    }

    public void setAu_rod(int au_rod) {
        this.au_rod = au_rod;
    }

    public int getRoyltyper() {
        return royltyper;
    }

    public void setRoyltyper(int royltyper) {
        this.royltyper = royltyper;
    }
    
}
