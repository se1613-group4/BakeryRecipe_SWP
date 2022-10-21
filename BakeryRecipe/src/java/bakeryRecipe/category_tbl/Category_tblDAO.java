/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.category_tbl;

import bakeryRecipe.utils.DBConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LamVo
 */
public class Category_tblDAO implements Serializable{
    // function of DAO code here
    public boolean checkPhonenumber(String phonenumber) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean set = false;
        try {
            //1. make connection
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. create sql string
                String sql = "select phone_number from account_tbl where phone_number like ? ";
                //3. create statement obj
                stm = connection.prepareStatement(sql); // tao ra obj rong
                stm.setString(1, phonenumber);
                //4. execute query
                rs = stm.executeQuery();
                //5 process result
                if (rs.next()) {
                    set= true;
                } else {
                    set= false;
                }
            }
             } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return set ;

    }
    
    private List<Category_tblDTO> categoryDtoList;

    /**
     * Author: LamVo
     * @return list of category DTO (s)
     */
    public List<Category_tblDTO> getCategoryDtoList() {
        return this.categoryDtoList;
    }
     public void loadAllCategory()
            throws SQLException {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        this.categoryDtoList = null;
        try {
            //1. make connection
            con = DBConnection.getConnection();
            if (con != null) {
                //2. create sql string
                String sql = "SELECT category_id, name as category_name\n"
                        + "FROM bakery_recipe.category_tbl";
                //3. create statement obj
                stm = con.createStatement();
                //4. execute query
                rs = stm.executeQuery(sql);
                //5 process result
                while (rs.next()) {                    
                    // get category DTO info
                    int categoryId = rs.getInt("category_id");
                    String categoryName = rs.getString("category_name");
                    Category_tblDTO categoryDto = new Category_tblDTO(categoryId, categoryName);                                                            
                    // check categoryDto list not null
                    if (this.categoryDtoList == null) {
                        this.categoryDtoList = new ArrayList<>();
                    }// end check categoryDto list is null
                    // add to categoryDto list
                    this.categoryDtoList.add(categoryDto);
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
    }// end loadAllCategory function
}
