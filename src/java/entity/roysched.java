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
public class roysched {
    private String title_id;
    private int lorange;
    private int hirange;
    private int royalty;

    public roysched() {
    }

    @Override
    public String toString() {
        return "roysched{" + "title_id=" + title_id + ", lorange=" + lorange + ", hirange=" + hirange + ", royalty=" + royalty + '}';
    }

    public roysched(String title_id, int lorange, int hirange, int royalty) {
        this.title_id = title_id;
        this.lorange = lorange;
        this.hirange = hirange;
        this.royalty = royalty;
    }

    public String getTitle_id() {
        return title_id;
    }

    public void setTitle_id(String title_id) {
        this.title_id = title_id;
    }

    public int getLorange() {
        return lorange;
    }

    public void setLorange(int lorange) {
        this.lorange = lorange;
    }

    public int getHirange() {
        return hirange;
    }

    public void setHirange(int hirange) {
        this.hirange = hirange;
    }

    public int getRoyalty() {
        return royalty;
    }

    public void setRoyalty(int royalty) {
        this.royalty = royalty;
    }
    
}
