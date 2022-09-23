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
 * @author LamVo
 */
public class Comment_tblDTO implements Serializable{
    private int userId;
    private int resipeId;
    private String commentDetail;
    private Date created_date;
    private Date lastModified;
    private boolean isActived;
    // Constructors

    public Comment_tblDTO() {
    }

    public Comment_tblDTO(int userId, int resipeId, String commentDetail, Date created_date, Date lastModified, boolean isActived) {
        this.userId = userId;
        this.resipeId = resipeId;
        this.commentDetail = commentDetail;
        this.created_date = created_date;
        this.lastModified = lastModified;
        this.isActived = isActived;
    }
    // Getters

    public int getUserId() {
        return userId;
    }

    public int getResipeId() {
        return resipeId;
    }

    public String getCommentDetail() {
        return commentDetail;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public boolean isIsActived() {
        return isActived;
    }
    // Setters

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setResipeId(int resipeId) {
        this.resipeId = resipeId;
    }

    public void setCommentDetail(String commentDetail) {
        this.commentDetail = commentDetail;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public void setIsActived(boolean isActived) {
        this.isActived = isActived;
    }
    
}
