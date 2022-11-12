<%-- 
    Document   : like
    Created on : Oct 13, 2022, 3:01:32 PM
    Author     : ThongNT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bakery Recipe - Like</title>
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
        <!-- Icon -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
        <!--ThongNT custom css-->
        <link rel="stylesheet" href="css/custom/single-recipe.css">
    </head>

    <body>
        <c:set var="recipeDto" value="${requestScope.RECIPE_INFO}"/>
        <c:set var="currentAccountDto" value="${sessionScope.USER}"/>
        <c:set var="isLiked" value="${requestScope.ISLIKED}"/>
        <c:set var="likeCount" value="${requestScope.LIKES_COUNT}"/>

        <c:url var="likeURL" value="likeController">
            <c:param name="txtRecipeId" value="${recipeDto.recipeId}"></c:param>
            <c:param name="txtUserId" value="${currentAccountDto.userId}"></c:param>
        </c:url>
        <c:url var="unlikeURL" value="unlikeController">
            <c:param name="txtRecipeId" value="${recipeDto.recipeId}"></c:param>
            <c:param name="txtUserId" value="${currentAccountDto.userId}"></c:param>
        </c:url>

    <li class="single-meta">
        <a class="custom-btn-thongnt" href=
           <c:if test="${isLiked == -1  || isLiked == 0}">"${likeURL}"> <i class="bi bi-heart"></i></c:if>
            <c:if test="${isLiked == 1}">"${unlikeURL}"> <i class="fas fa-heart"></i></c:if>
            <span>${likeCount}</span>
            Likes</a>
    </li>
    <%--
    <c:if test="${isLiked == -1  || isLiked == 0}">
        <div class="like-container">
            <form action="likeController">
                <input type="hidden" name="txtRecipeId" value="${recipeDto.recipeId}">
                <input type="hidden" name="txtUserId" value="${currentAccountDto.userId}">
                <button>LIKE <i class="fa fa-heart" aria-hidden="true"></i></button>
            </form>
        </div>
    </c:if><!-- end check if user has not login (check here only for display suitable button) -->

    <c:if test="${isLiked == 1}">
        <div class="like-container">
            <form action="unlikeController">
                <input type="hidden" name="txtRecipeId" value="${recipeDto.recipeId}">
                <input type="hidden" name="txtUserId" value="${currentAccountDto.userId}">
                <button>UNLIKE <i class="fa fa-heart" aria-hidden="true"></i></button>
            </form>
        </div>
    </c:if><!-- end check if user has login (check here only for display suitable button) -->
    --%>
</body>
</html>
