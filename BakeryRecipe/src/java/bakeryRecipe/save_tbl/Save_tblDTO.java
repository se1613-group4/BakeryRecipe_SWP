/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.save_tbl;

import java.io.Serializable;

/**
 *
 * @author LamVo
 */
public class Save_tblDTO implements Serializable{
    private int userId;
    private int recipeId;
    // Constructors

    public Save_tblDTO() {
    }

    public Save_tblDTO(int userId, int recipeId) {
        this.userId = userId;
        this.recipeId = recipeId;
    }
    // Getters

    public int getUserId() {
        return userId;
    }

    public int getRecipeId() {
        return recipeId;
    }
    // Setters

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }
    
}
