/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package bakeryRecipe.controller;

import bakeryRecipe.account_tbl.Account_tblDAO;
import bakeryRecipe.account_tbl.Account_tblDTO;
import bakeryRecipe.google_tbl.GooglePojo;
import bakeryRecipe.profile_tbl.Profile_tblDAO;
import bakeryRecipe.profile_tbl.Profile_tblDTO;
import bakeryRecipe.user_tbl.User_tblDAO;
import bakeryRecipe.user_tbl.User_tblDTO;
import bakeryRecipe.utils.AppContants;
import bakeryRecipe.utils.GoogleUtils;
import bakeryRecipe.utils.SHA256;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static org.apache.tomcat.jni.User.username;

/**
 *
 * @author PC
 */
@WebServlet("/login-google")
public class LoginGoogleServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public LoginGoogleServlet() {
        super();
    }

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
            throws ServletException, IOException, NoSuchAlgorithmException {
        response.setContentType("text/html;charset=UTF-8");
        ServletContext context = getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITEMAPS");
        String url = siteMaps.getProperty(AppContants.DisplayHomePageFeature.HOME_PAGE);
        Date lastModified = Date.valueOf(LocalDate.now());
        String code = request.getParameter("code");
        boolean foundErr = false;
        try {
            if (code == null || code.isEmpty()) {
                RequestDispatcher dis = request.getRequestDispatcher(url);
                dis.forward(request, response);
            } else {
                String accessToken = GoogleUtils.getToken(code);
                GooglePojo accGG = GoogleUtils.getUserInfo(accessToken);
                Account_tblDAO accDAO = new Account_tblDAO();
                //boolean checkUsername= accDAO.checkUserName(accGG.getId());
                String password = (String) accGG.getId();
                String avt=(String) accGG.getPicture();
                byte[] getSha = SHA256.getSHA(password);
                String passSHA = SHA256.toHexString(getSha);

                Account_tblDTO user = accDAO.loginGG(accGG.getEmail(), passSHA);
                if (user != null) {
                    boolean checkAccIsActive = accDAO.checkAccountIsActiveGG(accGG.getEmail());
                    if (checkAccIsActive == false) {
                        foundErr = true;
                        String message = "Your account not active,please contant admin";
                        request.getSession().setAttribute("Not_active", message);
                        RequestDispatcher rd = request.getRequestDispatcher(url);
                        rd.forward(request, response);
                    }
                    HttpSession session = request.getSession(true);
                    session.setAttribute("USER", user);
                    session.setAttribute("LOGIN_USER", user);
                    if (user.isIsAdmin() == true) {
                        url = siteMaps.getProperty(AppContants.Admin.ADMIN_DASHBOARD);
                    } else {
                        url = siteMaps.getProperty(AppContants.LoginFeatures.GET_NOTIFICATION_DATA_CONTROLLER);
                    }
                } else {

                    User_tblDTO userDto = new User_tblDTO(lastModified);
                    //Account_tblDTO accDto = new Account_tblDTO(0, 0, username, passSHA, email, phoneNumber, lastModified, true, false);
                    Profile_tblDTO proDto = new Profile_tblDTO();
                    //create a database model
                    User_tblDAO userDao = new User_tblDAO();
                    Account_tblDAO accDao = new Account_tblDAO();
                    Profile_tblDAO proDao = new Profile_tblDAO();

                    boolean userResult = userDao.CreateUser_tbl();
                    int cuurentUserId = userDao.getCurrentUserId();
                    boolean accResult = accDao.saveUserGG(accGG, passSHA, cuurentUserId);
                    boolean profileResult = proDao.CreateProfileGG_tbl(proDto, cuurentUserId, accGG.getName(),accGG.getPicture());
                    if (userResult && accResult && profileResult) {
                        url = siteMaps.getProperty(AppContants.LoginFeatures.GET_NOTIFICATION_DATA_CONTROLLER);
                        HttpSession session = request.getSession(true);

                        String message = "Your account has been successfully created, please login to use the website";
                        request.getSession().setAttribute("Register_done", message);
                    }
                }
            }

        } catch (SQLException ex) {
            String msg = ex.getMessage();
            log("CreateAccountController _ SQL " + msg);

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
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginGoogleServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginGoogleServlet.class.getName()).log(Level.SEVERE, null, ex);
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
