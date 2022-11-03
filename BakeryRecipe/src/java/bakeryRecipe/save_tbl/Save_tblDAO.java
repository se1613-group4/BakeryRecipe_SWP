/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.save_tbl;

import bakeryRecipe.utils.DBConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author LamVo
 */
public class Save_tblDAO implements Serializable {

    // function of DAO code here
    public boolean SearchSaveRecipe(int userId, int recipeId)
            throws SQLException, NamingException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean result = false;
        try {
            //1. Make connection
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. Create SQL String
                String sql = "select recipe_id \n"
                        + "from save_tbl\n"
                        + "where user_id = ? and recipe_id = ?;";
                //3. Create Statement Object
                stm = connection.prepareStatement(sql);
                stm.setInt(1, userId);
                stm.setInt(2, recipeId);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. Process result 
                if (rs.next()) {
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

    public boolean UnsaveRecipe(int userId, int recipeId)
            throws SQLException, NamingException {
        Connection connection = null;
        PreparedStatement stm = null;
        int rs;
        boolean result = false;
        try {
            //1. Make connection
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. Create SQL String
                String sql = "DELETE FROM `bakery_recipe`.`save_tbl` WHERE (`user_id` = ?) and (`recipe_id` = ?);";
                //3. Create Statement Object
                stm = connection.prepareStatement(sql);
                stm.setInt(1, userId);
                stm.setInt(2, recipeId);
                //4. Execute Query
                rs = stm.executeUpdate();
                //5. Process result 
                if (rs != 0) {
                    result = true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return result;
    }
    
    public boolean SaveRecipe(int userId, int recipeId)
            throws SQLException, NamingException {
        Connection connection = null;
        PreparedStatement stm = null;
        int rs;
        boolean result = false;
        try {
            //1. Make connection
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. Create SQL String
                String sql = "INSERT INTO `bakery_recipe`.`save_tbl` (`user_id`, `recipe_id`) VALUES (?, ?);";
                //3. Create Statement Object
                stm = connection.prepareStatement(sql);
                stm.setInt(1, userId);
                stm.setInt(2,recipeId);
                //4. Execute Query
                rs = stm.executeUpdate();
                //5. Process result 
                if (rs != 0) {
                    result = true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return result;
    }
}
