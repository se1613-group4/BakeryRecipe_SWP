/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.tag_detail_tbl;

import java.io.Serializable;

/**
 *
 * @author LamVo
 */
public class Tag_Detail_tblDTO implements Serializable{
    private int recipeId;
    private int tagId;

    public Tag_Detail_tblDTO() {
    }

    public Tag_Detail_tblDTO(int recipeId, int tagId) {
        this.recipeId = recipeId;
        this.tagId = tagId;
    }
    //getters

    public int getRecipeId() {
        return recipeId;
    }

    public int getTagId() {
        return tagId;
    }
    //setters

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }
    
}
