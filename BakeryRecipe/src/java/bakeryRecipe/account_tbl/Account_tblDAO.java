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
import javax.naming.NamingException;

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
            pt.setBoolean(7, false);
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
            String query = "SELECT user_id,username,is_admin \n"
                    + "FROM account_tbl\n"
                    + "where username like ? and password=? and is_actived=true ";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, pass);

            rs = pst.executeQuery();

            if (rs.next()) {
                int userId = rs.getInt("user_id");
                boolean isadmin = rs.getBoolean("is_admin");
                acc = new Account_tblDTO(userId, username, pass, isadmin);

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

    private List<Account_tblDTO> accounts;

    public List<Account_tblDTO> getAccounts() {
        return accounts;
    }

    //check phonenumber alredy exist in Update function 
    public boolean checkUpdatePhonenumber(String phonenumber, int userID) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean set = false;
        try {
            //1. make connection
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. create sql string
                String sql = "select phone_number from account_tbl where phone_number like ? and user_id != ?";
                //3. create statement obj
                stm = connection.prepareStatement(sql); // tao ra obj rong
                stm.setString(1, phonenumber);
                stm.setInt(2, userID);
                //4. execute query
                rs = stm.executeQuery();
                //5 process result
                if (rs.next()) {
                    set = true;
                } else {
                    set = false;
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
        return set;

    }

    //check phonenumber alredy exist
    public boolean checkPhonenumber(String phonenumber) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean set = false;
        try {
            //1. make connection
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. create sql string
                String sql = "select phone_number from account_tbl where phone_number like ? ";
                //3. create statement obj
                stm = connection.prepareStatement(sql); // tao ra obj rong
                stm.setString(1, phonenumber);
                //4. execute query
                rs = stm.executeQuery();
                //5 process result
                if (rs.next()) {
                    set = true;
                } else {
                    set = false;
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
        return set;

    }

    //check Email already exist in Update function 
    public boolean checkUpdateEmail(String email, int userId) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean set = false;
        try {
            //1. make connection
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. create sql string
                String sql = "select email from account_tbl where email like ? and user_id != ?";
                //3. create statement obj
                stm = connection.prepareStatement(sql); // tao ra obj rong
                stm.setString(1, email);
                stm.setInt(2, userId);
                //4. execute query
                rs = stm.executeQuery();
                //5 process result
                if (rs.next()) {
                    set = true;
                } else {
                    set = false;
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
        return set;

    }

    //check Email alredy exist
    public boolean checkEmail(String email) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean set = false;
        try {
            //1. make connection
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. create sql string
                String sql = "select email from account_tbl where email like ? ";
                //3. create statement obj
                stm = connection.prepareStatement(sql); // tao ra obj rong
                stm.setString(1, email);
                //4. execute query
                rs = stm.executeQuery();
                //5 process result
                if (rs.next()) {
                    set = true;
                } else {
                    set = false;
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
        return set;

    }

    //check password alredy exist
    public boolean checkPasword(int userId, String password) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean set = false;
        try {
            //1. make connection
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. create sql string
                String sql = "select password from account_tbl "
                        + "where user_id=? and password=?";
                //3. create statement obj
                stm = connection.prepareStatement(sql); // tao ra obj rong
                stm.setInt(1, userId);
                stm.setString(2, password);
                //4. execute query
                rs = stm.executeQuery();
                //5 process result
                if (rs.next()) {
                    set = true;
                } else {
                    set = false;
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
        return set;

    }

    //update password when logged
    public boolean uploadPassword(int userId, String oldPassword, String newPassword)
            throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        Date now = Date.valueOf(LocalDate.now());
        try {
            //1. make connection
            con = DBConnection.getConnection();
            if (con != null) {
                //2. create sql string
                String sql = "update account_tbl set password=?, last_modified=? "
                        + "where user_id=? and password=?";
                //3. create statement obj
                stm = con.prepareStatement(sql);
                stm.setString(1, newPassword);
                stm.setDate(2, now);
                stm.setInt(3, userId);
                stm.setString(4, oldPassword);
                //4. execute query
                int affectedRows = stm.executeUpdate();
                //5 process result
                if (affectedRows > 0) {
                    result = true;
                }// end process rs
            }// end check con not null
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    public boolean deleteAccount(int userID)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            //1. make connection
            con = DBConnection.getConnection();
            if (con != null) {
                //2. create sql string
                String sql = "update account_tbl set is_actived=false where user_id=?";
                //3. create statement obj
                stm = con.prepareStatement(sql); // tao ra obj rong
                stm.setInt(1, userID);
                //4. execute query
                int affactedRows = stm.executeUpdate();
                //5 process result
                if (affactedRows > 0) {
                    result = true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    //check email and phonenumber when you are not logged in to the system
    public boolean checkEmailAndPhonenumber(String email, String phonenumber) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean set = false;
        try {
            //1. make connection
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. create sql string
                String sql = "select user_id from account_tbl where email=? and phone_number=?";
                //3. create statement obj
                stm = connection.prepareStatement(sql); // tao ra obj rong
                stm.setString(1, email);
                stm.setString(2, phonenumber);
                //4. execute query
                rs = stm.executeQuery();
                //5 process result
                if (rs.next()) {
                    set = true;
                } else {
                    set = false;
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
        return set;

    }

    //check new password is the same old password when have email and phonenumber
    public boolean checkPasswordEP(String email, String phonenumber, String newPassword) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean set = false;
        try {
            //1. make connection
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. create sql string
                String sql = "select user_id from account_tbl where email=? and phone_number=? and password=?";
                //3. create statement obj
                stm = connection.prepareStatement(sql); // tao ra obj rong
                stm.setString(1, email);
                stm.setString(2, phonenumber);
                stm.setString(3, newPassword);
                //4. execute query
                rs = stm.executeQuery();
                //5 process result
                if (rs.next()) {
                    set = true;
                } else {
                    set = false;
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
        return set;

    }

    //update password when have email and phonenumber
    public boolean uploadPasswordEP(String email, String phonenumber, String newPassword)
            throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        Date now = Date.valueOf(LocalDate.now());
        try {
            //1. make connection
            con = DBConnection.getConnection();
            if (con != null) {
                //2. create sql string
                String sql = "update account_tbl set password=?, last_modified=? "
                        + "where email=? and phone_number=? ";
                //3. create statement obj
                stm = con.prepareStatement(sql);
                stm.setString(1, newPassword);
                stm.setDate(2, now);
                stm.setString(3, email);
                stm.setString(4, phonenumber);

                //4. execute query
                int affectedRows = stm.executeUpdate();
                //5 process result
                if (affectedRows > 0) {
                    result = true;
                }// end process rs
            }// end check con not null
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    //check account is active
    public boolean checkAccountIsActive(String username, String password) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean set = false;
        try {
            //1. make connection
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. create sql string
                String sql = "select is_actived from account_tbl where username=? and password=? and is_actived=true ";
                //3. create statement obj
                stm = connection.prepareStatement(sql); // tao ra obj rong
                stm.setString(1, username);
                stm.setString(2, password);
                //4. execute query
                rs = stm.executeQuery();
                //5 process result
                if (rs.next()) {
                    set = true;
                } else {
                    set = false;
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
        return set;

    }
    public boolean checkEmailIsActive(String email) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean set = false;
        try {
            //1. make connection
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. create sql string
                String sql = "select is_actived from account_tbl where email=? and is_actived=true ";
                //3. create statement obj
                stm = connection.prepareStatement(sql); // tao ra obj rong
                stm.setString(1, email);
                //4. execute query
                rs = stm.executeQuery();
                //5 process result
                if (rs.next()) {
                    set = true;
                } else {
                    set = false;
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
        return set;

    }
    
    public int checkUserIdWithEmail(String email) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int result = 0;
        try {
            //1. make connection
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. create sql string
                String sql = "select user_id from account_tbl where email=? ";
                //3. create statement obj
                stm = connection.prepareStatement(sql); // tao ra obj rong
                stm.setString(1, email);
                //4. execute query
                rs = stm.executeQuery();
                //5 process result
                if (rs.next()) {
                    result = rs.getInt("user_id");
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
    public boolean verifyEmail(int userID)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            //1. make connection
            con = DBConnection.getConnection();
            if (con != null) {
                //2. create sql string
                String sql = "update account_tbl set is_actived=true where user_id=?";
                //3. create statement obj
                stm = con.prepareStatement(sql); // tao ra obj rong
                stm.setInt(1, userID);
                //4. execute query
                int affactedRows = stm.executeUpdate();
                //5 process result
                if (affactedRows > 0) {
                    result = true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

// -------- ADMIN SITE --------
    public List<Integer> getDashBoardInfoAdmin() throws SQLException {
        List<Integer> result = null;
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
                    result.add(result.get(0) - result.get(1));  // ban 
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

    public int getEndIndexAccountListAdmin(String searchvalue) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int result = 0;
        try {
            //1. make connection
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. create sql string
                String sql = " select count(acc.is_actived) as total_rows from account_tbl acc\n"
                        + " where acc.is_admin=false and acc.username like ? or acc.phone_number like ? ";
                //3. create statement obj
                stm = connection.prepareStatement(sql); // tao ra obj rong
                stm.setString(1, "%" + searchvalue + "%");
                stm.setString(2, "%" + searchvalue + "%");
                //4. execute query
                rs = stm.executeQuery();
                //5 process result
                if (rs.next()) {
                    result = rs.getInt("total_rows");
                }

                result = result / 10;
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

    public ArrayList<Account_tblDTO> getListAccountAdmin(String searchvalue, int pageindex, int pagesize) throws SQLException {
        ArrayList<Account_tblDTO> result = null;
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            //1. make connection
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. create sql string
                String sql = "call getlistaccount_Admin(?,?,?)";
                //3. create statement obj
                stm = connection.prepareStatement(sql); // tao ra obj rong
                stm.setString(1, searchvalue);
                stm.setInt(2, pageindex);
                stm.setInt(3, pagesize);
                //4. execute query
                rs = stm.executeQuery();
                //5 process result
                //int accountId, int userId, String username, String password, String email, String phoneNumber, Date lastModified, boolean isActived, boolean isAdmin
                result = new ArrayList<>();
                while (rs.next()) {
                    result.add(new Account_tblDTO(
                            rs.getInt("account_id"),
                            rs.getInt("user_id"),
                            rs.getString("username"),
                            "***",
                            rs.getString("email"),
                            rs.getString("phone_number"),
                            rs.getDate("last_modified"),
                            rs.getBoolean("is_actived"),
                            false
                    ));

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
