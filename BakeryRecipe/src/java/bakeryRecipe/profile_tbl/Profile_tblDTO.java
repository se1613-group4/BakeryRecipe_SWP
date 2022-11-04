/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.profile_tbl;

import bakeryRecipe.account_tbl.Account_tblDTO;
import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author LamVo
 */
public class Profile_tblDTO extends Account_tblDTO implements Serializable {

    private int profileId;
    private int userId;
    private String fullName;
    private String gender;
    private String avatarUrl;
    private String biography;
    private Date lastModified;
    // Constructors

    public Profile_tblDTO() {
    }

    public Profile_tblDTO(int userId, Date lastModified) {
        this.userId = userId;
        this.lastModified = lastModified;
    }

    public Profile_tblDTO(int profileId, int userId, String fullName, String gender, String avatarUrl, String biography, Date lastModified) {
        this.profileId = profileId;
        this.userId = userId;
        this.fullName = fullName;
        this.gender = gender;
        this.avatarUrl = avatarUrl;
        this.biography = biography;
        this.lastModified = lastModified;
    }

    public Profile_tblDTO(String username, String password, String fullName, String email, String phoneNumber, String gender, String avatarUrl, String bio, boolean isActived, boolean isAdmin) {
        super(username, password, email, phoneNumber, isActived, isAdmin);
        this.fullName = fullName;
        this.biography = bio;
        this.gender = gender;
        this.avatarUrl = avatarUrl;
    }

    public Profile_tblDTO(int userId, String fullName) {
        this.userId = userId;
        this.fullName = fullName;
    }

    public Profile_tblDTO(int userId, String fullName, String biography) {
        this.userId = userId;
        this.fullName = fullName;
        this.biography = biography;
    }
    public Profile_tblDTO(int userId, String fullName, String avatarUrl, String biography) {
        this.userId = userId;
        this.fullName = fullName;
        this.avatarUrl = avatarUrl;
        this.biography = biography;
    }
    
    // Getters

    public int getProfileId() {
        return profileId;
    }

    public int getUserId() {
        return userId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getGender() {
        return gender;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getBiography() {
        return biography;
    }

    public Date getLastModified() {
        return lastModified;
    }
    // Setters

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

}
