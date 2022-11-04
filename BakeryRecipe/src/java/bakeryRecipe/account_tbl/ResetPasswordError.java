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
public class ResetPasswordError implements Serializable {
    private String oldPasswordWrongErr;
    private String confirmNotMathched;
    private String newPasswordSameAsErr;
    private String newPasswordFormatErr;

    public ResetPasswordError(String oldPasswordWrongErr, String confirmNotMathched, String newPasswordSameAsErr, String newPasswordFormatErr) {
        this.oldPasswordWrongErr = oldPasswordWrongErr;
        this.confirmNotMathched = confirmNotMathched;
        this.newPasswordSameAsErr = newPasswordSameAsErr;
        this.newPasswordFormatErr = newPasswordFormatErr;
    }

    @Override
    public String toString() {
        return "ResetPasswordError{" + "oldPasswordWrongErr=" + oldPasswordWrongErr + ", confirmNotMathched=" + confirmNotMathched + ", newPasswordSameAsErr=" + newPasswordSameAsErr + ", newPasswordFormatErr=" + newPasswordFormatErr + '}';
    }

    public String getOldPasswordWrongErr() {
        return oldPasswordWrongErr;
    }

    public void setOldPasswordWrongErr(String oldPasswordWrongErr) {
        this.oldPasswordWrongErr = oldPasswordWrongErr;
    }

    public String getConfirmNotMathched() {
        return confirmNotMathched;
    }

    public void setConfirmNotMathched(String confirmNotMathched) {
        this.confirmNotMathched = confirmNotMathched;
    }

    public String getNewPasswordSameAsErr() {
        return newPasswordSameAsErr;
    }

    public void setNewPasswordSameAsErr(String newPasswordSameAsErr) {
        this.newPasswordSameAsErr = newPasswordSameAsErr;
    }

    public String getNewPasswordFormatErr() {
        return newPasswordFormatErr;
    }

    public void setNewPasswordFormatErr(String newPasswordFormatErr) {
        this.newPasswordFormatErr = newPasswordFormatErr;
    }

    public ResetPasswordError() {
    }

}