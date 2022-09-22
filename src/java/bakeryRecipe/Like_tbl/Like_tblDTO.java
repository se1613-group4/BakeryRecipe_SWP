/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bakeryRecipe.Like_tbl;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class Like_tblDTO implements Serializable {
    private int userId;
    private int recipeId;

    public Like_tblDTO() {
    }

    public Like_tblDTO(int userId, int recipeId) {
        this.userId = userId;
        this.recipeId = recipeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }
    
    
}
