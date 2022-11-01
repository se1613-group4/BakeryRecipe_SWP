/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package bakeryRecipe.controller;

import bakeryRecipe.account_tbl.Account_tblDAO;
import bakeryRecipe.account_tbl.Account_tblDTO;
import bakeryRecipe.account_tbl.RegisterError;
import bakeryRecipe.user_tbl.User_tblDAO;
import bakeryRecipe.user_tbl.User_tblDTO;
import bakeryRecipe.profile_tbl.Profile_tblDAO;
import bakeryRecipe.profile_tbl.Profile_tblDTO;
import bakeryRecipe.utils.AppContants;
import bakeryRecipe.utils.SHA256;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
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
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

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
        String url = siteMaps.getProperty(AppContants.RegisterFeatures.ERROR_PAGE);
        RegisterError errors = new RegisterError();
        boolean foundErr = false;
        String username = request.getParameter("txtUsername");
        String email = request.getParameter("txtEmail");
        String password = request.getParameter("txtPassword");
        
        String fullname =request.getParameter("txtFullname");
        String confirm = request.getParameter("txtConfirm");
        String phoneNumber = request.getParameter("txtPhonenumber");
        Date lastModified = Date.valueOf(LocalDate.now());
        //String register = request.getParameter("btAction");
        Pattern usernamePattern = Pattern.compile("[a-zA-Z][a-zA-Z0-9]{5,15}");
        /*
        Must be 8-15 characters and must start with a letter
        May not contain special characters – only letters and numbers
         */
        Pattern passwordPattern = Pattern.compile("[a-zA-Z0-9]{8,}$");
        //Pattern passwordPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
        /*
        Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character
         */
        //Pattern fullnamePattern = Pattern.compile("^([a-zA-Z0-9]+|[a-zA-Z0-9]+\\s{1}[a-zA-Z0-9]{1,}|[a-zA-Z0-9]+\\s{1}[a-zA-Z0-9]{3,}\\s{1}[a-zA-Z0-9]{1,})$");
        Pattern emailPattern = Pattern.compile(
                "^[a-zA-Z][\\w-.]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$");
//        String EMAIL_PATTERN
//                = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
        /*  - Bắt đầu bằng chữ cái.
            - Chỉ chứa chữ cái, chữ số và dấu gạch ngang (-).
            - Chứa một ký tự @, sau @ là tên miền.
            - Tên miền có thể là domain.xxx.yyy hoặc domain.xxx. 
                Trong đó xxx và yyy là các chữ cái và có độ dài từ 2 trở lên.*/
        Pattern phonenumberPattern = Pattern.compile("(84|0[3|5|7|8|9])+([0-9]{8})");
        /*
        0388888888
        0588888888
        0788888888
        0888888888
        0988888888
        8488888888
         */
        try {
            Account_tblDAO accDAO = new Account_tblDAO();
            if (usernamePattern.matcher(username).matches() == false) {
                foundErr = true;
                errors.setUsernameFormatErr("Username wrong format.\n "
                        + "Username must be 6-15 characters.\n "
                        + "Must start with a letter.\n "
                        + "May not contain special characters");
            }

            if (passwordPattern.matcher(password).matches() == false) {
                foundErr = true;
                errors.setPasswordFormatErr("Password wrong format.\n  "
                        + "Minimum eight characters\n"
                        + "May not contain special character");
            } 
            if (!confirm.trim().equals(password)) {
                foundErr = true;
                errors.setConfirmNotMathched("Confirm must matches password");
            }
//            if (fullnamePattern.matcher(fullname).matches() == false) {
//                foundErr = true;
//                errors.setFullnameFormatErr("Fullname wrong format");
//            }
            
            boolean checkEmailExit = accDAO.checkEmail(email);
            if (emailPattern.matcher(email).matches() == false) {
                foundErr = true;
                errors.setEmailFormatErr("Email Start with a letter.\n"
                        + "              - Contains only letters, numbers and dashes (-), doc (.)\n"
                        + "              - Contains an @ character, after @ is the domain name.");
            }
            if (checkEmailExit == true) {
                foundErr = true;
                errors.setEmailExisted("Email existed try again!");
            }
            
            boolean checkPhonenumberExit = accDAO.checkPhonenumber(phoneNumber);
            if (phonenumberPattern.matcher(phoneNumber).matches() == false) {
                foundErr = true;
                errors.setPhonenumberFormatErr("Phonenumer must is Vietnam's phone number!");
            } 
            if (checkPhonenumberExit == true) {
                foundErr = true;
                errors.setPhonenumberExisted("Phonenumber existed try again!");
            }
            
            if (foundErr) {
                request.setAttribute("REGISTER_ERR", errors);
            } else {
                //make user object
                byte[] getSha= SHA256.getSHA(password);
                String passSHA= SHA256.toHexString(getSha);
                User_tblDTO userDto = new User_tblDTO(lastModified);
                Account_tblDTO accDto = new Account_tblDTO(0, 0, username, passSHA, email, phoneNumber, lastModified, true, false);
                Profile_tblDTO proDto = new Profile_tblDTO();
                //create a database model
                User_tblDAO userDao = new User_tblDAO();
                Account_tblDAO accDao = new Account_tblDAO();
                Profile_tblDAO proDao = new Profile_tblDAO();

                boolean userResult = userDao.CreateUser_tbl();
                int cuurentUserId = userDao.getCurrentUserId();
                boolean accResult = accDao.saveUser(accDto, cuurentUserId);
                boolean profileResult = proDao.CreateProfile_tbl(proDto, cuurentUserId,fullname);
                if (userResult && accResult && profileResult) {
                    url = siteMaps.getProperty(AppContants.RegisterFeatures.VERIFY_EMAIL_PAGE);
                    HttpSession session = request.getSession(true);
                    session.setAttribute(username, username);

                    String message = "Your account has been successfully created, please login to use the website";
                    request.getSession().setAttribute("Register_done", message);
                } else {
                    errors.setUsernameExisted("Username existed try again!");
                    request.setAttribute("REGISTER_ERR", errors);
                }
            }

        } catch (SQLException ex) {
            String msg = ex.getMessage();
            log("CreateAccountController _ SQL " + msg);
            if (msg.contains("duplicate")) { // trung username (key) cung la SQLException
                errors.setUsernameExisted(username + " is existed");
                request.setAttribute("REGISTER_ERR", errors);
            }
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
        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
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
        } catch (NoSuchAlgorithmException ex) {
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
