/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.recipe_tbl;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author LamVo
 */
public class Recipe_tblDTO implements Serializable{
    private int recipeId;
    private int userId;
    private int categoryId;
    private String name;
    private int serving;
    private int preTime; // prepare time in minute
    private int cookTime; // cooking time in minute
    private int likedCount;
    private int savedCount;
    private Date createdDate;
    private Date lastModified;
    private boolean isActived;
    private boolean isHidden;
    // Constructors
    public Recipe_tblDTO() {
    }

    public Recipe_tblDTO(int recipeId, int userId, int categoryId, String name, int serving, int preTime, int cookTime, int likedCount, int savedCount, Date createdDate, Date lastModified, boolean isActived, boolean isHidden) {
        this.recipeId = recipeId;
        this.userId = userId;
        this.categoryId = categoryId;
        this.name = name;
        this.serving = serving;
        this.preTime = preTime;
        this.cookTime = cookTime;
        this.likedCount = likedCount;
        this.savedCount = savedCount;
        this.createdDate = createdDate;
        this.lastModified = lastModified;
        this.isActived = isActived;
        this.isHidden = isHidden;
    }
    // Getters
    public int getRecipeId() {
        return recipeId;
    }

    public int getUserId() {
        return userId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public int getServing() {
        return serving;
    }

    public int getPreTime() {
        return preTime;
    }

    public int getCookTime() {
        return cookTime;
    }

    public int getLikedCount() {
        return likedCount;
    }

    public int getSavedCount() {
        return savedCount;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public boolean isIsActived() {
        return isActived;
    }

    public boolean isIsHidden() {
        return isHidden;
    }
    // Setter
    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setServing(int serving) {
        this.serving = serving;
    }

    public void setPreTime(int preTime) {
        this.preTime = preTime;
    }

    public void setCookTime(int cookTime) {
        this.cookTime = cookTime;
    }

    public void setLikedCount(int likedCount) {
        this.likedCount = likedCount;
    }

    public void setSavedCount(int savedCount) {
        this.savedCount = savedCount;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public void setIsActived(boolean isActived) {
        this.isActived = isActived;
    }

    public void setIsHidden(boolean isHidden) {
        this.isHidden = isHidden;
    }
    
}
