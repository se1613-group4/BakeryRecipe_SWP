/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.notification_tbl;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author LamVo
 */
public class Notification_tblDTO implements Serializable{
    private int notiId;
    private int userId;
    private String detail;
    private Date createdDate;
    // Constructors

    public Notification_tblDTO() {
    }

    public Notification_tblDTO(int notiId, int userId, String detail, Date createdDate) {
        this.notiId = notiId;
        this.userId = userId;
        this.detail = detail;
        this.createdDate = createdDate;
    }
    // Getters

    public int getNotiId() {
        return notiId;
    }

    public int getUserId() {
        return userId;
    }

    public String getDetail() {
        return detail;
    }

    public Date getCreatedDate() {
        return createdDate;
    }
    // Setters

    public void setNotiId(int notiId) {
        this.notiId = notiId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    
}
