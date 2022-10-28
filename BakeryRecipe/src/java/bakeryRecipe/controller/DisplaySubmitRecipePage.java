/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.controller;

import bakeryRecipe.category_tbl.Category_tblDAO;
import bakeryRecipe.category_tbl.Category_tblDTO;
import bakeryRecipe.ingredient_tbl.Ingredient_tblDAO;
import bakeryRecipe.ingredient_tbl.Ingredient_tblDTO;
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

/**
 *
 * @author LamVo
 */
@WebServlet(name = "DisplaySubmitRecipePage", urlPatterns = {"/DisplaySubmitRecipePage"})
public class DisplaySubmitRecipePage extends HttpServlet {

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
        String url = siteMaps.getProperty(AppContants.DisplaySubmitRecipeFeature.SUBMIT_RECIPE_PAGE);
        try {
            // Load all category recipe
            Category_tblDAO categoryDao = new Category_tblDAO();
            categoryDao.loadAllCategory();
            List<Category_tblDTO> categoryList = categoryDao.getCategoryDtoList();
            if (categoryList != null) {
                request.setAttribute("CATRGORY_LIST", categoryList);
            }
            // Load all ingredient
            Ingredient_tblDAO ingredientDao = new Ingredient_tblDAO();
            ingredientDao.loadAllIngredient();
            List<Ingredient_tblDTO> ingredienList = ingredientDao.getIngredientDtoList();
            if (ingredienList != null) {
                request.setAttribute("INGREDIENT_LIST", ingredienList);
            }
        } catch (SQLException ex) {
            log("DisplaySubmitRecipePage Controller _ SQL " + ex.getMessage());
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
