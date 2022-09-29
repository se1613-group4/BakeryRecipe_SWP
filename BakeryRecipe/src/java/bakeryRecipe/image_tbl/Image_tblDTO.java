/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.image_tbl;

import java.io.Serializable;

/**
 *
 * @author LamVo
 */
public class Image_tblDTO implements Serializable{
    private int imgId;
    private int recipeId;
    private String imgLink;
    // Constructors

    public Image_tblDTO() {
    }

    public Image_tblDTO(int imgId, int recipeId, String imgLink) {
        this.imgId = imgId;
        this.recipeId = recipeId;
        this.imgLink = imgLink;
    }
    
    public Image_tblDTO(int imgId, String imgLink) {
        this.imgId = imgId;
        this.imgLink = imgLink;
    }
    // Getters

    public int getImgId() {
        return imgId;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public String getImgLink() {
        return imgLink;
    }
    // Setters

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }
    
}
