<%-- 
    Document   : header_user
    Created on : Sep 29, 2022, 5:18:34 PM
    Author     : LamVo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="">
    <head>
        <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Bakery Recipe - Header</title>
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
        <c:url var="login_url" value="loginPage"></c:url>
        <c:if test="${sessionScope.LOGIN_USER==null ||  sessionScope.LOGIN_USER.isActived==true}">
            <h5> Please to login</h5>
            <button type="button"  class="btn btn-danger" style="font-size: 1.75rem"  onclick="dieu_huong_login()">Login</button>
            <script>
                function dieu_huong_login() {
                    location.assign("${login_url}");
                }
            </script>
        </c:if>

        <c:if test="${sessionScope.LOGIN_USER!=null  || sessionScope.LOGIN_USER.isActived==false }">
            <!-- Header start here-->
            <header class="header-one">
                <!-- Top Header-->    
                <div id="header-main-menu" class="header-main-menu header-sticky">
                    <div class="container">                    
                        <div class="row">
                            <div class="col-lg-6 col-md-3 col-sm-4 col-4 possition-static">
                                <div class="site-logo-mobile">
                                    <a href="displayHomePage" class="sticky-logo-light"><img src="img/logo-light.png" alt="Site Logo"></a>
                                    <a href="displayHomePage" class="sticky-logo-dark"><img src="img/logo-dark.png" alt="Site Logo"></a>
                                </div>
                                <nav class="site-nav">
                                    <ul id="site-menu" class="site-menu">
                                        <li><a href="displayHomePage">Home</a>
                                        </li>
                                        <li>
                                            <a href="#">Category</a>
                                        </li>
                                        <li>
                                            <a href="#">All Recipes</a>
                                        </li>

                                    </ul>
                                </nav>
                            </div>

                            <div class="col-lg-6 col-md-9 col-sm-8 col-8 d-flex align-items-center justify-content-end">
                                <div class="nav-action-elements-layout1">
                                    <ul class="site-menu">                                     
                                        <!--profile user-->
                                        <li>
                                            <a href="#">
                                                <i class="flaticon-profile"></i> Welcome, ${sessionScope.USER.username}</a>
                                            <ul class="dropdown-menu-col-1" id="dropdown-user">
                                                <li>
                                                    <a href="displayUserProfileController">
                                                        Profile</a>
                                                </li>
                                                <li>
                                                    <a href="displayOwnRecipes">My recipes</a>
                                                </li>  
                                                <li>
                                                    <c:url var="Reset_url" value="resetPasswordPage"></c:url>
                                                    <a href="${Reset_url}" onclick="getConfirmation">Reset Password</a>
                                                </li>
                                                <li>
                                                    <a href="removeAccountController" onclick="return confirm('Are you sure? Do you want to delete this item?');">Delete</a>
                                                </li>

                                            </ul>
                                        </li>

                                        <!--                                    <li>
                                                                                <a href="displayUserProfileController" class="fill-btn"><i class="flaticon-plus-1"></i>
                                                                                    PROFILE</a>
                                                                            </li>-->

                                        <li>
                                            <a href="displaySubmitReciePageController" class="fill-btn"><i class="flaticon-plus-1"></i>
                                                CREATE RECIPE</a>
                                        </li>

                                        <!-- Logout Button-->
                                        <li>
                                            <c:if test="${sessionScope.LOGIN_USER==null ||  sessionScope.LOGIN_USER.isActived==true}">
                                                <h5> Please to login</h5>
                                                <button type="button"  class="btn btn-danger" style="font-size: 1.75rem"  onclick="dieu_huong_login()">Login</button>
                                                <script>
                                                    function dieu_huong_login() {
                                                        location.assign("${login_url}");
                                                    }
                                                </script>
                                            </c:if>
                                            <c:if test="${sessionScope.LOGIN_USER!=null  || sessionScope.LOGIN_USER.isActived==false }">
                                                <button type="button" class="login-btn" >
                                                    <a href="LogoutServlet" class="login-btn">Logout</a>
                                                </button>     
                                            </c:if>
                                        </li>                                    
                                    </ul>
                                </div>

                                <div class="mob-menu-open toggle-menu">
                                    <span class="bar"></span>
                                    <span class="bar"></span>
                                    <span class="bar"></span>
                                    <span class="bar"></span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Bottom Header-->
                <div class="header-bottom d-none d-lg-block">
                    <div class="container">
                        <div class="row">
                            <!-- Logo -->
                            <div class="col-lg-4 d-none d-lg-block">
                                <div class="site-logo-desktop">
                                    <a href="index.html" class="main-logo"><img src="img/logo-dark.png" alt="Site Logo"></a>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </header>
            <!--notification-->
            <c:forEach var="noti" items="${NOTIFIII}">
                <p>${noti.getDetail()}</p>
            </c:forEach>      
            <!--notification-->


            <!-- Header end here -->

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
        </c:if>
    </body>
</html>
