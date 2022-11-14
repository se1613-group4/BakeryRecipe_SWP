/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.controller;

import bakeryRecipe.account_tbl.Account_tblDTO;
import bakeryRecipe.category_tbl.Category_tblDAO;
import bakeryRecipe.category_tbl.Category_tblDTO;
import bakeryRecipe.follow_tbl.Follow_tblDAO;
import bakeryRecipe.notification_tbl.Notification_tblDAO;
import bakeryRecipe.notification_tbl.Notification_tblDTO;
import bakeryRecipe.profile_tbl.Profile_tblDAO;
import bakeryRecipe.profile_tbl.Profile_tblDTO;
import bakeryRecipe.recipe_tbl.Recipe_tblDAO;
import bakeryRecipe.recipe_tbl.Recipe_tblDTO;
import bakeryRecipe.tag_tbl.Tag_tblDAO;
import bakeryRecipe.tag_tbl.Tag_tblDTO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
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
@WebServlet(name = "LoadHomePageController", urlPatterns = {"/LoadHomePageController"})
public class LoadHomePageController extends HttpServlet {

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
        try {
            HttpSession session = request.getSession(true);
            Recipe_tblDAO recipeDao = new Recipe_tblDAO();
           
            recipeDao.loadTopRecipe(3);
            List<Recipe_tblDTO> top3Recipes = recipeDao.getRecipeDtoList();
            session.setAttribute("TOP3_RECIPES", top3Recipes);
            
            recipeDao.loadTopRecipe(5);
            List<Recipe_tblDTO> top5Recipes = recipeDao.getRecipeDtoList();
            session.setAttribute("TOP5_RECIPES", top5Recipes);
            
            recipeDao.loadMostViewRecipe(3);
            List<Recipe_tblDTO> top3ViewRecipes = recipeDao.getRecipeDtoList();
            session.setAttribute("TOP3_VIEW_RECIPES", top3ViewRecipes);
            
            recipeDao.loadRecentlyRecipe();
            List<Recipe_tblDTO> recentlyRecipes = recipeDao.getRecipeDtoList();
            session.setAttribute("RECENTLY_RECIPES", recentlyRecipes);
            
            Category_tblDAO categoryDao = new Category_tblDAO();
            categoryDao.loadAllCategory();
            List<Category_tblDTO> allCategory = categoryDao.getCategoryDtoList();
            session.setAttribute("ALL_CATEGORY", allCategory);
             
            Tag_tblDAO tagDao = new Tag_tblDAO();
            tagDao.loadTopTag(10);
            List<Tag_tblDTO> allTag = tagDao.getTagDtoList();
            session.setAttribute("All_TAG", allTag);
           
            //hoanganh section start
            Profile_tblDAO daoProfile = new Profile_tblDAO();
            Follow_tblDAO daoFollow = new Follow_tblDAO();
            //process result
            Profile_tblDTO profile = daoProfile.displayMostRecipesUserProfile();
            List<Profile_tblDTO> profileList = daoProfile.getUsersTopFollower();
            int follower_amount = daoFollow.displayFollower(profile.getUserId());
            int following_amount = daoFollow.displayFollowing(profile.getUserId());
            session.setAttribute("MOST_RECIPE_PROFILE", profile);
            session.setAttribute("USER_MOST_FOLLOW_LIST", profileList);
            session.setAttribute("MOST_RECIPE_PROFILE_FOLLOWERS", follower_amount);
            session.setAttribute("MOST_RECIPE_PROFILE_FOLLOWING", following_amount); 
            //hoanganh section end

            //--- Listen to new NOTIFICATION //
             
             Account_tblDTO account = (Account_tblDTO) session.getAttribute("USER");
             if(account != null)
             {
              Notification_tblDAO notidao = new Notification_tblDAO();
              ArrayList<Notification_tblDTO> lsNoti = (ArrayList<Notification_tblDTO>) session.getAttribute("NOTIFIII"); ;
              ArrayList<Notification_tblDTO> dao = notidao.getListNoti(account.getUserId());
              if(lsNoti == null){
                  lsNoti = new ArrayList<>();
                  lsNoti.add(new Notification_tblDTO(0,0,"Hello there,wellcome to Bakery Recipe...", null ));
              }else{
                  lsNoti = dao==null ? lsNoti : dao;
              }
              
                   session.setAttribute("NOTIFIII",lsNoti);
            
             }
              //--- Listen to new NOTIFICATION //
        } catch (SQLException ex) {
            Logger.getLogger(LoadHomePageController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException e) {
            Logger.getLogger(LoadHomePageController.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            
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
