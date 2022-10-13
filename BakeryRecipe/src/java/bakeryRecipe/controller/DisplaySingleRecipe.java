/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.controller;

import bakeryRecipe.account_tbl.Account_tblDTO;
import bakeryRecipe.comment_tbl.Comment_tblDAO;
import bakeryRecipe.comment_tbl.Comment_tblDTO;
import bakeryRecipe.like_tbl.Like_tblDAO;
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
 * @author LamVo, thongnt
 */
@WebServlet(name = "DisplaySingleRecipe", urlPatterns = {"/DisplaySingleRecipe"})
public class DisplaySingleRecipe extends HttpServlet {

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

        //Get site map 
        ServletContext context = getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITEMAPS");
        // End get site map

        String url = siteMaps.getProperty(AppContants.DisplaySingleRecipeFeature.RECIPE_NOT_FOUND_PAGE);
        try {
            if (request.getParameter("recipeId") != null) {
                int recipeId = Integer.parseInt(request.getParameter("recipeId"));
                //1. Call DAO (method)
                Recipe_tblDAO recipeDao = new Recipe_tblDAO();
                Recipe_tblDTO recipeDto = recipeDao.getRecipe(recipeId);
                //2. Process result
                request.setAttribute("RECIPE_INFO", recipeDto);
                url = siteMaps.getProperty(AppContants.DisplaySingleRecipeFeature.SINGLE_RECIPE_PAGE);
                //----------------------------
                //thongnt section
                //DISPLAY COMMENTS FUNCTION
                //1. Call DAO
                Comment_tblDAO commentDao = new Comment_tblDAO();
                List<Comment_tblDTO> commentsList = commentDao.getCommentByRecipeId(recipeId);
                //2. Process result
                request.setAttribute("COMMENTS_LIST", commentsList);

                //DISPLAY LIKES OF RECIPE FUNCTION
                //1. Call DAO
                Like_tblDAO likeDao = new Like_tblDAO();
                int likeCount = likeDao.getLikesNums(recipeId);
                //2. Process result
                request.setAttribute("LIKES_COUNT", likeCount);

                //CHECK IF LIKED FUNCTION
                HttpSession session = request.getSession(true);
                Account_tblDTO currentUser = (Account_tblDTO) session.getAttribute("USER");
                int isLiked = 0;
                if (currentUser == null) {
                    isLiked = -1;
                } else {
                    if (likeDao.isLiked(recipeId, currentUser.getUserId())) {
                        isLiked = 1;
                    }//end check if user has liked recipe                    
                }//end check if user has login

                request.setAttribute("ISLIKED", isLiked);
                System.out.println("ISLIKED ======= " + isLiked);

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
