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
    
    
}
