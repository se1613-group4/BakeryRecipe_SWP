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
        <!--Notification--> 
        <link rel="stylesheet" href="css/notification.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
        <script src="js/notification.js"></script>
    </head>
    <body>
        
            <!-- Header start here-->
            <header class="header-one">
                <!-- Top Header-->    
                <div id="header-main-menu" class="header-main-menu header-sticky">
                    <div class="container">                    
                        <div class="row">
<!--                            <div class="col-lg-2 d-none d-lg-block">
                            <div class="site-logo-desktop" style="margin: 5px 0 0 0">
                                <a href="homePage" class="sticky-logo-light"><img src="img/logo-light.png" alt="Site Logo"></a>
                            </div>
                        </div>-->
                            <div class="col-lg-6 col-md-3 col-sm-4 col-4 possition-static">
                                <div class="site-logo-mobile">
                                    <a href="homePage" class="sticky-logo-light"><img src="img/logo-light.png" alt="Site Logo"></a>
                                    <a href="homePage" class="sticky-logo-dark"><img src="img/logo-dark.png" alt="Site Logo"></a>
                                </div>
                                <nav class="site-nav">
                                    <ul id="site-menu" class="site-menu">
                                        <li><a href="homePage">Home</a>
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
                                   <!--Notification-->
                                    <li  id="noti_Container">
                                        <div id="noti_Counter" ></div>   <!--SHOW NOTIFICATIONS COUNT.-->

                                        <!--A CIRCLE LIKE BUTTON TO DISPLAY NOTIFICATION DROPDOWN.-->
                                        <div id="noti_Button"><i style="color: #FFF" class="fa fa-bell" ></i></div>    

                                        <!--THE NOTIFICAIONS DROPDOWN BOX.-->
                                        <div id="notifications">
                                            <h3>Notifications</h3>
                                            <div style="height:300px; overflow-y: scroll;">
                                                <c:set var="noti" value="${sessionScope.NOTIFICATION_RESULT}"/>
                                                <c:if test="${not empty noti}">
                                                    <c:forEach var="notiDto" items="${noti}" varStatus="counter">
                                                        <c:set var="notiDetail" value="${notiDto.detail}"/>
                                                            <p>${notiDetail}</p>
                                                    </c:forEach>
                                                </c:if>
                                                <c:if test="${empty noti}">
                                                    <p>No notification yet</p>
                                                </c:if>
                                            </div>
                                            <div class="seeAll"><a href="#">See All</a></div>
                                        </div>
                                    </li>
                                    <!--End Notification-->
                                    <!--Create recipe button-->
                                    <li>
                                        <a href="submitRecipePage" class="fill-btn"><i class="flaticon-plus-1"></i>
                                            CREATE RECIPE</a>
                                    </li>                                                                         
                                    <!--End Create recipe button-->
                                    <!--profile user-->
                                    <li>
                                        <c:set var="avatar" value="${sessionScope.USER.avatar}"></c:set>
                                        <a href="#" style="width: 10rem">
                                            <c:if test="${not empty avatar}">
                                            <img src="${avatar}" alt="user-avatar" class="rounded-circle"
                                                     style="width: 40%;"/>
                                            </c:if>
                                            <c:if test="${empty avatar}">
                                            <i class="flaticon-profile"></i>
                                            </c:if>
                                            <b>  ${sessionScope.USER.username}</b></a>
                                        <ul class="dropdown-menu-col-1" id="dropdown-user" style="width: 15rem">
                                            <li style="display: inline-block; width: 100%">
                                                <a href="displayUserProfileController">
                                                    Profile</a>
                                            </li>
                                            <li style="display: inline-block; width: 100%">
                                                <a href="displayOwnRecipes">My recipes</a>
                                            </li>  
                                            <li style="display: inline-block; width: 100%">
                                                <c:url var="Reset_url" value="resetPasswordPage"></c:url>
                                                <a href="${Reset_url}">Reset Password</a>
                                            </li>
                                            <li style="display: inline-block; width: 100%">
                                                <a href="removeAccountController" onclick="return confirm('Are you sure? Do you want to delete this item?');">Inactive account</a>
                                            </li>
                                            <li style="display: inline-block; width: 100%">                                                                                        
                                                <!--<button type="button" class="login-btn" >-->
                                                    <a href="logoutController">Logout</a>
                                                <!--</button>-->     

                                            </li> 
                                        </ul>
                                    </li>
                                    <!--End profile user-->
                                        <!-- Logout Button-->
<!--                                        <li>                                                                                        
                                                <button type="button" class="login-btn" >
                                                    <a href="logoutController" class="login-btn">Logout</a>
                                                </button>     
                                            -->
                                        </li>                                    
                                    </ul>
                            </div>

                            <div class="mob-menu-open toggle-menu">
                                <span class="bar"></span>
                                <span class="bar"></span>
                                <span class="bar"></span>
                                <span class="bar"></span>
                            </div>
                            <!--</div>-->
                            </div>
                        </div>
                    </div>
                </div>

            <!-- Bottom Header-->
            <div class="header-bottom d-none d-lg-block">
                <div class="container">
                    <div class="row">
                        <!-- Logo -->
                        <div class="col-lg-12 d-none d-lg-block">
                            <div class="site-logo-desktop" style="display: flex; justify-content: center;">
                                <a href="homePage" class="main-logo"><img src="img/logo-dark.png" alt="Site Logo"></a>
                            </div>
                        </div>
                        
                    </div>
                </div>
            </div>
                
            <!--</div>-->
        </header>        
        
        <!-- Header end here -->

    </body>
</html>
