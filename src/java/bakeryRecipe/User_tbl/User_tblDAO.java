/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bakeryRecipe.User_tbl;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author PC
 */
public class User_tblDAO implements Serializable {
    private int userId;
    private int recipeId;
    private String commentDetail;
    private Date createdDate;
    private Date lastModified;
    private boolean isActived;

    public User_tblDAO() {
    }

    public User_tblDAO(int userId, int recipeId, String commentDetail, Date createdDate, Date lastModified, boolean isActived) {
        this.userId = userId;
        this.recipeId = recipeId;
        this.commentDetail = commentDetail;
        this.createdDate = createdDate;
        this.lastModified = lastModified;
        this.isActived = isActived;
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

    public String getCommentDetail() {
        return commentDetail;
    }

    public void setCommentDetail(String commentDetail) {
        this.commentDetail = commentDetail;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public boolean isIsActived() {
        return isActived;
    }

    public void setIsActived(boolean isActived) {
        this.isActived = isActived;
    }
    
    
}
