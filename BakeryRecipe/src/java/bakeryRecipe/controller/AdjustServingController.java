/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.controller;

import bakeryRecipe.recipe_ingredient_tbl.Recipe_Ingredient_tblDAO;
import bakeryRecipe.recipe_ingredient_tbl.Recipe_Ingredient_tblDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LamVo
 */
@WebServlet(name = "AdjustServingController", urlPatterns = {"/AdjustServingController"})
public class AdjustServingController extends HttpServlet {

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
        int numServing = Integer.parseInt(request.getParameter("numServing"));
        int recipeId = Integer.parseInt(request.getParameter("recipeId"));
        int serving = Integer.parseInt(request.getParameter("serving"));
        try (PrintWriter out = response.getWriter()) {
            //Get the ingredient list
            Recipe_Ingredient_tblDAO ingredientDetailDao = new Recipe_Ingredient_tblDAO();
            ingredientDetailDao.getIngredientDetail(recipeId);
            List<Recipe_Ingredient_tblDTO> ingredientDetailDtoList = ingredientDetailDao.getRecipeIngreDtoList();
            
            /* Out put to the screen*/
            for (Recipe_Ingredient_tblDTO ingredient : ingredientDetailDtoList) {
                double quantity =  Math.round((ingredient.getQuantity() / serving) * numServing); // ko hien thi so thap phan dc
                String unit = ingredient.getUnit();
                if (unit.equals("none")) unit="";
                out.println("<div class=\"ingredient\">\n" +
"                       <p><b><span class=\"ingredient-quantity\">"+quantity+"</span> \n" +
                                      unit+"</b> \n" +
"                                     "+ingredient.getIngredientName()+"</p>    \n" +
"                       </div>");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdjustServingController.class.getName()).log(Level.SEVERE, null, ex);
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
