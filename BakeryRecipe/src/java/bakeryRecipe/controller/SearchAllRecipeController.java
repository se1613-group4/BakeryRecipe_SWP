/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package bakeryRecipe.controller;

import bakeryRecipe.category_tbl.Category_tblDAO;
import bakeryRecipe.category_tbl.Category_tblDTO;
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

/**
 *
 * @author ThongNT
 */
@WebServlet(name = "SearchAllRecipeController", urlPatterns = {"/SearchAllRecipeController"})
public class SearchAllRecipeController extends HttpServlet {
//    private final String HOME_PAGE = "index.jsp";
//    private final String SEARCH_RESULT_PAGE = "search.jsp";

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
        String url = siteMaps.getProperty(AppContants.SearchAllRecipesFeature.HOME_PAGE);

        String searchValue = request.getParameter("txtSearchValue");

        String[] categoryCheckboxs = request.getParameterValues("category-checkboxs");

        try {
            int searchNotFound = 1;//search not found is true by default
            if (!searchValue.trim().isEmpty()) {
                //1. Call DAO
                Recipe_tblDAO dao = new Recipe_tblDAO();
                Category_tblDAO catDao = new Category_tblDAO();

                //2. Process result
                List<Recipe_tblDTO> result = dao.searchAllRecipe(searchValue, categoryCheckboxs);
                List<Recipe_tblDTO> resultTop9 = dao.searchAllRecipePaging9(searchValue, 0);
                catDao.loadAllCategory();
                List<Category_tblDTO> categoryList = catDao.getCategoryDtoList();

                //3. setAttribute to request
                request.setAttribute("SEARCH_RESULT", result);
                request.setAttribute("SEARCH_RESULT_TOP9", resultTop9);
                request.setAttribute("CATEGORY_LIST", categoryList);
                if (result != null) {
                    searchNotFound = 0;//search not found is false
                }
            } else {
                searchNotFound = -1;//input empty search value
                //1. Call DAO
                Recipe_tblDAO dao = new Recipe_tblDAO();
                Category_tblDAO catDao = new Category_tblDAO();

                //2. Process result
                List<Recipe_tblDTO> result = dao.searchAllRecipe("", categoryCheckboxs);
                List<Recipe_tblDTO> resultTop9 = dao.searchAllRecipePaging9("", 0);
                catDao.loadAllCategory();
                List<Category_tblDTO> categoryList = catDao.getCategoryDtoList();

                //3. setAttribute to request
                request.setAttribute("SEARCH_RESULT", result);
                request.setAttribute("SEARCH_RESULT_TOP9", resultTop9);
                request.setAttribute("CATEGORY_LIST", categoryList);
            }

            request.setAttribute("SEARCH_NOT_FOUND", searchNotFound);
            System.out.println("SEARCH_NOT_FOUND" + searchNotFound);
            url = siteMaps.getProperty(AppContants.SearchAllRecipesFeature.SEARCH_RESULT_PAGE);
        } catch (SQLException ex) {
            log("SearchAllRecipe Controller _ SQL " + ex.getMessage());
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
