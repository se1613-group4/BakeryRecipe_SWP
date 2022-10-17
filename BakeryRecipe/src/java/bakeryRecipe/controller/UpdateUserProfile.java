/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package bakeryRecipe.controller;

import bakeryRecipe.account_tbl.Account_tblDAO;
import bakeryRecipe.account_tbl.Account_tblDTO;
import bakeryRecipe.profile_tbl.Profile_tblDAO;
import bakeryRecipe.profile_tbl.UpdateError;
import bakeryRecipe.utils.AppContants;
import java.io.IOException;
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
 * @author dangh
 */
@WebServlet(name = "UpdateUserProfile", urlPatterns = {"/UpdateUserProfile"})
public class UpdateUserProfile extends HttpServlet {

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

        //start get sitemap
        ServletContext context = getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITEMAPS");
        //end get sitemap

        String url = siteMaps.getProperty(AppContants.UpdateUserProfile.DISPLAY_USER_PROFILE_CONTROLLER);
//        String url = "single-author.jsp";
        UpdateError errors = new UpdateError();
        boolean foundErr = false;
        boolean result = false;
        String userId = request.getParameter("txtUserId");
        String recipeId = request.getParameter("");
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String fullName = request.getParameter("txtFullName");
        String email = request.getParameter("txtEmail");
        String phoneNumber = request.getParameter("txtPhoneNumber");
        String gender = request.getParameter("txtGender");
        String biography = request.getParameter("txtBiography");
        Pattern usernamePattern = Pattern.compile("[a-zA-Z][a-zA-Z0-9]{8,15}");
        Pattern passwordPattern = Pattern.compile("[^: \\&\\.\\~]*[a-z0-9]+[^:\\&\\.\\~]+");
        Pattern fullnamePattern = Pattern.compile("^([a-zA-Z0-9]+|[a-zA-Z0-9]+\\s{1}[a-zA-Z0-9]{1,}|[a-zA-Z0-9]+\\s{1}[a-zA-Z0-9]{3,}\\s{1}[a-zA-Z0-9]{1,})$");
        Pattern emailPattern = Pattern.compile(
                "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$");
        Pattern phonenumberPattern = Pattern.compile("(84|0[3|5|7|8|9])+([0-9]{8})");
        Pattern bioPattern = Pattern.compile("^.{0,10}$");
        Pattern genderPattern = Pattern.compile("^[a-zA-Z]{1,10}$");

        try {
            Account_tblDAO accDAO = new Account_tblDAO();
            if (usernamePattern.matcher(username).matches() == false) {
                foundErr = true;
                errors.setUsernameFormatErr("Username wrong format.\n "
                        + "Username must be 8-15 characters.\n "
                        + "Must start with a letter.\n "
                        + "May not contain special characters");
            }

            if (passwordPattern.matcher(password).matches() == false) {
                foundErr = true;
                errors.setPasswordFormatErr("password wrong format.\n  "
                        + "Password contain at least one lower-case letter.\n"
                        + "Must contain at least one number "
                        + "and may not contain special characters");
            }

            if (fullnamePattern.matcher(fullName).matches() == false) {
                foundErr = true;
                errors.setFullnameFormatErr("Fullname wrong format");
            }

            boolean checkEmailExit = accDAO.checkEmail(email);
            if (emailPattern.matcher(email).matches() == false) {
                foundErr = true;
                errors.setEmailFormatErr("Email Start with a letter.\n"
                        + "              - Contains only letters, numbers and dashes (-).\n"
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
                errors.setPhonenumberExisted("Phonenumer existed try again!");
            }
            if (bioPattern.matcher(biography).matches() == false) {
                foundErr = true;
                errors.setBioFormatError("Bio wrong format.\n  "
                        + "Bio contain 0-3000 characters.\n"
                );
            }
            if (genderPattern.matcher(gender).matches() == false) {
                foundErr = true;
                errors.setGenderFormatError("Gender wrong format.\n  "
                        + "Gender contain 1-10 characters.\n"
                );
            }
            if (foundErr) {
                request.setAttribute("UPDATE_ERR", errors);
            } else {
                HttpSession session = request.getSession();
                Account_tblDTO user = (Account_tblDTO) session.getAttribute("USER");
//                System.out.println("UserID to update: ***********" + user.getUserId());

                //call DAO
                Profile_tblDAO dao = new Profile_tblDAO();
//                System.out.println("user update id" + user.getUserId());
                result = dao.updateUserProfile(user.getUserId(), username, password, fullName, email, phoneNumber, gender, url, biography, true, result);
                //process result 
                if (result) {
                    url = siteMaps.getProperty(AppContants.UpdateUserProfile.DISPLAY_USER_PROFILE_CONTROLLER);

                }
            }
        } catch (SQLException ex) {
            String msg = ex.getMessage();
            log("Error at DisplayUserProfile: " + ex.toString());
            if (msg.contains("duplicate")) { // trung username (key) cung la SQLException
                errors.setUsernameExisted(username + " is existed");
                request.setAttribute("UPDATE_ERR", errors);
            }
        } catch (NamingException ex) {
            log("Error at DisplayUserProfile: " + ex.toString());
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
