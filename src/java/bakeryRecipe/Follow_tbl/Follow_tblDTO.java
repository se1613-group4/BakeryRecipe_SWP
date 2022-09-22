/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bakeryRecipe.Follow_tbl;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class Follow_tblDTO implements Serializable {
    private int userId;
    private int userIdFolloewId;

    public Follow_tblDTO() {
    }

    public Follow_tblDTO(int userId, int userIdFolloewId) {
        this.userId = userId;
        this.userIdFolloewId = userIdFolloewId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserIdFolloewId() {
        return userIdFolloewId;
    }

    public void setUserIdFolloewId(int userIdFolloewId) {
        this.userIdFolloewId = userIdFolloewId;
    }
    
}
