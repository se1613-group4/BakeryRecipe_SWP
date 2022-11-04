/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.user_tbl;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author LamVo
 */
public class User_tblDTO implements Serializable{
    private int userId;
    private Date createdDate;
    // Constructors

    public User_tblDTO() {
    }

    public User_tblDTO(Date createdDate) {
        this.createdDate = createdDate;
    }

    public User_tblDTO(int userId, Date createdDate) {
        this.userId = userId;
        this.createdDate = createdDate;
    }
    // Getters

    public int getUserId() {
        return userId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    
}
