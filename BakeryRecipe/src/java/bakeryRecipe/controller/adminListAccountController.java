/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package bakeryRecipe.controller;

import bakeryRecipe.account_tbl.Account_tblDAO;
import bakeryRecipe.account_tbl.Account_tblDTO;
import bakeryRecipe.report_tbl.Report_tblDAO;
import bakeryRecipe.report_tbl.Report_tblDTO;
import bakeryRecipe.utils.AppContants;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jexk
 */
@WebServlet(name = "adminListAccountController", urlPatterns = {"/adminListAccountController"})
public class adminListAccountController extends HttpServlet {

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
        ServletContext context = getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITEMAPS");
        String url = AppContants.Admin.ADMIN_LISTRECIPE;
        int pageindex;  //  trang đang đứng 
        int endindex;    /// trang cuoi cung 
        Report_tblDAO rpdao = new Report_tblDAO();
        
        ArrayList<Account_tblDTO> result = null;
        try {
             
            HttpSession session = request.getSession();
            String test =request.getParameter("roww");
            String searchuseradmin = request.getParameter("a");
            ArrayList<Report_tblDTO> myreport = rpdao.getListRpAdmin();
            
              if(test == null){
                  pageindex = 1 ;
              }else{
                   pageindex = Integer.parseInt(test);
              }
            String searchvalue = searchuseradmin == null ? "" : searchuseradmin.trim();
              
            Account_tblDAO dao = new Account_tblDAO();
            endindex = dao.getEndIndexAccountListAdmin(searchvalue);
            result = (ArrayList<Account_tblDTO>) dao.getListAccountAdmin(searchvalue,pageindex, 10);
            
            session.setAttribute("ADMIN_LIST_USER", result);
            session.setAttribute("end_account", endindex);
            session.setAttribute("ADMIN_LIST_REPORT", myreport);
        } catch (SQLException ex) {
            log(ex.getMessage() + "DisplayHomePage Controller _ SQL ");
        } finally {

            response.sendRedirect(url);
        }
        
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
