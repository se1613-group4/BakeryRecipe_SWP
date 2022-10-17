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
                        <form name="submitForm" class="submit-recipe-form" action="createRecipeController" 
                              onsubmit="return validateForm()" method="post">

                            <!--Input recipe name-->
                            <div class="form-group">
                                <label for="txtRecipeName">Recipe Title <font color="red">*</font></label>
                                <input type="text" placeholder="Recipe Name" class="form-control" name="txtRecipeName" value="" autofocus
                                    data-error="Title is required" required>
                                <div class="help-block with-errors"></div>
                            </div>
                            <!--Choose category-->
                            <c:set var="categoryList" value="${requestScope.CATRGORY_LIST}"></c:set>
                            <div class="form-group">
                                <label for="txtCategoryId">Recipe Category <font color="red">*</font></label>
                                <select class="select2" name="txtCategoryId">
                                    <option value="" disabled="disabled" selected>Choose Category</option>
                                <c:if test="${not empty categoryList}">
                                    <c:forEach var="categoryDto" items="${categoryList}">
                                        <option value="${categoryDto.categoryId}">${categoryDto.name}</option>
                                    </c:forEach>
                                </c:if>                                    
                                </select>
                            </div>
                            <!--Input recipe description-->
                            <div class="form-group">
                                <label for="txtDescription">Description <font color="red">*</font></label>
                                <textarea placeholder="Short description about your recipe..." 
                                        class="textarea form-control" name="txtDescription" id="form-message"
                                        rows="3" cols="20" data-error="Description is required" required></textarea>
                                <div class="help-block with-errors"></div>
                            </div>
                            <!--Upload photos-->
                            <div class="additional-input-wrap">
                                <label>Your photos</label>
                                <div class="form-group">
<!--                                    <input type="text" placeholder="Paste your image url here" id="img-template"
                                           class="form-control img-input" name="txtImgUrl" value=""/>-->
<!--                                    data-error="Subject field is required" required>-->
                                    <div class="row no-gutters img-div no-remove" id="img-sample">                                    
                                        <!--Input image url-->
                                        <div class="col-12">
                                            <div class="form-group additional-input-box icon-right">
                                                <input type="text" placeholder="Paste your image url here" class="form-control"
                                                   name="txtImgUrl" value=""/>
                                                <i class="fas fa-times" onclick="removeElement(this)"></i>
                                            </div>
                                        </div>
                                    </div>
                                    <button type="button" id="add-img-btn" class="btn-upload" onclick="addImg()">
                                            <i class="flaticon-add-plus-button"></i>Add Image</button>
                                </div>
                            </div>
                            <!--Upload videos-->
                            <div class="additional-input-wrap">
                                <label>Your video</label>
                                <div class="form-group">                                    
                                    <input type="text" placeholder="Paste your youtube video url here" class="form-control" name="txtVidUrl" value=""/>                                                                  
                                </div>
                            </div>
                            <!--Input Detail information-->
                            <div class="additional-input-wrap">
                                <label>Detail Information <font color="red">*</font></label>
                                <div class="row gutters-5">
                                    <div class="col-lg-7">
                                        <div class="form-group additional-input-box icon-left">
                                            <i class="far fa-clock"></i>
                                            <input type="number" min="1" max="1000" placeholder="Prep Time: 00(minutes)" class="form-control"
                                                name="txtPrepTime" data-error="Prep time is required" required>
                                            <div class="help-block with-errors"></div>
                                        </div>
                                    </div>
                                    <!--Break Space-->
                                    <div class="col-lg-5"></div>
                                    <!--End Break Space-->
                                    <div class="col-lg-7">
                                        <div class="form-group additional-input-box icon-left">
                                            <i class="fas fa-utensils"></i>
                                            <input type="number" min="1" max="1000" placeholder="Cook Time: 00(minutes)" class="form-control"
                                                name="txtCookTime" data-error="Cook Time is required" required>
                                            <div class="help-block with-errors"></div>
                                        </div>
                                    </div>
                                    <!--Break Space-->
                                    <div class="col-lg-5"></div>
                                    <!--End Break Space-->
                                    <div class="col-lg-7">
                                        <div class="form-group additional-input-box icon-left">
                                            <i class="fas fa-users"></i>
                                            <input type="number" min="1" max="1000000" placeholder="Serving: 00(people)" class="form-control"
                                                name="txtServing" data-error="Serving is required" required>
                                            <div class="help-block with-errors"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!--Input ingredients-->
                            <c:set var="ingredientList" value="${requestScope.INGREDIENT_LIST}"></c:set>
                            <%--<c:set var="unitList" value="${requestScope.UNIT_LIST}"></c:set>--%>                             
                            <div class="additional-input-wrap" id="ingre-parent">                                
                                <label>Ingredients <font color="red">*</font></label>                                
                                <!--1-->
                                <div class="row no-gutters ingre-div no-remove" id="ingredient-sample">
                                    <!--Select Ingredient-->
                                    <div class="col-7">
                                        <div class="form-group additional-input-box icon-left">  
                                            <select class="select2 input-select2" name="txtIngredientId">
                                                <option value="" disabled="disabled" selected="selected">Ingredient</option>
                                            <c:if test="${not empty ingredientList}">
                                                <c:forEach var="ingredientDto" items="${ingredientList}">
                                                    <option value="${ingredientDto.ingredientId}">${ingredientDto.name} (${ingredientDto.unit})</option>
                                                </c:forEach>
                                            </c:if>
                                            </select>
                                        </div>
                                    </div>
                                    <!--Input Quantity-->
                                    <div class="col-5">
                                        <div class="form-group additional-input-box icon-right">
                                            <input type="number" step="0.01" min="0.01" placeholder="Quantity" class="form-control"
                                                name="txtQuantity"/>
                                            <i class="fas fa-times" onclick="removeElement(this)"></i>
                                        </div>
                                    </div>
                                    <!--Select Unit-->                                      
                                    <%--<div class="col-4">
                                        <div class="form-group additional-input-box icon-right">
                                            <select class="select2 input-select2" name="txtUnitId">
                                                <option value=""  disabled="disabled" selected="selected">Unit</option>
                                            <c:if test="${not empty ingredientList}">
                                                <c:forEach var="ingredientDto" items="${ingredientList}">
                                                    <option value="${ingredientDto.ingredientId}">${ingredientDto.unit}</option>
                                                </c:forEach>
                                            </c:if>
                                            </select>  
                                            <i class="fas fa-times"></i>
                                        </div>
                                    </div>                                    --%>
                                </div>
                                <!--Add ingredient button-->
                                <button type="button" class="btn-upload" id="add-ingre-tbn" onclick="addIngredient()">
                                    <i class="flaticon-add-plus-button"></i>Add Ingredient</button>
                            </div>
                            <!--Hidden Field to send to server-->
                            <!--<h2>Result</h2>-->
                            <div class="hidden-field-area">
                                <!--<input type="hidden" name="txtIngredient" value="" />-->
                            </div>
                            <!--Input instruction (steps)-->
                            <div class="form-group">
                                <label>Instruction</label>
                                <div class="row no-gutters step-div no-remove" id="step-sample">                                    
                                    <!--Input Step-->
                                    <div class="col-12">
                                        <div class="form-group additional-input-box icon-right">
                                            <input type="text" placeholder="Type detail step instruction" class="form-control"
                                                   name="txtStep" value=""/>
                                            <i class="fas fa-times" onclick="removeElement(this)"></i>
                                        </div>
                                          <!--onclick="removeElement('step-sample')-->
                                    </div>
                                </div>
                                <!--Add step button-->
                                <button type="button" class="btn-upload" id="add-setep-tbn" onclick="addStep()">
                                    <i class="flaticon-add-plus-button"></i>Add Step</button>
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
