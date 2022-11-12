/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.video_tbl;

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

/**
 *
 * @author LamVo
 */
public class Video_tblDAO implements Serializable{

   /**
     * Author LamVo
     * @param recipeId
     * @param url
     * @return
     * @throws SQLException
     */
    public boolean insertVideo(int recipeId, String url) 
            throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            //1.  make connection
            con = DBConnection.getConnection();
            if (con != null) {
                //2. create sql string
                String sql = "INSERT INTO `bakery_recipe`.`video_tbl` (`recipe_id`, `video_link`)\n"
                        + "VALUES (?, ?);";
                //3. create statement obj
                stm = con.prepareStatement(sql);
                stm.setInt(1, recipeId);
                stm.setString(2, url);
                //4. execute query
                int affectedRows = stm.executeUpdate();
                //5 process result
                if (affectedRows > 0) {
                    result = true;
                }// end process rs
            }// end check con not null
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;                
    }
    
    
    public String getVidUrl(int recipeId)
            throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        String result = null;
        try {
            //1. make connection
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. create sql string
                String sql = "SELECT video_link\n"
                        + "FROM bakery_recipe.video_tbl\n"
                        + "where recipe_id = ?;";
                //3. create statement obj
                stm = connection.prepareStatement(sql); // tao ra obj rong
                stm.setInt(1, recipeId);
                //4. execute query
                rs = stm.executeQuery(); // do phia tren da nap roi nen ko can truyen them tham so de nap vao bo nho
                //5. process result
                if (rs.next()) {
                    // get recipe DTO info
                    result = rs.getString("video_link");
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
}
