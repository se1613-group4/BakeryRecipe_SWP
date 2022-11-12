/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package bakeryRecipe.controller;

import bakeryRecipe.account_tbl.Account_tblDTO;
import bakeryRecipe.notification_tbl.Notification_tblDAO;
import bakeryRecipe.notification_tbl.Notification_tblDTO;
import bakeryRecipe.utils.AppContants;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dangh
 */
@WebServlet(name = "GetNotificationData", urlPatterns = {"/GetNotificationData"})
public class GetNotificationData extends HttpServlet {

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

        //start get sitemap
        ServletContext context = getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITEMAPS");
        //end get sitemap

        String url = siteMaps.getProperty(AppContants.NotificationFeartures.DISPLAY_HOME_PAGE_CONTROLLER);

        try {
            HttpSession session = request.getSession();
            Account_tblDTO user = (Account_tblDTO) session.getAttribute("USER");
            if (user != null) {
                //call dao 
                Notification_tblDAO dao = new Notification_tblDAO();
                //process result 
                List<Notification_tblDTO> result = dao.getListNoti(user.getUserId());
                if(result == null ) {
                   result = new ArrayList<Notification_tblDTO>();
                   Notification_tblDTO newDto = new Notification_tblDTO();
                   newDto.setDetail("Welcome to Bakery recipe");
                 result.add(newDto);
               }
//                for (int i = 0; i < result.size(); i++) {
//                }
               
             session.setAttribute("NOTIFICATION_RESULT", result );
           
                url = siteMaps.getProperty(AppContants.NotificationFeartures.DISPLAY_HOME_PAGE_CONTROLLER);
            }
        } catch (SQLException ex) {
            log("SearchController _ SQL " + ex.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
