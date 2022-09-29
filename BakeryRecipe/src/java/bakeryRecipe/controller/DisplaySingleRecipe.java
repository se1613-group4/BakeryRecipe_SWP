/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.controller;

import bakeryRecipe.recipe_tbl.Recipe_tblDAO;
import bakeryRecipe.recipe_tbl.Recipe_tblDTO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LamVo
 */
@WebServlet(name = "DisplaySingleRecipe", urlPatterns = {"/DisplaySingleRecipe"})
public class DisplaySingleRecipe extends HttpServlet {
    
    private final String RECIPE_NOT_FOUND_PAGE = "error_404.html";
    private final String SINGLE_RECIPE_PAGE = "single_recipe.jsp";
    
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
        
        String url = RECIPE_NOT_FOUND_PAGE;
        try {
            if (request.getParameter("recipeId") != null) {
                int recipeId = Integer.parseInt(request.getParameter("recipeId"));
                //1. Call DAO (method)
                Recipe_tblDAO recipeDao = new Recipe_tblDAO();
                Recipe_tblDTO recipeDto = recipeDao.getRecipe(recipeId);
                //2. Process result
                request.setAttribute("RECIPE_INFO", recipeDto);
                url = SINGLE_RECIPE_PAGE;
            }
        } catch (SQLException ex) {
            log("DisplaySingleRecipe Controller _ SQL " + ex.getMessage());
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
