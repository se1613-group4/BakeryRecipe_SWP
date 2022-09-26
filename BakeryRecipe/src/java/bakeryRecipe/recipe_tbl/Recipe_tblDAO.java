/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.recipe_tbl;

import bakeryRecipe.utils.DBConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LamVo
 */
public class Recipe_tblDAO implements Serializable {
    // function of DAO code here

    /**
     * Search all Recipe object by name
     *
     * @param searchValue characters of recipe's name
     * @return A list of Recipe_tblDTO objects
     * @throws SQLException
     */
    public List<Recipe_tblDTO> searchAllRecipe(String searchValue) throws SQLException {

        List<Recipe_tblDTO> recipesList = null;
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            //1. Get connection
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. Write SQL String
                String sql = "select \n"
                        + "	recipe_id, \n"
                        + "    user_id, \n"
                        + "    category_id, \n"
                        + "    name, \n"
                        + "    serving,\n"
                        + "    instruction,\n"
                        + "    prepare_time,\n"
                        + "    cook_time,\n"
                        + "    liked_count, \n"
                        + "    saved_count,\n"
                        + "    created_date, \n"
                        + "    last_modified,\n"
                        + "    is_actived,\n"
                        + "    is_hidden \n"
                        + "from recipe_tbl\n"
                        + "where name like ? and is_hidden = false;";
                //3. Create Statement Object
                stm = connection.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                //4. Execute statement
                rs = stm.executeQuery();
                //5. Process result= rs.getInt("recipe_id");
                while (rs.next()) {
                    int recipeId = rs.getInt("recipe_id");
                    int userId = rs.getInt("user_id");
                    int categoryId = rs.getInt("category_id");
                    String name = rs.getString("name");
                    int serving = rs.getInt("serving");
                    int preTime = rs.getInt("prepare_time"); // prepare time in minute
                    int cookTime = rs.getInt("cook_time"); // cooking time in minute
                    int likedCount = rs.getInt("liked_count");
                    int savedCount = rs.getInt("saved_count");
                    Date createdDate = rs.getDate("created_date");
                    Date lastModified = rs.getDate("last_modified");
                    boolean isActived = rs.getBoolean("is_actived");
                    boolean isHidden = rs.getBoolean("is_hidden");
                    
                    Recipe_tblDTO dto = new Recipe_tblDTO(recipeId, userId, categoryId, name, serving, preTime, cookTime, likedCount, savedCount, createdDate, lastModified, isActived, isHidden);
                    
                    if (recipesList == null)
                        recipesList = new ArrayList<>();
                    //recipesList has existed
                    recipesList.add(dto);
                }//end traverse ResultSet
            }
            return recipesList;
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
