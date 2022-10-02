/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.comment_tbl;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author LamVo, ThongNT
 */
public class Comment_tblDTO implements Serializable{
    private int userId;
    private int recipeId;
    private String fullName;
    private String avtUrl;
    private String commentDetail;
    private Date createdDate;
    private Date lastModified;
    private boolean isActived;
    
    
    // Constructors

    public Comment_tblDTO() {
    }

    public Comment_tblDTO(int userId, int recipeId, String commentDetail, Date created_date, Date lastModified, boolean isActived) {
        this.userId = userId;
        this.recipeId = recipeId;
        this.commentDetail = commentDetail;
        this.createdDate = created_date;
        this.lastModified = lastModified;
        this.isActived = isActived;
    }

    public Comment_tblDTO(int userId, int recipeId, String fullName, String avtUrl, String commentDetail, Date createdDate, Date lastModified, boolean isActived) {
        this.userId = userId;
        this.recipeId = recipeId;
        this.fullName = fullName;
        this.avtUrl = avtUrl;
        this.commentDetail = commentDetail;
        this.createdDate = createdDate;
        this.lastModified = lastModified;
        this.isActived = isActived;
    }
    
    
    // Getters

    public int getUserId() {
        return userId;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public String getCommentDetail() {
        return commentDetail;
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

    public String getFullName() {
        return fullName;
    }

    public String getAvtUrl() {
        return avtUrl;
    }
    
    
    // Setters

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public void setCommentDetail(String commentDetail) {
        this.commentDetail = commentDetail;
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

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public void setAvtUrl(String avtUrl) {
        this.avtUrl = avtUrl;
    }
}
