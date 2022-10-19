/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.profile_tbl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import bakeryRecipe.utils.DBConnection;
import javax.naming.NamingException;

/**
 *
 * @author LamVo
 */
public class Profile_tblDAO implements Serializable {

    // function of DAO code here
    public boolean CreateProfile_tbl(Profile_tblDTO pro, int currentUserId, String fullname) throws SQLException {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        boolean set = false;

        Date now = Date.valueOf(LocalDate.now());
        try {
            con = DBConnection.getConnection();
            if (con != null) {
                String query = " insert into Profile_tbl (user_id, last_modified, full_name) \n"
                        + "values (?, ?, ?);";

                PreparedStatement pt = con.prepareStatement(query);
                pt.setInt(1, currentUserId);
                pt.setDate(2, now);
                pt.setString(3, fullname);
                pt.executeUpdate();
                set = true;
            }
            //Insert register data to database

        } catch (Exception e) {
            e.printStackTrace();
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
        return set;
    }

    public Profile_tblDTO displayUserProfile(int loginValue)
            throws SQLException, NamingException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Profile_tblDTO result = null;
        try {
            //1. Make connection
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. Create SQL String
                String sql = "select username, password, full_name, email, phone_number, gender, avatar_url, bio, is_actived, is_admin \n"
                        + " from account_tbl \n"
                        + " join profile_tbl \n"
                        + " on account_tbl.user_id = profile_tbl.user_id\n"
                        + " where account_tbl.user_id = ?";
                //3. Create Statement Object
                stm = connection.prepareStatement(sql);
                stm.setInt(1, loginValue);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. Process result 
                if (rs.next()) {
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String fullName = rs.getString("full_name");
                    String email = rs.getString("email");                    
                    String phoneNumber = rs.getString("phone_number");                    
                    String gender = rs.getString("gender");
                    String avatarUrl = rs.getString("avatar_url");
                    String biography = rs.getString("bio");
                    Boolean isActived = rs.getBoolean("is_actived");
                    Boolean isAdmin = rs.getBoolean("is_admin");
                    result = new Profile_tblDTO(username, password, fullName, email, phoneNumber, gender, avatarUrl, biography, isActived, isAdmin);
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

    public Profile_tblDTO displayOtherUserProfile(int loginValue)
            throws SQLException, NamingException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Profile_tblDTO result = null;
        try {
            //1. Make connection
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. Create SQL String
                String sql = "select profile_id, user_id, full_name, gender, avatar_url, bio, last_modified \n"
                        + "from Profile_tbl \n"
                        + "Where user_id = ?";
                //3. Create Statement Object
                stm = connection.prepareStatement(sql);
                stm.setInt(1, loginValue);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. Process result 
                if (rs.next()) {
                    int profileID = rs.getInt("profile_id");
                    int userID = rs.getInt("user_id");
                    String fullName = rs.getString("full_name");
                    String gender = rs.getString("gender");
                    String avatarUrl = rs.getString("avatar_url");
                    String biography = rs.getNString("bio");
                    Date lastModified = rs.getDate("last_modified");
                    result = new Profile_tblDTO(profileID, userID, fullName, gender, avatarUrl, biography, lastModified);
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
    
    public boolean updateUserProfile(int userId, String password,  String fullName,  String email,  String  phoneNumber,  
                                                                                    String  gender,  String  avatarUrl,  String biography,  boolean  isActived, boolean isAdmin)
            throws SQLException, NamingException {
        boolean result = false;

        Connection connection = null;
        PreparedStatement stm = null;

        try {
            //Make Connection
            connection = DBConnection.getConnection();
            if (connection != null) {
                //Write sql String
                String sql = "update profile_tbl join account_tbl on account_tbl.user_id = profile_tbl.user_id\n"
                        + "set password = ?, full_name = ?,  email = ?, phone_number = ?, gender = ?, avatar_url = ?, bio = ?, is_actived = ?, is_admin = ?\n"
                        + "where profile_tbl.user_id = ?";

                //Create Statement
                stm = connection.prepareStatement(sql);
                stm.setString(1, password);
                stm.setString(2, fullName);
                stm.setString(3, email);
                stm.setString(4, phoneNumber);
                stm.setString(5, gender);
                stm.setString(6, avatarUrl);
                stm.setString(7, biography);
                System.out.println("++++++++++++" + biography);
                stm.setBoolean(8 , isActived);                
                stm.setBoolean(9  , isAdmin);
                stm.setInt(10, userId);
                //Execute stm
                int effectedRows = stm.executeUpdate();
                //Process result
                if (effectedRows > 0) {
                    result = true;
                }
            }//end check connection != null
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
