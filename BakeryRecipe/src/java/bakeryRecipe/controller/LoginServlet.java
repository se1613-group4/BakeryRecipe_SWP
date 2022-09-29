/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package bakeryRecipe.controller;

import bakeryRecipe.account_tbl.Account_tblDAO;
import bakeryRecipe.account_tbl.Account_tblDTO;
import bakeryRecipe.utils.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
private final String ERROR = "index.jsp";
    private static final String SUCCESS="home_page_user.jsp";
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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */                 
            //feth data from login form
            
            String username = request.getParameter("txtUsername");
            String pass = request.getParameter("txtPassword");
            if(username==null || username.isEmpty()){
                request.setAttribute("errorUserID", "UserID not empty");
                
            }
            if(pass==null || pass.isEmpty()){
                 request.setAttribute("errorUserPassword", "Password not empty");
            } if (username != null && pass != null && !username.isEmpty() && !pass.isEmpty()) {
                Account_tblDAO dao = new Account_tblDAO(DBConnection.getConnection());
                Account_tblDTO user = dao.login(username, pass);
                if (user != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("USER", user);
                    //response.sendRedirect("welcome.jsp");
                    response.sendRedirect(SUCCESS);
                    
                }else{
                    out.println("user not found");
                }
            }
            
//            Account_tblDAO dao = new Account_tblDAO(DBConnection.getConnection());
//            Account_tblDTO acc = dao.login(username, pass);
//            
//            if(acc!=null){
//                HttpSession session = request.getSession();
//                session.setAttribute("LOGIN", acc);
////                response.sendRedirect("welcome.jsp");
//                response.sendRedirect("index_1.jsp");
//            }else{
//                out.println("user not found");
//            }

            
        }catch (Exception e) {
            log("Error at LoginServlet: "+e.toString());
        }finally{
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
