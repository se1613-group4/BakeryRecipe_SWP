/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.like_tbl;

import bakeryRecipe.utils.DBConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ThongNT
 */
public class Like_tblDAO implements Serializable {

    /**
     * This function to get the number of likes by input recipe ID
     *
     * @param recipeId
     * @return numberOfLikes
     * @throws SQLException
     */
    public int getLikesNums(int recipeId) throws SQLException {
        int result = 0;
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            //1. Make connection        
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. Write SQL String
                String sql = "select count(user_id) as like_count from like_tbl\n"
                        + "where recipe_id = ?;";
                //3. Create statement obj
                stm = connection.prepareStatement(sql);
                stm.setInt(1, recipeId);
                //4. Execute query
                rs = stm.executeQuery();
                //5. Process result
                while (rs.next()) {
                    //get like_count
                    result = rs.getInt("like_count");
                }//end traverse ResultSet
            }//end check conection is not null
            return result;
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

    public boolean isLiked(int recipeId, int userId) throws SQLException {
        boolean result = false;
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            //1. Make connection
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. Write SQL String
                String sql = "select user_id from like_tbl\n"
                        + "where user_id = ? and recipe_id = ?;";
                //3. Create statement obj
                stm = connection.prepareStatement(sql);
                stm.setInt(1, userId);
                stm.setInt(2, recipeId);
                //4. Execute statement
                rs = stm.executeQuery();
                //5. Process ResultSet
                int tmp = 0;
                while (rs.next()) {
                    //get like_count
                    tmp = rs.getInt("user_id");
                }//end traverse ResultSet                
                if (tmp != 0) {
                    result = true;
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

        return result;
    }

    /**
     * This function to add new like to like_tbl by input recipe ID and current
     * user ID
     *
     * @param recipeId
     * @param userId
     * @return boolean
     */
    public boolean likeRecipe(int recipeId, int userId) throws SQLException {
        boolean result = false;
        Connection connection = null;
        PreparedStatement stm = null;

        try {
            //1. Make connection        
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. Write SQL String
                String sql = "INSERT INTO `bakery_recipe`.`like_tbl` (`user_id`, `recipe_id`) "
                        + "VALUES (?, ?);";
                //3. Create statement obj
                stm = connection.prepareStatement(sql);
                stm.setInt(1, userId);
                stm.setInt(2, recipeId);
                //4. Execute query
                int tmp = stm.executeUpdate();
                //5. Process result
                if (tmp != 0) {
                    result = true;
                }
            }//end check conection is not null
            return result;
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public boolean unlikeRecipe(int recipeId, int userId) throws SQLException {
        boolean result = false;
        Connection connection = null;
        PreparedStatement stm = null;

        try {
            //1. Make connection        
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. Write SQL String
                String sql = "DELETE FROM `bakery_recipe`.`like_tbl` "
                        + "WHERE (`user_id` = ?) and (`recipe_id` = ?);";
                //3. Create statement obj
                stm = connection.prepareStatement(sql);
                stm.setInt(1, userId);
                stm.setInt(2, recipeId);
                //4. Execute query
                int tmp = stm.executeUpdate();
                //5. Process result
                if (tmp != 0) {
                    result = true;
                }
            }//end check conection is not null
            return result;
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
