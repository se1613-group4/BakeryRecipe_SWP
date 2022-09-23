/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.ingredient_tbl;

import java.io.Serializable;

/**
 *
 * @author LamVo
 */
public class Ingredient_tblDTO implements Serializable{
    private int ingredientId;
    private String name;
    // Constructors

    public Ingredient_tblDTO() {
    }

    public Ingredient_tblDTO(int ingredientId, String name) {
        this.ingredientId = ingredientId;
        this.name = name;
    }
    // Getters

    public int getIngredientId() {
        return ingredientId;
    }

    public String getName() {
        return name;
    }
    // Setters

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
