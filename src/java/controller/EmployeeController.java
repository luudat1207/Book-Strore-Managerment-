/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.employee;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAOemployee;

/**
 *
 * @author ptuan
 */
@WebServlet(name = "EmployeeController", urlPatterns = {"/EmployeeController"})
public class EmployeeController extends HttpServlet {

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
        String service = request.getParameter("go");
        DAOemployee dao = new DAOemployee();
        if (service == null) {
            service = "listAllEmployee";
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if (service.equals("insertEmployee")) {
                String emp_id = request.getParameter("emp_id");
                String fname = request.getParameter("fname");
                String minit = request.getParameter("minit");
                String lname = request.getParameter("lname");
                String job_id = request.getParameter("job_id");
                String job_lvl = request.getParameter("job_lvl");
                String pub_id = request.getParameter("pub_id");
                String hire_date = request.getParameter("hire_date");
                if (emp_id == null || emp_id.equals("")) {
                    out.print("<h2>Employee ID is not null</h2>");
                    return;
                }
                if (fname == null || fname.equals("")) {
                    out.print("<h2>Fname is not null</h2>");
                    return;
                }
                if (lname == null || lname.equals("")) {
                    out.print("<h2>Lname is not null</h2>");
                    return;
                }
                if (job_id == null || job_id.equals("")) {
                    out.print("<h2>Jod ID is not null</h2>");
                    return;
                }
                if (pub_id == null || pub_id.equals("")) {
                    out.print("<h2>Pub Id is not null</h2>");
                    return;
                }
                if (hire_date == null || hire_date.equals("")) {
                    out.print("<h2>Hire date is not null</h2>");
                    return;
                }
                int job_id1 = Integer.parseInt(job_id);
                int job_lvl1 = Integer.parseInt(job_lvl);
                employee emp = new employee(emp_id, fname, minit, lname, job_id1, job_lvl1, pub_id, hire_date);
                dao.addEmployee(emp);
                response.sendRedirect("EmployeeController");
            }
            if (service.equals("listAllEmployee")) {
                Vector<employee> vector = dao.viewAll();
                // pre some other data
                String titlePage = "Employee manager";
                String titleTable = "List of employee";
                // set value for jsp by request.
                request.setAttribute("list", vector);
                request.setAttribute("titlepage", titlePage);
                request.setAttribute("titleTabale", titleTable);
                // select jsp
                RequestDispatcher dispath = request.getRequestDispatcher("/JSP/Display/DisplayEmployee.jsp");
                dispath.forward(request, response);

            }
            if (service.equals("updateEmployee")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    String empId = request.getParameter("emp_id");
                    String sql = "select * from employee where emp_id = '" + empId + "'";
                    ResultSet rs = dao.getData(sql);
                    ResultSet rs1 = dao.getData("select * from jobs");
                    ResultSet rs2 = dao.getData("select * from publishers");
                    String titPage = "Employee Manager";
                    String titTable = "List All";
                    request.setAttribute("rs", rs);
                    request.setAttribute("rsjobs", rs1);
                    request.setAttribute("rspub", rs2);
                    request.setAttribute("page", titPage);
                    request.setAttribute("table", titTable);
                    dispath(request, response, "/JSP/Update/UpdateEmployee.jsp");
                } else {
                    String emp_id = request.getParameter("emp_id");
                    String fname = request.getParameter("fname");
                    String minit = request.getParameter("minit");
                    String lname = request.getParameter("lname");
                    String job_id = request.getParameter("job_id");
                    String job_lvl = request.getParameter("job_lvl");
                    String pub_id = request.getParameter("pub_id");
                    String hire_date = request.getParameter("hire_date");
                    int job_id1 = Integer.parseInt(job_id);
                    int job_lvl1 = Integer.parseInt(job_lvl);
                    employee emp = new employee(emp_id, fname, minit, lname, job_id1, job_lvl1, pub_id, hire_date);
                    dao.updateEmployee(emp);
                    response.sendRedirect("EmployeeController");
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
