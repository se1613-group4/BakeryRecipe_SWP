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
public class VerifyCodeErr implements Serializable{
    private String codeIncorrect;

    public VerifyCodeErr() {
    }

    public String getCodeIncorrect() {
        return codeIncorrect;
    }

    public void setCodeIncorrect(String codeIncorrect) {
        this.codeIncorrect = codeIncorrect;
    }
    
}
