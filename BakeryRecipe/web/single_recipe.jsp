<%-- 
    Document   : single-recipe
    Created on : Sep 26, 2022, 1:50:27 PM
    Author     : LamVo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Bakery Recipe - Single Recipe</title>
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
        <!-- Owl Carousel CSS -->
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <!-- Custom Css -->
        <link rel="stylesheet" href="style.css">
        <!-- Modernizr Js -->
        <script src="js/modernizr-3.6.0.min.js"></script>
    </head>
    <body>
        <!-- Pre loader Start Here -->
        <div id="preloader"></div>
        <!-- Pre loader End Here -->
        <!-- Scroll Up Start Here -->
        <a href="#wrapper" data-type="section-switch" class="scrollup">
            <i class="fas fa-angle-double-up"></i>
        </a>
        <!-- Scroll Up End Here -->
        <!--Header start here-->
        <c:set var="user" value="${sessionScope.USER}"></c:set>
        <c:if test="${empty user}">
            <%@include file="header.html" %>
        </c:if>
        <c:if test="${not empty user}">
            <jsp:include page="header_user.jsp"></jsp:include>
        </c:if>
        <!--Header end here-->

        <div id="wrapper" class="wrapper">        
            <!-- Inner Page Banner Area Start Here -->
            <section class="inner-page-banner bg-common" data-bg-image="img/figure/inner-page-banner1.jpg">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <div class="breadcrumbs-area">
                                <h1>Single Recipe</h1>
                                <ul>
                                    <li>
                                        <a href="homePage">Home</a>
                                    </li>
                                    <li>Recipe Details</li>
                                </ul>
                            </div>
                        </div>
                    </div>
            </section>
            <!-- Inner Page Banner Area End Here -->

            <!-- Single Recipe With Side bar Area Start Here -->
            <c:set var="recipeDto" value="${requestScope.RECIPE_INFO}"/>
            <c:set var="author" value="${recipeDto.authorInfo}"/>
            <c:set var="category" value="${recipeDto.category}"/>
            <c:set var="image" value="${recipeDto.image}"/>
            <c:set var="likeCount" value="${requestScope.LIKES_COUNT}"/>
            <c:url var="single_recipe_url" value="DisplaySingleRecipe">
                <c:param name="recipeId" value="${recipeDto.recipeId}"/>
            </c:url>
            <c:set var="save_result" value="${requestScope.SAVED}"/>

            <c:set var="loginValue" value="${sessionScope.USER}"/>
            
            <section class="single-recipe-wrap-layout1 padding-top-74 padding-bottom-50">            
                <div class="container">
                    <div class="row gutters-60">
                        <div class="col-lg-8">
                            <div class="single-recipe-layout1">
                                <div class="ctg-name">${category.name}</div>
                                <h2 class="item-title">${recipeDto.name}</h2>
                                <!--header recipe information-->
                                <div class="row mb-4">
                                    <div class="col-xl-9 col-12">
                                        <ul class="entry-meta">
                                            <li class="single-meta"><a href="#"><i class="far fa-calendar-alt"></i>${recipeDto.lastModified}</a></li>
                                            <li class="single-meta"><a href="#DisplayAuthorInfo"><i class="fas fa-user"></i>by <span>${author.fullName}</span></a>
                                                <jsp:include page="follow.jsp" />
                                            </li>
                                            <li class="single-meta"><a href="#"><i class="fas fa-heart"></i><span>${likeCount}</span>
                                                    Likes</a><jsp:include page="like.jsp" /></li>
                                                    <!--Save-->
                                            <c:if test="${not empty loginValue}">
                                                <c:if test="${empty save_result}">
                                                    <li class="single-meta">
                                                        <form action="saveRecipeController" method="POST">      
                                                            <i class="fa fa-bookmark" aria-hidden="true"></i><span></span>
                                                            <input type="submit" name="saveRecipeController" value="Save">        
                                                            <input type="hidden" name="txtRecipeId" value="${recipeDto.recipeId}"/>
                                                        </form> 
                                                    </li>
                                                </c:if>
                                                <c:if test="${not empty save_result}">
                                                    <li class="single-meta">
                                                        <form action="unsaveRecipeController" method="POST">      
                                                            <i class="fa fa-bookmark" aria-hidden="true"></i><span></span>
                                                            <input type="submit" name="saveRecipeController" value="Unsaved">        
                                                            <input type="hidden" name="txtRecipeId" value="${recipeDto.recipeId}"/>
                                                        </form> 
                                                    </li>
                                                </c:if> 
                                            </c:if>
                                            <jsp:include page="report.jsp" />
                                        </ul>
                                    </div>
                                </div>
                                <!--image of recipe-->
                                <div class="item-figure">
                                    <img src="${image.imgLink}" alt="Post Image">
                                </div>
                                <!--Recipe Icon Addition information Detail-->
                                <div class="item-feature">
                                    <ul>
                                        <li>
                                            <div class="feature-wrap">
                                                <div class="media">
                                                    <div class="feature-icon">
                                                        <i class="far fa-clock"></i>
                                                    </div>
                                                    <div class="media-body space-sm">
                                                        <div class="feature-title">PREP TIME</div>
                                                        <div class="feature-sub-title">${recipeDto.preTime} Mins</div>
                                                    </div>
                                                </div>
                                        </li>
                                        <li>
                                            <div class="feature-wrap">
                                                <div class="media">
                                                    <div class="feature-icon">
                                                        <i class="fas fa-utensils"></i>
                                                    </div>
                                                    <div class="media-body space-sm">
                                                        <div class="feature-title">COOK TIME</div>
                                                        <div class="feature-sub-title">${recipeDto.cookTime} Mins</div>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="feature-wrap">
                                                <div class="media">
                                                    <div class="feature-icon">
                                                        <i class="fas fa-users"></i>
                                                    </div>
                                                    <div class="media-body space-sm">
                                                        <div class="feature-title">SERVING</div>
                                                        <div class="feature-sub-title">${recipeDto.serving} People</div>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="feature-wrap">
                                                <div class="media">
                                                    <div class="feature-icon">
                                                        <i class="far fa-eye"></i>
                                                    </div>
                                                    <div class="media-body space-sm">
                                                        <div class="feature-title">VIEWS</div>
                                                        <div class="feature-sub-title">0</div>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                                <p class="item-description">${recipeDto.description}</p>

                                <div class="making-elements-wrap">
                                    <div class="row">
                                        <div class="col-xl-6 col-12">
                                            <div class="ingridients-wrap">
                                                <h3 class="item-title"><i class="fas fa-list-ul"></i>Ingridients</h3>
                                                <!--Adjust servings-->
                                                <div class="adjust-servings">
                                                    <div class="servings-title">Adjust Servings</div>
                                                    <form class="servings-quantity" action="#">
                                                        <div class="input-group quantity-holder" id="quantity-holder">
                                                            <input type="text" name='numServing' class="form-control quantity-input"
                                                                   value="${recipeDto.serving}" placeholder="1" readonly>
                                                            <input type="hidden" name="trecipeId" id="recipeID" value="${param.recipeId}" />
                                                            <input type="hidden" name="tserving" id="serving" value="${recipeDto.serving}" />
                                                            <div class="btn-quantity-select">
                                                                <button class="quantity-plus" type="button"> 
                                                                    <i class="fas fa-plus"></i>
                                                                </button>
                                                                <button class="quantity-minus" type="button">
                                                                    <i class="fas fa-minus"></i>
                                                                </button>
                                                            </div>
                                                        </div>
                                                    </form>
                                                </div>
                                                <div class="testAjax">
                                                <!--Display Ingredient List-->
                                                <c:set var="ingreList" value="${requestScope.INGREDIENT_LIST}"></c:set>
                                                <c:if test="${not empty ingreList}">
                                                    <c:forEach var="ingredient" items="${ingreList}">
                                                        <div class="ingredient">
                                                            <p><b><span class="ingredient-quantity">${ingredient.quantity}</span> 
                                                                    <c:if test="${ingredient.unit != 'none'}">${ingredient.unit}</c:if></b> 
                                                                ${ingredient.ingredientName}</p>    
                                                        </div>
                                                    </c:forEach>                                                   
                                                </c:if>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <!--List of making steps-->
                                    <div class="direction-wrap-layout1">
                                        <div class="section-heading heading-dark">
                                            <h2 class="item-heading">DIRECTIONS</h2>
                                        </div>          
                                        <c:set var="stepList" value="${requestScope.STEP_LIST}"></c:set>
                                        <c:if test="${not empty stepList}">
                                            <c:forEach var="step" items="${stepList}" varStatus="counter">
                                                <div class="direction-box-layout1">
                                                    <div class="item-content">
                                                        <div class="serial-number">Step ${counter.count}</div>
                                                        <p>${step}</p>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </c:if>                                        
                                    </div>

                                    <!-- Tag of this Recipe-->
                                    <div class="tag-share">
                                        <ul>
                                            <!--Tags-->
                                            <c:set var="tagList" value="${requestScope.TAG_LIST}"></c:set>
                                            <c:if test="${not empty tagList}">
                                                <li>
                                                    <ul class="inner-tag">                                                
                                                        <c:forEach var="tag" items="${tagList}">
                                                            <li>
                                                                <a href="#">${tag}</a>
                                                            </li>
                                                        </c:forEach>
                                                    </ul>
                                                </li>
                                            </c:if>   
                                            <!--Share-->    
                                            <li>
                                                <ul class="inner-share">
                                                    <li>
                                                        <a href="#">
                                                            <i class="fab fa-facebook-f"></i>
                                                        </a>
                                                    </li>
                                                    <li>
                                                        <a href="#">
                                                            <i class="fab fa-twitter"></i>
                                                        </a>
                                                    </li>
                                                    <li>
                                                        <a href="#">
                                                            <i class="fab fa-linkedin-in"></i>
                                                        </a>
                                                    </li>
                                                    <li>
                                                        <a href="#">
                                                            <i class="fab fa-google-plus-g"></i>
                                                        </a>
                                                    </li>
                                                    <li>
                                                        <a href="#">
                                                            <i class="fab fa-pinterest"></i>
                                                        </a>
                                                    </li>
                                                </ul>
                                            </li>
                                        </ul>
                                    </div>  

                                    <!-- Recipe's Author -->
                                    <div class="recipe-author">
                                        <div class="media media-none--xs">
                                            <img src="${author.avatarUrl}" alt="Blog Author" class="rounded-circle media-img-auto"
                                                    style="height: 20%; width: 20%;">
                                            <div class="media-body">
                                                <h4 class="author-title">${author.fullName}</h4>
                                                <h5 class="author-sub-title">Written by</h5>
                                                <p>${author.biography}</p>
                                                <ul class="author-social">
                                                    <li>
                                                        <a href="#"><i class="fab fa-facebook-f"></i></a>
                                                    </li>
                                                    <li>
                                                        <a href="#"><i class="fab fa-twitter"></i></a>
                                                    </li>
                                                    <li>
                                                        <a href="#"><i class="fab fa-linkedin-in"></i></a>
                                                    </li>
                                                    <li>
                                                        <a href="#"><i class="fab fa-pinterest-p"></i></a>
                                                    </li>
                                                    <li>
                                                        <a href="#"><i class="fab fa-skype"></i></a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>            
                                    <!-- Suggest recipe start here -->
                                    <!-- Suggest recipe end here -->

                                    <jsp:include page="like.jsp" />
                                    <jsp:include page="comment.jsp" />

                                </div>
                            </div>
                        </div> 
                                                            
                     <!--Right side bar start here-->
                    <%@include file="righ-side-bar.jsp" %>
                    <!--Right side bar end here-->
                    </div>
                </div>             
            </section>
            <!-- Single Recipe With Side bar Area End Here -->
        </div>

        <!-- Search Box Start Here -->
        <div id="search" class="search-wrap">
            <button type="button" class="close">×</button>
            <form class="search-form">
                <input type="search" value="" placeholder="Type here........" />
                <button type="submit" class="search-btn"><i class="flaticon-search"></i></button>
            </form>
        </div>    
        <!-- Search Box End Here -->
        
         <!-- Modal Start-->
        <div class="modal fade" id="myModal" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <div class="title-default-bold mb-none">Login</div>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>
                    <div class="modal-body">
                        <c:url var="login_url" value="loginPage"></c:url>
                        <c:url var="register_url" value="registerPage"></c:url>
                            <form class="login-form" action="login_url"  method="post" id="loginform">
                                <!--                                <div class="inline-box mb-5 mt-4">
                                                                    <a href="${login_url}">Login</a>
                                                                <a href="${register_url}">Register</a>
                                                            </div>-->
                            <div class="inline-box mb-5 mt-4">
                                <button type="button"  class="btn btn-danger" style="font-size: 1.75rem"  onclick="dieu_huong_login()">Login</button>
                                <script>
                                    function dieu_huong_login() {
                                        location.assign("${login_url}");
                                    }
                                </script>
                                <button type="button"  class="btn btn-danger" style="font-size: 1.75rem"  onclick="dieu_huong_Register()">Register</button>
                                <script>
                                    function dieu_huong_Register() {
                                        location.assign("${register_url}");
                                    }
                                </script>
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
        <script>
        <!--Chan gui form bang Enter-->
        $("form").keypress(function (e) {
            if (e.which == 13) {
                return false;
            }
        });
        </script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="js/adjustServing.js"></script>
    </body>
</html>
