/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package bakeryRecipe.controller;

import bakeryRecipe.profile_tbl.Profile_tblDAO;
import bakeryRecipe.profile_tbl.Profile_tblDTO;
import bakeryRecipe.recipe_tbl.Recipe_tblDAO;
import bakeryRecipe.utils.AppContants;
import java.io.IOException;
import java.sql.SQLException;
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
 @WebServlet(name = "adminUsdetail", urlPatterns = {"/adminUsdetail"})
 public class adminUsdetail extends HttpServlet {
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        /**
         * Get site map (Copy this for all controller)
         */
        ServletContext context = getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITEMAPS");        
        HttpSession session = request.getSession();

        String urlRewriting = AppContants.Admin.ADMIN_USDETAIL;
        String test = request.getParameter("usid");
        int  usid = test==null? 1 :  Integer.parseInt(test);
        try {
            Profile_tblDAO dao = new Profile_tblDAO();
            Profile_tblDTO  dto =dao.displayUserProfile(usid);
            
            if (dto != null) {
                    session.setAttribute( "usinf", dto);
                    urlRewriting ="adminHome";
            }
            
            
        } catch (SQLException ex) {
            log("RemoveRecipe Controller _ SQL " + ex.getMessage());
        } catch (NamingException ex) {
          Logger.getLogger(adminUsdetail.class.getName()).log(Level.SEVERE, null, ex);
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
