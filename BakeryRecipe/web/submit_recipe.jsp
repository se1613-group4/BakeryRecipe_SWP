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
        <script src="https://kit.fontawesome.com/6166015301.js" crossorigin="anonymous"></script>
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
        <!--Css file for tag-->
        <link rel="stylesheet" href="css/tagStyle.css">
        <!--Css file for upload image dialog-->
        <link rel="stylesheet" href="css/dialog.css"/>
        <!-- Lam custom css -->
        <style type="text/css">
            .small-label {
                font-size: 99% !IMPORTANT;
            }
            input {
                font-size: 98% !IMPORTANT;
                height: 43.97px !IMPORTANT;
                border-radius: 4px !IMPORTANT;
            }
            .additional-input-box {
                height: 80% !IMPORTANT;
                margin: 0 !IMPORTANT;
                padding-top: 20px !IMPORTANT;
                padding-bottom: 20px !IMPORTANT;
                border-radius: 4px !IMPORTANT;
            }
            .btn-upload {
                border: none !IMPORTANT;
                outline: none !IMPORTANT;
                color: #fff !IMPORTANT;
                font-size: 14px !IMPORTANT;
                padding: 9px 10px !IMPORTANT;
                border-radius: 5px !IMPORTANT;
                background: #7D7A7A !IMPORTANT;
                font-weight: normal !IMPORTANT;
                /*                position: absolute !IMPORTANT;
                                right: 20px !IMPORTANT;
                                margin-top: 5px !IMPORTANT;*/
                /*                top: 350px !IMPORTANT;*/
            }
            .uploaded-img {
                height: 15%;
                width: 15%;
                margin: 2px;
            }
            .btn-upload:hover {
                background: #ff4a52f7 !IMPORTANT;
            }
            .btn-submit{
                border-radius: 4px !IMPORTANT;
            }
        </style>
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
                                            <a href="displayHomePage">Home</a>
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
                            <!--Input recipe form-->
                            <div class="col-lg-8">
                                <!--Create Recipe Form-->
                                <form id="submitForm" class="submit-recipe-form" action="CreateNewRecipe" 
                                      onsubmit="return validateForm()" method="post" enctype="multipart/form-data">

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
                                <!--Input tags of recipe-->
                                <div class="tag-container">
                                    <div class="tag-title">
                                        <!--<img src="https://niemvuilaptrinh.ams3.cdn.digitaloceanspaces.com/Tags-Input/tag-icon.svg" alt="icon">-->
                                        <label>Tags</label>
                                    </div>

                                    <div class="tag-content">
                                        <p>Type tags and press Enter to save tags, separated by (,).</p>
                                        <ul id="ul-tag"><input type="text" id="input-tag" spellcheck="false"></ul>
                                    </div>

                                    <div class="tag-details">
                                        <p><span>10</span> tags maximum</p>
                                        <!--<button>Clear all tags</button>-->
                                    </div>

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
                                        <!--Input image url-->
                                        <div id="uploaded-image-grid">            
                                        </div>
                                        <input type="file" name="file" id="file-uploader" accept=".jpg, .jpeg, .png" 
                                               style="margin-top: 5px;"/>
                                        <!--<p style="font-size: 12px; margin-top: 3px;">Maximum 5 images</p>-->
                                        <!--<a type="button" id="add-img-btn" class="btn-upload upload-window button" href="#login-box">Upload image</a>-->
                                    </div>
                                </div>
                                <!--Upload videos-->
                                <div class="additional-input-wrap">
                                    <label>Your video</label>
                                    <div class="form-group">                                    
                                        <input type="text" placeholder="Paste your youtube video url here" class="form-control" name="txtVidUrl" value=""/>
                                        <button type="button" id="add-vid-btn" class="btn-upload" onclick="#">Check URL</button>
                                    </div>
                                </div>

                                <!--Input Detail information-->
                                <div class="additional-input-wrap">
                                    <label>Detail Information <font color="red">*</font></label>
                                    <div class="row gutters-5">
                                        <!--Prep time-->
                                        <div class="col-lg-8">
                                            <div class="form-group additional-input-box icon-left">
                                                <i class="far fa-clock"></i>
                                                <label class="col-lg-4 small-label" style="color:#6E6E6E">Prep time</label>
                                                <input type="number" min="1" max="1000" placeholder="00 (minutes)" class="form-control"
                                                       name="txtPrepTime" data-error="Prep time is required" required>
                                                <div class="help-block with-errors"></div>
                                            </div>
                                        </div>
                                        <!--Cook time-->
                                        <div class="col-lg-8">
                                            <div class="form-group additional-input-box icon-left">
                                                <i class="fas fa-utensils"></i>
                                                <label class="col-lg-4 small-label" style="color:#6E6E6E">Cook time</label>
                                                <input type="number" min="1" max="1000" placeholder="00 (minutes)" class="form-control"
                                                       name="txtCookTime" data-error="Cook Time is required" required>
                                                <div class="help-block with-errors"></div>
                                            </div>
                                        </div>
                                        <!--Serving-->
                                        <div class="col-lg-8">
                                            <div class="form-group additional-input-box icon-left">
                                                <i class="fas fa-users"></i>
                                                <label class="col-lg-4 small-label" style="color:#6E6E6E; padding-left: 6px">Serving</label>
                                                <input type="number" min="1" max="1000000" placeholder="Serving: 00 (people)" class="form-control"
                                                       name="txtServing" data-error="Serving is required" required>
                                                <div class="help-block with-errors"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <!--Input ingredients-->
                                <c:set var="ingredientList" value="${requestScope.INGREDIENT_LIST}"></c:set>                       
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
                                    </div>
                                    <!--Add ingredient button-->
                                    <!--<div class="div-upload">-->
                                    <button type="button" class="btn-upload" id="add-ingre-tbn" onclick="addIngredient()">
                                        <!--<i class="flaticon-add-plus-button"></i>-->
                                        Add Ingredient</button>
                                    <!--</div>-->
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
                                    <!--<div class="div-upload">-->
                                    <button type="button" class="btn-upload" id="add-setep-tbn" onclick="addStep()">
                                        <!--<i class="flaticon-add-plus-button"></i>-->
                                        Add Step</button>
                                    <!--</div>-->
                                </div>


                                <button type="submit" class="btn-submit">SUBMIT RECIPE</button>
                            </form>

                        </div>  

                        <!--Right Side Bar-->
                        <div class="col-lg-4 sidebar-widget-area sidebar-break-md">                                                
                            <!-- Top 5 Recipes-->
                            <div class="widget">                            
                                <div class="section-heading heading-dark">
                                    <h3 class="item-heading">TOP RECIPES</h3>
                                </div>
                                <div class="widget-latest">
                                    <ul class="block-list">
                                        <c:set var="top5Recipes" value="${sessionScope.TOP5_RECIPES}"/>
                                        <c:forEach var="recipeDto" items="${top5Recipes}" varStatus="counter">
                                            <c:set var="author" value="${recipeDto.authorInfo}"/>
                                            <c:set var="category" value="${recipeDto.category}"/>
                                            <c:set var="image" value="${recipeDto.image}"/>
                                            <c:url var="single_recipe_url" value="DisplaySingleRecipe">
                                                <c:param name="recipeId" value="${recipeDto.recipeId}"/>
                                            </c:url>                                        
                                            <li class="single-item">
                                                <div class="item-img">
                                                    <a href="${single_recipe_url}"><img src="${image.imgLink}" alt="Post"></a>
                                                    <div class="count-number">${counter.count}</div>
                                                </div>
                                                <div class="item-content">
                                                    <div class="item-ctg">${category.name}</div>
                                                    <h4 class="item-title"><a href="${single_recipe_url}">${recipeDto.name}</a></h4>
                                                    <div class="item-post-by">
                                                        <a href="#DisplayAuthorProfile"><i class="fas fa-user"></i><span>by</span>
                                                            ${author.fullName}</a>
                                                    </div>
                                                </div>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </div>

                            <!-- Category List-->
                            <c:set var="categoryList" value="${sessionScope.ALL_CATEGORY}"></c:set>
                                <div class="widget">
                                    <div class="section-heading heading-dark">
                                        <h3 class="item-heading">CATEGORIES</h3>
                                    </div>
                                    <div class="widget-categories">
                                        <ul>
                                        <c:forEach var="categoryDto" items="${categoryList}">
                                            <li>
                                                <a href="#${categoryDto.categoryId}">${categoryDto.name}
                                                    <span>${categoryDto.countNum}</span>
                                                </a>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </div>                        
                        </div>
                    </div>
                </div>
            </section>
            <!-- Submit Recipe Area End Here -->
            <!-- Footer Area Start Here -->
            <%@include file="footer.html" %>
            <!-- Footer Area End Here -->
        </div>
         
    <!--Upload image dialog start here-->
    <div class="login" id="login-box">
        <h3 style="font-family: 'Poppins', sans-serif;">Upload image</h3>
        <a class="close" href="#">
            <img class="img-close" title="Close Window" alt="Close" src="img/figure/close.png" 
                 style="width: 5%; height: 5%"/>
        </a>
        <form id="upload-from" class="upload-content" action="UploadImageServlet" method="post" enctype="multipart/form-data">
            <input type="file" name="file" id="file-uploader" accept=".jpg, .jpeg, .png" multiple
                   style="margin-top: 5px;"/>
            <p style="font-size: 12px; margin-top: 3px;">Maximum 5 images</p>
            <div id="image-grid">            
            </div>
            <button class="button btn-upload submit-button" type="button" onclick="submitImage()">Upload</button>
        </form>
    </div>
    <!--Upload image dialog end here-->    

    <!--Ajax-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>            
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
    <script>
    <!--Chặn gửi form bằng Enter-->
        $("#submitForm").keypress(function (e) {
            if (e.which == 13) {
                return false;
            }
        });
    </script>
    <script src="./js/upload-image.js"></script>
    <script src="js/submit_recipe.js"></script>
    <script src="js/tagStyle.js"></script>
    <script src="js/dialog.js"></script>
</body>
</html>
