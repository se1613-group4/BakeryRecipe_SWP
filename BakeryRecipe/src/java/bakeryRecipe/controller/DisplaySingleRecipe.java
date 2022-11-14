/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.controller;

import bakeryRecipe.account_tbl.Account_tblDTO;
import bakeryRecipe.comment_tbl.Comment_tblDAO;
import bakeryRecipe.comment_tbl.Comment_tblDTO;
import bakeryRecipe.follow_tbl.Follow_tblDAO;
import bakeryRecipe.like_tbl.Like_tblDAO;
import bakeryRecipe.recipe_ingredient_tbl.Recipe_Ingredient_tblDAO;
import bakeryRecipe.recipe_ingredient_tbl.Recipe_Ingredient_tblDTO;
import bakeryRecipe.recipe_tbl.Recipe_tblDAO;
import bakeryRecipe.recipe_tbl.Recipe_tblDTO;
import bakeryRecipe.tag_detail_tbl.Tag_Detail_tblDAO;
import bakeryRecipe.tag_tbl.Tag_tblDAO;
import bakeryRecipe.utils.AppContants;
import bakeryRecipe.video_tbl.Video_tblDAO;
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
                String steps = recipeDto.getSteps();
                String[] stepArr = steps.split(" --- ");
                request.setAttribute("STEP_LIST", stepArr);
                // Load ingredient
                Recipe_Ingredient_tblDAO ingredientDetailDao = new Recipe_Ingredient_tblDAO();
                ingredientDetailDao.getIngredientDetail(recipeId);
                List<Recipe_Ingredient_tblDTO> ingredientDetailDtoList = ingredientDetailDao.getRecipeIngreDtoList();
                request.setAttribute("INGREDIENT_LIST", ingredientDetailDtoList);
                // load tags
                Tag_Detail_tblDAO tagDetailDao = new Tag_Detail_tblDAO();                
                List<Integer> listTagIds = tagDetailDao.getTagIds(recipeId);
                if (listTagIds != null) {
                    Tag_tblDAO tagDao = new Tag_tblDAO();
                    List<String> tagNames = new ArrayList<>();
                    for (Integer tagId : listTagIds) {
                        String tagName = tagDao.getTagName(tagId);
                        if (tagName != null) {
                            tagNames.add(tagName);
                        }
                    }
                    request.setAttribute("TAG_LIST", tagNames);
                }
                // Get video url
                Video_tblDAO vidDao = new Video_tblDAO();
                String vidUrl = vidDao.getVidUrl(recipeId);
                if (vidUrl!=null) {
                    String youtubeCode = GetYoutubeVideoCode(vidUrl);
                    request.setAttribute("YOUTUBE_CODE", youtubeCode);
                }
                
                 // Load similar recipes
                List<Recipe_tblDTO> similarRecipeResultList = recipeDao.displaySimilarRecipe(recipeDto.getCategoryId());
                request.setAttribute("SIMILAR_RECIPE_LIST", similarRecipeResultList);
                //----------------------------
                //thongnt section start
                //DISPLAY COMMENTS FUNCTION
                //1. Call DAO
                Comment_tblDAO commentDao = new Comment_tblDAO();
                List<Comment_tblDTO> commentsList = commentDao.getCommentByRecipeId(recipeId);
                //2. Process result
                request.setAttribute("COMMENTS_LIST", commentsList);
//                System.out.println("COMMENTS_LIST" + commentsList);
                
                
                //DISPLAY LIKES OF RECIPE FUNCTION
                //1. Call DAO
                Like_tblDAO likeDao = new Like_tblDAO();
                int likeCount = likeDao.getLikesNums(recipeId);
                //2. Process result
                request.setAttribute("LIKES_COUNT", recipeDto.getLikedCount());

                //CHECK IF LIKED and FOLLOWED FUNCTION
                HttpSession session = request.getSession(true);
                Follow_tblDAO followDao = new Follow_tblDAO();
                Account_tblDTO currentUser = (Account_tblDTO) session.getAttribute("USER");
                int isLiked = 0; //have not loged in OR have not liked
                int isfollowed = 0; //have not loged in OR have not followed

                if (currentUser == null) {
                    isLiked = -1; //have not loged in
                    isfollowed = -1; //have not loged in
                } else {
                    if (likeDao.isLiked(recipeId, currentUser.getUserId())) {
                        isLiked = 1;
                    }//end check if user has liked recipe
                    int recipeAuthorId = recipeDto.getAuthorInfo().getUserId();
                    System.out.println("PAIR FOLLOW: " + currentUser.getUserId() + "-" + recipeAuthorId);
                    System.out.println(followDao.isFollowed(1, 1));
                    if (followDao.isFollowed(currentUser.getUserId(), recipeAuthorId)) {
                        isfollowed = 1;
                    }//end check if user has followed this recipe's author
                }//end check if user has login
                
                request.setAttribute("ISLIKED", isLiked);
                request.setAttribute("ISFOLLOWED", isfollowed);

                //thongnt section end
                //----------------------------
                url = siteMaps.getProperty(AppContants.DisplaySingleRecipeFeature.CHECK_SAVED_RECIPE_CONTROLLER);

            }
        } catch (SQLException ex) {
            log("DisplaySingleRecipe Controller _ SQL " + ex.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
    }
    
    
    private String GetYoutubeVideoCode(String vidUrl) {
        int startIndex = vidUrl.indexOf("?v=");
        int endIndex = vidUrl.indexOf("&") > startIndex ? vidUrl.indexOf("&") : vidUrl.length();        
        return vidUrl.substring(startIndex+3, endIndex);
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
