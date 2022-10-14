/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.controller;

import bakeryRecipe.account_tbl.Account_tblDTO;
import bakeryRecipe.recipe_tbl.Recipe_tblDAO;
import bakeryRecipe.recipe_tbl.Recipe_tblDTO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "CreateNewRecipe", urlPatterns = {"/CreateNewRecipe"})
public class CreateNewRecipe extends HttpServlet {

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
        String url = "";
        //Get parameters
        HttpSession session = request.getSession();
        int userId = ((Account_tblDTO)session.getAttribute("USER")).getUserId();
        String recipeName = request.getParameter("txtRecipeName");
        int categoryId = Integer.parseInt(request.getParameter("txtCategoryId"));
        String description = request.getParameter("txtDescription");
        int prepTime = Integer.parseInt(request.getParameter("txtPrepTime"));
        int cookTime = Integer.parseInt(request.getParameter("txtCookTime"));
        int serving = Integer.parseInt(request.getParameter("txtServing"));
        int ingredientId = Integer.parseInt(request.getParameter("txtIngredientId"));
        double quantity = Double.parseDouble(request.getParameter("txtQuantity"));
        int unitId = Integer.parseInt(request.getParameter("txtUnitId"));
        // all validate data
        try {
//            public Recipe_tblDTO(int userId, int categoryId, String name, int serving, String description, int preTime, int cookTime)
            Recipe_tblDTO recipeDto = new Recipe_tblDTO(userId, categoryId, recipeName, serving, description, prepTime, cookTime);
            // call reippe DAO and insert into recipe_tbl
            Recipe_tblDAO recipeDao = new Recipe_tblDAO();
            boolean insertRecipeResult = recipeDao.insertRecipe(recipeDto);
            System.out.println("======RESULT=======" + insertRecipeResult);
            // call recipe_ingredientDao and indert into recipe_ingredient_tbl
            // call imageDao and insert into image_tbl
        } catch (SQLException ex) {
            log("CreateNewRecipe Controller _ SQL " + ex.getMessage());
        } finally {
            
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
