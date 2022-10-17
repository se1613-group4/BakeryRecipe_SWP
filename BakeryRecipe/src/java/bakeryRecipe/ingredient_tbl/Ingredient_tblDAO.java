/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.ingredient_tbl;

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
public class Ingredient_tblDAO implements Serializable{
    private List<Ingredient_tblDTO> ingredientDtoList;

    /**
     * Author: LamVo
     * @return list of category DTO (s)
     */
    public List<Ingredient_tblDTO> getIngredientDtoList() {
        return this.ingredientDtoList;
    }
     public void loadAllIngredient()
            throws SQLException {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        this.ingredientDtoList = null;
        try {
            //1. make connection
            con = DBConnection.getConnection();
            if (con != null) {
                //2. create sql string
                String sql = "SELECT ingredient_id, name as ingredient_name, unit\n"
                        + "FROM bakery_recipe.ingredient_tbl";
                //3. create statement obj
                stm = con.createStatement();
                //4. execute query
                rs = stm.executeQuery(sql);
                //5 process result
                while (rs.next()) {                    
                    // get category DTO info
                    int ingredientId = rs.getInt("ingredient_id");
                    String ingredientName = rs.getString("ingredient_name");
                    String unit = rs.getString("unit");
                    Ingredient_tblDTO ingredientDto = new Ingredient_tblDTO(ingredientId, ingredientName,unit);
                    // check categoryDto list not null
                    if (this.ingredientDtoList == null) {
                        this.ingredientDtoList = new ArrayList<>();
                    }// end check categoryDto list is null
                    // add to categoryDto list
                    this.ingredientDtoList.add(ingredientDto);
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
    }// end loadAllIngredient function
}
