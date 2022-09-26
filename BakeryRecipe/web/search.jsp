<%-- 
    Document   : search
    Created on : Sep 26, 2022, 4:37:50 PM
    Author     : trung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bakery Recipe - Search</title>
    </head>
    <body>
        
        <form action="MainController">
            Search value <input type="text" name="txtSearchValue" 
                                value="${param.txtSearchValue}"/>
            <input type="submit" value="Search" name="btAction"/>
        </form><br/>
        
        <c:set var="searchValue" value="${param.txtSearchValue}"/> <%--la set att cung la phep gan--%>
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
    </body>
</html>
