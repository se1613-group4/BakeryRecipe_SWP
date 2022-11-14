<%-- 
    Document   : single-author
    Created on : Sep 29, 2022, 11:32:50 PM
    Author     : dangh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Ranna | Author Details</title>
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
        <!-- Model Start -->


        <!--[if lte IE 9]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
            <![endif]-->

        <!-- Add your site or application content here -->
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

            <!--Header start here-->
            <c:set var="user" value="${sessionScope.USER}"></c:set>
            <c:if test="${empty user}">
                <%@include file="header.html" %>
            </c:if>
            <c:if test="${not empty user}">
                <jsp:include page="header_user.jsp"></jsp:include>
            </c:if>
            <!-- Header Area End Here -->
            <!-- Inne Page Banner Area Start Here -->
            <section class="inner-page-banner bg-common" data-bg-image="img/figure/inner-page-banner1.jpg">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <div class="breadcrumbs-area">
                                <h1>Single Author Archives</h1>
                                <ul>
                                    <li>
                                        <a href="index.html">Home</a>
                                    </li>
                                    <li>Author Archives</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Inne Page Banner Area End Here -->
            <!-- Single Author Area Start Here -->
            <section class="single-author-page-wrap padding-top-80 padding-bottom-50">
                <div class="container">
                    <div class="row gutters-60">
                        <div class="col-lg-8">
                            <c:set var="profile_result" value="${requestScope.USER_PROFILE}"/>
                            <c:set var="followers_result" value="${requestScope.USER_FOLLOWERS}"/>
                            <c:set var="following_result" value="${requestScope.USER_FOLLOWING}"/>
                            <c:if test="${not empty profile_result}">
                                <form action="displayUserProfileController" method="POST">
                                    <div class="author-info">
                                        <div class="media media-none--xs" style="display: flex; flex-direction: column">
                                            <div style="display: flex; flex-direction: row; justify-content: center">
                                                <img src="${profile_result.avatarUrl}" alt="Blog Author" class="rounded-circle media-img-auto"
                                                     style="width: 30%; height: 30%">

                                                <div style="display: flex; flex-direction: column; margin-left: 10px; margin-top: 20px">
                                                    <h1 class="author-title">${profile_result.fullName}
                                                    </h1>
                                                    <p><b>${followers_result}</b> Followers <b style="margin-left: 20px">${following_result}</b> Following</p>
                                                </div>  
                                            </div>                                              

                                            <div class="media-body" style="margin-top: 20px; width: 100%">

                                                <div style="width: 100%; display: flex; flex-direction: row; border-bottom: solid 1px #C0C0C0; margin-top: 10px">
                                                    <div style="width: 20%">
                                                        <label style="font-size: 20px; font-weight: bold">Gender: </label></div>
                                                    <div style="width: 70%;  border-radius: 10px; ">
                                                        <p style="font-size: 25px; width: 100%"> ${profile_result.gender}</p>
                                                    </div>
                                                </div>

                                                <div>
                                                    <label style="font-size: 20px; font-weight: bold">Bio: </label>
                                                    <p style="font-size: 25px; text-align: center; width: 100%"> ${profile_result.biography}</p>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </form>
                                <jsp:include page="follow.jsp" />
                            </c:if>
                            <c:if test="${empty profile_result}">
                                <h1>User is not found!!</h1>
                            </c:if>
                            <div class="section-heading heading-dark">
                                <h2 class="item-heading">36 RECIPES</h2>
                            </div>
                            <div class="row">
                                <div class="col-md-6 col-sm-6 col-12">
                                    <div class="product-box-layout1">
                                        <figure class="item-figure"><a href="single-recipe1.html"><img src="img/product/product50.jpg"
                                                                                                       alt="Product"></a></figure>
                                        <div class="item-content">
                                            <span class="sub-title">CHICKEN</span>
                                            <h3 class="item-title"><a href="single-recipe1.html">Tomatoes Stuffed with Foie
                                                    and Chanterelles</a></h3>
                                            <ul class="item-rating">
                                                <li class="star-fill"><i class="fas fa-star"></i></li>
                                                <li class="star-fill"><i class="fas fa-star"></i></li>
                                                <li class="star-fill"><i class="fas fa-star"></i></li>
                                                <li class="star-fill"><i class="fas fa-star"></i></li>
                                                <li class="star-empty"><i class="fas fa-star"></i></li>
                                                <li><span>9<span> / 10</span></span> </li>
                                            </ul>
                                            <p>More off this less hello salamander lied porpoise much over tightly circa
                                                outside crud mightily rigorouse. </p>
                                            <ul class="entry-meta">
                                                <li><a href="#"><i class="fas fa-clock"></i>15 Mins</a></li>
                                                <li><a href="#"><i class="fas fa-user"></i>by <span>John Martin</span></a></li>
                                                <li><a href="#"><i class="fas fa-heart"></i><span>02</span> Likes</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6 col-sm-6 col-12">
                                    <div class="product-box-layout1">
                                        <figure class="item-figure"><a href="single-recipe1.html"><img src="img/product/product51.jpg"
                                                                                                       alt="Product"></a></figure>
                                        <div class="item-content">
                                            <span class="sub-title">CHICKEN</span>
                                            <h3 class="item-title"><a href="single-recipe1.html">Tomatoes Stuffed with Foie
                                                    and Chanterelles</a></h3>
                                            <ul class="item-rating">
                                                <li class="star-fill"><i class="fas fa-star"></i></li>
                                                <li class="star-fill"><i class="fas fa-star"></i></li>
                                                <li class="star-fill"><i class="fas fa-star"></i></li>
                                                <li class="star-fill"><i class="fas fa-star"></i></li>
                                                <li class="star-empty"><i class="fas fa-star"></i></li>
                                                <li><span>9<span> / 10</span></span> </li>
                                            </ul>
                                            <p>More off this less hello salamander lied porpoise much over tightly circa
                                                outside crud mightily rigorouse. </p>
                                            <ul class="entry-meta">
                                                <li><a href="#"><i class="fas fa-clock"></i>15 Mins</a></li>
                                                <li><a href="#"><i class="fas fa-user"></i>by <span>John Martin</span></a></li>
                                                <li><a href="#"><i class="fas fa-heart"></i><span>02</span> Likes</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6 col-sm-6 col-12">
                                    <div class="product-box-layout1">
                                        <figure class="item-figure"><a href="single-recipe1.html"><img src="img/product/product52.jpg"
                                                                                                       alt="Product"></a></figure>
                                        <div class="item-content">
                                            <span class="sub-title">CHICKEN</span>
                                            <h3 class="item-title"><a href="single-recipe1.html">Tomatoes Stuffed with Foie
                                                    and Chanterelles</a></h3>
                                            <ul class="item-rating">
                                                <li class="star-fill"><i class="fas fa-star"></i></li>
                                                <li class="star-fill"><i class="fas fa-star"></i></li>
                                                <li class="star-fill"><i class="fas fa-star"></i></li>
                                                <li class="star-fill"><i class="fas fa-star"></i></li>
                                                <li class="star-empty"><i class="fas fa-star"></i></li>
                                                <li><span>9<span> / 10</span></span> </li>
                                            </ul>
                                            <p>More off this less hello salamander lied porpoise much over tightly circa
                                                outside crud mightily rigorouse. </p>
                                            <ul class="entry-meta">
                                                <li><a href="#"><i class="fas fa-clock"></i>15 Mins</a></li>
                                                <li><a href="#"><i class="fas fa-user"></i>by <span>John Martin</span></a></li>
                                                <li><a href="#"><i class="fas fa-heart"></i><span>02</span> Likes</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6 col-sm-6 col-12">
                                    <div class="product-box-layout1">
                                        <figure class="item-figure"><a href="single-recipe1.html"><img src="img/product/product53.jpg"
                                                                                                       alt="Product"></a></figure>
                                        <div class="item-content">
                                            <span class="sub-title">CHICKEN</span>
                                            <h3 class="item-title"><a href="single-recipe1.html">Tomatoes Stuffed with Foie
                                                    and Chanterelles</a></h3>
                                            <ul class="item-rating">
                                                <li class="star-fill"><i class="fas fa-star"></i></li>
                                                <li class="star-fill"><i class="fas fa-star"></i></li>
                                                <li class="star-fill"><i class="fas fa-star"></i></li>
                                                <li class="star-fill"><i class="fas fa-star"></i></li>
                                                <li class="star-empty"><i class="fas fa-star"></i></li>
                                                <li><span>9<span> / 10</span></span> </li>
                                            </ul>
                                            <p>More off this less hello salamander lied porpoise much over tightly circa
                                                outside crud mightily rigorouse. </p>
                                            <ul class="entry-meta">
                                                <li><a href="#"><i class="fas fa-clock"></i>15 Mins</a></li>
                                                <li><a href="#"><i class="fas fa-user"></i>by <span>John Martin</span></a></li>
                                                <li><a href="#"><i class="fas fa-heart"></i><span>02</span> Likes</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6 col-sm-6 col-12">
                                    <div class="product-box-layout1">
                                        <figure class="item-figure"><a href="single-recipe1.html"><img src="img/product/product54.jpg"
                                                                                                       alt="Product"></a></figure>
                                        <div class="item-content">
                                            <span class="sub-title">CHICKEN</span>
                                            <h3 class="item-title"><a href="single-recipe1.html">Tomatoes Stuffed with Foie
                                                    and Chanterelles</a></h3>
                                            <ul class="item-rating">
                                                <li class="star-fill"><i class="fas fa-star"></i></li>
                                                <li class="star-fill"><i class="fas fa-star"></i></li>
                                                <li class="star-fill"><i class="fas fa-star"></i></li>
                                                <li class="star-fill"><i class="fas fa-star"></i></li>
                                                <li class="star-empty"><i class="fas fa-star"></i></li>
                                                <li><span>9<span> / 10</span></span> </li>
                                            </ul>
                                            <p>More off this less hello salamander lied porpoise much over tightly circa
                                                outside crud mightily rigorouse. </p>
                                            <ul class="entry-meta">
                                                <li><a href="#"><i class="fas fa-clock"></i>15 Mins</a></li>
                                                <li><a href="#"><i class="fas fa-user"></i>by <span>John Martin</span></a></li>
                                                <li><a href="#"><i class="fas fa-heart"></i><span>02</span> Likes</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6 col-sm-6 col-12">
                                    <div class="product-box-layout1">
                                        <figure class="item-figure"><a href="single-recipe1.html"><img src="img/product/product55.jpg"
                                                                                                       alt="Product"></a></figure>
                                        <div class="item-content">
                                            <span class="sub-title">CHICKEN</span>
                                            <h3 class="item-title"><a href="single-recipe1.html">Tomatoes Stuffed with Foie
                                                    and Chanterelles</a></h3>
                                            <ul class="item-rating">
                                                <li class="star-fill"><i class="fas fa-star"></i></li>
                                                <li class="star-fill"><i class="fas fa-star"></i></li>
                                                <li class="star-fill"><i class="fas fa-star"></i></li>
                                                <li class="star-fill"><i class="fas fa-star"></i></li>
                                                <li class="star-empty"><i class="fas fa-star"></i></li>
                                                <li><span>9<span> / 10</span></span> </li>
                                            </ul>
                                            <p>More off this less hello salamander lied porpoise much over tightly circa
                                                outside crud mightily rigorouse. </p>
                                            <ul class="entry-meta">
                                                <li><a href="#"><i class="fas fa-clock"></i>15 Mins</a></li>
                                                <li><a href="#"><i class="fas fa-user"></i>by <span>John Martin</span></a></li>
                                                <li><a href="#"><i class="fas fa-heart"></i><span>02</span> Likes</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <ul class="pagination-layout1">
                                <li class="active">
                                    <a href="#">1</a>
                                </li>
                                <li>
                                    <a href="#">2</a>
                                </li>
                                <li>
                                    <a href="#">3</a>
                                </li>
                                <li>
                                    <a href="#">4</a>
                                </li>
                                <li>
                                    <a href="#">5</a>
                                </li>
                            </ul>
                        </div>
                        <div class="col-lg-4 sidebar-widget-area sidebar-break-md">
                            <div class="widget">
                                <div class="section-heading heading-dark">
                                    <h3 class="item-heading">FEATURED RECIPE</h3>
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
                                    <h3 class="item-heading">SUBSCRIBE &amp; FOLLOW</h3>
                                </div>
                                <div class="widget-follow-us">
                                    <ul>
                                        <li class="single-item"><a href="#"><i class="fab fa-facebook-f"></i>LIKE ME ON</a></li>
                                        <li class="single-item"><a href="#"><i class="fab fa-twitter"></i>LIKE ME</a></li>
                                        <li class="single-item"><a href="#"><i class="fab fa-linkedin-in"></i>LIKE ME</a></li>
                                        <li class="single-item"><a href="#"><i class="fab fa-pinterest-p"></i>LIKE ME</a></li>
                                        <li class="single-item"><a href="#"><i class="fab fa-instagram"></i>LIKE ME</a></li>
                                        <li class="single-item"><a href="#"><i class="fab fa-youtube"></i>Subscribe</a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="widget">
                                <div class="section-heading heading-dark">
                                    <h3 class="item-heading">LATEST RECIPES</h3>
                                </div>
                                <div class="widget-latest">
                                    <ul class="block-list">
                                        <li class="single-item">
                                            <div class="item-img">
                                                <a href="#"><img src="img/product/latest1.jpg" alt="Post"></a>
                                                <div class="count-number">1</div>
                                            </div>
                                            <div class="item-content">
                                                <div class="item-ctg">DESERT</div>
                                                <h4 class="item-title"><a href="#">Salami Oven Roasted are
                                                        Mozzarella Oelette</a></h4>
                                                <div class="item-post-by"><a href="single-blog.html"><i class="fas fa-user"></i><span>by</span>
                                                        John Martin</a></div>
                                            </div>
                                        </li>
                                        <li class="single-item">
                                            <div class="item-img">
                                                <a href="#"><img src="img/product/latest2.jpg" alt="Post"></a>
                                                <div class="count-number">2</div>
                                            </div>
                                            <div class="item-content">
                                                <div class="item-ctg">DESERT</div>
                                                <h4 class="item-title"><a href="#">Salami Oven Roasted are
                                                        Mozzarella Oelette</a></h4>
                                                <div class="item-post-by"><a href="single-blog.html"><i class="fas fa-user"></i><span>by</span>
                                                        John Martin</a></div>
                                            </div>
                                        </li>
                                        <li class="single-item">
                                            <div class="item-img">
                                                <a href="#"><img src="img/product/latest3.jpg" alt="Post"></a>
                                                <div class="count-number">3</div>
                                            </div>
                                            <div class="item-content">
                                                <div class="item-ctg">DESERT</div>
                                                <h4 class="item-title"><a href="#">Salami Oven Roasted are
                                                        Mozzarella Oelette</a></h4>
                                                <div class="item-post-by"><a href="single-blog.html"><i class="fas fa-user"></i><span>by</span>
                                                        John Martin</a></div>
                                            </div>
                                        </li>
                                        <li class="single-item">
                                            <div class="item-img">
                                                <a href="#"><img src="img/product/latest4.jpg" alt="Post"></a>
                                                <div class="count-number">4</div>
                                            </div>
                                            <div class="item-content">
                                                <div class="item-ctg">DESERT</div>
                                                <h4 class="item-title"><a href="#">Salami Oven Roasted are
                                                        Mozzarella Oelette</a></h4>
                                                <div class="item-post-by"><a href="single-blog.html"><i class="fas fa-user"></i><span>by</span>
                                                        John Martin</a></div>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div class="widget">
                                <div class="section-heading heading-dark">
                                    <h3 class="item-heading">INSTAGRAM</h3>
                                </div>
                                <div class="widget-instagram">
                                    <ul>
                                        <li>
                                            <div class="item-box">
                                                <img src="img/social-figure/social-figure9.jpg" alt="Social Figure" class="img-fluid">
                                                <a href="#" class="item-icon"><i class="fab fa-instagram"></i></a>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="item-box">
                                                <img src="img/social-figure/social-figure10.jpg" alt="Social Figure" class="img-fluid">
                                                <a href="#" class="item-icon"><i class="fab fa-instagram"></i></a>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="item-box">
                                                <img src="img/social-figure/social-figure11.jpg" alt="Social Figure" class="img-fluid">
                                                <a href="#" class="item-icon"><i class="fab fa-instagram"></i></a>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="item-box">
                                                <img src="img/social-figure/social-figure12.jpg" alt="Social Figure" class="img-fluid">
                                                <a href="#" class="item-icon"><i class="fab fa-instagram"></i></a>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="item-box">
                                                <img src="img/social-figure/social-figure13.jpg" alt="Social Figure" class="img-fluid">
                                                <a href="#" class="item-icon"><i class="fab fa-instagram"></i></a>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="item-box">
                                                <img src="img/social-figure/social-figure14.jpg" alt="Social Figure" class="img-fluid">
                                                <a href="#" class="item-icon"><i class="fab fa-instagram"></i></a>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="item-box">
                                                <img src="img/social-figure/social-figure15.jpg" alt="Social Figure" class="img-fluid">
                                                <a href="#" class="item-icon"><i class="fab fa-instagram"></i></a>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="item-box">
                                                <img src="img/social-figure/social-figure16.jpg" alt="Social Figure" class="img-fluid">
                                                <a href="#" class="item-icon"><i class="fab fa-instagram"></i></a>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="item-box">
                                                <img src="img/social-figure/social-figure17.jpg" alt="Social Figure" class="img-fluid">
                                                <a href="#" class="item-icon"><i class="fab fa-instagram"></i></a>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Single Author Area End Here -->
            <!-- Footer Area Start Here -->
            <footer class="ranna-bg-dark">
                <div class="container">
                    <div class="footer-logo">
                        <a href="index.html"><img src="img/logo-light.png" class="img-fluid" alt="footer-logo"></a>
                    </div>
                    <div class="footer-menu">
                        <ul>
                            <li><a href="#">FACEBOOK</a></li>
                            <li><a href="#">TWITTER</a></li>
                            <li><a href="#">INSTAGRAM</a></li>
                            <li><a href="#">PINTEREST</a></li>
                            <li><a href="#">GOOGLEPLUS</a></li>
                            <li><a href="#">YOUTUBE</a></li>
                        </ul>
                    </div>
                    <div class="copyright"><a target="_blank" href="https://www.templateshub.net">Templates Hub</a></div>
                </div>
            </footer>
            <!-- Footer Area End Here -->
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
                        <form class="login-form">
                            <input class="main-input-box" type="text" placeholder="User Name" />
                            <input class="main-input-box" type="password" placeholder="Password" />
                            <div class="inline-box mb-5 mt-4">
                                <div class="checkbox checkbox-primary">
                                    <input id="modal-checkbox" type="checkbox">
                                    <label for="modal-checkbox">Remember Me</label>
                                </div>
                                <label class="lost-password"><a href="#">Lost your password?</a></label>
                            </div>
                            <div class="inline-box mb-5 mt-4">
                                <button class="btn-fill" type="submit" value="Login">Login</button>
                                <a href="#" class="btn-register"><i class="fas fa-user"></i>Register Here!</a>
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
    </body>
</html>
