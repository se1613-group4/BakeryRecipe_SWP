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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
            throws ServletException, IOException, SQLException {
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

//            pattern = Pattern.compile(USERNAME_PATTERN); 
            Pattern usernamePattern = Pattern.compile("[a-zA-Z][a-zA-Z0-9]{6,20}");
            /*
            Must be 8-15 characters and must start with a letter
            May not contain special characters – only letters and numbers
            */
            Pattern passwordPattern = Pattern.compile("[^: \\&\\.\\~]*[a-z0-9]+[^:\\&\\.\\~]{6,30}");
            /*
            Must be 8-15 characters and must start with a letter
            Must contain at least one lower-case letter (abcdefghijklmnopqrstuvwxyz)
            Must contain at least one number (0123456789)
            Must not contain a colon (:); an ampersand (&); a period (.); a tilde (~); or a space.
            */
//            if (username.isEmpty()) {
//                foundErr = true;
//                errors.setUserameEmptyErr("Username must be not empty!");
//            }
//            if (usernamePattern.matcher(username).matches() == false) {
//                foundErr = true;
//                errors.setUserameFormatErr("Username wrong format, username "
//                        + "must be 8-15 characters and must start with a letter "
//                        + "and may not contain special characters");
//            }

//            if (password.isEmpty()) {
//                foundErr = true;
//                errors.setPasswordEmptyErr("Password must be not empty!");
//            }
//            if (passwordPattern.matcher(password).matches() == false) {
//                foundErr = true;
//                errors.setPasswordFormatErr("password wrong format, password "
//                        + "contain at least one lower-case letter, Must contain at least one number "
//                        + "and may not contain special characters");
//            }

//            if (pattern.matcher(username).matches()) {
//                foundErr = true;
//                errors.setUserameFormatErr("Username must có từ 3 - 15 kí tự!");
//            }
            if (foundErr) {
                request.setAttribute("LOGIN_ERR", errors);
            } else {
                //1. call model/DAO
                //- new DAO obj, then call method on DAO object
                Account_tblDAO dao = new Account_tblDAO();
                Account_tblDTO user = dao.login(username, password);
                //2. process result
                if (user != null) {
                    url = siteMaps.getProperty(AppContants.LoginFeatures.HOME_PAGE_USER);
                    HttpSession session = request.getSession(true);
                    session.setAttribute("USER", user);
                    session.setAttribute("LOGIN_PAGE1", user);
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
