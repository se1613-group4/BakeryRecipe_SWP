/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryRecipe.utils;

/**
 *
 * @author LamVo
 */
public class AppContants { // mapping all features strings

    public class DisplayHomePageFeature {

        public static final String HOME_PAGE = "homePage";
    }

    public class SearchAllRecipesFeature {

        public static final String HOME_PAGE = "homePageJsp";
        public static final String SEARCH_RESULT_PAGE = "searchResultPage";
    }

    public class AddNewCommentFeature {

        public static final String PREVIOUS_RECIPE_PAGE = "singleRecipePage";
        public static final String DISPLAY_SINGLE_RECIPE_CONTROLLER = "DisplaySingleRecipeController";
        public static final String ERROR_PAGE = "addCommentErrorPage";
        public static final String LOGIN_PAGE = "loginJsp";
    }

    public class DisplaySingleRecipeFeature {

        public static final String RECIPE_NOT_FOUND_PAGE = "recipeNotFoundPage";
        public static final String SINGLE_RECIPE_PAGE = "singleRecipePage";
    }

    public class DisplayOwnRecipesFeature {

        public static final String MY_RECIPES_PAGE = "myRecipesPage";
    }

    public class RemoveRecipeFeature {

        public static final String ERROR_PAGE = "errorPage";
    }

    public class LoginFeatures {

        public static final String LOGIN_PAGE = "loginPage";
        public static final String HOME_PAGE_USER = "homePageUser";
    }

    public class RegisterFeatures {

        public static final String ERROR_PAGE = "registerPage";
        public static final String LOGIN_PAGE = "loginPage";
    }

    public class Admin {

        public static final String ADMIN_UPDATESINGLERECIPE = "adminUpdateRecipe";
        public static final String ADMIN_HOME = "adminHome";
        public static final String ADMIN_DASHBOARD = "adminDashBoardController";
        public static final String ADMIN_LISTUSER = "adminListUserController";
        public static final String ADMIN_USDETAIL = "adminUsdetail";
        public static final String ADMIN_LISTRECIPE = "listRecipeAdmin";

    }

    public class DisplayUserProfileFeartures {

        public static final String PROFILE_PAGE = "userProfilePage";
        public static final String USER_HOME_PAGE = "userHomePage";
    }

    public class ResetPasswordFeartures {

        public static final String RESET_PASSWORD_PAGE = "resetPasswordPage";
        public static final String USER_HOME_PAGE = "userHomePage";
    }

    public class RemoveAccountFeartures {

        public static final String USER_HOME_PAGE = "userHomePage";
        public static final String LOGIN_PAGE = "loginPage";
    }

    public class ForgotPaswordFeartures {

        public static final String FORGOT_PASSWORD_PAGE = "forgotPasswordPage";
        public static final String LOGIN_PAGE = "loginPage";
    }

    public class DisplaySubmitRecipeFeature {

        public static final String SUBMIT_RECIPE_PAGE = "submitRecipePage";

    }
    
    public class CreateRecipeFeature {
        public static final String ERROR_PAGE = "errorPage";
        public static final String MY_RECIPES_PAGE = "displayOwnRecipes";
    }
}
