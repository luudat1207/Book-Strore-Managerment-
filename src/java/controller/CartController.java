/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Cart;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAOsales;
import model.DAOtiltes;

/**
 *
 * @author ptuan
 */
@WebServlet(name = "CartController", urlPatterns = {"/CartController"})
public class CartController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String service = request.getParameter("go");
             DAOtiltes daoT = new DAOtiltes();
              DAOsales daoS = new DAOsales();
            /* TODO output your page here. You may use following sample code. */
            if (service.equals("addtoCart")) {
                HttpSession session = request.getSession();
                String key = request.getParameter("titleId");
                Cart cart = (Cart) session.getAttribute(key);
                if (cart == null) {
                    String sql = "Select * from titles where title_id='" + key + "'";
                    ResultSet rs = daoT.getData(sql);
                    int qty = 1;
                    try {
                        while (rs.next()) {
                            String tile_id = rs.getString("title_id");
                            String title_name = rs.getString(2);
                            String type = rs.getString(3);
                            String pub_id = rs.getString(4);
                            double pricers = rs.getDouble("price");
                            double advance = rs.getDouble(6);
                            int royalty = rs.getInt("royalty");
                            int ytd_sales = rs.getInt(8);
                            String notes = rs.getString(9);
                            String pubdate = rs.getString(10);
                            String image = rs.getString(11);
                            request.setAttribute("qty", qty);
                            Cart cart2 = new Cart(qty, tile_id, type, type, pub_id, pricers, advance, royalty, ytd_sales, notes, pubdate,image);
                            session.setAttribute(key, cart2);
                            response.sendRedirect("TitleController");
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    cart.setQty(cart.getQty() + 1);
                    session.setAttribute(key, cart);
                    response.sendRedirect("TitleController");
                }
            }
            if (service.equals("showCart")) {
                HttpSession session = request.getSession();
                if(session == null){
                    dispath(request, response, "/JSP/Login/Login.jsp");
                }else{
                dispath(request, response, "JSP/Card/showCart.jsp");
                }
            }
            if(service.equals("checkout")){
                
            }
        }
    
    }
    public void dispath(HttpServletRequest request,
            HttpServletResponse response, String page)
            throws IOException, ServletException {
        RequestDispatcher dispath = request.getRequestDispatcher(page);
        dispath.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
