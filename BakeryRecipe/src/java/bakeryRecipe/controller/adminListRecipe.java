/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package bakeryRecipe.controller;

import bakeryRecipe.profile_tbl.Profile_tblDAO;
import bakeryRecipe.profile_tbl.Profile_tblDTO;
import bakeryRecipe.recipe_tbl.Recipe_tblDAO;
import bakeryRecipe.recipe_tbl.Recipe_tblDTO;
import bakeryRecipe.utils.AppContants;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jexk
 */
@WebServlet(name = "listRecipeAdmin", urlPatterns = {"/listRecipeAdmin"})
 public class adminListRecipe extends HttpServlet {
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        /**
         * Get site map (Copy this for all controller)
         */
        ServletContext context = getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITEMAPS");        
        HttpSession session = request.getSession();

        String urlRewriting = AppContants.Admin.ADMIN_HOME;
        String test = request.getParameter("usrecid");
        int  usid = test==null? 0 :  Integer.parseInt(test);
        
        try {
             Recipe_tblDAO dao = new Recipe_tblDAO();
            ArrayList<Recipe_tblDTO> rslt = dao.AdmingetRecipebyUser(usid);
            
            
            if (rslt != null) {
                    session.setAttribute( "ADMIN_LIST_RECIPE", rslt);
            }
            
            
        } catch (SQLException ex) {
            log("RemoveRecipe Controller _ SQL " + ex.getMessage());
        } finally {
            response.sendRedirect(urlRewriting);
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
