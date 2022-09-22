/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bakeryRecipe.Account_tbl;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author PC
 */
public class Account_tblDTO implements Serializable {
    private int accountId;
    private int userId;
    private String username;
    private String password;
    private String email;
    private int phoneNumber;
    private Date lastModifed;
    private boolean isActived;
    private boolean isAdmin;

    public Account_tblDTO() {
    }

    public Account_tblDTO(int accountId, int userId, String username, String password, String email, int phoneNumber, Date lastModifed, boolean isActived, boolean isAdmin) {
        this.accountId = accountId;
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.lastModifed = lastModifed;
        this.isActived = isActived;
        this.isAdmin = isAdmin;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getLastModifed() {
        return lastModifed;
    }

    public void setLastModifed(Date lastModifed) {
        this.lastModifed = lastModifed;
    }

    public boolean isIsActived() {
        return isActived;
    }

    public void setIsActived(boolean isActived) {
        this.isActived = isActived;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    
}
