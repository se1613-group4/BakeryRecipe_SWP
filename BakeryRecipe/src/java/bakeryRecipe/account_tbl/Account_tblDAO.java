/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.account_tbl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

/**
 *
 * @author LamVo
 */
public class Account_tblDAO implements Serializable {

    Connection con;

    public Account_tblDAO(Connection con) {
        this.con = con;
    }

    //for register user 
    public boolean saveUser(Account_tblDTO acc) {
        boolean set = false;
        Date now = Date.valueOf(LocalDate.now());
        try {
            //Insert register data to database
            String query = "insert into Account_tbl ( username, password,"
                    + " email, phone_number, last_modified, is_actived, is_admin)"
                    + " values ( ?, ?, ?, ?, ?, ?, ?);";

            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setString(1, acc.getUsername());
            pt.setString(2, acc.getPassword());
            pt.setString(3, acc.getEmail());
            pt.setString(4, acc.getPhoneNumber());
            pt.setDate(5, now);
            pt.setBoolean(6, true);
            pt.setBoolean(7, false);
            pt.executeUpdate();
            set = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return set;
    }

    //user login
    public Account_tblDTO login(String username, String pass) {
        Account_tblDTO usr = null;

        try {
            String query = "select * from account_tbl where username=? and password=?";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, pass);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
//                usr = new Account_tblDTO();
////                usr.setAccountId(rs.getInt("id"));
////                usr.setUsername(rs.getString("name"));
//                usr.setUsername(rs.getString("UserName"));
//                usr.setPassword(rs.getString("Password"));
                usr = new Account_tblDTO(username, pass);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return usr;
    }

}

