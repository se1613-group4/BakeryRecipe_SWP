<%-- 
    Document   : top_recipe
    Created on : Sep 25, 2022, 5:19:05 PM
    Author     : LamVo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bakery Recipe - Home</title>
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

        <!-- Search input -->
        <div class="col-lg-4">
            <div class="nav-action-elements-layout3">
                <form class="search-form" action="MainController">
                    <input type="text" id="ooooo" value="" placeholder="Type here........" name="txtSearchValue"/>
                    <button type="submit" class="search-btn" value="Search" name="btAction"><i class="flaticon-search"></i></button>
                </form>
            </div>
        </div>

        <!-- Slider Area Start Here - TOP 3 RECIPES (by likes)-->
        <section class="ranna-slider-area">
            <div class="container">                
                <div class="rc-carousel nav-control-layout2" data-loop="true" data-items="30" data-margin="5"
                     data-autoplay="false" data-autoplay-timeout="5000" data-smart-speed="700" data-dots="false"
                     data-nav="true" data-nav-speed="false" data-r-x-small="1" data-r-x-small-nav="true"
                     data-r-x-small-dots="false" data-r-x-medium="1" data-r-x-medium-nav="true" data-r-x-medium-dots="false"
                     data-r-small="1" data-r-small-nav="true" data-r-small-dots="false" data-r-medium="1"
                     data-r-medium-nav="true" data-r-medium-dots="false" data-r-large="1" data-r-large-nav="true"
                     data-r-large-dots="false" data-r-extra-large="1" data-r-extra-large-nav="true"
                     data-r-extra-large-dots="false">

                    <c:set var="top3Recipes" value="${sessionScope.TOP3_RECIPES}"/>
                    <c:forEach var="recipeDto" items="${top3Recipes}" varStatus="counter">
                        <c:set var="author" value="${recipeDto.authorInfo}"/>
                        <c:set var="category" value="${recipeDto.category}"/>
                        <c:set var="image" value="${recipeDto.image}"/>
                        <c:url var="single_recipe_url" value="DisplaySingleRecipe">
                            <c:param name="recipeId" value="${recipeDto.recipeId}"/>
                        </c:url>

                        <div class="ranna-slider-content-layout1">
                            <figure class="item-figure"><a href="${single_recipe_url}"><img src="${image.imgLink}" alt="Post"></a></figure>
                            <div class="item-content">
                                <span class="sub-title">${category.name}</span>
                                <h2 class="item-title"><a href="${single_recipe_url}">${recipeDto.name}</a></h2>                            
                                <p>${recipeDto.description}</p>
                                <ul class="entry-meta">
                                    <li><a href="#"><i class="fas fa-clock"></i>${recipeDto.totalTime} Mins</a></li>
                                    <li><a href="#"><i class="fas fa-user"></i>by <span>${author.fullName}</span></a></li>
                                    <li><a href="#"><i class="fas fa-heart"></i><span>${recipeDto.likedCount}</span> Likes</a></li>
                                </ul>
                            </div>
                        </div> 
                    </c:forEach>
                </div>
            </div>
        </section>
        <!-- Slider Area End Here -->

        <!-- Latest Recipe Start Here -->
        <section class="padding-bottom-45">
            <div class="container">
                <div class="row gutters-60">
                    <!-- Trending Recipes-->
                    <div class="col-lg-8">
                        <div class="section-heading heading-dark">
                            <h2 class="item-heading">LATEST RECIPES</h2>
                        </div>
                        <div class="row">
                            <c:set var="recentlyRecipes" value="${sessionScope.RECENTLY_RECIPES}"/>
                            <c:forEach var="recipeDto" items="${recentlyRecipes}" varStatus="counter">
                                <c:set var="author" value="${recipeDto.authorInfo}"/>
                                <c:set var="category" value="${recipeDto.category}"/>
                                <c:set var="image" value="${recipeDto.image}"/>
                                <c:url var="single_recipe_url" value="DisplaySingleRecipe">
                                    <c:param name="recipeId" value="${recipeDto.recipeId}"/>
                                </c:url>
                                <div class="col-12">                                
                                    <div class="product-box-layout1">
                                        <figure class="item-figure"><a href="${single_recipe_url}"><img src="${image.imgLink}"
                                                                                                        alt="Product"></a></figure>
                                        <div class="item-content">
                                            <span class="sub-title">${category.name}</span>
                                            <h2 class="item-title"><a href="${single_recipe_url}">${recipeDto.name}</a></h2>
                                            <p>${recipeDto.description}</p>
                                            <ul class="entry-meta">
                                                <li><a href="#"><i class="fas fa-clock"></i>${recipeDto.totalTime} Mins</a></li>
                                                <li><a href="#"><i class="fas fa-user"></i>by <span>${author.fullName}</span></a></li>
                                                <li><a href="#"><i class="fas fa-heart"></i><span>${recipeDto.likedCount}</span> Likes</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div> 
                            </c:forEach>                  

                        </div>
                        <div class="ranna-ad-box">
                            <a href="#"><img src="img/figure/figure1.jpg" alt="ad"></a>
                        </div>
                    </div>

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
                        <div class="widget">
                            <div class="section-heading heading-dark">
                                <h3 class="item-heading">CATEGORIES</h3>
                            </div>
                            <div class="widget-categories">
                                <ul>
                                    <li>
                                        <a href="#">BreakFast
                                            <span>25</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">Lunch
                                            <span>15</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">Pasta
                                            <span>22</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">Dinner
                                            <span>18</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">Dessert
                                            <span>36</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">Drinks
                                            <span>12</span>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>                        
                    </div>
                </div>
            </div>
        </section>
        <!-- Trending Recipe End Here -->

        <!-- Editor’s Choice Start Here -->
        <section class="padding-bottom-45">
            <div class="container">
                <div class="section-heading heading-dark">
                    <h2 class="item-heading">EDITOR'S CHOICE</h2>
                </div>
                <div class="row">
                    <div class="col-lg-4 col-md-6 col-sm-12 col-12">
                        <div class="product-box-layout2">
                            <figure class="item-figure"><a href="single-recipe1.html"><img src="img/product/product11.jpg"
                                                                                           alt="Product"></a></figure>
                            <div class="item-content">
                                <span class="sub-title">BREAKFAST</span>
                                <h3 class="item-title"><a href="single-recipe1.html">Tomatoes Stuffed with Foie and
                                        Chanterelles</a></h3>
                                <ul class="entry-meta">
                                    <li><a href="#"><i class="fas fa-clock"></i>15 Mins</a></li>
                                    <li><a href="#"><i class="fas fa-user"></i>by <span>John Martin</span></a></li>
                                    <li><a href="#"><i class="fas fa-heart"></i><span>02</span> Likes</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-12 col-12">
                        <div class="product-box-layout2">
                            <figure class="item-figure"><a href="single-recipe1.html"><img src="img/product/product12.jpg"
                                                                                           alt="Product"></a></figure>
                            <div class="item-content">
                                <span class="sub-title">DESERT</span>
                                <h3 class="item-title"><a href="single-recipe1.html">Pumpkin Cheesecake With
                                        GingersnapCrust</a></h3>
                                <ul class="entry-meta">
                                    <li><a href="#"><i class="fas fa-clock"></i>15 Mins</a></li>
                                    <li><a href="#"><i class="fas fa-user"></i>by <span>John Martin</span></a></li>
                                    <li><a href="#"><i class="fas fa-heart"></i><span>02</span> Likes</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 d-block d-md-none d-lg-block col-sm-12 col-12">
                        <div class="product-box-layout2">
                            <figure class="item-figure"><a href="single-recipe1.html"><img src="img/product/product13.jpg"
                                                                                           alt="Product"></a></figure>
                            <div class="item-content">
                                <span class="sub-title">JUICE</span>
                                <h3 class="item-title"><a href="single-recipe1.html">Blueberry Juice with Lemon Crema</a></h3>                                
                                <ul class="entry-meta">
                                    <li><a href="#"><i class="fas fa-clock"></i>15 Mins</a></li>
                                    <li><a href="#"><i class="fas fa-user"></i>by <span>John Martin</span></a></li>
                                    <li><a href="#"><i class="fas fa-heart"></i><span>02</span> Likes</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Editor’s Choice End Here -->

        <!-- Popular Recipe Start Here -->
        <section class="padding-bottom-45">
            <div class="container">
                <div class="row gutters-60">
                    <div class="col-lg-8">
                        <div class="section-heading heading-dark">
                            <h2 class="item-heading">POPULAR RECIPES</h2>
                        </div>
                        <div class="row">
                            <div class="col-xl-12 col-lg-6 col-md-6 col-sm-6 col-12">
                                <div class="product-box-layout3">
                                    <figure class="item-figure"><a href="single-recipe1.html"><img src="img/product/product14.jpg"
                                                                                                   alt="Product"></a></figure>
                                    <div class="item-content">
                                        <span class="sub-title">BREAKFAST</span>
                                        <h3 class="item-title"><a href="single-recipe1.html">Asian Chicken Noodles</a></h3>
                                        <ul class="item-rating">
                                            <li class="star-fill"><i class="fas fa-star"></i></li>
                                            <li class="star-fill"><i class="fas fa-star"></i></li>
                                            <li class="star-fill"><i class="fas fa-star"></i></li>
                                            <li class="star-fill"><i class="fas fa-star"></i></li>
                                            <li class="star-empty"><i class="fas fa-star"></i></li>
                                            <li><span>9<span> / 10</span></span> </li>
                                        </ul>
                                        <p>Pro sint falli definitiones noel ei verear intellegatpri civibus
                                            consequat efficiantue.Vestibulum ante ipsum primis in fau
                                            cibus orci luctus et ultrices posuere cubilia Curae; Nunc
                                            mattis turpis id aliquet.</p>
                                        <ul class="entry-meta">
                                            <li><a href="#"><i class="fas fa-clock"></i>15 Mins</a></li>
                                            <li><a href="#"><i class="fas fa-user"></i>by <span>John Martin</span></a></li>
                                            <li><a href="#"><i class="fas fa-heart"></i><span>02</span> Likes</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-12 col-lg-6 col-md-6 col-sm-6 col-12">
                                <div class="product-box-layout3">
                                    <figure class="item-figure"><a href="single-recipe1.html"><img src="img/product/product15.jpg"
                                                                                                   alt="Product"></a></figure>
                                    <div class="item-content">
                                        <span class="sub-title">SEA FOOD</span>
                                        <h3 class="item-title"><a href="single-recipe1.html">Italiano Salad Mixed</a></h3>
                                        <ul class="item-rating">
                                            <li class="star-fill"><i class="fas fa-star"></i></li>
                                            <li class="star-fill"><i class="fas fa-star"></i></li>
                                            <li class="star-fill"><i class="fas fa-star"></i></li>
                                            <li class="star-fill"><i class="fas fa-star"></i></li>
                                            <li class="star-empty"><i class="fas fa-star"></i></li>
                                            <li><span>9<span> / 10</span></span> </li>
                                        </ul>
                                        <p>Pro sint falli definitiones noel ei verear intellegatpri civibus
                                            consequat efficiantue.Vestibulum ante ipsum primis in fau
                                            cibus orci luctus et ultrices posuere cubilia Curae; Nunc
                                            mattis turpis id aliquet.</p>
                                        <ul class="entry-meta">
                                            <li><a href="#"><i class="fas fa-clock"></i>15 Mins</a></li>
                                            <li><a href="#"><i class="fas fa-user"></i>by <span>John Martin</span></a></li>
                                            <li><a href="#"><i class="fas fa-heart"></i><span>02</span> Likes</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-12 col-lg-6 col-md-6 col-sm-6 col-12">
                                <div class="product-box-layout3">
                                    <figure class="item-figure"><a href="single-recipe1.html"><img src="img/product/product16.jpg"
                                                                                                   alt="Product"></a></figure>
                                    <div class="item-content">
                                        <span class="sub-title">SALAD</span>
                                        <h3 class="item-title"><a href="single-recipe1.html">Maxican Dessert</a></h3>
                                        <ul class="item-rating">
                                            <li class="star-fill"><i class="fas fa-star"></i></li>
                                            <li class="star-fill"><i class="fas fa-star"></i></li>
                                            <li class="star-fill"><i class="fas fa-star"></i></li>
                                            <li class="star-fill"><i class="fas fa-star"></i></li>
                                            <li class="star-empty"><i class="fas fa-star"></i></li>
                                            <li><span>9<span> / 10</span></span> </li>
                                        </ul>
                                        <p>Pro sint falli definitiones noel ei verear intellegatpri civibus
                                            consequat efficiantue.Vestibulum ante ipsum primis in fau
                                            cibus orci luctus et ultrices posuere cubilia Curae; Nunc
                                            mattis turpis id aliquet.</p>
                                        <ul class="entry-meta">
                                            <li><a href="#"><i class="fas fa-clock"></i>15 Mins</a></li>
                                            <li><a href="#"><i class="fas fa-user"></i>by <span>John Martin</span></a></li>
                                            <li><a href="#"><i class="fas fa-heart"></i><span>02</span> Likes</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="d-lg-block d-xl-none col-lg-6 col-md-6 col-sm-6 col-12">
                                <div class="product-box-layout3">
                                    <figure class="item-figure"><a href="single-recipe1.html"><img src="img/product/product14.jpg"
                                                                                                   alt="Product"></a></figure>
                                    <div class="item-content">
                                        <span class="sub-title">BREAKFAST</span>
                                        <h3 class="item-title"><a href="single-recipe1.html">Asian Chicken Noodles</a></h3>
                                        <ul class="item-rating">
                                            <li class="star-fill"><i class="fas fa-star"></i></li>
                                            <li class="star-fill"><i class="fas fa-star"></i></li>
                                            <li class="star-fill"><i class="fas fa-star"></i></li>
                                            <li class="star-fill"><i class="fas fa-star"></i></li>
                                            <li class="star-empty"><i class="fas fa-star"></i></li>
                                            <li><span>9<span> / 10</span></span> </li>
                                        </ul>
                                        <p>Pro sint falli definitiones noel ei verear intellegatpri civibus
                                            consequat efficiantue.Vestibulum ante ipsum primis in fau
                                            cibus orci luctus et ultrices posuere cubilia Curae; Nunc
                                            mattis turpis id aliquet.</p>
                                        <ul class="entry-meta">
                                            <li><a href="#"><i class="fas fa-clock"></i>15 Mins</a></li>
                                            <li><a href="#"><i class="fas fa-user"></i>by <span>John Martin</span></a></li>
                                            <li><a href="#"><i class="fas fa-heart"></i><span>02</span> Likes</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 sidebar-widget-area sidebar-break-md">
                        <div class="widget">
                            <div class="section-heading heading-dark">
                                <h3 class="item-heading">FEATURED ARTICLE</h3>
                            </div>
                            <div class="widget-featured-feed">
                                <div class="rc-carousel nav-control-layout1" data-loop="true" data-items="3"
                                     data-margin="5" data-autoplay="true" data-autoplay-timeout="5000" data-smart-speed="700"
                                     data-dots="false" data-nav="true" data-nav-speed="false" data-r-x-small="1"
                                     data-r-x-small-nav="true" data-r-x-small-dots="false" data-r-x-medium="1"
                                     data-r-x-medium-nav="true" data-r-x-medium-dots="false" data-r-small="1"
                                     data-r-small-nav="true" data-r-small-dots="false" data-r-medium="1"
                                     data-r-medium-nav="true" data-r-medium-dots="false" data-r-large="1"
                                     data-r-large-nav="true" data-r-large-dots="false" data-r-extra-large="1"
                                     data-r-extra-large-nav="true" data-r-extra-large-dots="false">
                                    <div class="featured-box-layout1">
                                        <div class="item-img">
                                            <img src="img/product/product17.jpg" alt="Brand" class="img-fluid">
                                        </div>
                                        <div class="item-content">
                                            <span class="ctg-name">BREAKFAST</span>
                                            <h4 class="item-title"><a href="single-recipe1.html">Baked Garlic Prawn</a></h4>
                                            <p>Definitiones noel ei verear intelle
                                                gatpri civibus consequat area
                                                refund efficiantue.</p>
                                        </div>
                                    </div>
                                    <div class="featured-box-layout1">
                                        <div class="item-img">
                                            <img src="img/product/product18.jpg" alt="Brand" class="img-fluid">
                                        </div>
                                        <div class="item-content">
                                            <span class="ctg-name">DINNER</span>
                                            <h4 class="item-title"><a href="single-recipe1.html">Baked Garlic Prawn</a></h4>
                                            <p>Definitiones noel ei verear intelle
                                                gatpri civibus consequat area
                                                refund efficiantue.</p>
                                        </div>
                                    </div>
                                    <div class="featured-box-layout1">
                                        <div class="item-img">
                                            <img src="img/product/product19.jpg" alt="Brand" class="img-fluid">
                                        </div>
                                        <div class="item-content">
                                            <span class="ctg-name">SALAD</span>
                                            <h4 class="item-title"><a href="single-recipe1.html">Baked Garlic Prawn</a></h4>
                                            <p>Definitiones noel ei verear intelle
                                                gatpri civibus consequat area
                                                refund efficiantue.</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="widget">
                            <div class="section-heading heading-dark">
                                <h3 class="item-heading">POPULAR TAGS</h3>
                            </div>
                            <div class="widget-tag">
                                <ul>
                                    <li>
                                        <a href="#">DESERT</a>
                                    </li>
                                    <li>
                                        <a href="#">CAKE</a>
                                    </li>
                                    <li>
                                        <a href="#">BREAKFAST</a>
                                    </li>
                                    <li>
                                        <a href="#">BURGER</a>
                                    </li>
                                    <li>
                                        <a href="#">DINNER</a>
                                    </li>
                                    <li>
                                        <a href="#">PIZZA</a>
                                    </li>
                                    <li>
                                        <a href="#">SEA FOOD</a>
                                    </li>
                                    <li>
                                        <a href="#">SALAD</a>
                                    </li>
                                    <li>
                                        <a href="#">JUICE</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Popular Recipe End Here -->

        <!-- Footer Area Start Here -->
        <%@include file="footer.html" %>
        <!-- Footer Area End Here -->

        <!-- Modal Start-->
    <form action="MainController"  method="post">
        <div class="modal fade" id="myModal" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <div class="title-default-bold mb-none">Login</div>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>
                    <div class="modal-body">
                        <form class="login-form">
                            <input class="main-input-box" name="txtUsername" type="text" placeholder="User Name" />
                            <%=request.getAttribute("errorUserID")==null?"" : request.getAttribute("errorUserID")%>
                         <c:if test="${requestScope.errorUserID!=null && not empty requestScope.errorUserID}">
                            <h1>${requestScope.errorUserID}</h1>
                        </c:if>
                            <input class="main-input-box" name="txtPassword" type="password" placeholder="Password" />
                            <%=request.getAttribute("errorUserID")==null?"" : request.getAttribute("errorUserID")%>
                         <c:if test="${requestScope.errorUserID!=null && not empty requestScope.errorUserID}">
                            <h1>${requestScope.errorUserID}</h1>
                        </c:if>
                            <div class="inline-box mb-5 mt-4">
                                <div class="checkbox checkbox-primary">
                                    <input id="modal-checkbox" type="checkbox">
                                    <label for="modal-checkbox">Remember Me</label>
                                </div>
                                <label class="lost-password"><a href="#">Lost your password?</a></label>
                            </div>
                            <div class="inline-box mb-5 mt-4">
                                <button class="btn-fill" type="submit" value="Login" name="btAction">Login</button>
                                <a href="registration.jsp" name="Register" class="btn-register"><i class="fas fa-user"></i>Register Here!</a>
                            </div>
                        </form>
                        <label>Login connect with your Social Network</label>
                        <div class="login-box-social">
                            <ul>
                                <li><a href="#" class="facebook"><i class="fab fa-facebook-f"></i></a></li>
                                <li><a href="#" class="twitter"><i class="fab fa-twitter"></i></a></li>
                                <li><a href="#" class="linkedin"><i class="fab fa-linkedin-in"></i></a></li>
                                <li><a href="#" class="google"><i class="fab fa-google-plus-g"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
        <!-- Modal End-->

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
        <!-- Smoothscroll Js -->
        <script src="js/smoothscroll.min.js"></script>
        <!-- Custom Js -->
        <script src="js/main.js"></script>
    </body>
</html>
