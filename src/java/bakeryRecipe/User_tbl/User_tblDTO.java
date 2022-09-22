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
public class User_tblDTO implements Serializable {
    private int userId;
    private Date createdDate;

    public User_tblDTO() {
    }

    public User_tblDTO(int userId, Date createdDate) {
        this.userId = userId;
        this.createdDate = createdDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    
}
