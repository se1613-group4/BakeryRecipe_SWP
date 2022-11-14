/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bakeryRecipe.follow_tbl;

import bakeryRecipe.utils.DBConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author danghh, ThongNT
 */
public class Follow_tblDAO implements Serializable {

    public int displayFollower(int loginValue)
            throws SQLException, NamingException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int result = 0;
        try {
            //1. Make connection
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. Create SQL String
                String sql = "SELECT count(user_id) as followers\n"
                        + "FROM follow_tbl\n"
                        + "where user_id_followed = ?;";
                //3. Create Statement Object
                stm = connection.prepareStatement(sql);
                stm.setInt(1, loginValue);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. Process result 
                if (rs.next()) {
                    result = rs.getInt("followers");
                }
                return result;
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

    public int displayFollowing(int loginValue)
            throws SQLException, NamingException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int result = 0;
        try {
            //1. Make connection
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. Create SQL String
                String sql = "SELECT count(user_id_followed) as followings\n"
                        + "FROM follow_tbl\n"
                        + "where user_id = ?;";
                //3. Create Statement Object
                stm = connection.prepareStatement(sql);
                stm.setInt(1, loginValue);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. Process result 
                if (rs.next()) {
                    result = rs.getInt("followings");
                }
                return result;
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
     * This function is used to check if the current user have followed the other user yet.
     * 
     * @param currentUserId
     * @param otherUserId
     * @return
     * @throws SQLException 
     */
    public boolean isFollowed(int currentUserId, int otherUserId) throws SQLException {
        boolean result = false;
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            //1. Make connection
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. Write SQL String
                String sql = "select user_id from follow_tbl\n"
                        + "where user_id = ? and user_id_followed = ?;";
                //3. Create statement obj
                stm = connection.prepareStatement(sql);
                stm.setInt(1, currentUserId);
                stm.setInt(2, otherUserId);
                //4. Execute statement
                rs = stm.executeQuery();
                //5. Process ResultSet
                int tmp = 0;
                while (rs.next()) {
                    //get follow_count
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
     * This function is used to add a row to follow_tbl 
     * 
     * @param userId
     * @param recipeAuthorId
     * @return true if the operation is successful, otherwise, false
     * @throws SQLException 
     */
    public boolean followRecipe(int userId, int recipeAuthorId) throws SQLException {
        boolean result = false;
        Connection connection = null;
        PreparedStatement stm = null;

        try {
            //1. Make connection        
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. Write SQL String
                String sql = "INSERT INTO `bakery_recipe`.`follow_tbl` (`user_id`, `user_id_followed`) "
                        + "VALUES (?, ?);";
                //3. Create statement obj
                stm = connection.prepareStatement(sql);
                stm.setInt(1, userId);
                stm.setInt(2, recipeAuthorId);
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

    /**
     * This function is used to delete a row from  follow_tbl 
     * 
     * @param userId
     * @param recipeAuthorId
     * @return true if the operation is successful, otherwise, false
     * @throws SQLException 
     */
    public boolean unfollowRecipe(int userId, int recipeAuthorId) throws SQLException {
        boolean result = false;
        Connection connection = null;
        PreparedStatement stm = null;

        try {
            System.out.println("UNFOLLOW DAO");
            //1. Make connection        
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. Write SQL String
                String sql = "DELETE FROM `bakery_recipe`.`follow_tbl` "
                        + "WHERE (`user_id` = ?) and (`user_id_followed` = ?);";
                //3. Create statement obj
                stm = connection.prepareStatement(sql);
                stm.setInt(1, userId);
                stm.setInt(2, recipeAuthorId);
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
    
    public List<Integer> getFollowers(int loginValue)
            throws SQLException, NamingException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int followerId;
        List<Integer> result = null;
        try {
            //1. Make connection
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. Create SQL String
                String sql = "select user_id_followed\n"
                        + "from follow_tbl\n"
                        + "where user_id = ?";
                //3. Create Statement Object
                stm = connection.prepareStatement(sql);
                stm.setInt(1, loginValue);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. Process result 
                while (rs.next()) {
                    followerId = rs.getInt("user_id_followed");
                    if (result == null){
                        result = new ArrayList<>();
                    }
                    result.add(followerId);
                }
                return result;
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
