/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bakeryRecipe.account_tbl;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class LoginError implements Serializable {
    private String  userameEmptyErr;
    private String passwordEmptyErr;
    private String accountNotFound;
    private String userameFormatErr;
    private String passwordFormatErr;
    public LoginError() {
    }

    
    public LoginError(String userameEmptyErr, String passwordEmptyErr, String accountNotFound) {
        this.userameEmptyErr = userameEmptyErr;
        this.passwordEmptyErr = passwordEmptyErr;
        this.accountNotFound = accountNotFound;
    }

    public LoginError(String userameEmptyErr, String passwordEmptyErr, String accountNotFound, String userameFormatErr, String passwordFormatErr) {
        this.userameEmptyErr = userameEmptyErr;
        this.passwordEmptyErr = passwordEmptyErr;
        this.accountNotFound = accountNotFound;
        this.userameFormatErr = userameFormatErr;
        this.passwordFormatErr = passwordFormatErr;
    }

    public String getUserameFormatErr() {
        return userameFormatErr;
    }

    public void setUserameFormatErr(String userameFormatErr) {
        this.userameFormatErr = userameFormatErr;
    }

    public String getPasswordFormatErr() {
        return passwordFormatErr;
    }

    public void setPasswordFormatErr(String passwordFormatErr) {
        this.passwordFormatErr = passwordFormatErr;
    }

    public String getUserameEmptyErr() {
        return userameEmptyErr;
    }

    public void setUserameEmptyErr(String userameEmptyErr) {
        this.userameEmptyErr = userameEmptyErr;
    }

    public String getPasswordEmptyErr() {
        return passwordEmptyErr;
    }

    public void setPasswordEmptyErr(String passwordEmptyErr) {
        this.passwordEmptyErr = passwordEmptyErr;
    }

    public String getAccountNotFound() {
        return accountNotFound;
    }

    public void setAccountNotFound(String accountNotFound) {
        this.accountNotFound = accountNotFound;
    }
    
}
