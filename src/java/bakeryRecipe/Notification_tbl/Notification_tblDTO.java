/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bakeryRecipe.Notification_tbl;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author PC
 */
public class Notification_tblDTO implements Serializable {
    private int notiId;
    private int userId;
    private String detail;
    private Date createdDate;

    public Notification_tblDTO() {
    }

    public Notification_tblDTO(int notiId, int userId, String detail, Date createdDate) {
        this.notiId = notiId;
        this.userId = userId;
        this.detail = detail;
        this.createdDate = createdDate;
    }

    public int getNotiId() {
        return notiId;
    }

    public void setNotiId(int notiId) {
        this.notiId = notiId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    
    
}
