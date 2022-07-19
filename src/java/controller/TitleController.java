/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Cart;
import entity.tiltes;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAOtiltes;

/**
 *
 * @author ptuan
 */
@WebServlet(name = "TitleController", urlPatterns = {"/TitleController"})
public class TitleController extends HttpServlet {

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
        DAOtiltes dao = new DAOtiltes();
        String service = request.getParameter("go");
        HttpSession session = request.getSession();

        if (service == null) {
            // call controller direct
            service = "listAllTitle";
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            // Insert Title from controller direct
            if (service.equals("insertTile")) {

                // Get data
                String title_ID = request.getParameter("title_id");
                String title = request.getParameter("title");
                String type = request.getParameter("Type");
                String pubid = request.getParameter("pubid");
                String price = request.getParameter("Price");
                String advance = request.getParameter("Advance");
                String royalty = request.getParameter("Royalty");
                String ytd_sales = request.getParameter("Ytd_sales");
                String notes = request.getParameter("notes");
                String pubdate = request.getParameter("Pubdate");
                String image = request.getParameter("image");

                // Check data
                if (title_ID == null || title_ID.equals("")) {
                    out.print("<h2>Title ID is not null</h2>");
                    return;
                }
                if (title == null || title.equals("")) {
                    out.print("<h2>Title is not null</h2>");
                    return;
                }
                if (type == null || title.equals(notes)) {
                    out.print("<h2>Type is not null</h2>");
                    return;
                }
                if (pubdate == null || pubdate.equals("")) {
                    out.print("<h2>Pub date is not nulll</h2>");
                    return;
                }

                // Convert data     
                String image1 ="/image/"+image;
                double price1 = Double.parseDouble(price);
                double advance1 = Double.parseDouble(advance);
                int royalty1 = Integer.parseInt(royalty);
                int ytd_sales1 = Integer.parseInt(ytd_sales);

                //add to obj                
                tiltes til = new tiltes(title_ID, title, type, pubid, price1, advance1, royalty1, ytd_sales1, notes, pubdate,image1);

                //add to sql                
                int n = dao.addTiles(til);

                //Retrun Controll
                response.sendRedirect("TitleController");
            }
            
            // ListALL Title from controller direct
            if (service.equals("listAllTitle")) {
                // get data from model 
                Vector<tiltes> vector = dao.viewAllTiles();
                // pre some other data
                String titlePage = "Title manager";
                String titleTable = "List of titles";
                // set value for jsp by request.
                request.setAttribute("list", vector);
                request.setAttribute("titlepage", titlePage);
                request.setAttribute("titleTabale", titleTable);

                // select jsp
                dispath(request, response, "/JSP/Display/DisplayTitle.jsp");
            }
            // Update title from controller direct
            if (service.equals("updateTitle")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    // chua nhan button submit

                    // step 1 : Show records
                    String titleID = request.getParameter("titleID");
                    String sql = "Select * from Titles where title_id= '"
                            + titleID + "'";
                    ResultSet rs = dao.getData(sql);
                    ResultSet rs1 = dao.getData("select * from publishers");
                    request.setAttribute("rsTitle", rs);
                    request.setAttribute("rsPublisher", rs1);
                    dispath(request, response, "/JSP/Update/UpdateTitle.jsp");
                } else {
                    String title_ID = request.getParameter("title_id");
                    String title = request.getParameter("title");
                    String type = request.getParameter("Type");
                    String pubid = request.getParameter("pubid");
                    String price = request.getParameter("Price");
                    String advance = request.getParameter("Advance");
                    String royalty = request.getParameter("Royalty");
                    String ytd_sales = request.getParameter("Ytd_sales");
                    String notes = request.getParameter("notes");
                    String pubdate = request.getParameter("Pubdate");
                    String image = request.getParameter("image");
                    String image1 ="image/"+image;
                    double price1 = Double.parseDouble(price);
                    double advance1 = Double.parseDouble(advance);
                    int royalty1 = Integer.parseInt(royalty);
                    int ytd_sales1 = Integer.parseInt(ytd_sales);
                    tiltes til = new tiltes(title_ID, title, type, pubid, price1, advance1, royalty1, ytd_sales1, notes, pubdate,image1);
                    int n = dao.updateTitle(til);
                    response.sendRedirect("TitleController");
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
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
