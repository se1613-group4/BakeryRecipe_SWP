/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package bakeryRecipe.controller;

import bakeryRecipe.account_tbl.Account_tblDTO;
import bakeryRecipe.like_tbl.Like_tblDAO;
import bakeryRecipe.utils.AppContants;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "UnlikeController", urlPatterns = {"/UnlikeController"})
public class UnlikeController extends HttpServlet {

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
         * Get site map
         */
        ServletContext context = getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITEMAPS");
        // End get site map

        // Mapping url
        String urlRewriting = siteMaps.getProperty(AppContants.LikeFeature.ERROR_PAGE);
        try {
            HttpSession session = request.getSession(true);
            Account_tblDTO currentUser = (Account_tblDTO) session.getAttribute("USER");
            if (currentUser == null) {
                urlRewriting = siteMaps.getProperty(AppContants.LikeFeature.LOGIN_PAGE);
            } else {
                int recipe_id = Integer.parseInt(request.getParameter("txtRecipeId"));
                int user_id = Integer.parseInt(request.getParameter("txtUserId"));
                Like_tblDAO dao = new Like_tblDAO();
                if (dao.unlikeRecipe(recipe_id, user_id)) {
                    urlRewriting = siteMaps.getProperty(AppContants.LikeFeature.DISPLAY_SINGLE_RECIPE_CONTROLLER) + "?" + "recipeId=" + recipe_id;
                }//end check result
            }//end check has been login

        } catch (SQLException ex) {
            log("Unlike Controller _ SQL " + ex.getMessage());
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
