/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bakeryRecipe.email;

/**
 *
 * @author PC
 */
public class VerifyEmailErr {
    private String cannotSend;
    private String emailNotExisted;
    private String emailIsActive;

    public VerifyEmailErr() {
    }

    public VerifyEmailErr(String cannotSend, String emailNotExisted, String emailIsActive) {
        this.cannotSend = cannotSend;
        this.emailNotExisted = emailNotExisted;
        this.emailIsActive = emailIsActive;
    }

    public String getCannotSend() {
        return cannotSend;
    }

    public void setCannotSend(String cannotSend) {
        this.cannotSend = cannotSend;
    }

    public String getEmailNotExisted() {
        return emailNotExisted;
    }

    public void setEmailNotExisted(String emailNotExisted) {
        this.emailNotExisted = emailNotExisted;
    }

    public String getEmailIsActive() {
        return emailIsActive;
    }

    public void setEmailIsActive(String emailIsActive) {
        this.emailIsActive = emailIsActive;
    }
    
    
    
}
