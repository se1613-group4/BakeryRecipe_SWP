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
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author LamVo
 */
@WebServlet(name = "CreateNewRecipe", urlPatterns = {"/CreateNewRecipe"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)
public class CreateNewRecipe extends HttpServlet {
    //Save images in absolute directory path
    private static final String SAVE_DIR = "D:" + File.separator + "bakeryrecipe_images";
    
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
        String url = siteMaps.getProperty(AppContants.CreateRecipeFeature.ERROR_PAGE);
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
//        String[] imgUrls = request.getParameterValues("txtImgUrl");
        String vidUrl = request.getParameter("txtVidUrl");
        // all validate data
        try {
            /*
            * INSERT TO RECIPE TABLE   
            */
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
            // call reippe DAO and insert into recipe_tbl
            Recipe_tblDAO recipeDao = new Recipe_tblDAO();
            boolean resultInsertRecipe = recipeDao.insertRecipe(recipeDto);
//            System.out.println("======RESULT INSERT RECIPE=======" + resultInsertRecipe);
            /*
            * INSERT TO RECIPE_INGREDIENT TABLE
            */
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
            int recipeCurrentId = recipeDao.getCurrentIdent();
            boolean resultInsertIngre = repIngreDao.insertIngredientDetail(recipeCurrentId, ingredientList);
            System.out.println("======RESULT INSERT INGRE=======" + resultInsertIngre);
            
            /*
            * INSERT TO IMAGE TABLE   
            */
            // Get uploaded image files
            File fileSaveDir = new File(SAVE_DIR);
            if (!fileSaveDir.exists()) {
                fileSaveDir.mkdir();
            }
            String[] imgUrls = new String[5];
            int i =0;
            //You need this loop if you submitted more than one file   
            for (Part part : request.getParts()) {
                String fileName = ExtractFileName(part);
                if (!fileName.isEmpty()) {
                    String filePath = SAVE_DIR + File.separator +fileName;
                    imgUrls[i++] = "/bakeryrecipe_images/" + fileName;
                    part.write(filePath);
                }
            }
            // call imageDao and insert into image_tbl
            boolean resultInsertImg = true;
            if (imgUrls != null && !"".equals(imgUrls[0])) {
                Image_tblDAO imgDao = new Image_tblDAO();                
                imgDao.removeImg(recipeCurrentId);
                resultInsertImg = imgDao.insertImg(recipeCurrentId, imgUrls);
                System.out.println("======RESULT INSERT IMAGE=======" + resultInsertImg);
            }
            /*
            * INSERT TO VIDEO TABLE    
            */
            // call videoDao and insert into video_tbl
            boolean resultInsertVid = true;
            if (!"".equals(vidUrl)) {
                Video_tblDAO vidDao = new Video_tblDAO();
                resultInsertVid = vidDao.insertVideo(recipeCurrentId, vidUrl);
                System.out.println("======RESULT INSERT VIDEO=======" + resultInsertVid);
            }   
            // All insert results are true -> redirect to MyRecipes Page
            if (resultInsertRecipe && resultInsertIngre && resultInsertImg && resultInsertVid) {
                url = siteMaps.getProperty(AppContants.CreateRecipeFeature.MY_RECIPES_PAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateNewRecipe.class.getName()).log(Level.SEVERE, null, ex);
            //            log("CreateNewRecipe Controller _ SQL " + ex.getMessage());
        }finally {
            response.sendRedirect(url);
        }
    }
    
    // file name of the upload file is included in content-disposition     header like this:
    //form-data; name="dataFile"; filename="PHOTO.JPG"
    private String ExtractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1); // return: PHOTO.JPG
            }
        }
        return "";
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
