/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.recipe_tbl;

import java.io.Serializable;

/**
 *
 * @author LamVo
 */
public class Recipe_tblErrorDTO implements Serializable{
    private String descriptionExceedCharsCount;
    private String stepExceedCharsCount;

    public Recipe_tblErrorDTO() {
    }

    public String getDescriptionExceedCharsCount() {
        return descriptionExceedCharsCount;
    }

    public void setDescriptionExceedCharsCount(String descriptionExceedCharsCount) {
        this.descriptionExceedCharsCount = descriptionExceedCharsCount;
    }

    public String getStepExceedCharsCount() {
        return stepExceedCharsCount;
    }

    public void setStepExceedCharsCount(String stepExceedCharsCount) {
        this.stepExceedCharsCount = stepExceedCharsCount;
    }
    
}
