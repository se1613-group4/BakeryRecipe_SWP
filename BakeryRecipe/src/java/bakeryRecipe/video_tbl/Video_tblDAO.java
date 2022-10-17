/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.video_tbl;

import bakeryRecipe.utils.DBConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
