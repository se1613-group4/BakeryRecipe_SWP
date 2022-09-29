/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.account_tbl;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author LamVo
 */
public class Account_tblDTO implements Serializable{
    private int accountId;
    private int userId;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private Date lastModified;
    private boolean isActived;
    private boolean isAdmin;
    // Constructors

    public Account_tblDTO() {
    }

    public Account_tblDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account_tblDTO(int userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }
    
    

    public Account_tblDTO(int accountId, int userId, String username, String password, String email, String phoneNumber, Date lastModified, boolean isActived, boolean isAdmin) {
        this.accountId = accountId;
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.lastModified = lastModified;
        this.isActived = isActived;
        this.isAdmin = isAdmin;
    }
    // Getters

    public int getAccountId() {
        return accountId;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public boolean isIsActived() {
        return isActived;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }
    // Setters

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public void setIsActived(boolean isActived) {
        this.isActived = isActived;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    
}
