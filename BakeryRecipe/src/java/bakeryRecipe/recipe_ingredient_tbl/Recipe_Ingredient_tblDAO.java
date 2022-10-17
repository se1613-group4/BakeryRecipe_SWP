/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.recipe_ingredient_tbl;

import bakeryRecipe.category_tbl.Category_tblDTO;
import bakeryRecipe.image_tbl.Image_tblDTO;
import bakeryRecipe.profile_tbl.Profile_tblDTO;
import bakeryRecipe.recipe_tbl.Recipe_tblDTO;
import bakeryRecipe.utils.DBConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LamVo
 */
public class Recipe_Ingredient_tblDAO implements Serializable{
    /**
     * Author LamVo
     * @param currentRecipeIdent
     * @param ingredientList
     * @return
     * @throws SQLException 
     */
    public boolean insertIngredientDetail(int currentRecipeIdent, Map<Integer,Double> ingredientList) throws SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            con = DBConnection.getConnection();
            if (con!=null) {
                //1. get connection
                con.setAutoCommit(false);
                //2. write sql string
                String sql = "INSERT INTO recipe_ingredient_tbl (recipe_id, ingredient_id, quantity)\n"
                        + "VALUES (?, ?, ?);";
                //3. create stm obj and pass value to sql
                stm = con.prepareStatement(sql);
                for (Integer key : ingredientList.keySet()) {
                    int ingredientId = key;
                    double quantity = ingredientList.get(key);
                    stm.setInt(1, currentRecipeIdent);
                    stm.setInt(2, ingredientId);
                    stm.setDouble(3, quantity);
                    stm.addBatch();
                }
                int[] affectedRows = stm.executeBatch();
                if (affectedRows != null) {
                    result = true;
                    for (int i = 0; i < affectedRows.length; i++) {
                        if (affectedRows[i] == 0) { // no row affected -> insert failed
                            result = false;
                            break;
                        }// end check affectedRows[i] == 0
                    }// end traverser affectedRows
                }// end check affectedRows != null
                if (result) {
                    con.commit();
                }
            }// end con != null
        } catch (SQLException ex) {
            if (con != null) {
                con.rollback();
                Logger.getLogger(Recipe_Ingredient_tblDAO.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
        }finally {
            if (stm !=null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }
    private List<Recipe_Ingredient_tblDTO> recipeIngreDtoList;

    /**
     * Author: LamVo
     * @return list of recipe DTO (s)
     */
    public List<Recipe_Ingredient_tblDTO> getRecipeIngreDtoList() {
        return this.recipeIngreDtoList;
    }
    public void getIngredientDetail(int recipeId)
            throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        this.recipeIngreDtoList = null;
        try {
            //1. make connection
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. create sql string
                String sql = "SELECT I.name as ingredient_name, R.quantity, I.unit\n"
                        + "FROM recipe_ingredient_tbl R\n"
                        + "		inner join ingredient_tbl I on R.ingredient_id = I.ingredient_id\n"
                        + "where R.recipe_id = ?;";
                //3. create statement obj
                stm = connection.prepareStatement(sql); // tao ra obj rong
                stm.setInt(1, recipeId);
                //4. execute query
                rs = stm.executeQuery(); // do phia tren da nap roi nen ko can truyen them tham so de nap vao bo nho
                //5. process result
                if (rs.next()) {
                    // get ingredient detail DTO info
                    String ingredientName = rs.getString("ingredient_name");
                    double quantity = rs.getDouble("quantity");
                    String unit = rs.getString("unit");                                 
                    // create recipeDTO
                    Recipe_Ingredient_tblDTO recipeIngreDto = new Recipe_Ingredient_tblDTO(unit, quantity, ingredientName);
                    if (this.recipeIngreDtoList == null) {
                        this.recipeIngreDtoList = new ArrayList<>();
                    }
                    this.recipeIngreDtoList.add(recipeIngreDto);

                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
