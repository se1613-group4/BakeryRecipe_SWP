/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.account_tbl;

import bakeryRecipe.user_tbl.User_tblDTO;
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
public class Account_tblDAO implements Serializable {

    Connection con;

    public Account_tblDAO(Connection con) {
        this.con = con;
    }

    public Account_tblDAO() {
    }
    
    /**
     * Author: LamVo
     *
     * @param username
     * @param password
     * @return
     * @throws SQLException
     */
    public Account_tblDTO checkLogin(String username, String password)
            throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Account_tblDTO result = null;
        try {
            //1. make connection
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. create sql string
                String sql = "SELECT user_id, username, is_admin\n"
                        + "FROM account_tbl\n"
                        + "WHERE username LIKE ? AND password = ? AND is_actived = 1";
                //3. create statement obj
                stm = connection.prepareStatement(sql); // tao ra obj rong
                stm.setString(1, username);
                stm.setString(2, password);;
                //4. execute query
                rs = stm.executeQuery();
                //5 process result
                if (rs.next()) {
                    int userId = rs.getInt("user_id");
                    boolean role = rs.getBoolean("is_admin");
                    result = new Account_tblDTO(userId, username, role);
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

    //for register user 
    public boolean saveUser(Account_tblDTO acc, int currentUserId) {

        boolean set = false;
        Date now = Date.valueOf(LocalDate.now());
        try {
            //Insert register data to database
            String query = "insert into Account_tbl ( user_id, username, password,"
                    + " email, phone_number, last_modified, is_actived, is_admin)"
                    + " values ( ?, ?, ?, ?, ?, ?, ?, ?);";

            PreparedStatement pt = this.con.prepareStatement(query);
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

}
