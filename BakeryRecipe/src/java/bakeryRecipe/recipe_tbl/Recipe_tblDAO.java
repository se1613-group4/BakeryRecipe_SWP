/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.recipe_tbl;

import bakeryRecipe.category_tbl.Category_tblDTO;
import bakeryRecipe.image_tbl.Image_tblDTO;
import bakeryRecipe.profile_tbl.Profile_tblDTO;
import bakeryRecipe.utils.DBConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LamVo
 */
public class Recipe_tblDAO implements Serializable {
    
    private List<Recipe_tblDTO> recipeDtoList;

    /**
     * @return list of recipe DTO (s)
     */
    public List<Recipe_tblDTO> getRecipeDtoList() {
        return this.recipeDtoList;
    }

    /**
     * Search all Recipe object by name
     * Author: ThongNT
     * @param searchValue characters of recipe's name
     * @return A list of Recipe_tblDTO objects
     * @throws SQLException
     */
    public List<Recipe_tblDTO> searchAllRecipe(String searchValue) throws SQLException {

        List<Recipe_tblDTO> recipesList = null;
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            //1. Get connection
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. Write SQL String
                String sql = "SELECT liked_count, \n"
                        + "		R.recipe_id, \n"
                        + "        R.name as recipe_name, \n"
                        + "        img_id, \n"
                        + "        img_link,\n"
                        + "		profile_tbl.user_id, \n"
                        + "        profile_tbl.full_name, \n"
                        + "        category_tbl.category_id, \n"
                        + "        category_tbl.name as category_name, \n"
                        + "        serving, \n"
                        + "        (prepare_time+cook_time) as total_time, \n"
                        + "        instruction, \n"
                        + "        R.last_modified\n"
                        + "FROM (select liked_count, \n"
                        + "			recipe_id, \n"
                        + "            name, \n"
                        + "            serving, \n"
                        + "            prepare_time, \n"
                        + "            cook_time, \n"
                        + "            instruction, \n"
                        + "            last_modified, \n"
                        + "            category_id, \n"
                        + "            user_id, \n"
                        + "            is_actived, \n"
                        + "            is_hidden\n"
                        + "		from recipe_tbl \n"
                        + "		where \n"
                        + "			is_actived = 1 \n"
                        + "                 and is_hidden = 0 ) as R\n"
                        + "		inner join category_tbl on R.category_id = category_tbl.category_id\n"
                        + "		inner join profile_tbl on R.user_id = profile_tbl.user_id\n"
                        + "		inner join image_tbl on R.recipe_id = image_tbl.recipe_id\n"
                        + "WHERE (R.name like ? or profile_tbl.full_name like ?)";
                //3. Create Statement Object
                stm = connection.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                stm.setString(2, "%" + searchValue + "%");
                //4. Execute statement
                rs = stm.executeQuery();
                //5. Process result= rs.getInt("recipe_id");
                while (rs.next()) {
                    // get recipe DTO info
                    int recipeId = rs.getInt("R.recipe_id");
                    String recipeName = rs.getString("recipe_name");
                    String description = rs.getString("instruction");
                    int serving = rs.getInt("serving");
                    int totalTime = rs.getInt("total_time");
                    int likedCount = rs.getInt("liked_count");
                    Date lastModified = rs.getDate("R.last_modified");
                    
                    // get user's profile DTO info
                    int userId = rs.getInt("profile_tbl.user_id");
                    String authorName = rs.getString("profile_tbl.full_name");
                    Profile_tblDTO authorInfo = new Profile_tblDTO(userId, authorName);
                    
                    // get category DTO info
                    int categoryId = rs.getInt("category_tbl.category_id");
                    String categoryName = rs.getString("category_name");
                    Category_tblDTO category = new Category_tblDTO(categoryId, categoryName);
                    
                    // get image info
                    int imgId = rs.getInt("img_id");
                    String imgLink = rs.getString("img_link");
                    Image_tblDTO image = new Image_tblDTO(imgId, imgLink);
                    
                    // create recipeDTO
                    Recipe_tblDTO recipeDto = new Recipe_tblDTO(recipeId, recipeName, serving, description, totalTime, likedCount, lastModified, authorInfo, category, image);
                    
                    // check recipe dto list not null
                    if (recipesList == null) {
                        recipesList = new ArrayList<>();
                    }
                    //recipesList has existed
                    recipesList.add(recipeDto);
                }//end traverse ResultSet
            }
            return recipesList;
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
    }//end searchAllRecipe function


    /**
     * Load top 5 recipe DTO by count of likes
     * Author: LamVo
     * @param topNum
     * @throws java.sql.SQLException
     */
    public void loadTopRecipe(int topNum)
            throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        this.recipeDtoList = null;
        try {
            //1. make connection
            con = DBConnection.getConnection();
            if (con != null) {
                //2. create sql string
                String sql = "SELECT liked_count, R.recipe_id, R.name as recipe_name, img_id, img_link,\n"
                        + "         profile_tbl.user_id, profile_tbl.full_name, category_tbl.category_id, category_tbl.name as category_name, \n"
                        + "         serving, (prepare_time+cook_time) as total_time, instruction, R.last_modified\n"
                        + "FROM (select liked_count, recipe_id, name, serving, prepare_time, cook_time, instruction, last_modified, category_id, user_id, is_actived, is_hidden\n"
                        + "		from recipe_tbl \n"
                        + "		where is_actived = 1 and is_hidden = 0\n"
                        + "		order by liked_count desc limit ?) as R\n"
                        + "	inner join category_tbl on R.category_id = category_tbl.category_id\n"
                        + "	inner join profile_tbl on R.user_id = profile_tbl.user_id\n"
                        + "     inner join image_tbl on R.recipe_id = image_tbl.recipe_id";
                //3. create statement obj
                stm = con.prepareStatement(sql);
                stm.setInt(1, topNum);
                //4. execute query
                rs = stm.executeQuery();
                //5 process result
                while (rs.next()) {
                    // get recipe DTO info
                    int recipeId = rs.getInt("R.recipe_id");
                    String recipeName = rs.getString("recipe_name");
                    String description = rs.getString("instruction");
                    int serving = rs.getInt("serving");
                    int totalTime = rs.getInt("total_time");
                    int likedCount = rs.getInt("liked_count");
                    Date lastModified = rs.getDate("R.last_modified");
                    // get user's profile DTO info
                    int userId = rs.getInt("profile_tbl.user_id");
                    String authorName = rs.getString("profile_tbl.full_name");
                    Profile_tblDTO authorInfo = new Profile_tblDTO(userId, authorName);
                    // get category DTO info
                    int categoryId = rs.getInt("category_tbl.category_id");
                    String categoryName = rs.getString("category_name");
                    Category_tblDTO category = new Category_tblDTO(categoryId, categoryName);
                    // get image info
                    int imgId = rs.getInt("img_id");
                    String imgLink = rs.getString("img_link");
                    Image_tblDTO image = new Image_tblDTO(imgId, imgLink);
                    // create recipeDTO
                    Recipe_tblDTO recipeDto = new Recipe_tblDTO(recipeId, recipeName, serving, description, totalTime, likedCount, lastModified, authorInfo, category, image);
                    // check recipe dto list not null
                    if (this.recipeDtoList == null) {
                        this.recipeDtoList = new ArrayList<>();
                    }// end check recipeIdList is null
                    // add to recipeId list
                    this.recipeDtoList.add(recipeDto);
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
    }// end loadTopRecipe function

    /**
     * Load all recipes sort by update day - with pagination sql
     *
     * @throws SQLException
     */
    public void loadRecentlyRecipe() // can them pagination
            throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        this.recipeDtoList = null;
        try {
            //1. make connection
            con = DBConnection.getConnection();
            if (con != null) {
                //2. create sql string
                String sql = "SELECT liked_count, R.recipe_id, R.name as recipe_name, img_id, img_link,\n"
                        + "		profile_tbl.user_id, profile_tbl.full_name, category_tbl.category_id, category_tbl.name as category_name, \n"
                        + "             serving, (prepare_time+cook_time) as total_time, instruction, R.last_modified\n"
                        + "FROM (select liked_count, recipe_id, name, serving, prepare_time, cook_time, instruction, last_modified, category_id, user_id, is_actived, is_hidden\n"
                        + "		from recipe_tbl \n"
                        + "		where is_actived = 1 and is_hidden = 0) as R\n"
                        + "	inner join category_tbl on R.category_id = category_tbl.category_id\n"
                        + "	inner join profile_tbl on R.user_id = profile_tbl.user_id\n"
                        + "     inner join image_tbl on R.recipe_id = image_tbl.recipe_id\n"
                        + "order by R.last_modified DESC";
                //3. create statement obj
                stm = con.prepareStatement(sql);
                //4. execute query
                rs = stm.executeQuery();
                //5 process result
                while (rs.next()) {
                    // get recipe DTO info
                    int recipeId = rs.getInt("R.recipe_id");
                    String recipeName = rs.getString("recipe_name");
                    String description = rs.getString("instruction");
                    int serving = rs.getInt("serving");
                    int totalTime = rs.getInt("total_time");
                    int likedCount = rs.getInt("liked_count");
                    Date lastModified = rs.getDate("R.last_modified");
                    // get user's profile DTO info
                    int userId = rs.getInt("profile_tbl.user_id");
                    String authorName = rs.getString("profile_tbl.full_name");
                    Profile_tblDTO authorInfo = new Profile_tblDTO(userId, authorName);
                    // get category DTO info
                    int categoryId = rs.getInt("category_tbl.category_id");
                    String categoryName = rs.getString("category_name");
                    Category_tblDTO category = new Category_tblDTO(categoryId, categoryName);
                    // get image info
                    int imgId = rs.getInt("img_id");
                    String imgLink = rs.getString("img_link");
                    Image_tblDTO image = new Image_tblDTO(imgId, imgLink);
                    // create recipeDTO
                    Recipe_tblDTO recipeDto = new Recipe_tblDTO(recipeId, recipeName, serving, description, totalTime, likedCount, lastModified, authorInfo, category, image);
                    // check recipe dto list not null
                    if (this.recipeDtoList == null) {
                        this.recipeDtoList = new ArrayList<>();
                    }// end check recipeIdList is null
                    // add to recipeId list
                    this.recipeDtoList.add(recipeDto);
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
    }// end loadRecentlyRecipe function

    /**
     * Get a recipe DTO by recipeID
     *
     * @param recipeId
     * @return one recipe DTO
     * @throws java.sql.SQLException
     *
     */
    public Recipe_tblDTO getRecipe(int recipeId)
            throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Recipe_tblDTO result = null;
        try {
            //1. make connection
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. create sql string
                String sql = "SELECT liked_count, saved_count, R.recipe_id, R.name as recipe_name, img_id, img_link,\n"
                        + "             profile_tbl.user_id, profile_tbl.full_name, category_tbl.category_id, category_tbl.name as category_name, \n"
                        + "         serving, prepare_time, cook_time, instruction, R.last_modified\n"
                        + "FROM (select liked_count, saved_count, recipe_id, name, serving, prepare_time, cook_time, instruction, last_modified, category_id, user_id, is_actived, is_hidden\n"
                        + "         from recipe_tbl where recipe_id = ?) as R\n"
                        + "	inner join category_tbl on R.category_id = category_tbl.category_id\n"
                        + "	inner join profile_tbl on R.user_id = profile_tbl.user_id\n"
                        + "     inner join image_tbl on R.recipe_id = image_tbl.recipe_id";
                //3. create statement obj
                stm = connection.prepareStatement(sql); // tao ra obj rong
                stm.setInt(1, recipeId);
                //4. execute query
                rs = stm.executeQuery(); // do phia tren da nap roi nen ko can truyen them tham so de nap vao bo nho
                //5. process result
                if (rs.next()) {
                    // get recipe DTO info
                    String recipeName = rs.getString("recipe_name");
                    int serving = rs.getInt("serving");
                    String description = rs.getString("instruction");
                    int preTime = rs.getInt("prepare_time");
                    int cookTime = rs.getInt("cook_time");
                    int likedCount = rs.getInt("liked_count");
                    int savedCount = rs.getInt("saved_count");
                    Date lastModified = rs.getDate("last_modified");
                    // get user's profile DTO info
                    int userId = rs.getInt("profile_tbl.user_id");
                    String authorName = rs.getString("profile_tbl.full_name");
                    Profile_tblDTO authorInfo = new Profile_tblDTO(userId, authorName);
                    // get category DTO info
                    int categoryId = rs.getInt("category_tbl.category_id");
                    String categoryName = rs.getString("category_name");
                    Category_tblDTO category = new Category_tblDTO(categoryId, categoryName);
                    // get image info
                    int imgId = rs.getInt("img_id");
                    String imgLink = rs.getString("img_link");
                    Image_tblDTO image = new Image_tblDTO(imgId, imgLink);
                    // create recipeDTO
                    Recipe_tblDTO recipeDto = new Recipe_tblDTO(recipeId, recipeName, serving, description, preTime, cookTime, likedCount, savedCount, lastModified, authorInfo, category, image);
                    result = recipeDto;

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
        return result;
    }
            
}
