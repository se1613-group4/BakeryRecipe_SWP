<%-- 
    Document   : login
    Created on : Oct 4, 2022, 4:59:46 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="bakeryRecipe.account_tbl.LoginError" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Bakery Recipe| Login</title>
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
        <!-- Custom Css -->
        <link rel="stylesheet" href="style.css">
        <!-- Modernizr Js -->
        <script src="js/modernizr-3.6.0.min.js"></script>

    </head>
    <body>
    <body>
        <!--[if lte IE 9]>
        <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
        <![endif]-->
        <c:if test="${not empty Remove_done}">
        <script>alert("Your account is delete");
        </script></c:if>
        <c:remove var="Remove_done" scope="session" /> 
        
        <c:if test="${not empty Register_done}">
        <script>alert("Your account is Register. Please login!");
        </script></c:if>
        <c:remove var="Register_done" scope="session" /> 
        
        <c:if test="${not empty Forgot_done}">
        <script>alert("Your password is change. Please Login!");
        </script></c:if>
        <c:remove var="Forgot_done" scope="session" /> 
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

            <!-- Inne Page Banner Area Start Here -->
            <section class="inner-page-banner bg-common" data-bg-image="img/figure/inner-page-banner1.jpg">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <div class="breadcrumbs-area">
                                <h1>User Login Page</h1>
                                <ul>
                                    <li>
                                        <a href=homePage name="btAction" value="Home">Home</a>
                                    </li>
                                    <li>Login</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Inne Page Banner Area End Here -->

            <font color="red">${message}</font></br>
            <c:remove var="message" scope="session" /> 
            <!-- Login Area Start Here -->

            <section class="login-page-wrap padding-top-80 padding-bottom-50">
                <div class="container">
                    <div class="row gutters-60">
                        <div class="col-lg-8">
                            <div class="login-box-layout1">
                                <div class="section-heading heading-dark">
                                    <h2 class="item-heading">LOGIN FORM</h2>
                                </div>
                                <!--LOGIN FORM-->
                                <c:set var="error" value="${requestScope.LOGIN_ERR}"></c:set>
                                
                                
                                <form class="login-form" action="loginController"  method="post">

                                    <input class="main-input-box" value="${param.txtUsername}" name="txtUsername" type="text" placeholder="User Name" required
                                           oninvalid="this.setCustomValidity('Enter User Name Here')"
                                           oninput="this.setCustomValidity('')"/>
                                    <c:if test="${not empty error.userameEmptyErr}">
                                        <font color="red">${error.userameEmptyErr}</font></br>
                                    </c:if>

                                    <input class="main-input-box" name="txtPassword" type="password" placeholder="Password" required
                                           oninvalid="this.setCustomValidity('Enter password Here')"
                                           oninput="this.setCustomValidity('')"/>
                                    <c:if test="${not empty error.passwordEmptyErr}">
                                        <font color="red">${error.passwordEmptyErr}</font></br>
                                    </c:if>


                                    <c:if test="${not empty error.accountNotFound}">
                                        <font color="red">${error.accountNotFound}</font></br>
                                    </c:if>
                                    <div class="inline-box mb-5 mt-4">
<!--                                        <div class="checkbox checkbox-primary">
                                            <input id="modal-checkbox" type="checkbox">
                                            <label for="modal-checkbox">Remember Me</label>
                                        </div>-->
                                        <c:url var="forgot_url" value="forgotPasswordPage"></c:url>
                                        <label class="lost-password"><a href="${forgot_url}">Lost your password?</a></label>
                                    </div>
                                    <div class="inline-box mb-5 mt-4">
                                        <!--                                        <button class="btn-fill"  value="loginC" name="btAction">Login</button>-->
                                        <button class="btn btn-danger" style="font-size: 1.5rem" type="submit" >Login</button>
                                        <c:url var="register_url" value="registerPage"></c:url>
                                        <a href="${register_url}">Register</a>
                                    </div>
                                </form>

                            </div>
                        </div>


                    </div>
                </div>
            </section>
            <!-- Login Area End Here -->

        </div>

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
</body>
</html>
