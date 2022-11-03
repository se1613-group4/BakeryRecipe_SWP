/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package bakeryRecipe.controller;

import bakeryRecipe.account_tbl.Account_tblDTO;
import bakeryRecipe.save_tbl.Save_tblDAO;
import bakeryRecipe.utils.AppContants;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Properties;
import javax.naming.NamingException;
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
 * @author dangh
 */
@WebServlet(name = "CheckSavedRecipes", urlPatterns = {"/CheckSavedRecipes"})
public class CheckSavedRecipes extends HttpServlet {

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

        String url = siteMaps.getProperty(AppContants.SaveRecipe.SINGLE_RECIPE_PAGE);

        try {
            //Search saved recipe 
            int recipeId = Integer.parseInt(request.getParameter("recipeId"));
            System.out.println("-----------------search saved recipe: " + recipeId);
            Save_tblDAO saveDao = new Save_tblDAO();
            boolean searchSavedRecipeResult = false;
            HttpSession session = request.getSession();
            Account_tblDTO user = (Account_tblDTO) session.getAttribute("USER");
            if (user != null) {
                searchSavedRecipeResult = saveDao.SearchSaveRecipe(user.getUserId(), recipeId);
                if (searchSavedRecipeResult) {
                    request.setAttribute("SAVED", searchSavedRecipeResult);
                }
            }
            url = siteMaps.getProperty(AppContants.SaveRecipe.SINGLE_RECIPE_PAGE);

        } catch (SQLException ex) {
//            log("DisplaySingleRecipe Controller _ SQL " + ex.getMessage());
        } catch (NamingException ex) {

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
