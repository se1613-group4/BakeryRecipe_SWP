<%-- 
    Document   : follow
    Created on : Oct 27, 2022, 10:24:52 PM
    Author     : ThongNT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bakery Recipe - Follow</title>
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
        <!-- Icon -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
        <!--ThongNT custom css-->
        <link rel="stylesheet" href="css/custom/single-recipe.css">
    </head>

    <body>
        <c:set var="recipeDto" value="${requestScope.RECIPE_INFO}"/>
        <c:set var="currentAccountDto" value="${sessionScope.USER}"/>
        <c:set var="isFollowed" value="${requestScope.ISFOLLOWED}"/>


        <c:if test="${isFollowed == -1  || isFollowed == 0}">
            <div class="follow-container">
                <form action="followController">
                    <input type="hidden" name="txtRecipeId" value="${recipeDto.recipeId}">
                    <input type="hidden" name="txtUserId" value="${currentAccountDto.userId}">
                    <input type="hidden" name="txtRecipeAuthorId" value="${recipeDto.authorInfo.userId}">
                    <button class="custom-btn-thongnt"><i class="bi bi-plus"></i>&nbsp;Follow</button>
                </form>
            </div>
        </c:if><!-- end check if user has not login (check here only for display suitable button) -->

        <c:if test="${isFollowed == 1}">
            <div class="follow-container">
                <form action="unfollowController">
                    <input type="hidden" name="txtRecipeId" value="${recipeDto.recipeId}">
                    <input type="hidden" name="txtUserId" value="${currentAccountDto.userId}">
                    <input type="hidden" name="txtRecipeAuthorId" value="${recipeDto.authorInfo.userId}">
                    <button>Unfollow <i class="fa fa-heart" aria-hidden="true"></i></button>
                </form>
            </div>
        </c:if><!-- end check if user has login (check here only for display suitable button) -->
    </body>
</html>

