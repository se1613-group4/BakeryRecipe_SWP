/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.image_tbl;

import bakeryRecipe.recipe_ingredient_tbl.Recipe_Ingredient_tblDAO;
import bakeryRecipe.utils.DBConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LamVo
 */
public class Image_tblDAO implements Serializable{
    /**
     * Author LamVo
     * @param recipeId
     * @param urls
     * @return
     * @throws SQLException
     */
    public boolean insertImg(int recipeId, String[] urls) 
            throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            con = DBConnection.getConnection();
            if (con!=null) {
                //1. get connection
                con.setAutoCommit(false);
                //2. write sql string
                String sql = "INSERT INTO image_tbl (`recipe_id`, `img_link`) \n"
                        + "VALUES (?, ?);";
                //3. create stm obj and pass value to sql
                stm = con.prepareStatement(sql);
                for (String url : urls) {
                    if (url!= null && !url.isEmpty()) {
                        stm.setInt(1, recipeId);
                        stm.setString(2, url);
                        stm.addBatch();
                    }
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
                Logger.getLogger(Image_tblDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    /**
     * Author LamVo
     * @param recipeId
     * @return
     * @throws SQLException
     */
    public boolean removeImg(int recipeId) 
            throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            //1.  make connection
            con = DBConnection.getConnection();
            if (con != null) {
                //2. create sql string
                String sql = "DELETE FROM image_tbl\n"
                        + "WHERE (`recipe_id` = ?);";
                //3. create statement obj
                stm = con.prepareStatement(sql);
                stm.setInt(1, recipeId);
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
