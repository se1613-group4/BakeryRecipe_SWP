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
import java.util.List;

/**
 *
 * @author LamVo
 */
public class Account_tblDAO implements Serializable {
      private List<Account_tblDTO>  accountDtoList;

  public List<Account_tblDTO> getaccountDtoList() {
        return this.accountDtoList;
    }

    public Account_tblDAO(Connection con) {
    }

    //for register user 
    public boolean saveUser(Account_tblDTO acc, int currentUserId) {
      Connection con;
        boolean set = false;
        Date now = Date.valueOf(LocalDate.now());
        try {
            //Insert register data to database
            String query = "insert into Account_tbl ( user_id, username, password,"
                    + " email, phone_number, last_modified, is_actived, is_admin)"
                    + " values ( ?, ?, ?, ?, ?, ?, ?, ?);";

            PreparedStatement pt = con.prepareStatement(query);
            pt.setInt(1, currentUserId);
            pt.setString(2, acc.getUsername());
            pt.setString(3, acc.getPassword());
            pt.setString(4, acc.getEmail());
            pt.setString(5, acc.getPhoneNumber());
            pt.setDate(6, now);
            pt.setBoolean(7, true);
            pt.setBoolean(8, false);
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
            String query = "SELECT user_id, username, password \n"
                    + "FROM account_tbl\n"
                    + "where username like ? and password=?";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, pass);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int userId = rs.getInt("user_id");
                usr = new Account_tblDTO(userId, username, pass);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return usr;
    }
  public List<Account_tblDTO> getListAccountUser(){
       
      
      return accountDtoList;
  }
}
