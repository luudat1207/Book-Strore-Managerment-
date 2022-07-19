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
public class publishers {
    private String pub_id;
    private String pub_name;
    private String city;
    private String state;
    private String country;
    private String image;

    public publishers() {
    }

    public publishers(String pub_id, String pub_name, String city, String state, String country, String image) {
        this.pub_id = pub_id;
        this.pub_name = pub_name;
        this.city = city;
        this.state = state;
        this.country = country;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public String getPub_id() {
        return pub_id;
    }

    public void setPub_id(String pub_id) {
        this.pub_id = pub_id;
    }

    public String getPub_name() {
        return pub_name;
    }

    public void setPub_name(String pub_name) {
        this.pub_name = pub_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
}
