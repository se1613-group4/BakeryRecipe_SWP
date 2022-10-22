/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package bakeryRecipe.controller;

import bakeryRecipe.account_tbl.Account_tblDAO;
import bakeryRecipe.account_tbl.Account_tblDTO;
import bakeryRecipe.account_tbl.LoginError;
import java.io.IOException;
import java.sql.SQLException;
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
import bakeryRecipe.utils.AppContants;
import java.util.regex.Pattern;
import bakeryRecipe.utils.SHA256;
import java.security.NoSuchAlgorithmException;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author PC
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
//private static final String USERNAME_PATTERN = "^[a-z0-9._-]{3,15}$"; 
//private Pattern pattern;    

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
            throws ServletException, IOException, SQLException, NoSuchAlgorithmException {
        response.setContentType("text/html;charset=UTF-8");

        ServletContext context = getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITEMAPS");
        String url = siteMaps.getProperty(AppContants.LoginFeatures.LOGIN_PAGE);
        LoginError errors = new LoginError();
        boolean foundErr = false;
        try {
            /* TODO output your page here. You may use following sample code. */
            //feth data from login form            
            String username = request.getParameter("txtUsername").trim();
            String password = request.getParameter("txtPassword");
            byte[] getSha= SHA256.getSHA(password);
            String passSHA= SHA256.toHexString(getSha);
            if (foundErr) {
                request.setAttribute("LOGIN_ERR", errors);
            } else {
                //1. call model/DAO
                //- new DAO obj, then call method on DAO object
                Account_tblDAO dao = new Account_tblDAO();
                Account_tblDTO user = dao.login(username, passSHA);
                //2. process result
                if (user != null) {
                    //url = siteMaps.getProperty(AppContants.LoginFeatures.HOME_PAGE_USER);
                    HttpSession session = request.getSession(true);
                    session.setAttribute("USER", user);
                    session.setAttribute("LOGIN_USER", user);
                    if (user.isIsAdmin() == true) {
                        url = siteMaps.getProperty(AppContants.LoginFeatures.LOGIN_PAGE);
                    } else {
                        url = siteMaps.getProperty(AppContants.LoginFeatures.HOME_PAGE_USER);
                    }
                    
                } //end if user click login
                else {
                    errors.setAccountNotFound("Wrong username and password! Try again!");
                    request.setAttribute("LOGIN_ERR", errors);
                }
            }
        } catch (SQLException ex) {
            log("LoginController _ SQL " + ex.getMessage());

        } finally {
//            response.sendRedirect(url);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
