<%-- Document : search Created on : Sep 26, 2022, 4:37:50 PM Author : ThongNT --%>

<%@page import="bakeryRecipe.recipe_tbl.Recipe_tblDTO" %>
<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bakery Recipe - Search</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Favicon -->
        <link rel="shortcut icon" href="img/favicon.png">
        <!-- Normalize Css -->
        <link rel="stylesheet" href="css/normalize.css">
        <!-- Main Css -->
        <link rel="stylesheet" href="css/main.css">
        <!-- Bootstrap Css -->
        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <!-- Animate CSS -->
        <link rel="stylesheet" href="css/animate.min.css">
        <!-- Fontawesome CSS -->
        <link rel="stylesheet" href="css/fontawesome-all.min.css">
        <!-- Flaticon CSS -->
        <link rel="stylesheet" href="fonts/flaticon.css">
        <!-- Custom Css -->
        <link rel="stylesheet" href="style.css">
        <!-- Modernizr Js -->
        <script src="js/modernizr-3.6.0.min.js"></script>
    </head>

    <body>
        <c:set var="searchValue" value="${param.txtSearchValue}" />

        <!-- Preloader Start Here -->
        <div id="preloader"></div>
        <!-- Preloader End Here -->
        <!-- ScrollUp Start Here -->
        <a href="#wrapper" data-type="section-switch" class="scrollup">
            <i class="fas fa-angle-double-up"></i>
        </a>
        <!-- ScrollUp End Here -->
        <div id="wrapper" class="wrapper">
            <!-- Header start here-->
            <c:set var="user" value="${sessionScope.USER}"></c:set>
            <c:if test="${empty user}">
                <%@include file="header.html" %>
            </c:if>
            <c:if test="${not empty user}">
                <jsp:include page="header_user.jsp"></jsp:include>
            </c:if>
            <!-- Header end here-->

            <!-- Inne Page Banner Area Start Here -->
            <section class="inner-page-banner bg-common"
                     data-bg-image="img/figure/inner-page-banner1.jpg">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <div class="breadcrumbs-area">
                                <h1>Search Your Recipes</h1>
                                <ul>
                                    <li>
                                        <a href="homePage">Home</a>
                                    </li>
                                    <li>All Recipes</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Inner Page Banner Area End Here -->

            <!-- Recipe Without Sidebar Area Start Here -->
            <section class="recipe-without-sidebar-wrap padding-top-80 padding-bottom-22">
                <div class="container">
                    <div class="adv-search-wrap">
                        <div class="input-group">
                            <form action="SearchAllRecipeController"
                                  style="width: 100% !important;    display: flex !important;    justify-content: center !important;">
                                <input type="text" class="form-control"
                                       placeholder="Author Name or Recipe Search . . ."
                                       name="txtSearchValue" value="${searchValue}" />

                                <div class="btn-group" style="display: inline-block">
                                    <div class="input-group-btn">
                                        <input type="submit" value="Search" name="btAction"
                                               class="btn-search" />
                                    </div>
                                </div>
                            </form>
                        </div>

                    </div>
                    <c:set var="categoryDtoList" value="${requestScope.CATEGORY_LIST}"></c:set>
                        <div class="advance-search-form">
                            <div class="row">
                                <div class="col">
                                    <h3 class="item-title">BY CATEGORIES</h3>
                                    <ul class="search-items">
                                        <form action="SearchAllRecipeController">
                                            <input type="hidden" name="txtSearchValue" value="${searchValue}" />
                                        <!-- forEach here -->
                                        <c:forEach var="categoryDto" items="${categoryDtoList}"
                                                   varStatus="counter">
                                            <li style=" display: inline; width: fit-content; ">
                                                <div class="checkbox checkbox-primary" style=" display: inline-block; width: 140px; padding: 5px ">
                                                    <input id="checkbox-${categoryDto.categoryId}" type="checkbox" value="${categoryDto.name}" name="category-checkboxs">
                                                    <label for="checkbox-${categoryDto.categoryId}">${categoryDto.name}</label>
                                                </div>
                                            </li>
                                            <!-- forEach end here -->    
                                        </c:forEach>  
                                        <br/>
                                        <button type="submit">Apply</button>
                                    </form>
                                </ul>
                            </div>
                            <!--                                                <div class="col-lg-6">
                                                                                <h3 class="item-title">BY INGREDIENTS</h3>
                                                                                <ul class="search-items">
                                                                                     forEach start here 
                                                                                    <li>
                                                                                        <div class="checkbox checkbox-primary">
                                                                                            <input id="checkbox106" type="checkbox">
                                                                                            <label for="checkbox106">Oil</label>
                                                                                        </div>
                                                                                    </li>
                                                                                     forEach end here 
                                                                                </ul>
                                                                            </div>-->
                        </div>
                    </div>

                    <div class="row">
                        <c:if test="${empty searchValue}">
                            <p>
                                No record is matched!
                            </p>
                        </c:if>
                        <c:if test="${not empty searchValue}">
                            <p class="d-none" id="searchValueForJs">${searchValue}</p>
                            <c:set var="searchResult" value="${requestScope.SEARCH_RESULT}" />
                            <c:if test="${not empty searchResult}">
                                <c:if test="${searchResult.size() > 9}">
                                    <p class="d-none" id="searchResultSizeForJs">${searchResult.size()}
                                    </p>
                                    <c:set var="searchResultTop9"
                                           value="${requestScope.SEARCH_RESULT_TOP9}" />
                                    <c:forEach var="recipeDto" items="${searchResultTop9}"
                                               varStatus="counter">
                                        <c:set var="recipeName" value="${recipeDto.name}" />
                                        <c:set var="description" value="${recipeDto.description}" />
                                        <c:set var="author" value="${recipeDto.authorInfo}" />
                                        <c:set var="category" value="${recipeDto.category}" />
                                        <c:set var="image" value="${recipeDto.image.imgLink}" />
                                        <c:set var="totalTime" value="${recipeDto.totalTime}" />
                                        <c:set var="likedCount" value="${recipeDto.likedCount}" />
                                        <c:url var="single_recipe_url" value="DisplaySingleRecipe">
                                            <c:param name="recipeId" value="${recipeDto.recipeId}" />
                                        </c:url>

                                        <div
                                            class="col-lg-4 col-md-6 col-sm-6 col-12 search-result-box">
                                            <div class="product-box-layout1">
                                                <figure class="item-figure">
                                                    <a href=${single_recipe_url}>
                                                        <img src=${image} alt="Recipe"></a>
                                                </figure>
                                                <div class="item-content">
                                                    <span class="sub-title">${category.name}</span>
                                                    <h3 class="item-title">
                                                        <a href="${single_recipe_url}">${recipeName}</a>
                                                    </h3>

                                                    <p>${description} </p>
                                                    <ul class="entry-meta">
                                                        <li><a href="#"><i
                                                                    class="fas fa-clock"></i>${totalTime}
                                                                minute</a></li>
                                                        <li><a href="#"><i class="fas fa-user"></i>by
                                                                <span>${author.fullName}</span></a></li>
                                                        <li><a href="#"><i
                                                                    class="fas fa-heart"></i>${likedCount}
                                                                Likes</a></li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                    <div class="row search-result-container"></div>
                                    <button id="search-result-loadmore-btn"
                                            onclick="loadMoreSearchResult()">Load more</button>
                                </c:if>
                                <!-- there was more than 9 search result value = enough in a page -->

                                <c:if test="${searchResult.size() < 10}">
                                    <c:forEach var="recipeDto" items="${searchResult}"
                                               varStatus="counter">
                                        <c:set var="recipeName" value="${recipeDto.name}" />
                                        <c:set var="description" value="${recipeDto.description}" />
                                        <c:set var="author" value="${recipeDto.authorInfo}" />
                                        <c:set var="category" value="${recipeDto.category}" />
                                        <c:set var="image" value="${recipeDto.image.imgLink}" />
                                        <c:set var="totalTime" value="${recipeDto.totalTime}" />
                                        <c:set var="likedCount" value="${recipeDto.likedCount}" />
                                        <c:url var="single_recipe_url" value="DisplaySingleRecipe">
                                            <c:param name="recipeId" value="${recipeDto.recipeId}" />
                                        </c:url>

                                        <div class="col-lg-4 col-md-6 col-sm-6 col-12">
                                            <div class="product-box-layout1">
                                                <figure class="item-figure">
                                                    <a href=${single_recipe_url}>
                                                        <img src=${image} alt="Recipe"></a>
                                                </figure>
                                                <div class="item-content">
                                                    <span class="sub-title">${category.name}</span>
                                                    <h3 class="item-title">
                                                        <a href="single-recipe1.html">${recipeName}</a>
                                                    </h3>

                                                    <p>${description} </p>
                                                    <ul class="entry-meta">
                                                        <li><a href="#"><i
                                                                    class="fas fa-clock"></i>${totalTime}
                                                                minute</a></li>
                                                        <li><a href="#"><i class="fas fa-user"></i>by
                                                                <span>${author.fullName}</span></a></li>
                                                        <li><a href="#"><i
                                                                    class="fas fa-heart"></i>${likedCount}
                                                                Likes</a></li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </c:if>
                                <!-- there was less than 9 search result value = enough in a page -->

                            </c:if><!-- there was search result -->
                        </c:if><!-- there was search value -->



                    </div>
                </div>
            </section>
            <!-- Recipe Without Sidebar Area End Here -->

            <!-- Footer Area Start Here -->
            <%@include file="footer.html" %>
            <!-- Footer Area End Here -->
        </div>
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
                            <form class="login-form" action="login_url" method="post" id="loginform">
                                <!--                                <div class="inline-box mb-5 mt-4">
                                                        <a href="${login_url}">Login</a>
                                                    <a href="${register_url}">Register</a>
                                                </div>-->
                            <div class="inline-box mb-5 mt-4">
                                <button type="button" class="btn btn-danger" style="font-size: 1.75rem"
                                        onclick="dieu_huong_login()">Login</button>
                                <script>
                                    function dieu_huong_login() {
                                        location.assign("${login_url}");
                                    }
                                </script>
                                <button type="button" class="btn btn-danger" style="font-size: 1.75rem"
                                        onclick="dieu_huong_Register()">Register</button>
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
                                <li><a href="#" class="facebook"><i class="fab fa-facebook-f"></i></a>
                                </li>
                                <li><a href="#" class="twitter"><i class="fab fa-twitter"></i></a></li>
                                <li><a href="#" class="linkedin"><i class="fab fa-linkedin-in"></i></a>
                                </li>
                                <li><a href="#" class="google"><i class="fab fa-google-plus-g"></i></a>
                                </li>
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
        <!-- Smoothscroll Js -->
        <script src="js/smoothscroll.min.js"></script>
        <!-- Custom Js -->
        <script src="js/main.js"></script>
    </body>

</html>