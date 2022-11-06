<%-- 
    Document   : righ-side-bar
    Created on : Oct 26, 2022, 11:39:28 PM
    Author     : LamVo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bakery Recipe - Righ Side Bar</title>
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
        <!-- Owl Carousel CSS -->
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <!-- Custom Css -->
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <c:import url="LoadHomePageController"></c:import>
        <div class="col-lg-4 sidebar-widget-area sidebar-break-md">                                                
             <!--Top 5 Recipes-->
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

             <!--Category List-->
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
            
            <c:set var="tagList" value="${sessionScope.All_TAG}"></c:set>
            <div class="widget">
                <div class="section-heading heading-dark">
                    <h3 class="item-heading">TAG</h3>
                </div>
                <div class="widget-categories">
                    <ul>
                        <c:forEach var="tagDto" items="${tagList}">
                            <li>
                                <a href="#${tagDto.tagId}">${tagDto.name}
                                    <span>${tagDto.count}</span>
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div> 
        </div>
        

    </body>
</html>
