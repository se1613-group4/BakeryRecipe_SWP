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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LamVo
 */
public class Recipe_tblDAO implements Serializable {

    private List<Recipe_tblDTO> recipeDtoList;

    /**
     * Author: LamVo
     *
     * @return list of recipe DTO (s)
     */
    public List<Recipe_tblDTO> getRecipeDtoList() {
        return this.recipeDtoList;
    }

    
    public boolean addNewView(int recipeId) throws SQLException {
        boolean result = false;
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            //1. Get connection
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. Write SQL String
                String sql = "UPDATE `bakery_recipe`.`recipe_tbl` SET `view_count` = `view_count` + 1 WHERE (`recipe_id` = ?);";
                //3. Create statement
                stm = connection.prepareStatement(sql);
                stm.setInt(1, recipeId);
                //4. Execute statement
                int tmp = stm.executeUpdate();
                //5. Process result
                if (tmp != 0) {
                    result = true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return result;
    }//end addNewView function


public void loadMostViewRecipe(int topNum)
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
                String sql = "SELECT liked_count, R.recipe_id, R.name as recipe_name, serving, (prepare_time+cook_time) as total_time,\n" +
"                        		instruction, R.last_modified, img_id, img_link, \n" +
"                        		profile_tbl.user_id, profile_tbl.full_name, category_tbl.category_id, category_tbl.name as category_name, R.view_count\n" +
"                        FROM recipe_tbl as R\n" +
"                        	inner join category_tbl on R.category_id = category_tbl.category_id\n" +
"                        	inner join profile_tbl on R.user_id = profile_tbl.user_id\n" +
"                            inner join image_tbl on R.recipe_id = image_tbl.recipe_id\n" +
"                        where R.is_actived = 1 and R.is_hidden = 0\n" +
"                        	  order by R.view_count desc limit ?;";
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
                    int view_count = rs.getInt("R.view_count");
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
                    Recipe_tblDTO recipeDto = new Recipe_tblDTO(recipeId, recipeName, serving, description, totalTime, likedCount, lastModified, authorInfo, category, image, view_count);
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
    }// end loadMostViewRecipe function
    
    /**
     * Search all Recipe object by name
     *
     * @Author: ThongNT
     * @param searchValue characters of recipe's name
     * @return A list of Recipe_tblDTO objects
     * @throws SQLException
     */
    public List<Recipe_tblDTO> searchAllRecipe(String searchValue, String[] categoryFilter) throws SQLException {

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

                if (categoryFilter != null) {
                    sql = sql.concat(" and category_tbl.name in (");
                    for (String categoryName : categoryFilter) {
                        sql = sql.concat("'").concat(categoryName).concat("', ");
                    }
                    sql = sql.concat(")");
                    sql = sql.replace(", )", ")");
                    System.out.println("SQL STring: " + sql);
                }
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
     * Search all Recipe object by name, limit by 9 object from a input
     * parameter
     *
     * @Author: ThongNT
     * @param searchValue characters of recipe's name
     * @return A list of Recipe_tblDTO objects
     * @throws SQLException
     */
    public List<Recipe_tblDTO> searchAllRecipePaging9(String searchValue, int startNumber) throws SQLException {

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
                        + "WHERE (R.name like ? or profile_tbl.full_name like ?)"
                        + "LIMIT ?, 9;";
                //3. Create Statement Object
                stm = connection.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                stm.setString(2, "%" + searchValue + "%");
                stm.setInt(3, startNumber);
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
     * Load top 5 recipe DTO by count of likes Author: LamVo
     *
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
                String sql = "SELECT liked_count, R.recipe_id, R.name as recipe_name, serving, (prepare_time+cook_time) as total_time,\n"
                        + "		instruction, R.last_modified, img_id, img_link, \n"
                        + "		profile_tbl.user_id, profile_tbl.full_name, category_tbl.category_id, category_tbl.name as category_name\n"
                        + "FROM recipe_tbl as R\n"
                        + "	inner join category_tbl on R.category_id = category_tbl.category_id\n"
                        + "	inner join profile_tbl on R.user_id = profile_tbl.user_id\n"
                        + "    inner join image_tbl on R.recipe_id = image_tbl.recipe_id\n"
                        + "where R.is_actived = 1 and R.is_hidden = 0\n"
                        + "	  order by R.liked_count desc limit ?;";
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
                        + "        serving, (prepare_time+cook_time) as total_time, instruction, R.last_modified\n"
                        + "FROM recipe_tbl as R\n"
                        + "	inner join category_tbl on R.category_id = category_tbl.category_id\n"
                        + "	inner join profile_tbl on R.user_id = profile_tbl.user_id\n"
                        + "    inner join image_tbl on R.recipe_id = image_tbl.recipe_id\n"
                        + "where R.is_actived = 1 and R.is_hidden = 0\n"
                        + "order by R.last_modified DESC limit 10";
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
     * Get a recipe DTO by recipeID Author: LamVo
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
                        + "profile_tbl.user_id, profile_tbl.full_name, profile_tbl.avatar_url, profile_tbl.bio,\n"
                        + "category_tbl.category_id, category_tbl.name as category_name,\n"
                        + "serving, prepare_time, cook_time, instruction, R.last_modified, step\n"
                        + "FROM recipe_tbl as R\n"
                        + "inner join category_tbl on R.category_id = category_tbl.category_id\n"
                        + "left join profile_tbl on R.user_id = profile_tbl.user_id\n"
                        + "left join image_tbl on R.recipe_id = image_tbl.recipe_id\n"
                        + "where R.recipe_id = ?;";
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
                    String steps = rs.getString("step");
                    // get user's profile DTO info
                    int userId = rs.getInt("profile_tbl.user_id");
                    String authorName = rs.getString("profile_tbl.full_name");
                    String avatar = rs.getString("profile_tbl.avatar_url");
                    String bio = rs.getString("profile_tbl.bio");
                    Profile_tblDTO authorInfo = new Profile_tblDTO(userId, authorName, avatar, bio);
                    // get category DTO info
                    int categoryId = rs.getInt("category_tbl.category_id");
                    String categoryName = rs.getString("category_name");
                    Category_tblDTO category = new Category_tblDTO(categoryId, categoryName);
                    // get image info
                    int imgId = rs.getInt("img_id");
                    String imgLink = rs.getString("img_link");
                    Image_tblDTO image = new Image_tblDTO(imgId, imgLink);
                    // create recipeDTO
                    Recipe_tblDTO recipeDto = new Recipe_tblDTO(recipeId, recipeName, serving, description, preTime, cookTime, likedCount, savedCount, lastModified, authorInfo, category, image, steps);
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

    /**
     * Create new recipe
     */
    /**
     * Load one user's recipes Author: LamVo
     *
     * @param userId
     * @throws java.sql.SQLException
     */
    public void loadAllRecipes(int userId)
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
                String sql = "SELECT liked_count, saved_count, R.recipe_id, R.name as recipe_name, img_id, img_link,\n"
                        + "		profile_tbl.user_id, profile_tbl.full_name, category_tbl.category_id, category_tbl.name as category_name, \n"
                        + "        serving, (prepare_time + cook_time) as total_time, instruction, R.created_date\n"
                        + "FROM recipe_tbl as R\n"
                        + "	inner join category_tbl on R.category_id = category_tbl.category_id\n"
                        + "	inner join profile_tbl on R.user_id = profile_tbl.user_id\n"
                        + "    left join image_tbl on R.recipe_id = image_tbl.recipe_id\n"
                        + "where R.is_actived=1 and R.is_hidden=0 and R.user_id =?\n"
                        + "order by R.created_date DESC";
                //3. create statement obj
                stm = con.prepareStatement(sql);
                stm.setInt(1, userId);
                //4. execute query
                rs = stm.executeQuery();
                //5 process result
                while (rs.next()) {
                    // get recipe DTO info
                    int recipeId = rs.getInt("R.recipe_id");
                    String recipeName = rs.getString("recipe_name");
                    String description = rs.getString("instruction");
                    int totalTime = rs.getInt("total_time");
                    int likedCount = rs.getInt("liked_count");
                    Date createDate = rs.getDate("created_date");
                    // get category DTO info
                    int categoryId = rs.getInt("category_tbl.category_id");
                    String categoryName = rs.getString("category_name");
                    Category_tblDTO category = new Category_tblDTO(categoryId, categoryName);
                    // get image info
                    int imgId = rs.getInt("img_id");
                    String imgLink = rs.getString("img_link");
                    Image_tblDTO image = new Image_tblDTO(imgId, imgLink);
                    // create recipeDTO
                    Recipe_tblDTO recipeDto = new Recipe_tblDTO(recipeId, recipeName, description, totalTime, likedCount, createDate, category, image);
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
    }

    /**
     * Remove one recipe of a user (soft delete) set isActive = 0
     *
     * @param recipeId
     * @return boolean result
     * @throws java.sql.SQLException
     */
    public boolean removeRecipe(int recipeId)
            throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            //1. make connection
            con = DBConnection.getConnection();
            if (con != null) {
                //2. create sql string
                String sql = "UPDATE recipe_tbl \n"
                        + "SET is_actived = 0 \n"
                        + "WHERE (recipe_id = ?)";
                //3. create statement obj
                stm = con.prepareStatement(sql);
                stm.setInt(1, recipeId);
                //4. execute query
                int affectedRows = stm.executeUpdate();
                //5 process result
                if (affectedRows > 0) {
                    result = true;
                }// end process rs
            }// end check con not null
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    public ArrayList<Recipe_tblDTO> AdmingetRecipebyUser(int usid) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        ArrayList<Recipe_tblDTO> result = null;
        try {
            //1. make connection
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. create sql string
                String sql = "call getlistRecipefromUser_admin(?)";
                //3. create statement obj
                stm = connection.prepareStatement(sql); // tao ra obj rong
                stm.setInt(1, usid);
                //4. execute query
                rs = stm.executeQuery();
                //5 process result
                while (rs.next()) {
                    if (result == null) {
                        result = new ArrayList<>();
                    }
                    result.add(new Recipe_tblDTO(
                            rs.getInt("recipe_id"),
                            rs.getString("name"),
                            rs.getInt("liked_count"),
                            rs.getInt("saved_count"),
                            rs.getDate("created_date"),
                            rs.getDate("last_modified"),
                            rs.getBoolean("is_actived")
                    ));
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

    /**
     * Author LamVo
     *
     * @param recipeDto
     * @return
     * @throws SQLException
     */
    public boolean insertRecipe(Recipe_tblDTO recipeDto)
            throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            //1.  make connection
            con = DBConnection.getConnection();
            if (con != null) {
                //2. create sql string
                String sql = "INSERT INTO recipe_tbl \n"
                        + "	(`user_id`, `category_id`, `name`, `serving`, `instruction`, `prepare_time`, `cook_time`, `step`) \n"
                        + "    VALUES (?, ?, ?, ?, ?, ?, ?,?);";
                //3. create statement obj
                stm = con.prepareStatement(sql);
                stm.setInt(1, recipeDto.getUserId());
                stm.setInt(2, recipeDto.getCategoryId());
                stm.setString(3, recipeDto.getName());
                stm.setInt(4, recipeDto.getServing());
                stm.setString(5, recipeDto.getDescription());
                stm.setInt(6, recipeDto.getPreTime());
                stm.setInt(7, recipeDto.getCookTime());
                stm.setString(8, recipeDto.getSteps());
                //4. execute query
                int affectedRows = stm.executeUpdate();
                //5 process result
                if (affectedRows > 0) {
                    result = true;
                }// end process rs
            }// end check con not null
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    public int getCurrentIdent() throws SQLException {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        int currentIdent = -1;
        try {
            //1.  make connection
            con = DBConnection.getConnection();
            if (con != null) {
                //2. create sql string
                String sql = "SELECT recipe_id as current_identity FROM recipe_tbl ORDER BY created_date DESC LIMIT 1";
                //3. create statement obj
                stm = con.createStatement();
                //4. execute query
                rs = stm.executeQuery(sql);
                //5 process result
                if (rs.next()) {
                    currentIdent = rs.getInt("current_identity");
                }
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
        return currentIdent;
    }

    public void activeRecipe(int recipeId) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            //1. make connection
            con = DBConnection.getConnection();
            if (con != null) {
                //2. create sql string
                String sql = "UPDATE recipe_tbl \n"
                        + "SET is_actived = 1 \n"
                        + "WHERE (recipe_id = ?)";
                //3. create statement obj
                stm = con.prepareStatement(sql);
                stm.setInt(1, recipeId);
                //4. execute query
                stm.executeUpdate();
                //5 process result              
            }// end check con not null
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    /**
     * Author LamVo
     *
     * @param recipeDto
     * @return
     * @throws SQLException
     */
    public boolean updateRecipe(Recipe_tblDTO recipeDto, int recipeId)
            throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            //1.  make connection
            con = DBConnection.getConnection();
            if (con != null) {
                //2. create sql string
                String sql = "UPDATE recipe_tbl\n"
                        + "SET category_id= ?, \n"
                        + "	name = ?, \n"
                        + "	serving= ?, \n"
                        + "	instruction = ?, \n"
                        + "	prepare_time = ?, \n"
                        + "	cook_time = ?, \n"
                        + "	last_modified = now(),\n"
                        + "     step = ?\n"
                        + "WHERE (recipe_id = ?);";
                //3. create statement obj
                stm = con.prepareStatement(sql);
                stm.setInt(1, recipeDto.getCategoryId());
                stm.setString(2, recipeDto.getName());
                stm.setInt(3, recipeDto.getServing());
                stm.setString(4, recipeDto.getDescription());
                stm.setInt(5, recipeDto.getPreTime());
                stm.setInt(6, recipeDto.getCookTime());
                stm.setString(7, recipeDto.getSteps());
                stm.setInt(8, recipeId);
                //4. execute query
                int affectedRows = stm.executeUpdate();
                //5 process result
                if (affectedRows > 0) {
                    result = true;
                }// end process rs
            }// end check con not null
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    public List<Recipe_tblDTO> displaySavedRecipe(int loginUserId) throws SQLException {

        List<Recipe_tblDTO> recipesList = null;
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            //1. Get connection
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. Write SQL String
                String sql = "select liked_count, recipe_tbl.recipe_id, recipe_tbl.name, serving, prepare_time, cook_time, instruction, recipe_tbl.last_modified, recipe_tbl.category_id, category_tbl.name, image_tbl.img_link, recipe_tbl.user_id, profile_tbl.full_name, is_actived, is_hidden\n"
                        + "from recipe_tbl \n"
                        + "inner join (select recipe_id from save_tbl where user_id = ?) as savedReicpe on recipe_tbl.recipe_id = savedReicpe.recipe_id\n"
                        + "inner join category_tbl on category_tbl.category_id = recipe_tbl.category_id\n"
                        + "inner join image_tbl on recipe_tbl.recipe_id = image_tbl.recipe_id\n"
                        + "inner join profile_tbl on recipe_tbl.user_id = profile_tbl.user_id\n"
                        + "where is_actived = 1 and is_hidden = 0";
                //3. Create Statement Object
                stm = connection.prepareStatement(sql);
                stm.setInt(1, loginUserId);
                //4. Execute statement
                rs = stm.executeQuery();
                //5. Process result= rs.getInt("recipe_id");
                while (rs.next()) {
                    // get recipe DTO info
                    int recipeId = rs.getInt("recipe_tbl.recipe_id");
                    String recipeName = rs.getString("recipe_tbl.name");
                    String description = rs.getString("instruction");
                    int serving = rs.getInt("serving");
                    int totalTime = rs.getInt("prepare_time") + rs.getInt("cook_time");
                    int likedCount = rs.getInt("liked_count");
                    Date lastModified = rs.getDate("recipe_tbl.last_modified");

                    // get user's profile DTO info
                    int userId = rs.getInt("recipe_tbl.user_id");
                    String authorName = rs.getString("profile_tbl.full_name");
                    Profile_tblDTO authorInfo = new Profile_tblDTO(userId, authorName);

                    // get category DTO info
                    int categoryId = rs.getInt("recipe_tbl.category_id");
                    String categoryName = rs.getString("category_tbl.name");
                    Category_tblDTO category = new Category_tblDTO(categoryId, categoryName);

                    // get image info
                    String imgLink = rs.getString("image_tbl.img_link");
                    Image_tblDTO image = new Image_tblDTO(imgLink);

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
    }

    public List<Recipe_tblDTO> searchSavedRecipe(int loginUserId, String searchValue) throws SQLException {

        List<Recipe_tblDTO> recipesList = null;
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            //1. Get connection
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. Write SQL String
                String sql = "select liked_count, recipe_tbl.recipe_id, recipe_tbl.name, serving, prepare_time, cook_time, instruction, recipe_tbl.last_modified, recipe_tbl.category_id, category_tbl.name, image_tbl.img_link, recipe_tbl.user_id, profile_tbl.full_name, is_actived, is_hidden\n"
                        + "from recipe_tbl \n"
                        + "inner join (select recipe_id from save_tbl where user_id = ?) as savedReicpe on recipe_tbl.recipe_id = savedReicpe.recipe_id\n"
                        + "inner join category_tbl on category_tbl.category_id = recipe_tbl.category_id\n"
                        + "inner join image_tbl on recipe_tbl.recipe_id = image_tbl.recipe_id\n"
                        + "inner join profile_tbl on recipe_tbl.user_id = profile_tbl.user_id\n"
                        + "where is_actived = 1 and is_hidden = 0 and  recipe_tbl.name like ? or profile_tbl.full_name like ?";
                //3. Create Statement Object
                stm = connection.prepareStatement(sql);
                stm.setInt(1, loginUserId);
                stm.setString(2, "%" + searchValue + "%");
                stm.setString(3, "%" + searchValue + "%");
                //4. Execute statement
                rs = stm.executeQuery();
                //5. Process result= rs.getInt("recipe_id");
                while (rs.next()) {
                    // get recipe DTO info
                    int recipeId = rs.getInt("recipe_tbl.recipe_id");
                    String recipeName = rs.getString("recipe_tbl.name");
                    String description = rs.getString("instruction");
                    int serving = rs.getInt("serving");
                    int totalTime = rs.getInt("prepare_time") + rs.getInt("cook_time");
                    int likedCount = rs.getInt("liked_count");
                    Date lastModified = rs.getDate("recipe_tbl.last_modified");

                    // get user's profile DTO info
                    int userId = rs.getInt("recipe_tbl.user_id");
                    String authorName = rs.getString("profile_tbl.full_name");
                    Profile_tblDTO authorInfo = new Profile_tblDTO(userId, authorName);

                    // get category DTO info
                    int categoryId = rs.getInt("recipe_tbl.category_id");
                    String categoryName = rs.getString("category_tbl.name");
                    Category_tblDTO category = new Category_tblDTO(categoryId, categoryName);

                    // get image info
                    String imgLink = rs.getString("image_tbl.img_link");
                    Image_tblDTO image = new Image_tblDTO(imgLink);

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
    }
}
