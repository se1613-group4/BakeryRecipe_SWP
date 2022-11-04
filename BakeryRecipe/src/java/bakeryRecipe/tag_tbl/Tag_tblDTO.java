/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.tag_tbl;

import java.io.Serializable;

/**
 *
 * @author LamVo
 */
public class Tag_tblDTO implements Serializable{
    private int tagId;
    private String name;
    private int count;

    public Tag_tblDTO() {
    }

    public Tag_tblDTO(int tagId, String name, int count) {
        this.tagId = tagId;
        this.name = name;
        this.count = count;
    }
    // getters
    public int getTagId() {
        return tagId;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }
    // setters

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
}
