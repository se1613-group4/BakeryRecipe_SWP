/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.unit_tbl;

import bakeryRecipe.ingredient_tbl.Ingredient_tblDTO;
import bakeryRecipe.recipe_ingredient_tbl.Recipe_Ingredient_tblDTO;
import bakeryRecipe.utils.DBConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LamVo
 */
public class Unit_tblDAO implements Serializable{
     private List<Unit_tblDTO> unitDtoList;

    /**
     * Author: LamVo
     * @return list of unit DTO (s)
     */        
     public List<Unit_tblDTO> getUnitDtoList() {
        return unitDtoList;
    }

    public void loadAllUnit() throws SQLException {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        this.unitDtoList = null;
        try {
            //1. make connection
            con = DBConnection.getConnection();
            if (con != null) {
                //2. create sql string
                String sql = "SELECT unit_id, unit_name\n"
                        + "FROM bakery_recipe.unit_tbl";
                //3. create statement obj
                stm = con.createStatement();
                //4. execute query
                rs = stm.executeQuery(sql);
                //5 process result
                while (rs.next()) {                    
                    // get category DTO info
                    int unitId = rs.getInt("unit_id");
                    String unitName = rs.getString("unit_name");
                    Unit_tblDTO unitDto = new Unit_tblDTO(unitId, unitName);
                    // check categoryDto list not null
                    if (this.unitDtoList== null) {
                        this.unitDtoList = new ArrayList<>();
                    }// end check categoryDto list is null
                    // add to categoryDto list
                    this.unitDtoList.add(unitDto);
                }// end process rs
            }// end check con not null
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    } // end loadAllIngredient function
}
