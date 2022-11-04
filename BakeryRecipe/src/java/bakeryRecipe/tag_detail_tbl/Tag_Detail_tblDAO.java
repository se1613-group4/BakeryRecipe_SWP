/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.tag_detail_tbl;

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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LamVo
 */
public class Tag_Detail_tblDAO implements Serializable{
    /**
     * Author LamVo
     * @param recipeId
     * @param tags
     * @return
     * @throws SQLException
     */
    public boolean insertTagDetail(int recipeId, String[] tags) 
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
                String sql = "INSERT INTO tag_detail_tbl (recipe_id, tag_id) \n"
                        + "VALUES (?, ?);";
                //3. create stm obj and pass value to sql
                stm = con.prepareStatement(sql);
                for (String tag : tags) {
                    if (tag!= null && !tag.isEmpty()) {
                        stm.setInt(1, recipeId);
                        stm.setInt(2, findTag(tag));
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
                Logger.getLogger(Tag_Detail_tblDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    public boolean removeTagDetail(int recipeId) 
            throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            //1.  make connection
            con = DBConnection.getConnection();
            if (con != null) {
                //2. create sql string
                String sql = "DELETE FROM tag_detail_tbl\n"
                        + "WHERE (recipe_id = ?);";
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
    
    private int findTag(String tagName)
            throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int result = -1;
        try {
            //1. make connection
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. create sql string
                String sql = "SELECT tag_id\n"
                        + "FROM tag_tbl\n"
                        + "WHERE name like ?;";
                //3. create statement obj
                stm = connection.prepareStatement(sql); // tao ra obj rong
                stm.setString(1, tagName);
                //4. execute query
                rs = stm.executeQuery(); // do phia tren da nap roi nen ko can truyen them tham so de nap vao bo nho
                //5. process result
                if (rs.next()) {
                    result = rs.getInt("tag_id");
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
    
    public List<Integer> getTagIds(int recipeId)
            throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Integer> tagIds = null;
        try {
            //1. make connection
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. create sql string
                String sql = "SELECT tag_id\n"
                        + "FROM tag_detail_tbl\n"
                        + "WHERE recipe_id = ?;";
                //3. create statement obj
                stm = connection.prepareStatement(sql); // tao ra obj rong
                stm.setInt(1, recipeId);
                //4. execute query
                rs = stm.executeQuery(); // do phia tren da nap roi nen ko can truyen them tham so de nap vao bo nho
                //5. process result
                while (rs.next()) {
                    if (tagIds == null) {
                        tagIds = new ArrayList<>();
                    }
                    // get tag IDs
                    int tagId = rs.getInt("tag_id");
                    tagIds.add(tagId);
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
        return tagIds;
    }
}
