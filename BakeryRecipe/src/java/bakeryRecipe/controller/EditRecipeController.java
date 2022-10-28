/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.controller;

import bakeryRecipe.account_tbl.Account_tblDTO;
import bakeryRecipe.image_tbl.Image_tblDAO;
import bakeryRecipe.recipe_ingredient_tbl.Recipe_Ingredient_tblDAO;
import bakeryRecipe.recipe_tbl.Recipe_tblDAO;
import bakeryRecipe.recipe_tbl.Recipe_tblDTO;
import bakeryRecipe.utils.AppContants;
import bakeryRecipe.video_tbl.Video_tblDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
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
@WebServlet(name = "EditRecipeController", urlPatterns = {"/EditRecipeController"})
public class EditRecipeController extends HttpServlet {

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
        
        // Mapping url        
        String url = siteMaps.getProperty(AppContants.EditRecipeFeature.RECIPE_NOT_FOUND);
        //Get parameters
        HttpSession session = request.getSession();
        int userId = ((Account_tblDTO)session.getAttribute("USER")).getUserId();
        String recipeName = request.getParameter("txtRecipeName");
        int categoryId = Integer.parseInt(request.getParameter("txtCategoryId"));
        String description = request.getParameter("txtDescription");
        int prepTime = Integer.parseInt(request.getParameter("txtPrepTime"));
        int cookTime = Integer.parseInt(request.getParameter("txtCookTime"));
        int serving = Integer.parseInt(request.getParameter("txtServing"));
        String[] ingredientArr = request.getParameterValues("txtIngredient");
        String[] steps = request.getParameterValues("txtStep");
        String[] imgUrls = request.getParameterValues("txtImgUrl");
        String vidUrl = request.getParameter("txtVidUrl");
        int recipeId = Integer.parseInt(request.getParameter("txtRecipeId"));
        // all validate data
        try {
            String stepStr = " ";
            if (!"".equals(steps[0].trim())) {
                stepStr = steps[0];
            }
            for (int i=1; i<steps.length; i++) {
                if (!"".equals(steps[i].trim())) {
                    stepStr = stepStr + " --- " + steps[i];
                }
            }
            Recipe_tblDTO recipeDto = new Recipe_tblDTO(userId, categoryId, recipeName, serving, description, prepTime, cookTime,stepStr);
            // call reippe DAO and update into recipe_tbl
            Recipe_tblDAO recipeDao = new Recipe_tblDAO();
            boolean resultUpdateRecipe = recipeDao.updateRecipe(recipeDto, recipeId);
//            System.out.println("======RESULT INSERT RECIPE=======" + resultInsertRecipe);
            
            // call recipe_ingredientDao and indert into recipe_ingredient_tbl
            Recipe_Ingredient_tblDAO repIngreDao = new Recipe_Ingredient_tblDAO();
            // process ingrStr
            Map<Integer, Double> ingredientList = new HashMap<>();
            for (String ingredientStr : ingredientArr) {
                String[] tokens = ingredientStr.split("-");
                int ingreId = Integer.parseInt(tokens[0]);
                double quantity = Double.parseDouble(tokens[1]);
                ingredientList.put(ingreId, quantity);
            }
            // delete old ingredient detail
            repIngreDao.removeIngredientDetail(recipeId);
            // add new ingredient detail
            boolean resultUpdateIngre = repIngreDao.insertIngredientDetail(recipeId, ingredientList);
            System.out.println("======RESULT INSERT INGRE=======" + resultUpdateIngre);
            
            // call imageDao and insert into image_tbl
            boolean resultUpdateImg = true;
            if (imgUrls != null && !"".equals(imgUrls[0])) {
                Image_tblDAO imgDao = new Image_tblDAO();
                // remove old img of that reicpe
                imgDao.removeImg(recipeId);
                // add new img(s) of that recipe
                resultUpdateImg = imgDao.insertImg(recipeId, imgUrls);
//                if (imgDao.removeImg(recipeCurrentId)) {
//                    resultInsertImg = imgDao.insertImg(recipeCurrentId, imgUrls);
//                }
                System.out.println("======RESULT INSERT IMAGE=======" + resultUpdateImg);
            }          
            // call videoDao and insert into video_tbl
            boolean resultInsertVid = true;
            if (!"".equals(vidUrl)) {
                Video_tblDAO vidDao = new Video_tblDAO();
                resultInsertVid = vidDao.insertVideo(recipeId, vidUrl);
                System.out.println("======RESULT INSERT VIDEO=======" + resultInsertVid);
            }   
            // All insert results are true -> redirect to MyRecipes Page
            if (resultUpdateRecipe && resultUpdateIngre && resultUpdateImg && resultInsertVid) {
                url = "DisplaySingleRecipe?recipeId="+recipeId;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateNewRecipe.class.getName()).log(Level.SEVERE, null, ex);
            //            log("CreateNewRecipe Controller _ SQL " + ex.getMessage());
        }finally {
            response.sendRedirect(url);
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
