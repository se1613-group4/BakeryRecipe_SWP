/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.video_tbl;

import java.io.Serializable;

/**
 *
 * @author LamVo
 */
public class Video_tblDTO implements Serializable{
    private int videoId;
    private int recipeId;
    private String videoLink;

    public Video_tblDTO() {
    }

    public Video_tblDTO(int videoId, int recipeId, String videoLink) {
        this.videoId = videoId;
        this.recipeId = recipeId;
        this.videoLink = videoLink;
    }

    public Video_tblDTO(String videoLink) {
        this.videoLink = videoLink;
    }
    
    /**
     * @return the videoId
     */
    public int getVideoId() {
        return videoId;
    }

    /**
     * @param videoId the videoId to set
     */
    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    /**
     * @return the recipeId
     */
    public int getRecipeId() {
        return recipeId;
    }

    /**
     * @param recipeId the recipeId to set
     */
    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    /**
     * @return the videoLink
     */
    public String getVideoLink() {
        return videoLink;
    }

    /**
     * @param videoLink the videoLink to set
     */
    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }
    
}
