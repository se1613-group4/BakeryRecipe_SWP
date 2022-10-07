<%-- 
    Document   : my_recipes
    Created on : Oct 3, 2022, 4:54:55 PM
    Author     : LamVo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Bakery Recipe | My Recipes</title>
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
    
     <!-- Header Area Start Here -->
        <%@include file="header_user.jsp" %>
        <!-- Header Area End Here -->
    
    <div id="wrapper" class="wrapper">        
        <!-- Inne Page Banner Area Start Here -->
        <section class="inner-page-banner bg-common" data-bg-image="img/figure/inner-page-banner1.jpg">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="breadcrumbs-area">
                            <h1>Manage my Recipes</h1>
                            <ul>
                                <li>
                                    <a href="userHomePage">Home</a>
                                </li>
                                <li>My Recipes</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Inne Page Banner Area End Here -->
        
        <c:set var="recipeList" value="${requestScope.MY_RECIPE_LIST}"></c:set>
        <c:if test="${empty recipeList}">
            </br><h2>You have not created any recipe yet!</h2>
        </c:if>
        <c:if test="${not empty recipeList}">
            
                
           
        </c:if>
        <!-- Recipe Without Sidebar Area Start Here -->
        <section class="recipe-without-sidebar-wrap padding-top-80 padding-bottom-22">
            <div class="container">               
                             
                <div class="row">
                    <c:forEach var="recipeDto" items="${recipeList}">
                        <c:set var="category" value="${recipeDto.category}"/>
                        <c:set var="image" value="${recipeDto.image}"/>
                        <c:url var="single_recipe_url" value="displaySingleRecipe">
                            <c:param name="recipeId" value="${recipeDto.recipeId}"/>
                        </c:url>
                        <c:url var="remove_recipe_url" value="removeRecipeController">
                            <c:param name="recipeId" value="${recipeDto.recipeId}"/>
                            <c:param name="userId" value="${sessionScope.USER.userId}"/>
                        </c:url>
                    <div class="col-lg-4 col-md-6 col-sm-6 col-12">
                        <div class="product-box-layout1">
                            <!-- Remove Link -->                            
                            <a href="${remove_recipe_url}" class="linkStyle">
                                <i class="fa-solid fa-trash-can"></i>Remove</a>
                            <!-- Edit Link-->                            
                            <a href="#editRecipe?recipeId=recipeId" class="linkStyle">
                                <i class="fa-solid fa-pen-to-square"></i>Edit</a>
                            
                            <figure class="item-figure"><a href="${single_recipe_url}">
                                    <img src="${image.imgLink}"
                                        alt="Product"></a></figure>
                            <div class="item-content">
                                <span class="sub-title">${category.name}</span>
                                <h3 class="item-title"><a href="${single_recipe_url}">${recipeDto.name}</a></h3>
                                <div class="item-rating">
                                    <span>${recipeDto.createdDate}</span>
                                </div>
                                <p>${recipeDto.description}</p>
                                <ul class="entry-meta">
                                    <li><a href="#"><i class="fas fa-clock"></i>${recipeDto.totalTime} Mins</a></li>                                    
                                    <li><a href="#"><i class="fas fa-heart"></i><span>${recipeDto.likedCount}</span> Likes</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    </c:forEach>                                   
                </div>
            </div>
        </section>
        <!-- Recipe Without Sidebar Area End Here -->
        
    </div>
    
    <!-- Footer Area Start Here -->
        <%@include file="footer.html" %>
    <!-- Footer Area End Here -->    
        
    <!-- Jquery Js -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <!-- Bootstrap Js -->
    <script src="js/popper.min.js"></script>
    <!-- Bootstrap Js -->
    <script src="js/bootstrap.min.js"></script>
    <!-- Plugins Js -->
    <script src="js/plugins.js"></script>
    <!-- Smoothscroll Js -->
    <script src="js/smoothscroll.min.js"></script>
    <!-- Custom Js -->
    <script src="js/main.js"></script>
    </body>
</html>
