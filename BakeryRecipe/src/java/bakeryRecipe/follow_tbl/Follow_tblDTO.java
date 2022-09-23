/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.follow_tbl;

import java.io.Serializable;

/**
 *
 * @author LamVo
 */
public class Follow_tblDTO implements Serializable{
    private int userId;
    private int userFollowedId;
    // Constructors

    public Follow_tblDTO() {
    }

    public Follow_tblDTO(int userId, int userFollowedId) {
        this.userId = userId;
        this.userFollowedId = userFollowedId;
    }
    // Getters

    public int getUserId() {
        return userId;
    }

    public int getUserFollowedId() {
        return userFollowedId;
    }
    // Setters

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserFollowedId(int userFollowedId) {
        this.userFollowedId = userFollowedId;
    }
    
}
