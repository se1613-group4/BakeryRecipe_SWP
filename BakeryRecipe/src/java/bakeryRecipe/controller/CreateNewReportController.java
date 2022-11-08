/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package bakeryRecipe.controller;

import bakeryRecipe.account_tbl.Account_tblDAO;
import bakeryRecipe.account_tbl.Account_tblDTO;
import bakeryRecipe.report_tbl.Report_tblDAO;
import bakeryRecipe.utils.AppContants;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
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
 * @author ThongNT
 */
@WebServlet(name = "CreateNewReportController", urlPatterns = {"/CreateNewReportController"})
public class CreateNewReportController extends HttpServlet {

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
        /**
         * Get site map (Copy this for all controller)
         */
        ServletContext context = getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITEMAPS");
        // End get site map

        // Mapping url        
        String urlRewriting = siteMaps.getProperty(AppContants.AddNewReportFeature.ERROR_PAGE);
        //user_id       int(11)
        //recipe_id     int(11)
        //report_detail text
        //created_date

        int recipe_id = Integer.parseInt(request.getParameter("txtRecipeId"));
        try {
            HttpSession session = request.getSession(true);
            Account_tblDTO currentUser = (Account_tblDTO) session.getAttribute("USER");
            if (currentUser == null) {
                urlRewriting = siteMaps.getProperty(AppContants.AddNewReportFeature.LOGIN_PAGE);
            } else {
                int user_id = currentUser.getUserId();
                String report_detail = request.getParameter("txtReportContent");
                Date created_date = new Date(Calendar.getInstance().getTime().getTime());
//            System.out.println("UnitTest REPORT: " + user_id + recipe_id + report_detail + created_date + last_modified + is_actived);
                Report_tblDAO dao = new Report_tblDAO();
                Account_tblDAO acdao = new Account_tblDAO();
                String usnameofrec = acdao.getUsernamebyRecipeId(recipe_id);
                // hieuvm inject code here  =
                 String new_report_detail = "|Id : " + recipe_id + " [ by : " +usnameofrec+ "]:sms:"+report_detail;
                // hieuvm endcode
                                    // HIEU VM INJECT NEW REPORT MESSEGER 
                if (dao.addNewReport(user_id, recipe_id, new_report_detail, created_date)) {
                    urlRewriting = siteMaps.getProperty(AppContants.AddNewReportFeature.DISPLAY_SINGLE_RECIPE_CONTROLLER) + "?" + "recipeId=" + recipe_id + "&REPORT_STATUS=success";
                }//end check result
            }//end check has been login
        } catch (SQLException ex) {
            if (ex.getMessage().contains("Duplicate entry")) {
                urlRewriting = siteMaps.getProperty(AppContants.AddNewReportFeature.DISPLAY_SINGLE_RECIPE_CONTROLLER) + "?" + "recipeId=" + recipe_id + "&REPORT_STATUS=duplicate";
            }
            log("CreateNewReport Controller _ SQL " + ex.getMessage());
        } finally {
            response.sendRedirect(urlRewriting);
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
