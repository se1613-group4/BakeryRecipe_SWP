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
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author LamVo
 */
public class Account_tblDAO implements Serializable {

    // register user 
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

    //user login
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

    //update password
    public boolean updateAccountPassword(int currentUserId, String newPass)
            throws SQLException, NamingException { // update password, role
        Connection connection = null;
        PreparedStatement stm = null;
        boolean result = false;
        Date now = Date.valueOf(LocalDate.now());
        try {
            //1. make connection
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. write sql string
                String sql = "update account_tbl\n"
                        + "set password=?, last_modified=?\n" //pass: varchar; isAdmin: bit(0,1)
                        + "where user_id LIKE ?"; //username: varchar
                //3. create stm 
                stm = connection.prepareStatement(sql);
                stm.setString(1, newPass);
                stm.setDate(2, now);
                stm.setInt(3, currentUserId);
                //4. execute update
                int affectedRow = stm.executeUpdate();
                //5. process result
                if (affectedRow > 0) {
                    result = true;
                }
            }
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
    
    private List<Account_tblDTO> accounts;
    public List<Account_tblDTO> getAccounts() 
    { 
        return accounts ;
    }
}
