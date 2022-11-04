/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.unit_tbl;

import java.io.Serializable;

/**
 *
 * @author LamVo
 */
public class Unit_tblDTO implements Serializable{
    private int unitId;
    private String unitName;

    public Unit_tblDTO() {
    }

    public Unit_tblDTO(int unitId, String unitName) {
        this.unitId = unitId;
        this.unitName = unitName;
    }

    public int getUnitId() {
        return unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
    
}
