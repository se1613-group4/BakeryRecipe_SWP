<%-- 
    Document   : submit_recipe
    Created on : Oct 7, 2022, 6:50:20 PM
    Author     : LamVo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Bakery Recipe | Submit Recipes</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Favicon -->
        <link rel="shortcut icon" href="img/favicon.png">
        <!-- Normalize Css -->
        <link rel="stylesheet" href="css/normalize.css">
        <!-- Main Css -->
        <link rel="stylesheet" href="css/main.css">
        <!-- Bootstrap Css -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <!-- Animate CSS -->
        <link rel="stylesheet" href="css/animate.min.css">
        <!-- Fontawesome CSS -->
        <link rel="stylesheet" href="css/fontawesome-all.min.css">
        <!-- Flaticon CSS -->
        <link rel="stylesheet" href="fonts/flaticon.css">
        <!-- Summernote CSS -->
        <link rel="stylesheet" href="css/summernote.css">
        <!-- Owl Carousel CSS -->
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <!-- Select 2 CSS -->
        <link rel="stylesheet" href="css/select2.min.css">
        <!-- Custom Css -->
        <link rel="stylesheet" href="style.css">
        <!-- Modernizr Js -->
        <script src="js/modernizr-3.6.0.min.js"></script>
    </head>
    <body>
        <!-- Preloader Start Here -->
        <div id="preloader"></div>
        <!-- Preloader End Here -->
        <!-- ScrollUp Start Here -->
        <a href="#wrapper" data-type="section-switch" class="scrollup">
            <i class="fas fa-angle-double-up"></i>
        </a>
        <!-- ScrollUp End Here -->
        <div id="wrapper" class="wrapper">
            <!-- Header Area Start Here -->
            <jsp:include page="header_user.jsp"></jsp:include>
            <!-- Header Area End Here -->
            <!-- Inne Page Banner Area Start Here -->
            <section class="inner-page-banner bg-common" data-bg-image="img/figure/inner-page-banner1.jpg">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <div class="breadcrumbs-area">
                                <h1>Submit Recipe</h1>
                                <ul>
                                    <li>
                                        <a href=" ">Home</a>
                                    </li>
                                    <li>Submit Recipe</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Inne Page Banner Area End Here -->
            <!-- Submit Recipe Area Start Here -->                                        
            <section class="submit-recipe-page-wrap padding-top-74 padding-bottom-50">
                <div class="container">
                    <div class="row gutters-60">
                        
                    <div class="col-lg-2">
                    </div>
                    <div class="col-lg-8">
                        <!--Create Recipe Form-->
                        <form class="submit-recipe-form" action="createRecipeController" method="post">

                            <!--Input recipe name-->
                            <div class="form-group">
                                <label>Recipe Title</label>
                                <input type="text" placeholder="Recipe Name" class="form-control" name="txtRecipeName" value=""
                                    data-error="Subject field is required" required>
                                <div class="help-block with-errors"></div>
                            </div>
                            <!--Choose category-->
                            <c:set var="categoryList" value="${requestScope.CATRGORY_LIST}"></c:set>
                            <div class="form-group">
                                <label>Recipe Category</label>
                                <select class="select2" name="txtCategoryId">
                                    <option value="" disabled="disabled" selected="selected">Choose Category</option>
                                <c:if test="${not empty categoryList}">
                                    <c:forEach var="categoryDto" items="${categoryList}">
                                        <option value="${categoryDto.categoryId}">${categoryDto.name}</option>
                                    </c:forEach>
                                </c:if>                                    
                                </select>
                            </div>
                            <!--Input recipe description-->
                            <div class="form-group">
                                <label>Description</label>
                                <textarea placeholder="Short description about your recipe..." 
                                        class="textarea form-control" name="txtDescription" id="form-message"
                                        rows="3" cols="20" data-error="Description field is required" required></textarea>
                                <div class="help-block with-errors"></div>
                            </div>
                            <!--Upload photos-->
                            <div class="additional-input-wrap">
                                <label>Upload your photos</label>
                                <div class="form-group">
                                    <ul class="upload-img">
<!--                                        <li><img src="img/figure/upload-banner1.jpg" alt="Upload Image"></li>
                                        <li><img src="img/figure/upload-banner1.jpg" alt="Upload Image"></li>-->
<!--                                        <li><img src="img/figure/upload-banner1.jpg" alt="Upload Image"></li>
                                        <li><img src="img/figure/upload-banner1.jpg" alt="Upload Image"></li>
                                        <li><img src="img/figure/upload-banner1.jpg" alt="Upload Image"></li>-->
                                    </ul>
                                    <button type="submit" class="btn-upload"><i class="fas fa-cloud-upload-alt"></i>UPLOAD</button>
                                </div>
                            </div>
                            <!--Input additional information-->
                            <div class="additional-input-wrap">
                                <label>Additional Information</label>
                                <div class="row gutters-5">
                                    <div class="col-lg-4">
                                        <div class="form-group additional-input-box icon-left">
                                            <i class="far fa-clock"></i>
                                            <input type="text" placeholder="Preparation Time (in minutes)" class="form-control"
                                                name="txtPrepTime">
                                        </div>
                                    </div>
                                    <div class="col-lg-4">
                                        <div class="form-group additional-input-box icon-left">
                                            <i class="fas fa-utensils"></i>
                                            <input type="text" placeholder="Cooking Time (in minutes)" class="form-control"
                                                name="txtCookTime">
                                        </div>
                                    </div>
                                    <div class="col-lg-4">
                                        <div class="form-group additional-input-box icon-left">
                                            <i class="fas fa-users"></i>
                                            <input type="text" placeholder="Serving People: 00" class="form-control"
                                                name="txtServing">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!--Input ingredients-->
                            <c:set var="ingredientList" value="${requestScope.INGREDIENT_LIST}"></c:set>
                            <c:set var="unitList" value="${requestScope.UNIT_LIST}"></c:set>                             
                            <div class="additional-input-wrap" id="ingre-parent">                                
                                <label>Ingredients</label>                                
                                <!--1-->
                                <div class="row no-gutters" id="ingredient-sample">
                                    <!--Select Ingredient-->
                                    <div class="col-5">
                                        <div class="form-group additional-input-box icon-left">  
                                            <select class="select2 input-select2" name="txtIngredientId">
                                                <option value="" disabled="disabled" selected="selected">Ingredient</option>
                                            <c:if test="${not empty ingredientList}">
                                                <c:forEach var="ingredientDto" items="${ingredientList}">
                                                    <option value="${ingredientDto.ingredientId}">${ingredientDto.name}</option>
                                                </c:forEach>
                                            </c:if>
                                            </select>                                         
                                            <!-- <input type="text" placeholder="Ingredient" class="form-control"
                                                name="txtIngredient"> -->
                                        </div>
                                    </div>
                                    <!--Input Quantity-->
                                    <div class="col-3">
                                        <div class="form-group additional-input-box icon-left">
                                            <input type="number" step="0.01" placeholder="Quantity" class="form-control"
                                                name="txtQuantity">
                                        </div>
                                    </div>
                                    <!--Select Unit-->                                      
                                    <div class="col-4">
                                        <div class="form-group additional-input-box icon-right">
                                            <select class="select2 input-select2" name="txtUnitId">
                                                <option value=""  disabled="disabled" selected="selected">Unit</option>
                                            <c:if test="${not empty unitList}">
                                                <c:forEach var="unitDto" items="${unitList}">
                                                    <option value="${unitDto.unitId}">${unitDto.unitName}</option>
                                                </c:forEach>
                                            </c:if>
                                            </select>  
                                            <i class="fas fa-times"></i>
                                        </div>
                                    </div>                                    
                                </div>
                                <!--Add ingredient button-->
                                <button type="button" class="btn-upload" id="add-ingre-tbn" onclick="test()"><i class="flaticon-add-plus-button"></i>ADD NEW
                                    INGREDIENT</button>
                            </div>
                            <!--Input instruction (steps)-->
                            <div class="form-group">
                                <label>Instruction</label>
                                <div class="row no-gutters" id="step-sample">                                    
                                    <!--Input Quantity-->
                                    <div class="col-10">
                                        <div class="form-group additional-input-box icon-left">
                                            <input type="text"placeholder="Type detail step instruction" class="form-control"
                                                   name="txtStep" value="">
                                        </div>
                                    </div>                                   
                                </div>
                            </div>
                            <button type="submit" class="btn-submit">SUBMIT RECIPE</button>
                        </form>

                    </div>  
                                            
                    </div>
                </div>
            </section>
            <!-- Submit Recipe Area End Here -->
            <!-- Footer Area Start Here -->
            <%@include file="footer.html" %>
            <!-- Footer Area End Here -->
        </div>

        <!-- Jquery Js -->
        <script src="js/jquery-3.3.1.min.js"></script>
        <!-- Bootstrap Js -->
        <script src="js/popper.min.js"></script>
        <!-- Bootstrap Js -->
        <script src="js/bootstrap.min.js"></script>
        <!-- Plugins Js -->
        <script src="js/plugins.js"></script>
        <!-- Owl Carousel Js -->
        <script src="js/owl.carousel.min.js"></script>
        <!-- Summernote JS -->
        <script src="js/summernote.min.js"></script>
        <!-- Select 2 Js -->
        <script src="js/select2.full.min.js"></script>
        <!-- Smoothscroll Js -->
        <script src="js/smoothscroll.min.js"></script>
        <!-- Custom Js -->
        <!--<script src="js/main.js"></script>-->
        <script src="js/submit_recipe.js"></script>
<!--        <script>
                                    
        </script>-->
    </body>
</html>
