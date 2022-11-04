/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.category_tbl;

import java.io.Serializable;

/**
 *
 * @author LamVo
 */
public class Category_tblDTO implements Serializable{
    private int categoryId;
    private String name;
    private int countNum;
    // Constructors

    public Category_tblDTO() {
    }

    public Category_tblDTO(int categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }

    public Category_tblDTO(int categoryId, String name, int countNum) {
        this.categoryId = categoryId;
        this.name = name;
        this.countNum = countNum;
    }
    
    // Getters

    public int getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }
    // Setters

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountNum() {
        return countNum;
    }

    public void setCountNum(int countNum) {
        this.countNum = countNum;
    }
    
}
