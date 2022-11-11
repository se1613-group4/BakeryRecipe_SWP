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
    private double quantity;
    
    private String ingredientName;
    // Constructors
    public Recipe_Ingredient_tblDTO() {
    }

    public Recipe_Ingredient_tblDTO(int recipeId, int ingredientId, String unit, int quantity, String ingredientName) {
        this.recipeId = recipeId;
        this.ingredientId = ingredientId;
        this.unit = unit;
        this.quantity = quantity;
        this.ingredientName = ingredientName;
    }

    public Recipe_Ingredient_tblDTO(int ingredientId, String unit, double quantity, String ingredientName) {
        this.ingredientId = ingredientId;
        this.unit = unit;
        this.quantity = quantity;
        this.ingredientName = ingredientName;
    }
    
    public Recipe_Ingredient_tblDTO(String unit, double quantity, String ingredientName) {
        this.unit = unit;
        this.quantity = quantity;
        this.ingredientName = ingredientName;
    }

    public Recipe_Ingredient_tblDTO(int ingredientId, double quantity) {
        this.ingredientId = ingredientId;
        this.quantity = quantity;
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

    public double getQuantity() {
        return quantity;
    }

    

    public String getIngredientName() {
        return ingredientName;
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

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
    
    
}
