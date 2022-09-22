/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bakeryRecipe.Profile_tbl;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author PC
 */
public class Profile_tblDTO implements Serializable {
    private int profileId;
    private int userId;
    private String fullName;
    private String gender;
    private String avatarUrl;
    private String bio;
    private Date lastModified;

    public Profile_tblDTO() {
    }

    public Profile_tblDTO(int profileId, int userId, String fullName, String gender, String avatarUrl, String bio, Date lastModified) {
        this.profileId = profileId;
        this.userId = userId;
        this.fullName = fullName;
        this.gender = gender;
        this.avatarUrl = avatarUrl;
        this.bio = bio;
        this.lastModified = lastModified;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }
    
}
