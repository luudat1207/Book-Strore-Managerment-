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
public class Cart extends tiltes{
    private int qty;

    public Cart(int qty) {
        this.qty = qty;
    }

    public Cart(int qty, String title_id, String title, String type, String pub_id, double price, double advance, int royalty, int ytd_sales, String notes, String pubdate,String image) {
        super(title_id, title, type, pub_id, price, advance, royalty, ytd_sales, notes, pubdate,image);
        this.qty = qty;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Cart() {
    }
}
