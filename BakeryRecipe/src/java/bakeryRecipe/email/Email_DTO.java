/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bakeryRecipe.email;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class Email_DTO implements Serializable {
    
    private String email;
    private String code;

    public Email_DTO() {
    }

    public Email_DTO( String email, String code) {
        
        this.email = email;
        this.code = code;
    }

    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
}
