/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.sales;
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
import model.DAOsales;
import model.DAOstores;

/**
 *
 * @author ptuan
 */
@WebServlet(name = "SalesController", urlPatterns = {"/SalesController"})
public class SalesController extends HttpServlet {

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
        DAOsales dao = new DAOsales();
        String service = request.getParameter("go");
        response.setContentType("text/html;charset=UTF-8");
        if (service == null) {
            service = "listAllSales";
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if (service.equals("insertSales")) {
                String stor_id = request.getParameter("Stor_id");
                String ord_num = request.getParameter("ord_num");
                String ord_date = request.getParameter("ord_date");
                String qty = request.getParameter("qty");
                String payterms = request.getParameter("payterms");
                String title_id = request.getParameter("tile_id");
                String status = request.getParameter("status");
                if (stor_id == null || stor_id.equals("")) {
                    out.print("<h2>Stor Id is not null</h2>");
                    return;
                }
                if (ord_num == null || ord_num.equals("")) {
                    out.print("<h2>Ord num is not null</h2>");
                    return;
                }
                if (ord_date == null || ord_date.equals("")) {
                    out.print("<h2>Ord date is not null</h2>");
                    return;
                }
                if (qty == null || qty.equals("")) {
                    out.print("<h2>Qty is not null</h2>");
                    return;
                }
                if (payterms == null || payterms.equals("")) {
                    out.print("<h2>Payterms is not null</h2>");
                    return;
                }
                if (title_id == null || title_id.equals("")) {
                    out.print("<h2>title ID is not null</h2>");
                    return;
                }
                int qty1 = Integer.parseInt(qty);
                int status1 = Integer.parseInt(status);
                sales sa = new sales(stor_id, ord_num, ord_date, qty1, payterms, title_id, status1);
                dao.addSales(sa);
                response.sendRedirect("SalesController");
            }
            if (service.equals("listAllSales")) {
                Vector<sales> vector = dao.viewAll();
                // pre some other data
                String titlePage = "Sales manager";
                String titleTable = "List of sales";
                // set value for jsp by request.
                request.setAttribute("list", vector);
                request.setAttribute("titlepage", titlePage);
                request.setAttribute("titleTabale", titleTable);
                // select jsp
                RequestDispatcher dispath = request.getRequestDispatcher("/JSP/Display/DisplaySales.jsp");
                dispath.forward(request, response);
            }
            if (service.equals("viewdetail")) {
                String StorID = request.getParameter("storid");
                String sql = "select s.ord_num, t.title, s.qty, t.price, s.qty*t.price as Total, s.status\n"
                        + "from sales s\n"
                        + "inner join titles t\n"
                        + "on s.title_id = t.title_id\n"
                        + "inner join stores sto \n"
                        + "on s.stor_id = sto.stor_id\n"
                        + "where sto.stor_id ='" + StorID + "'";
                ResultSet rs = dao.getData(sql);
                String storname = request.getParameter("storname");
                request.setAttribute("rsDetail", rs);
                request.setAttribute("stor_name", storname);
                String sql1 = "SELECT status\n"
                        + "FROM sales s\n"
                        + "WHERE s.stor_id='" + StorID + "'";
                ResultSet rs1 = dao.getData(sql1);
                request.setAttribute("status", rs1);
                RequestDispatcher dispath = request.getRequestDispatcher("/JSP/Display/DisplayDetail.jsp");
                dispath.forward(request, response);
            }
            if (service.endsWith("updateSale")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    String storID = request.getParameter("storID");
                    String sql = "select * from sales where stor_id ='" + storID + "'";
                    ResultSet rs = dao.getData(sql);
                    String sql2 = "select * from titles ";
                    String sql3 = "select * from stores";
                    String titlepage = "Sales Manager";
                    String titletable = "List Sales";
                    ResultSet rstitle = dao.getData(sql2);
                    ResultSet rsstore = dao.getData(sql3);
                    request.setAttribute("rstitles", rstitle);
                    request.setAttribute("rsStore", rsstore);
                    request.setAttribute("page", titlepage);
                    request.setAttribute("table", titletable);
                    request.setAttribute("rs", rs);
                    dispath(request, response, "/JSP/Update/UpdateSales.jsp");
                } else {
                    String stor_id = request.getParameter("Stor_id");
                    String ord_num = request.getParameter("ord_num");
                    String ord_date = request.getParameter("ord_date");
                    String qty = request.getParameter("qty");
                    String payterms = request.getParameter("payterms");
                    String title_id = request.getParameter("tile_id");
                    String status = request.getParameter("status");
                    int qty1 = Integer.parseInt(qty);
                    int status1 = Integer.parseInt(status);
                    sales sa = new sales(stor_id, ord_num, ord_date, qty1, payterms, title_id, status1);
                    dao.updateSales(sa);
                    response.sendRedirect("SalesController");
                }    
            }
             if (service.equals("updateStatus")) {
                    
                    String status = request.getParameter("status");
                    String id = request.getParameter("storID");
                    int sta = Integer.parseInt(status);
                    DAOstores dao1 = new DAOstores();
                    String sql = "update sales \n"
                            + "set status=" + sta + "\n"
                            + "where stor_id='" + id + "'";
                    ResultSet rs = dao1.getData(sql);

                    response.sendRedirect("StoresController");
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
