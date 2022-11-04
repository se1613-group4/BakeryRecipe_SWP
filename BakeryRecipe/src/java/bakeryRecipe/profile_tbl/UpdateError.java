/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bakeryRecipe.profile_tbl;

import bakeryRecipe.account_tbl.RegisterError;
import java.io.Serializable;

/**
 *
 * @author dangh
 */
public class UpdateError extends RegisterError implements Serializable{
    private String bioFormatError;
    private String genderFormatError;

    public UpdateError() {
    }
    
    public UpdateError(String bioFormatError, String genderFormatError) {
        this.bioFormatError = bioFormatError;
        this.genderFormatError = genderFormatError;
    }

    public UpdateError(String bioFormatError, String genderFormatError, String usernameFormatErr, String passwordFormatErr, String phonenumberFormatErr, String emailFormatErr, String confirmNotMathched, String usernameExisted, String phonenumberExisted, String emailExisted) {
        super(usernameFormatErr, passwordFormatErr, phonenumberFormatErr, emailFormatErr, confirmNotMathched, usernameExisted, phonenumberExisted, emailExisted);
        this.bioFormatError = bioFormatError;
        this.genderFormatError = genderFormatError;
    }

    public String getBioFormatError() {
        return bioFormatError;
    }

    public void setBioFormatError(String bioFormatError) {
        this.bioFormatError = bioFormatError;
    }

    public String getGenderFormatError() {
        return genderFormatError;
    }

    public void setGenderFormatError(String genderFormatError) {
        this.genderFormatError = genderFormatError;
    }
    
    
}
