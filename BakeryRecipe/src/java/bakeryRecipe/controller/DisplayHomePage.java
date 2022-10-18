/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.controller;

import bakeryRecipe.recipe_tbl.Recipe_tblDAO;
import bakeryRecipe.recipe_tbl.Recipe_tblDTO;
import bakeryRecipe.utils.AppContants;
import java.io.IOException;
import java.sql.SQLException;
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
 * @author LamVo
 */
@WebServlet(name = "DisplayHomePage", urlPatterns = {"/DisplayHomePage"})
public class DisplayHomePage extends HttpServlet {
//    private final String HOME_PAGE = "home_page.jsp";
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
        String url = AppContants.DisplayHomePageFeature.HOME_PAGE;    
        try {
            HttpSession session = request.getSession(true);
            Recipe_tblDAO recipeDao = new Recipe_tblDAO();
            
            recipeDao.loadTopRecipe(3);
            List<Recipe_tblDTO> top3Recipes = recipeDao.getRecipeDtoList();
            session.setAttribute("TOP3_RECIPES", top3Recipes);
            
            recipeDao.loadTopRecipe(5);
            List<Recipe_tblDTO> top5Recipes = recipeDao.getRecipeDtoList();
            session.setAttribute("TOP5_RECIPES", top5Recipes);
            
            recipeDao.loadRecentlyRecipe();
            List<Recipe_tblDTO> recentlyRecipes = recipeDao.getRecipeDtoList();
            session.setAttribute("RECENTLY_RECIPES", recentlyRecipes);
            
        } catch (SQLException ex) {
            log("DisplayHomePage Controller _ SQL " + ex.getMessage());
        } finally {
            response.sendRedirect(url);
//            RequestDispatcher rd = request.getRequestDispatcher(url)
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
