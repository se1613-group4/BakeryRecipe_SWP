/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package bakeryRecipe.controller;

import bakeryRecipe.account_tbl.Account_tblDAO;
import bakeryRecipe.account_tbl.Account_tblDTO;
import bakeryRecipe.account_tbl.ResetPasswordError;
import bakeryRecipe.utils.AppContants;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Properties;
import java.util.regex.Pattern;
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
 * @author PC
 */
@WebServlet(name = "ResetPasswordServlet", urlPatterns = {"/ResetPasswordServlet"})
public class ResetPasswordServlet extends HttpServlet {

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
        ServletContext context = getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITEMAPS");
        String urlRewriting = siteMaps.getProperty(AppContants.ResetPasswordFeartures.RESET_PASSWORD_PAGE);
        Account_tblDAO accDAO = new Account_tblDAO();
        HttpSession session = request.getSession();
        Account_tblDTO user = (Account_tblDTO) session.getAttribute("USER");
        ResetPasswordError errors = new ResetPasswordError();
        boolean foundErr = false;
        String olePassword = request.getParameter("txtOldPassword");
        String confirm = request.getParameter("txtConfirm");
        String newPassword = request.getParameter("txtNewPassword");
        Pattern passwordPattern = Pattern.compile("[^: \\&\\.\\~]*[a-z0-9]+[^:\\&\\.\\~]{6,30}");
        try  {
            boolean checkOlePassword= accDAO.checkPasword(user.getUserId(), olePassword);
            if (checkOlePassword==false) {
                foundErr = true;
                errors.setOldPasswordWrongErr("Wrong old password please check and re-enter");
            } 
            boolean checkNewPassword= accDAO.checkPasword(user.getUserId(), newPassword);
            if (checkNewPassword==true) {
                foundErr = true;
                errors.setNewPasswordSameAsErr("The new password must not be the same as the old password");
            }
            if (passwordPattern.matcher(newPassword).matches() == false) {
                foundErr = true;
                errors.setNewPasswordFormatErr("password wrong format.\n  "
                        + "Password contain at least one lower-case letter.\n"
                        + "Must contain at least one number "
                        + "and may not contain special characters");
            } 
            if (!confirm.trim().equals(newPassword)) {
                foundErr = true;
                errors.setConfirmNotMathched("Confirm must matches new password");
            }if (foundErr) {
                request.setAttribute("RESETPASSWOD_ERR", errors);
            } else {
                Account_tblDTO accDTO = new Account_tblDTO();
                Account_tblDAO accDao = new Account_tblDAO();
                boolean result = accDao.uploadPassword(user.getUserId(), olePassword, newPassword);
                if (result = true) {
                    urlRewriting = siteMaps.getProperty(AppContants.ResetPasswordFeartures.USER_HOME_PAGE);
                    session = request.getSession(true);
                    //session.setAttribute(olePassword, olePassword);
                    String message = "Your password has been successfully upload";
                    request.getSession().setAttribute("message", message);
                } else {
                    errors.setOldPasswordWrongErr("Username existed try again!");
                    request.setAttribute("RESETPASSWOD_ERR", errors);
                }
            }
        }catch (SQLException ex) {
            log("DeleteAccountServlet _ SQL " + ex.getMessage());
        } finally {
            // goi sendRedirect de btAction ko bi goi lai -> ko bi trung lai
            RequestDispatcher rd = request.getRequestDispatcher(urlRewriting);
            rd.forward(request, response); // sendRedirect + urlRewriting ~ 
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
