/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package bakeryRecipe.controller;

import bakeryRecipe.account_tbl.Account_tblDTO;
import bakeryRecipe.follow_tbl.Follow_tblDAO;
import bakeryRecipe.profile_tbl.Profile_tblDAO;
import bakeryRecipe.profile_tbl.Profile_tblDTO;
import bakeryRecipe.utils.AppContants;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import javax.naming.NamingException;
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
@WebServlet(name = "DisplayUserProfile", urlPatterns = {"/DisplayUserProfile"})
public class DisplayUserProfile extends HttpServlet {

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

        String editButton = request.getParameter("editBtn");
        String url = siteMaps.getProperty(AppContants.DisplayUserProfileFeartures.USER_HOME_PAGE);

        try {
            HttpSession session = request.getSession();
            Account_tblDTO user = (Account_tblDTO) session.getAttribute("USER");
            //call dao
            Profile_tblDAO daoProfile = new Profile_tblDAO();
            Follow_tblDAO daoFollow = new Follow_tblDAO();
            //process result
            Profile_tblDTO profile = daoProfile.displayUserProfile(user.getUserId());
            int follower_amount = daoFollow.displayFollower(user.getUserId());
            int following_amount = daoFollow.displayFollowing(user.getUserId());
            request.setAttribute("USER_PROFILE", profile);
            request.setAttribute("USER_FOLLOWERS", follower_amount);
            request.setAttribute("USER_FOLLOWING", following_amount);
            request.setAttribute("EDIT_TRIGGER", editButton);

            //redirect webpage
            url = siteMaps.getProperty(AppContants.DisplayUserProfileFeartures.PROFILE_PAGE);
        } catch (SQLException ex) {
            log("Error at DisplayUserProfile: " + ex.toString());
        } catch (NamingException ex) {
            log("Error at DisplayUserProfile: " + ex.toString());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
//            response.sendRedirect(url);
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
