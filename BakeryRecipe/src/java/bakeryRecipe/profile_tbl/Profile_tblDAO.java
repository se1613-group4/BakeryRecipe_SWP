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
import java.util.ArrayList;
import java.util.List;
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

    public Profile_tblDTO displayMostRecipesUserProfile()
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
                String sql = "select max(countRecipe), profile_id, profile.user_id, full_name, gender, avatar_url, bio, profile.last_modified\n"
                        + "from (\n"
                        + "select count(recipe_tbl.recipe_id) as countRecipe, profile_id, profile_tbl.user_id, full_name, gender, avatar_url, bio, profile_tbl.last_modified\n"
                        + "from profile_tbl \n"
                        + "inner join recipe_tbl on recipe_tbl.user_id = profile_tbl.user_id\n"
                        + "group by profile_tbl.user_id) as profile";
                //3. Create Statement Object
                stm = connection.prepareStatement(sql);
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

    public boolean updateUserProfile(int userId, String fullName, String email, String phoneNumber,
            String gender, String avatarUrl, String biography, boolean isActived, boolean isAdmin)
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
                        + "set full_name = ?,  email = ?, phone_number = ?, gender = ?, avatar_url = ?, bio = ?, is_actived = ?, is_admin = ?\n"
                        + "where profile_tbl.user_id = ?";

                //Create Statement
                stm = connection.prepareStatement(sql);
                stm.setString(1, fullName);
                stm.setString(2, email);
                stm.setString(3, phoneNumber);
                stm.setString(4, gender);
                stm.setString(5, avatarUrl);
                stm.setString(6, biography);
                stm.setBoolean(7, isActived);
                stm.setBoolean(8, isAdmin);
                stm.setInt(9, userId);
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

    public List<Profile_tblDTO> getUsersTopFollower() throws SQLException {
        List<Profile_tblDTO> profileList = null;
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            //1. Get connection
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. Write SQL String
                String sql = "select count(user_id_followed) as follow, profile_id, profile_tbl.user_id, full_name, gender, avatar_url, bio, profile_tbl.last_modified\n"
                        + "from profile_tbl\n"
                        + "inner join follow_tbl on follow_tbl.user_id = profile_tbl.user_id\n"
                        + "group by profile_tbl.user_id\n"
                        + "order by follow desc";
                //3. Create Statement Object
                stm = connection.prepareStatement(sql);
                //4. Execute statement
                rs = stm.executeQuery();
                //5. Process result= rs.getInt("recipe_id");
                while (rs.next()) {
                    //
                    int profileID = rs.getInt("profile_id");
                    int userID = rs.getInt("user_id");
                    String fullName = rs.getString("full_name");
                    String gender = rs.getString("gender");
                    String avatarUrl = rs.getString("avatar_url");
                    String biography = rs.getNString("bio");
                    Date lastModified = rs.getDate("last_modified");
                    Profile_tblDTO result = new Profile_tblDTO(profileID, userID, fullName, gender, avatarUrl, biography, lastModified);
                    // check recipe dto list not null
                    if (profileList == null) {
                        profileList = new ArrayList<>();
                    }
                    //recipesList has existed
                    profileList.add(result);
                }//end traverse ResultSet
            }
            return profileList;
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
    }
    
     public boolean CreateProfileGG_tbl(Profile_tblDTO pro, int currentUserId, String fullname, String avt) throws SQLException {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        boolean set = false;

        Date now = Date.valueOf(LocalDate.now());
        try {
            con = DBConnection.getConnection();
            if (con != null) {
                String query = " insert into Profile_tbl (user_id, last_modified, full_name,avatar_url) \n"
                        + "values (?, ?, ?, ?);";

                PreparedStatement pt = con.prepareStatement(query);
                pt.setInt(1, currentUserId);
                pt.setDate(2, now);
                pt.setString(3, fullname);
                pt.setString(4, avt);
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
}
