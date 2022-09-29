/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package bakeryRecipe.controller;

import bakeryRecipe.account_tbl.Account_tblDAO;
import bakeryRecipe.account_tbl.Account_tblDTO;
import bakeryRecipe.user_tbl.User_tblDAO;
import bakeryRecipe.user_tbl.User_tblDTO;
import bakeryRecipe.profile_tbl.Profile_tblDAO;
import bakeryRecipe.profile_tbl.Profile_tblDTO;
import bakeryRecipe.utils.DBConnection;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {
    private final String ERROR = "home_page.jsp";
    private final String SUCCESS = "login.html";
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
        
        String url = ERROR;
        //String register = request.getParameter("btAction");
        
        try {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String phoneNumber= request.getParameter("phoneNumber");
            Date lastModified= Date.valueOf(LocalDate.now());
            //make user object
            User_tblDTO userDto=new User_tblDTO(lastModified);
            Account_tblDTO accDto = new Account_tblDTO(0, 0, name, password, email, phoneNumber, lastModified, true, false);
            Profile_tblDTO proDto= new Profile_tblDTO(0, 0, name, ERROR, url, email, lastModified);
            //create a database model
            User_tblDAO userDao= new User_tblDAO(DBConnection.getConnection());
            Account_tblDAO accDao = new Account_tblDAO(DBConnection.getConnection());
            Profile_tblDAO proDao = new Profile_tblDAO();
            
            boolean userResult = userDao.CreateUser_tbl();
            int cuurentUserId = userDao.getCurrentUserId();
            boolean accResult = accDao.saveUser(accDto, cuurentUserId);
            boolean profileResult = proDao.CreateProfile_tbl(proDto, cuurentUserId);
            
//            if (userDao.CreateUser_tbl() && accDao.saveUser(dto) ) {
//            response.sendRedirect("home_page.jsp");
//            } else {
//                    String errorMessage = "User Available";
//                    HttpSession regSession = request.getSession();
//                    regSession.setAttribute("RegError", errorMessage);
//                    response.sendRedirect("registration.jsp");
//                    }
            if (userResult && accResult && profileResult) {
                HttpSession session = request.getSession();
                session.setAttribute(name, name);
                response.sendRedirect(SUCCESS);
                
            }

        } catch (SQLException ex) {
            log("Error at RegisterServlet: "+ex.toString());
        } finally{
            request.getRequestDispatcher(url).forward(request, response);
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
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
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
