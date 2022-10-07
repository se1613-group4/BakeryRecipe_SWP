/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.account_tbl;

import bakeryRecipe.utils.DBConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LamVo
 */
public class Account_tblDAO implements Serializable { 
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
                String sql = "SELECT user_id,is_admin,last_modified,is_actived\n"
                        + "FROM account_tbl\n"
                        + "WHERE username = ? AND password = ? ";
                //3. create statement obj
                stm = connection.prepareStatement(sql); // tao ra obj rong
                stm.setString(1, username);
                stm.setString(2, password);;
                //4. execute query
                rs = stm.executeQuery();
                //5 process result
                if (rs.next()) {
                    boolean isActived = rs.getBoolean("is_actived");
                    int userId = rs.getInt("user_id");
                    boolean isAdmin = rs.getBoolean("is_admin");
                    Date lastModif = rs.getDate("last_modified");
                   result = (isActived) ? new Account_tblDTO(userId, username,isAdmin) : new Account_tblDTO(false,lastModif);
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

   // for register user 
    public boolean saveUser(Account_tblDTO acc, int currentUserId) throws SQLException {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        boolean set = false;
        Date now = Date.valueOf(LocalDate.now());
        try {
            con = DBConnection.getConnection();
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

   // user login
    public Account_tblDTO login(String username, String pass) throws SQLException {
        Account_tblDTO acc = null;
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            con = DBConnection.getConnection();
            String query = "SELECT user_id, username, password \n"
                    + "FROM account_tbl\n"
                    + "where username like ? and password=? and is_actived=true and is_admin=false";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, pass);

            rs = pst.executeQuery();

            if (rs.next()) {
                int userId = rs.getInt("user_id");
                acc = new Account_tblDTO(userId, username, pass);

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
        return acc;
    }

    
    
    
    
    
    // -------- ADMIN SITE --------
    public List<Integer> getDashBoardInfoAdmin() throws SQLException{
        List<Integer> result = null ;
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            //1. make connection
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. create sql string
                String sql = "call getdashboardInfo_Admin";
                //3. create statement obj
               stm = connection.prepareStatement(sql); // tao ra obj rong
               
                //4. execute query
               rs = stm.executeQuery();
                //5 process result
                if (rs.next()) {
                   result = new ArrayList<>();
                   result.add(rs.getInt("total_account"));   // total 
                   result.add(rs.getInt("actived_account"));  // active 
                   result.add( result.get(0)-result.get(1));  // ban 
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
          return  result;
    }
    
    private List<Account_tblDTO> accounts;
    public List<Account_tblDTO> getAccounts() 
    { 
        return accounts ;
    }
}
