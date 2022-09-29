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
/**
 *
 * @author LamVo
 */
public class Profile_tblDAO implements Serializable{
    // function of DAO code here
    public boolean CreateProfile_tbl(Profile_tblDTO pro, int currentUserId) throws SQLException {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        boolean set = false;
        
        Date now = Date.valueOf(LocalDate.now());
        try {
            con=DBConnection.getConnection();
            if(con!=null){
                 String query = " insert into Profile_tbl (user_id, last_modified) \n" +
                            "values (?, ?);";

            PreparedStatement pt = con.prepareStatement(query);
            pt.setInt(1, currentUserId);            
            pt.setDate(2, now);
            pt.executeUpdate();
            set = true;
            }
            //Insert register data to database
           
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
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
