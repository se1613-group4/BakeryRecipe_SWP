/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.comment_tbl;

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
 * @author ThongNT
 */
public class Comment_tblDAO implements Serializable {

    private List<Comment_tblDTO> commentsList;

    /**
     * @return list of recipe DTO (s)
     */
    public List<Comment_tblDTO> getCommentsList() {
        return commentsList;
    }

    // function of DAO code here
    /**
     * This method is used to get the list of Comment DTO objects by inputting
     * Recipe ID
     *
     * Author: ThongNT
     *
     * @param recipeId
     * @return List of Comment_tblDTO objects
     * @throws SQLException
     */
    public List<Comment_tblDTO> getCommentByRecipeId(int recipeId) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            //1. Make connection
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. Create SQl String
                String sql = "SELECT R.recipe_id, \n"
                        + "        profile_tbl.user_id, \n"
                        + "        profile_tbl.full_name,\n"
                        + "        profile_tbl.avatar_url,\n"
                        + "        comment_detail,\n"
                        + "        comment_tbl.created_date,\n"
                        + "        comment_tbl.last_modified,\n"
                        + "        comment_tbl.is_actived\n"
                        + "FROM (select liked_count, \n"
                        + "        recipe_id,  \n"
                        + "		user_id, \n"
                        + "		is_actived, \n"
                        + "		is_hidden\n"
                        + "      from recipe_tbl \n"
                        + "      where \n"
                        + "        is_actived = 1 and is_hidden = 0 ) as R\n"
                        + "	inner join comment_tbl on R.recipe_id = comment_tbl.recipe_id\n"
                        + "	inner join profile_tbl on R.user_id = profile_tbl.user_id\n"
                        + "	inner join image_tbl on R.recipe_id = image_tbl.recipe_id\n"
                        + "WHERE R.recipe_id = ?;";
                //3. Create statement obj
                stm = connection.prepareStatement(sql);
                stm.setInt(1, recipeId);
                //4. Execute query
                rs = stm.executeQuery();
                //5. Process result
                while (rs.next()) {
                    //get comment DTO info
                    int userId = rs.getInt("profile_tbl.user_id");
                    String fullName = rs.getString("profile_tbl.full_name");
                    String avtUrl = rs.getString("profile_tbl.avatar_url");
                    String commentDetail = rs.getString("comment_detail");
                    Date created_date = rs.getDate("comment_tbl.created_date");
                    Date lastModified = rs.getDate("comment_tbl.last_modified");
                    boolean isActived = rs.getBoolean("comment_tbl.is_actived");
                    //create comment DTO
                    Comment_tblDTO comment = new Comment_tblDTO(userId, recipeId, fullName, avtUrl, commentDetail, created_date, lastModified, isActived);
                    // check recipe dto list not null
                    if (commentsList == null) {
                        commentsList = new ArrayList<>();
                    }//recipesList has existed
                    commentsList.add(comment);
                }//end traverse ResultSet
            }//end check conection is not null
            return commentsList;
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
    } //end getCommentByRecipeId function

    /**
     * This method to insert one new comment to the database by calling DAO
     * and return true if the insertion is successful, otherwise, return false
     * 
     * @param user_id
     * @param recipe_id
     * @param comment_detail
     * @param created_date
     * @param last_modified
     * @param is_actived
     * @return boolean
     * @throws SQLException 
     */
    public boolean addNewComment(int user_id, int recipe_id, String comment_detail, Date created_date, Date last_modified, boolean is_actived) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        boolean result = false;

        try {
            //1. Make connection
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. Create SQl String
                String sql = "insert into comment_tbl (user_id, recipe_id, comment_detail, created_date, last_modified, is_actived) \n"
                        + "	values (?, ?, ?, ?, ?, ?);";
                //3. Create statement obj
                stm = connection.prepareStatement(sql);
                stm.setInt(1, user_id);
                stm.setInt(2, recipe_id);
                stm.setString(3, comment_detail);
                stm.setDate(4, created_date);
                stm.setDate(5, last_modified);
                stm.setBoolean(6, is_actived);
//                System.out.println("----------------------------------------------");
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
    } //end addNewComment function
}
