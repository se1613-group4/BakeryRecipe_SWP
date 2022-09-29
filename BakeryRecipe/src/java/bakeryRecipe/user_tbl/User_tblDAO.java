/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.user_tbl;

import bakeryRecipe.account_tbl.Account_tblDTO;
import java.io.Serializable;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

/**
 *
 * @author LamVo
 */
public class User_tblDAO implements Serializable{
    // function of DAO code here
    Connection con;

    public User_tblDAO(Connection con) {
        this.con = con;
    }
    
    public int getCurrentUserId() {
        //User_tblDTO usr = null;
        int userId=-1;
        try {
            String query = "SELECT user_id as current_identity FROM user_tbl ORDER BY user_id DESC LIMIT 1";
            Statement pst = this.con.createStatement();
            //pst.setString(1, query);            

            ResultSet rs = pst.executeQuery(query);

            if (rs.next()) {
//                usr = new Account_tblDTO();
////                usr.setAccountId(rs.getInt("id"));
////                usr.setUsername(rs.getString("name"));
//                usr.setUsername(rs.getString("UserName"));
//                usr.setPassword(rs.getString("Password"));
//                usr = new User_tblDTO();
//                usr.setUserId(rs.getInt("id"));
                    out.println(userId);
                    userId = rs.getInt("current_identity");

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            
        }
        return userId;
    }
    
    public boolean CreateUser_tbl() {
        boolean set = false;
        Date now = Date.valueOf(LocalDate.now());
        try {
            
            //Insert register data to database
            String query = " insert into user_tbl (created_date) values(?)";

            PreparedStatement pt = this.con.prepareStatement(query);
            //pt.setInt(1, user.getUserId());            
            pt.setDate(1, now);
            pt.executeUpdate();
            set = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return set;
    }
}
