<%-- Document : top_recipe Created on : Sep 25, 2022, 5:19:05 PM Author : LamVo --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                <!--ThongNT custom css-->
                <link rel="stylesheet" href="css/custom/homepage.css">
            </head>

            <body>
                <c:import url="LoadHomePageController"></c:import>

                <!-- Preloader Start Here -->
                <div id="preloader"></div>
                <!-- Preloader End Here -->
                <!-- ScrollUp Start Here -->
                <a href="#wrapper" data-type="section-switch" class="scrollup">
                    <i class="fas fa-angle-double-up"></i>
                </a>
                <!-- ScrollUp End Here -->

                <!-- Header Area Start Here -->
                <c:set var="user" value="${sessionScope.USER}"></c:set>
                <c:if test="${empty user}">
                    <%@include file="header.html" %>
                </c:if>
                <c:if test="${not empty user}">
                    <jsp:include page="header_user.jsp"></jsp:include>
                </c:if>
                <!-- Header Area End Here -->

                <!-- Slider Area Start Here - TOP 3 RECIPES (by likes)-->
                <section class="ranna-slider-area">
                    <div class="container">
                        <!-- Search input -->
                        <div class="adv-search-wrap">
                            <div class="input-group">
                                <form class="form-control search-form" action="SearchAllRecipeController"
                                    style="border: none; display: flex !important;    justify-content: center !important;">
                                    <input type="text" id="ooooo" value="" placeholder="Author Name or Recipe Search . . ."
                                        name="txtSearchValue" class="form-control" style="border-radius: 10px 0 0 10px;"/>
                                    <button type="submit" class="search-btn custom-btn-thongnt" value="Search" name="btAction"><i
                                            class="flaticon-search"></i></button>
                                </form>
                            </div>
                        </div>
                        <div class="rc-carousel nav-control-layout2" data-loop="true" data-items="30" data-margin="5"
                            data-autoplay="false" data-autoplay-timeout="5000" data-smart-speed="700" data-dots="false"
                            data-nav="true" data-nav-speed="false" data-r-x-small="1" data-r-x-small-nav="true"
                            data-r-x-small-dots="false" data-r-x-medium="1" data-r-x-medium-nav="true"
                            data-r-x-medium-dots="false" data-r-small="1" data-r-small-nav="true"
                            data-r-small-dots="false" data-r-medium="1" data-r-medium-nav="true"
                            data-r-medium-dots="false" data-r-large="1" data-r-large-nav="true"
                            data-r-large-dots="false" data-r-extra-large="1" data-r-extra-large-nav="true"
                            data-r-extra-large-dots="false">

                            <c:set var="top3Recipes" value="${sessionScope.TOP3_RECIPES}" />
                            <c:forEach var="recipeDto" items="${top3Recipes}" varStatus="counter">
                                <c:set var="author" value="${recipeDto.authorInfo}" />
                                <c:set var="category" value="${recipeDto.category}" />
                                <c:set var="image" value="${recipeDto.image}" />
                                <c:url var="single_recipe_url" value="displaySingleRecipe">
                                    <c:param name="recipeId" value="${recipeDto.recipeId}" />
                                </c:url>

                                <div class="ranna-slider-content-layout1">
                                    <figure class="item-figure" id="homepage-carousel-item">
                                        <a id="homepage-carousel-item-a" href="${single_recipe_url}">
                                            <img id="homepage-carousel-item-img" class="img-banner"
                                                src="${image.imgLink}" alt="Post">
                                        </a>
                                    </figure>
                                    <div class="item-content">
                                        <span class="sub-title">${category.name}</span>
                                        <h2 class="item-title">
                                            <a href="${single_recipe_url}">
                                                ${recipeDto.name}
                                            </a>
                                        </h2>
                                        <p>${recipeDto.description}</p>
                                        <ul class="entry-meta">
                                            <li><a href="#"><i class="fas fa-clock"></i>${recipeDto.totalTime} Mins</a>
                                            </li>
                                            <li><a href="#"><i class="fas fa-user"></i>by
                                                    <span>${author.fullName}</span></a></li>
                                            <li><a href="#"><i
                                                        class="fas fa-heart"></i><span>${recipeDto.likedCount}</span>
                                                    Likes</a></li>
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
                                    <c:set var="recentlyRecipes" value="${sessionScope.RECENTLY_RECIPES}" />
                                    <c:forEach var="recipeDto" items="${recentlyRecipes}" varStatus="counter">
                                        <c:set var="author" value="${recipeDto.authorInfo}" />
                                        <c:set var="category" value="${recipeDto.category}" />
                                        <c:set var="image" value="${recipeDto.image}" />
                                        <c:url var="single_recipe_url" value="DisplaySingleRecipe">
                                            <c:param name="recipeId" value="${recipeDto.recipeId}" />
                                        </c:url>
                                        <div class="col-12 trending-recipes-box">
                                            <div class="product-box-layout1">
                                                <div class="item-content trending-recipes-box-content-container">
                                                    <span class="sub-title">${category.name}</span>
                                                    <h2 class="item-title">
                                                        <a href="${single_recipe_url}">${recipeDto.name}</a>
                                                    </h2>
                                                    <p>${recipeDto.description}</p>
                                                    <ul class="entry-meta">
                                                        <li>
                                                            <a href="#">
                                                                <i class="fas fa-clock"></i>${recipeDto.totalTime} Mins
                                                            </a>
                                                        </li>

                                                        <li>
                                                            <a href="#">
                                                                <i class="fas fa-user"></i> by
                                                                <span>${author.fullName}</span>
                                                            </a>
                                                        </li>

                                                        <li>
                                                            <a href="#">
                                                                <i
                                                                    class="fas fa-heart"></i><span>${recipeDto.likedCount}</span>
                                                                Likes</a>
                                                        </li>
                                                    </ul>
                                                </div>

                                                <figure class="item-figure">
                                                    <a href="${single_recipe_url}" class="trending-recipes-box-a">
                                                        <img src="${image.imgLink}" alt="Product"
                                                            class="trending-recipes-box-img">
                                                    </a>
                                                </figure>
                                            </div>
                                        </div>
                                    </c:forEach>

                                </div>
                                <div class="ranna-ad-box">
                                    <a href="#"><img src="img/figure/figure1.jpg" alt="ad"></a>
                                </div>
                            </div>
                            <!--Right side bar start here-->
                            <%@include file="righ-side-bar.jsp" %>
                                <!--Right side bar end here-->
                        </div>
                    </div>
                </section>
                <!-- Trending Recipe End Here -->
                <a href="#">See all</a>
                <!--Update later->

        <!-- Footer Area Start Here -->
                <%@include file="footer.html" %>
                    <!-- Footer Area End Here -->


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
                                            <li><a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/BakeryRecipe/login-google&response_type=code&client_id=220347070456-brh7fuqartnn99t6prha0o1kcc6rmajr.apps.googleusercontent.com&approval_prompt=force"
                                                    class="google"><i class="fab fa-google-plus-g"></i></a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            </form>


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
            </body>

            </html>