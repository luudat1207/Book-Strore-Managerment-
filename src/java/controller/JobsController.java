/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.jobs;
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
import model.DAOjobs;

/**
 *
 * @author ptuan
 */
@WebServlet(name = "JobsController", urlPatterns = {"/JobsController"})
public class JobsController extends HttpServlet {

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
        DAOjobs dao = new DAOjobs();
        response.setContentType("text/html;charset=UTF-8");
        String service = request.getParameter("go");
        if (service == null) {
            service = "listAllJobs";
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if (service.equals("insertJobs")) {
                String job_desc = request.getParameter("job_desc");
                String min_lvl = request.getParameter("min_lvl");
                String max_lvl = request.getParameter("max_lvl");
                if (job_desc == null || job_desc.equals("")) {
                    out.print("<h2>Job Desc is not null</h2>");
                    return;
                }
                if (min_lvl == null || min_lvl.equals("")) {
                    out.print("<h2>Min lv is not null</h2>");
                    return;
                }
                if (max_lvl == null || max_lvl.equals("")) {
                    out.print("<h2>Max lv is not null</h2>");
                    return;
                }
                int min_lv1 = Integer.parseInt(min_lvl);
                int max_lv1 = Integer.parseInt(max_lvl);
                jobs job = new jobs(job_desc, min_lv1, max_lv1);
                dao.addJobs(job);
                response.sendRedirect("JobsController");
            }
            if (service.equals("listAllJobs")) {
                Vector<jobs> vector = dao.viewAll();
                // pre some other data
                String titlePage = "Jobs manager";
                String titleTable = "List of jobs";
                // set value for jsp by request.
                request.setAttribute("list", vector);
                request.setAttribute("titlepage", titlePage);
                request.setAttribute("titleTabale", titleTable);
                // select jsp
                RequestDispatcher dispath = request.getRequestDispatcher("/JSP/Display/DisplayJobs.jsp");
                dispath.forward(request, response);
            }
            if (service.equals("updateJobs")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    String jobID = request.getParameter("jobsID");
                    String sql = "select * from jobs where job_id ='" + jobID + "'";
                    ResultSet rs = dao.getData(sql);
                    String titpage = "Jobs Manager";
                    String tittable ="List Jobs";
                    request.setAttribute("rs", rs);
                    request.setAttribute("page", titpage);
                    request.setAttribute("table", tittable);
                    dispath(request, response, "/JSP/Update/UpdateJobs.jsp");
                } else {
                    String job_id1 = request.getParameter("job_id");
                    String job_desc = request.getParameter("job_desc");
                    String min_lvl = request.getParameter("min_lvl");
                    String max_lvl = request.getParameter("max_lvl");
                    int min_lv1 = Integer.parseInt(min_lvl);
                    int max_lv1 = Integer.parseInt(max_lvl);
                    int job_id = Integer.parseInt(job_id1);
                    jobs job = new jobs(job_id,job_desc, min_lv1, max_lv1);
                    dao.updateJobs(job);
                    response.sendRedirect("JobsController");
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
