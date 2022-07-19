/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.publishers;
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
import model.DAOpublishers;

/**
 *
 * @author ptuan
 */
@WebServlet(name = "PublishersController", urlPatterns = {"/PublishersController"})
public class PublishersController extends HttpServlet {

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
        DAOpublishers dao = new DAOpublishers();
        String service = request.getParameter("go");
        response.setContentType("text/html;charset=UTF-8");
        if (service == null) {
            service = "listAllPublisher";
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if (service.equals("insertPublisher")) {
                String pub_id = request.getParameter("pub_id");
                String pub_name = request.getParameter("pub_name");
                String city = request.getParameter("city");
                String state = request.getParameter("state");
                String country = request.getParameter("country");
                String image = request.getParameter("image");
                if (pub_id == null || pub_id.equals("")) {
                    out.print("<h2>Pub Id is not null</h2>");
                    return;
                }
                String image1 = "image/"+image;
                publishers pubd = new publishers(pub_id, pub_name, city, state, country,image1);
                dao.addPublicsher(pubd);
                response.sendRedirect("PublishersController");
            }
            if (service.equals("listAllPublisher")) {
                Vector<publishers> vector = dao.viewAll();
                // pre some other data
                String titlePage = "Title manager";
                String titleTable = "List of titles";
                // set value for jsp by request.
                request.setAttribute("list", vector);
                request.setAttribute("titlepage", titlePage);
                request.setAttribute("titleTabale", titleTable);
                // select jsp
                RequestDispatcher dispath = request.getRequestDispatcher("/JSP/Display/DisplayPublisher.jsp");
                dispath.forward(request, response);
            }
            if (service.equals("updatePublisher")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    String pub_id = request.getParameter("pub_id");
                    String sql = "select * from publishers where pub_id ='" + pub_id + "'";
                    ResultSet rs = dao.getData(sql);
                    String titlesPage = "Publisher Manager";
                    String titleTable = "List All Publisher";
                    request.setAttribute("rs", rs);
                    request.setAttribute("page", titlesPage);
                    request.setAttribute("table", titleTable);
                    dispath(request, response, "/JSP/Update/UpdatePublisher.jsp");
                    
                } else {
                    String pub_id = request.getParameter("pub_id");
                    String pub_name = request.getParameter("pub_name");
                    String city = request.getParameter("city");
                    String state = request.getParameter("state");
                    String country = request.getParameter("country");
                    String image = request.getParameter("image");
                    String image1 = "image/"+image;
                    publishers pubd = new publishers(pub_id, pub_name, city, state, country,image1);
                    dao.updatePublisher(pubd);
                    response.sendRedirect("PublishersController");
                }
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
