/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.tileauthor;
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
import model.DAOtilteauthor;

/**
 *
 * @author ptuan
 */
@WebServlet(name = "TitleAuthorController", urlPatterns = {"/TitleAuthorController"})
public class TitleAuthorController extends HttpServlet {

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
        DAOtilteauthor dao = new DAOtilteauthor();
        String service = request.getParameter("go");
        response.setContentType("text/html;charset=UTF-8");
        if (service == null) {
            service = "listAllTitleAu";
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if (service.equals("insertTitleAuthors")) {
                String au_id = request.getParameter("au_id");
                String title_id = request.getParameter("tile_id");
                String au_ord = request.getParameter("au_ord");
                String royaltyper = request.getParameter("royaltyper");
                if (au_id == null || au_id.equals("")) {
                    out.print("<h2>Author id is not null</h2>");
                    return;
                }
                if (title_id == null || title_id.equals("")) {
                    out.print("<h2>Title id is not null</h2>");
                    return;
                }
                int au_ord1 = Integer.parseInt(au_ord);
                int royaltyper1 = Integer.parseInt(royaltyper);
                tileauthor tileau = new tileauthor(au_id, title_id, au_ord1, royaltyper1);
                dao.addTileAuthor(tileau);
                response.sendRedirect("TitleAuthorController");
            }
            if (service.equals("listAllTitleAu")) {
                Vector<tileauthor> vector = dao.viewAll();
                String titlePage = "Title Author manager";
                String titleTable = "List of TitleAuthor";
                request.setAttribute("list", vector);
                request.setAttribute("titlepage", titlePage);
                request.setAttribute("titleTable", titleTable);
                dispath(request, response, "/JSP/Display/DisplayTitleAuthor.jsp");
            }
            if (service.equals("updateTitleAuthor")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    String authorID = request.getParameter("authorID");
                    String titleID = request.getParameter("titleID");
                    String sql = "select * from titleauthor where au_id='" + authorID + "' and title_id='" + titleID + "'";
                    ResultSet rs = dao.getData(sql);

                    ResultSet rs1 = dao.getData("select * from authors");

                    ResultSet rs2 = dao.getData("select * from titles");
                    request.setAttribute("rstitleAu", rs);
                    request.setAttribute("rsAuthor", rs1);
                    request.setAttribute("rstitle", rs2);
                    dispath(request, response, "/JSP/Update/UpdateTitleAuthor.jsp");
                } else {
                    String au_id = request.getParameter("au_id");
                    String title_id = request.getParameter("tile_id");
                    String au_ord = request.getParameter("au_ord");
                    String royaltyper = request.getParameter("royaltyper");
                    int au_ord1 = Integer.parseInt(au_ord);
                    int royaltyper1 = Integer.parseInt(royaltyper);
                    tileauthor tileau = new tileauthor(au_id, title_id, au_ord1, royaltyper1);
                    dao.updateTileAuthor(tileau);
                    response.sendRedirect("TitleAuthorController");
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
