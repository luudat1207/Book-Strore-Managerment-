/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.stores;
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
import model.DAOstores;

/**
 *
 * @author ptuan
 */
@WebServlet(name = "StoresController", urlPatterns = {"/StoresController"})
public class StoresController extends HttpServlet {

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
        HttpSession session = request.getSession();
        DAOstores dao = new DAOstores();
        String service = request.getParameter("go");
        response.setContentType("text/html;charset=UTF-8");
        if (service == null) {
            service = "listAllStores";
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if (service.equals("insertStore")) {
                String stor_id = request.getParameter("stor_id");
                String stor_name = request.getParameter("stor_name");
                String stor_address = request.getParameter("stor_address");
                String city = request.getParameter("city");
                String state = request.getParameter("state");
                String zip = request.getParameter("zip");
                if (stor_id == null || stor_id.equals("")) {
                    out.print("<h2>Stores ID is not null</h2>");
                    return;
                }
                stores sto = new stores(stor_id, stor_name, stor_address, city, state, zip);
                dao.addStores(sto);
                response.sendRedirect("StoresController");

            }
            if (service.equals("listAllStores")) {
                Vector<stores> vector = dao.viewAll();
                // pre some other data
                String titlePage = "Stores manager";
                String titleTable = "List of stores";
                // set value for jsp by request.
                request.setAttribute("list", vector);
                request.setAttribute("titlepage", titlePage);
                request.setAttribute("titleTabale", titleTable);
                // select jsp
                RequestDispatcher dispath = request.getRequestDispatcher("/JSP/Display/DisplayStore.jsp");
                dispath.forward(request, response);
            }
            if (service.equals("updateStore")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    String storID = request.getParameter("stor_id");
                    String sql = "select * from stores where stor_id ='" + storID + "'";
                    ResultSet rs = dao.getData(sql);
                    String titlePage = "Stores manager";
                    String titleTable = "List of stores";
                    request.setAttribute("vector", rs);
                    request.setAttribute("titlePage", titlePage);
                    request.setAttribute("titleTable", titleTable);
                    dispath(request, response, "/JSP/Update/UpdateStore.jsp");
                } else {
                    String stor_id = request.getParameter("stor_id");
                    String stor_name = request.getParameter("stor_name");
                    String stor_address = request.getParameter("stor_address");
                    String city = request.getParameter("city");
                    String state = request.getParameter("state");
                    String zip = request.getParameter("zip");
                    stores sto = new stores(stor_id, stor_name, stor_address, city, state, zip);
                    dao.updateStore(sto);
                    response.sendRedirect("StoresController");
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
