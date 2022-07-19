/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.roysched;
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
import model.DAOroysched;

/**
 *
 * @author ptuan
 */
@WebServlet(name = "RoyschedController", urlPatterns = {"/RoyschedController"})
public class RoyschedController extends HttpServlet {

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
        DAOroysched dao = new DAOroysched();
        String service = request.getParameter("go");
        response.setContentType("text/html;charset=UTF-8");
        if (service == null) {
            service = "listAllRoysched";
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if (service.equals("insertRoyshed")) {
                String title_id = request.getParameter("titleID");
                String lorange = request.getParameter("Lorange");
                String hirange = request.getParameter("Hirange");
                String royalty = request.getParameter("Royalty");
                if (title_id == null || title_id.equals("")) {
                    out.print("<h2>Title ID is not null</h2>");
                    return;
                }
                int lorange1 = Integer.parseInt(lorange);
                int hirange1 = Integer.parseInt(hirange);
                int royalty1 = Integer.parseInt(royalty);
                roysched roy = new roysched(title_id, lorange1, hirange1, royalty1);
                dao.addRoyshed(roy);
                response.sendRedirect("RoyschedController");
            }
            if (service.equals("listAllRoysched")) {
                Vector<roysched> vector = dao.viewAll();
                // pre some other data
                String titlePage = "Roy manager";
                String titleTable = "List of roy";
                // set value for jsp by request.
                request.setAttribute("list", vector);
                request.setAttribute("titlepage", titlePage);
                request.setAttribute("titleTabale", titleTable);
                // select jsp
                RequestDispatcher dispath = request.getRequestDispatcher("/JSP/Display/DisplayRoy.jsp");
                dispath.forward(request, response);
            }
            if (service.equals("updateRoysched")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    String title_id = request.getParameter("title_id");
                    String sql = "select * from roysched where title_id ='" + title_id + "'";
                    ResultSet rs = dao.getData(sql);
                    String Titlepage = "Roy Manager";
                    String TitleTable = "Roy List";
                    ResultSet rs1 = dao.getData("select * from titles");
                    request.setAttribute("rsroy", rs);
                    request.setAttribute("rs1", rs1);
                    request.setAttribute("page", Titlepage);
                    request.setAttribute("table", TitleTable);
                    dispath(request, response, "/JSP/Update/UpdateRoy.jsp");
                } else {
                    String title_id = request.getParameter("titleID");
                    String lorange = request.getParameter("Lorange");
                    String hirange = request.getParameter("Hirange");
                    String royalty = request.getParameter("Royalty");
                    int lorange1 = Integer.parseInt(lorange);
                    int hirange1 = Integer.parseInt(hirange);
                    int royalty1 = Integer.parseInt(royalty);
                    roysched roy = new roysched(title_id, lorange1, hirange1, royalty1);
                    dao.updateRoyshed(roy);
                    response.sendRedirect("RoyschedController");
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
