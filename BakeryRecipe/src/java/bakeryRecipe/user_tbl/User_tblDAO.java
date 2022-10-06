/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.user_tbl;

import bakeryRecipe.account_tbl.Account_tblDTO;
import bakeryRecipe.utils.DBConnection;
import java.io.Serializable;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

/**
 *
 * @author LamVo
 */
public class User_tblDAO implements Serializable{
    // function of DAO code here
    
    
    public int getCurrentUserId() throws SQLException {
        //User_tblDTO usr = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int userId=-1;
        try {
            con=DBConnection.getConnection();
            String query = "SELECT user_id as current_identity FROM user_tbl ORDER BY user_id DESC LIMIT 1";
            Statement pst = con.createStatement();
            //pst.setString(1, query);            

            rs = pst.executeQuery(query);

            if (rs.next()) {
//                usr = new Account_tblDTO();
////                usr.setAccountId(rs.getInt("id"));
////                usr.setUsername(rs.getString("name"));
//                usr.setUsername(rs.getString("UserName"));
//                usr.setPassword(rs.getString("Password"));
//                usr = new User_tblDTO();
//                usr.setUserId(rs.getInt("id"));                   
                    userId = rs.getInt("current_identity");

            }

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
        return userId;
    }
    
    public boolean CreateUser_tbl() throws SQLException {
        boolean set = false;
        Connection con = null;
        Date now = Date.valueOf(LocalDate.now());
        try {
            con=DBConnection.getConnection();
            //Insert register data to database
            String query = " insert into user_tbl (created_date) values(?)";

            PreparedStatement pt = con.prepareStatement(query);
            //pt.setInt(1, user.getUserId());            
            pt.setDate(1, now);
            pt.executeUpdate();
            set = true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {            
            if (con != null) {
                con.close();
            }
        }
        return set;
    }
}