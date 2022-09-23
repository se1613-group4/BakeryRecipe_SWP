/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.recipe_ingredient_tbl;

import java.io.Serializable;

/**
 *
 * @author LamVo
 */
public class Recipe_Ingredient_tblDTO implements Serializable{
    private int recipeId;
    private int ingredientId;
    private String unit;
    private int quality;
    // Constructors
    public Recipe_Ingredient_tblDTO() {
    }

    public Recipe_Ingredient_tblDTO(int recipeId, int ingredientId, String unit, int quality) {
        this.recipeId = recipeId;
        this.ingredientId = ingredientId;
        this.unit = unit;
        this.quality = quality;
    }
    // Getters

    public int getRecipeId() {
        return recipeId;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public String getUnit() {
        return unit;
    }

    public int getQuality() {
        return quality;
    }
    // Setters
    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
    
}
