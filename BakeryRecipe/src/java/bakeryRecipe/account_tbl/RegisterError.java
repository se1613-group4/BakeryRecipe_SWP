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
public class RegisterError implements Serializable{
    private String usernameFormatErr;
    private String passwordFormatErr;
    private String fullnameFormatErr;
    private String phonenumberFormatErr;
    private String emailFormatErr;
    private String confirmNotMathched;
    private String usernameExisted;
    private String phonenumberExisted;
    private String emailExisted;

    public RegisterError() {
    }

    public RegisterError(String usernameFormatErr, String passwordFormatErr, String phonenumberFormatErr, String emailFormatErr, String confirmNotMathched, String usernameExisted, String phonenumberExisted, String emailExisted) {
        this.usernameFormatErr = usernameFormatErr;
        this.passwordFormatErr = passwordFormatErr;
        this.phonenumberFormatErr = phonenumberFormatErr;
        this.emailFormatErr = emailFormatErr;
        this.confirmNotMathched = confirmNotMathched;
        this.usernameExisted = usernameExisted;
        this.phonenumberExisted = phonenumberExisted;
        this.emailExisted = emailExisted;
    }

    public String getFullnameFormatErr() {
        return fullnameFormatErr;
    }

    public void setFullnameFormatErr(String fullnameFormatErr) {
        this.fullnameFormatErr = fullnameFormatErr;
    }

    public String getUsernameFormatErr() {
        return usernameFormatErr;
    }

    public void setUsernameFormatErr(String usernameFormatErr) {
        this.usernameFormatErr = usernameFormatErr;
    }

    public String getPasswordFormatErr() {
        return passwordFormatErr;
    }

    public void setPasswordFormatErr(String passwordFormatErr) {
        this.passwordFormatErr = passwordFormatErr;
    }

    public String getPhonenumberFormatErr() {
        return phonenumberFormatErr;
    }

    public void setPhonenumberFormatErr(String phonenumberFormatErr) {
        this.phonenumberFormatErr = phonenumberFormatErr;
    }

    public String getEmailFormatErr() {
        return emailFormatErr;
    }

    public void setEmailFormatErr(String emailFormatErr) {
        this.emailFormatErr = emailFormatErr;
    }

    public String getConfirmNotMathched() {
        return confirmNotMathched;
    }

    public void setConfirmNotMathched(String confirmNotMathched) {
        this.confirmNotMathched = confirmNotMathched;
    }

    public String getUsernameExisted() {
        return usernameExisted;
    }

    public void setUsernameExisted(String usernameExisted) {
        this.usernameExisted = usernameExisted;
    }

    public String getPhonenumberExisted() {
        return phonenumberExisted;
    }

    public void setPhonenumberExisted(String phonenumberExisted) {
        this.phonenumberExisted = phonenumberExisted;
    }

    public String getEmailExisted() {
        return emailExisted;
    }

    public void setEmailExisted(String emailExisted) {
        this.emailExisted = emailExisted;
    }

}
