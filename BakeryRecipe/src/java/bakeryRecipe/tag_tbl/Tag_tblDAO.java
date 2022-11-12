/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.tag_tbl;

import bakeryRecipe.utils.DBConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LamVo
 */
public class Tag_tblDAO implements Serializable{
    /**
     * Author LamVo
     * @param recipeId
     * @param tags
     * @return
     * @throws SQLException
     */
    public boolean insertTags(String[] tags) 
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
                String sql = "INSERT INTO tag_tbl (name) "
                        + "VALUES (?)";
                //3. create stm obj and pass value to sql
                stm = con.prepareStatement(sql);
                for (String tag : tags) {
                    if (tag!= null && !tag.isEmpty() && !findTag(tag)) {
                        stm.setString(1, tag);
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
                Logger.getLogger(Tag_tblDAO.class.getName()).log(Level.SEVERE, null, ex);
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

        
    private boolean findTag(String tagName)
            throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean result = false;
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
    
    public String getTagName(int tagId)
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
                String sql = "SELECT name\n"
                        + "FROM tag_tbl\n"
                        + "WHERE tag_id = ?;";
                //3. create statement obj
                stm = connection.prepareStatement(sql); // tao ra obj rong
                stm.setInt(1, tagId);
                //4. execute query
                rs = stm.executeQuery(); // do phia tren da nap roi nen ko can truyen them tham so de nap vao bo nho
                //5. process result
                if (rs.next()) {
                    result = rs.getString("name");
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
    
    private List<Tag_tblDTO> tagDtoList;

    /**
     * Author: LamVo
     * @return list of category DTO (s)
     */
    public List<Tag_tblDTO> getTagDtoList() {
        return this.tagDtoList;
    }
     public void loadAllTag()
            throws SQLException {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        this.tagDtoList = null;
        try {
            //1. make connection
            con = DBConnection.getConnection();
            if (con != null) {
                //2. create sql string
                String sql = "SELECT tag_id, name , count FROM bakery_recipe.tag_tbl";
                //3. create statement obj
                stm = con.createStatement();
                //4. execute query
                rs = stm.executeQuery(sql);
                //5 process result
                while (rs.next()) {                    
                    // get tag DTO info
                    int tagId = rs.getInt("tag_id");
                    String tagName = rs.getString("name");
                    int countNum = rs.getInt("count");
                    Tag_tblDTO tagDTO = new Tag_tblDTO(tagId, tagName, countNum);                                                            
                    // check categoryDto list not null
                    if (this.tagDtoList == null) {
                        this.tagDtoList = new ArrayList<>();
                    }// end check categoryDto list is null
                    // add to categoryDto list
                    this.tagDtoList.add(tagDTO);
                }// end process rs
            }// end check con not null
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }// end loadAllCategory function
     
     public void loadTopTag(int topNum)
            throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        this.tagDtoList = null;
        try {
            //1. make connection
            con = DBConnection.getConnection();
            if (con != null) {
                //2. create sql string
                String sql = "SELECT tag_id, name , count FROM bakery_recipe.tag_tbl as B order by B.count desc limit ?;";
                //3. create statement obj
                stm = con.prepareStatement(sql);
                stm.setInt(1, topNum);
                //4. execute query
                rs = stm.executeQuery();
                //5 process result
                while (rs.next()) {                    
                    // get tag DTO info
                    int tagId = rs.getInt("tag_id");
                    String tagName = rs.getString("name");
                    int countNum = rs.getInt("count");
                    Tag_tblDTO tagDTO = new Tag_tblDTO(tagId, tagName, countNum);                                                            
                    // check categoryDto list not null
                    if (this.tagDtoList == null) {
                        this.tagDtoList = new ArrayList<>();
                    }// end check categoryDto list is null
                    // add to categoryDto list
                    this.tagDtoList.add(tagDTO);
                }// end process rs
            }// end check con not null
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }// end loadAllCategory function
}
