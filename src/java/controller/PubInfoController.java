/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.pub_info;
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
import model.DAOpub_info;

/**
 *
 * @author ptuan
 */
@WebServlet(name = "PubInfoController", urlPatterns = {"/PubInfoController"})
public class PubInfoController extends HttpServlet {

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
        DAOpub_info dao = new DAOpub_info();
        response.setContentType("text/html;charset=UTF-8");
        String service = request.getParameter("go");
        if (service == null) {
            service = "listAllPubInfo";
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if (service.equals("insertPubInfor")) {
                String pub_id = request.getParameter("pub_id");
                String logo = request.getParameter("logo");
                String pr_info = request.getParameter("pr_info");
                if (pub_id == null || pub_id.equals("")) {
                    out.print("<h2>Pub ID is not null</h2>");
                    return;
                }
                pub_info pubi = new pub_info(pub_id, logo, pr_info);
                dao.addPub_info(pubi);
                response.sendRedirect("PubInfoController");
            }
            if (service.equals("listAllPubInfo")) {
                Vector<pub_info> vector = dao.viewAll();
                // pre some other data
                String titlePage = "PubInfor manager";
                String titleTable = "List of pubinfor";
                // set value for jsp by request.
                request.setAttribute("list", vector);
                request.setAttribute("titlepage", titlePage);
                request.setAttribute("titleTabale", titleTable);
                // select jsp
                RequestDispatcher dispath = request.getRequestDispatcher("/JSP/Display/DisplayPubInfo.jsp");
                dispath.forward(request, response);

            }
            if (service.equals("updatePubInfo")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    String pub_id = request.getParameter("pub_id");
                    String sql = "select * from pub_info where pub_id ='" + pub_id + "'";
                    ResultSet rs = dao.getData(sql);
                    String titlepage = "PubInfo manager";
                    String titleTable = "List all";
                    request.setAttribute("rs", rs);
                    request.setAttribute("page", titlepage);
                    request.setAttribute("table", titleTable);
                    dispath(request, response, "/JSP/Update/UpdatePubInfo.jsp");
                } else {
                    String pub_id = request.getParameter("pub_id");
                    String logo = request.getParameter("logo");
                    String pr_info = request.getParameter("pr_info");
                    //pub_info pubi = new pub_info(pub_id, logo, pr_info)
                    pub_info pubi = new pub_info(pub_id, pr_info);
                    int n = dao.updatePub_info(pubi);
                    response.sendRedirect("PubInfoController");
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
