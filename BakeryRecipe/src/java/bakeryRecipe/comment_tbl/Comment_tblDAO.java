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
import java.sql.Statement;

/**
 *
 * @author thongnt
 */
public class Comment_tblDAO implements Serializable {

    // function of DAO code here
    /**
     * This method is used to get the Comment DTO by input Recipe ID
     *
     * @param recipeId
     * @return
     * @throws SQLException
     */
    public Comment_tblDTO getCommentByRecipeId(int recipeId) throws SQLException {
        Connection connection = null;
        Statement stm = null;
        ResultSet rs = null;
        Comment_tblDTO result = null;

        try {
            //1. Make connection
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. Create SQl String
                String sql = "SELECT liked_count, \n"
                        + "		R.recipe_id, \n"
                        + "		profile_tbl.user_id, \n"
                        + "        profile_tbl.full_name,\n"
                        + "        img_id,\n"
                        + "        img_link,\n"
                        + "        comment_detail,\n"
                        + "        comment_tbl.created_date,\n"
                        + "        comment_tbl.last_modified,\n"
                        + "        comment_tbl.is_actived\n"
                        + "FROM (select liked_count, \n"
                        + "			recipe_id,  \n"
                        + "            user_id, \n"
                        + "            is_actived, \n"
                        + "            is_hidden\n"
                        + "		from recipe_tbl \n"
                        + "		where \n"
                        + "			is_actived = 1 \n"
                        + "            and is_hidden = 0 ) as R\n"
                        + "		inner join comment_tbl on R.recipe_id = comment_tbl.recipe_id\n"
                        + "		inner join profile_tbl on R.user_id = profile_tbl.user_id\n"
                        + "		inner join image_tbl on R.recipe_id = image_tbl.recipe_id;";
                //3. Create statement obj
                stm = connection.createStatement();
                //4. Execute query
                rs = stm.executeQuery(sql);
                //5. Process result
                if (rs.next()) {
                    //get comment DTO info
                    int userId = rs.getInt("profile_tbl.user_id");
                    String commentDetail = rs.getString("comment_detail");
                    Date created_date = rs.getDate("comment_tbl.created_date");
                    Date lastModified = rs.getDate("comment_tbl.last_modified");
                    boolean isActived = rs.getBoolean("comment_tbl.is_actived");
                    //create comment DTO
                    result = new Comment_tblDTO(userId, recipeId, commentDetail, created_date, lastModified, isActived);
                }//end process rs
            }//end check conection is not null
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
    }//end getCommentByRecipeId function
}
