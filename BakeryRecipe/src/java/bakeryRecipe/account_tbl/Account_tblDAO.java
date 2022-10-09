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
                    result = (isActived) ? new Account_tblDTO(userId, username, isAdmin) : new Account_tblDTO(false, lastModif);
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

    private List<Account_tblDTO> accounts;

    public List<Account_tblDTO> getAccounts() {
        return accounts;
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
                stm.setString(1, "%"+searchvalue+"%");
                stm.setString(2, "%"+searchvalue+"%");
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
