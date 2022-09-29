<%-- 
    Document   : search
    Created on : Sep 26, 2022, 4:37:50 PM
    Author     : trung
--%>

<%@page import="bakeryRecipe.recipe_tbl.Recipe_tblDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bakery Recipe - Search</title>
    </head>
    <body>

        <!-- Header -->
        <%@include file="header.html" %>

        <p>This is my search jsp</p>

        <c:set var="searchValue" value="${param.txtSearchValue}"/>

        <form action="MainController">
            Search value <input type="text" name="txtSearchValue" value="${searchValue}"/>
            <input type="submit" value="Search" name="btAction"/>
        </form><br/>

        

        <c:if test="${empty searchValue}">
            <p>
                No record is matched!
            </p>
        </c:if>
        <c:if test="${not empty searchValue}">
            <c:set var="searchResult" value="${requestScope.SEARCH_RESULT}"/>
            
            <c:if test="${not empty searchResult}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Recipe Id</th>
                            <th>User Id</th>
                            <th>Name</th>
                            <th>Liked Count</th>
                        </tr>
                    </thead>
                    <tbody>                            
                        <c:forEach var="recipeDto" items="${searchResult}" varStatus="counter">
                            <c:set var="author" value="${recipeDto.authorInfo}"/>
                            <c:set var="category" value="${recipeDto.category}"/>
                            <c:set var="image" value="${recipeDto.image}"/>
                            <c:url var="single_recipe_url" value="DisplaySingleRecipe">
                                <c:param name="recipeId" value="${recipeDto.recipeId}"/>
                            </c:url>
                            
                            ${recipeDto.recipeId} </br>
                                ${author.userId}</br>
                                ${recipeDto.name}</br>
                                ${recipeDto.likedCount}</br> </br>
                                
                        </c:forEach>
                    </tbody>
                </table>
                
            </c:if>
            
        </c:if>

        <%--
        <c:set var="searchValue" value="${param.txtSearchValue}"/>
        
        
        <c:if test="${not empty searchValue}">
            <c:set var="result" value="${requestScope.SEARCH_RESULT}"/>
            
            <c:if test="${not empty result}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Recipe Id</th>
                            <th>User Id</th>
                            <th>Name</th>
                            <th>Liked Count</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${result}" varStatus="counter">
                        <form action="DispatchServlet">
                            <tr>
                                <td>
                                    ${counter.count}
                                </td>
                                <td>
                                    ${dto.recipeId}
                                </td>
                                <td>
                                    ${dto.userId}
                                </td>
                                <td>
                                    ${dto.name}
                                </td>
                                <td>
                                    ${dto.likedCount}
                                </td>                                
                            </tr>
                        </form>
                    </c:forEach>
                </tbody>
            </table>

        </c:if>
        <c:if test="${empty result}">
            <h2>
                No record is matched!
            </h2>
        </c:if>
    </c:if>
    
        --%>

    </body>
</html>
