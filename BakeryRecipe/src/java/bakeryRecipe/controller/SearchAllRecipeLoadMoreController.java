/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package bakeryRecipe.controller;

import bakeryRecipe.recipe_tbl.Recipe_tblDAO;
import bakeryRecipe.recipe_tbl.Recipe_tblDTO;
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
 * @author ThongNT
 */
@WebServlet(name = "SearchAllRecipeLoadMoreController", urlPatterns = {"/SearchAllRecipeLoadMoreController"})
public class SearchAllRecipeLoadMoreController extends HttpServlet {

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
        String searchValue = request.getParameter("searchValue");
        int startNumber = Integer.parseInt(request.getParameter("startNumber"));

        try ( PrintWriter out = response.getWriter()) {
            //1. Call DAO
            Recipe_tblDAO dao = new Recipe_tblDAO();

            //2. Process result
            List<Recipe_tblDTO> result = dao.searchAllRecipePaging9(searchValue, startNumber);
            if (result != null) {
                for (Recipe_tblDTO recipeDto : result) {
                    out.println("<div class=\"col-lg-4 col-md-6 col-sm-6 col-12 search-result-box\">\n"
                            + "                                            <div class=\"product-box-layout1\">\n"
                            + "                                                <figure class=\"item-figure\">\n"
                            + "                                                    <a href=\"DisplaySingleRecipe?recipeId=" + recipeDto.getRecipeId() + "\">\n"
                            + "                                                        <img src='" + recipeDto.getImage().getImgLink() + "' alt=\"Recipe\"></a>\n"
                            + "                                                </figure>\n"
                            + "                                                <div class=\"item-content\">\n"
                            + "                                                    <span class=\"sub-title\">" + recipeDto.getCategory().getName() + "</span>\n"
                            + "                                                    <h3 class=\"item-title\">\n"
                            + "                                                        <a href=\"DisplaySingleRecipe?recipeId=" + recipeDto.getRecipeId() + "\">\n"
                            + recipeDto.getName() + "</a>\n"
                            + "                                                    </h3>\n"
                            + "\n"
                            + "                                                    <p>" + recipeDto.getDescription() + " </p>\n"
                            + "                                                    <ul class=\"entry-meta\">\n"
                            + "                                                        <li><a href=\"#\"><i class=\"fas fa-clock\"></i>" + recipeDto.getTotalTime() + " minute</a></li>\n"
                            + "                                                        <li><a href=\"#\"><i class=\"fas fa-user\"></i>by <span>" + recipeDto.getAuthorInfo().getFullName() + "</span></a></li>\n"
                            + "                                                        <li><a href=\"#\"><i class=\"fas fa-heart\"></i>" + recipeDto.getLikedCount() + " Likes</a></li>\n"
                            + "                                                    </ul>\n"
                            + "                                                </div>\n"
                            + "                                            </div>\n"
                            + "                                        </div>");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
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
