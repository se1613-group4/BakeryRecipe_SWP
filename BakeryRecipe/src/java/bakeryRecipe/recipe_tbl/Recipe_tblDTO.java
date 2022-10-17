/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.recipe_tbl;

import bakeryRecipe.category_tbl.Category_tblDTO;
import bakeryRecipe.image_tbl.Image_tblDTO;
import bakeryRecipe.profile_tbl.Profile_tblDTO;
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
    private String description;
    private int preTime; // prepare time in minute
    private int cookTime; // cooking time in minute
    private int totalTime;
    private int likedCount;
    private int savedCount;
    private Date createdDate;
    private Date lastModified;
    private boolean isActived;
    private boolean isHidden;
    private String Steps;
    
    private Profile_tblDTO authorInfo;
    private Category_tblDTO category;
    private Image_tblDTO image;
    // Constructors
    public Recipe_tblDTO() {
    }

    public Recipe_tblDTO(int userId, int categoryId, String name, int serving, String description, int preTime, int cookTime, String steps) {
        this.userId = userId;
        this.categoryId = categoryId;
        this.name = name;
        this.serving = serving;
        this.description = description;
        this.preTime = preTime;
        this.cookTime = cookTime;
        this.Steps = steps;
    }
    
    
    public Recipe_tblDTO(int recipeId, String name, int serving, String description, int preTime, int cookTime, int totalTime, int likedCount, int savedCount, Date createdDate, Date lastModified, boolean isActived, boolean isHidden, Profile_tblDTO authorInfo, Category_tblDTO category, Image_tblDTO image) {
        this.recipeId = recipeId;
        this.name = name;
        this.serving = serving;
        this.description = description;
        this.preTime = preTime;
        this.cookTime = cookTime;
        this.totalTime = totalTime;
        this.likedCount = likedCount;
        this.savedCount = savedCount;
        this.createdDate = createdDate;
        this.lastModified = lastModified;
        this.isActived = isActived;
        this.isHidden = isHidden;
        this.authorInfo = authorInfo;
        this.category = category;
        this.image = image;
    }    

    public Recipe_tblDTO(int recipeId, String name, String description, int totalTime, int likedCount, Date createdDate, Category_tblDTO category, Image_tblDTO image) {
        this.recipeId = recipeId;
        this.name = name;
        this.description = description;
        this.totalTime = totalTime;
        this.likedCount = likedCount;
        this.createdDate = createdDate;
        this.category = category;
        this.image = image;
    }
    
    public Recipe_tblDTO(int recipeId, String name, int serving, String description, int preTime, int cookTime, int likedCount, int savedCount, Date lastModified, Profile_tblDTO authorInfo, Category_tblDTO category, Image_tblDTO image) {
        this.recipeId = recipeId;
        this.name = name;
        this.serving = serving;
        this.description = description;
        this.preTime = preTime;
        this.cookTime = cookTime;
        this.likedCount = likedCount;
        this.savedCount = savedCount;
        this.lastModified = lastModified;
        this.authorInfo = authorInfo;
        this.category = category;
        this.image = image;
    }

    public Recipe_tblDTO(int recipeId, String name, int serving, String description, int preTime, int cookTime, int likedCount, int savedCount, Date lastModified, Profile_tblDTO authorInfo, Category_tblDTO category, Image_tblDTO image, String steps) {
        this.recipeId = recipeId;
        this.name = name;
        this.serving = serving;
        this.description = description;
        this.preTime = preTime;
        this.cookTime = cookTime;
        this.likedCount = likedCount;
        this.savedCount = savedCount;
        this.lastModified = lastModified;
        this.authorInfo = authorInfo;
        this.category = category;
        this.image = image;
        this.Steps = steps;
    }
    
    public Recipe_tblDTO(int recipeId, String name, int serving,String description, int totalTime, int likedCount, Date lastModified, Profile_tblDTO authorInfo, Category_tblDTO category, Image_tblDTO image) {
        this.recipeId = recipeId;
        this.name = name;
        this.serving = serving;
        this.description = description;
        this.totalTime = totalTime;
        this.likedCount = likedCount;
        this.lastModified = lastModified;
        this.authorInfo = authorInfo;
        this.category = category;
        this.image = image;
    }

    
    // Getters
    public int getRecipeId() {
        return recipeId;
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

    public int getTotalTime() {
        return totalTime;
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

    public Profile_tblDTO getAuthorInfo() {
        return authorInfo;
    }

    public Category_tblDTO getCategory() {
        return category;
    }

    public Image_tblDTO getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public int getUserId() {
        return userId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getSteps() {
        return Steps;
    }
    
        
    // Setter
    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
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

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
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

    public void setAuthorInfo(Profile_tblDTO authorInfo) {
        this.authorInfo = authorInfo;
    }

    public void setCategory(Category_tblDTO category) {
        this.category = category;
    }

    public void setImage(Image_tblDTO image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setSteps(String Steps) {
        this.Steps = Steps;
    }
    
    
    
    
}
