/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.controller.recipe;

import bakeryRecipe.ingredient_tbl.Ingredient_tblDAO;
import bakeryRecipe.ingredient_tbl.Ingredient_tblDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LamVo
 */
@WebServlet(name = "AddIngredientInput", urlPatterns = {"/AddIngredientInput"})
public class AddIngredientInput extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            // Load all ingredient
            Ingredient_tblDAO ingredientDao = new Ingredient_tblDAO();
            ingredientDao.loadAllIngredient();
            List<Ingredient_tblDTO> ingredienList = ingredientDao.getIngredientDtoList();
            if (ingredienList != null) {
                request.setAttribute("INGREDIENT_LIST", ingredienList);
            }
            String ingredientS = "";
            for (Ingredient_tblDTO ingredientDto : ingredienList) {
                ingredientS += "                                                            "
                        + "<option value=\""+ingredientDto.getIngredientId()+"\">"+ingredientDto.getName()+" "+ingredientDto.getUnit()+")</option>\n";
            }
            /* Output html code*/
            out.println("<div class=\"row no-gutters ingre-div\" id=\""+ java.time.LocalDateTime.now()+"\">\n" +
"                                            <!--Select Ingredient-->\n" +
"                                            <div class=\"col-7\">\n" +
"                                                <div class=\"form-group additional-input-box icon-left\">  \n" +
"                                                    <select class=\"select2 input-select2\" name=\"txtIngredientId\">\n" +
"                                                        <option value=\"\" disabled=\"disabled\" selected=\"selected\">Ingredient</option>\n" +
                                                         ingredientS +
"                                                </select>\n" +
"                                            </div>\n" +
"                                        </div>\n" +
"                                        <!--Input Quantity-->\n" +
"                                        <div class=\"col-5\">\n" +
"                                            <div class=\"form-group additional-input-box icon-right\">\n" +
"                                                <input type=\"number\" step=\"0.01\" min=\"0.01\" placeholder=\"Quantity\" class=\"form-control\"\n" +
"                                                       name=\"txtQuantity\"/>\n" +
"                                                <i class=\"fas fa-times\" onclick=\"removeElement(this)\"></i>\n" +
"                                            </div>\n" +
"                                        </div>\n" +
"                                    </div>");
        } catch (SQLException ex) {
            Logger.getLogger(AddIngredientInput.class.getName()).log(Level.SEVERE, null, ex);
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
