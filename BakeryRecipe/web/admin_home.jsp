<%--
  Created by IntelliJ IDEA.
  User: jexk_dev
  Date: 03/10/2022
  Time: 22:03

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Admin Management</title>
        <link rel="icon" type="image/x-icon" href="../../../../IdeaProjects/BakeryRecipe_SWP/BakeryRecipe/web/admin_img/favicon.png">
        <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,600" rel="stylesheet">
        <link rel="stylesheet" href="admin_font/css/font-awesome.min.css">
        <link rel="stylesheet" href="admin_css/prettify.css">
        <link rel="stylesheet" href="admin_css/style.css">
    </head>
    <body>
        <div id="hdr">
            <div class="hdr-inner">
                <h1>Trang Quản Trị Bakery Recipe</h1>
            </div>
        </div>
        <div class="div-center bdy">
            <div class="tbl">
                <div class="tbl-row">
                    <div class="tbl-cell menu-container">
                        <ul id="menu">
                            <li><a href="#dashboard" id="menu-dashboard"><i class="fa fa-upload"></i>Tổng Quan </a></li>
                            <li><a href="#listuser" id="menu-user"><i class="fa fa-play"></i>Danh Sách Người Dùng </a></li>
                            <li><a href="#userdetail" id="menu-userdetail"><i class="fa fa-sitemap"></i>Chi Tiết Người Dùng</a></li>
                            <li><a href="#listpostuser" id="menu-listpost"><i class="fa fa-upload"></i>Danh Sách Bài Đăng</a></li>
                            <li><a href="#postdetail" id="menu-postdetail"><i class="fa fa-upload"></i>Chi Tiết Bài Đăng</a></li>
                            <li><a href="#help" id="menu-help"><i class="fa fa-question-circle-o"></i>Thông Tin & Hỗ Trợ</a></li>
                        </ul>
                    </div>


                    <div class="tbl-cell container">
                        <div class="content">
                            <div id="dashboard" class="main-content">
                                <h2><i class="fa fa-info"></i>Tổng Quan :</h2>  


                                <div class="content-container">
                                    <c:set var="adminDashBoard" value="${sessionScope.ADMIN_DASHBOARD}"></c:set>
                                    <c:if test="${empty adminDashBoard}"> <H3> Mất Kết Nối Với DATABASE,Load file stored produce,Nhấn Nút Làm Mới </h3></c:if>
                                        <c:if test="${not empty adminDashBoard}">
                                        <h3>  Tổng Số Tài Khoản : ${adminDashBoard.get(0)} </h3> <br/>
                                        <h3> Tài Khoản Hoạt động  ${adminDashBoard.get(1)}  </h3> <br/>
                                        <h3> Tài Khoản Bị Khóa :  ${adminDashBoard.get(2)} </h3> <br/>
                                    </c:if>
                                </div>
                            </div>

                            <div id="listuser" class="main-content">
                                <h2><i class="fa fa-play"></i>Danh Sách Người Dùng :</h2>  

                                <div class="content-container">
                                    <div class ="content">
                                        <c:forEach begin="1" end="${sessionScope.end_account}" var="i" >
                                             <li><a href="adminListAccountController?listuserrowindex=${i}" >${i}</a></li>
                                        </c:forEach>
                                                                       

                                    </div>
                                    <table id="customers">
                                        <tr>
                                            <th>Stt </th>  
                                            <th>Username </th>
                                            <th>Email </th>
                                            <th>Sdt </th>
                                            <th>Lần Cuối Chỉnh Sửa </th> 
                                            <th>Đang Hoạt Động </th>  
                                        </tr>
                                        <c:forEach items="${sessionScope.ADMIN_LIST_USER}" var="account">
                                            <tr>
                                                <td>
                                                    ${account.accountId}
                                                </td>
                                                <td>
                                                    ${account.username}
                                                </td>
                                                <td>
                                                    ${account.email}
                                                </td>
                                                <td>
                                                    ${account.phoneNumber}
                                                </td>
                                                <td>
                                                    ${account.lastModified}
                                                </td>
                                                <td>
                                                    <input type="checkbox" name="vehicle1" checked="${account.isActived}">
                                                </td>
                                            </tr>
                                        </c:forEach>

                                    </table>

                                </div>






                            </div>

                        </div>


                    </div>
                </div>
            </div>
        </div>
        <script src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/prettify/prettify.js"></script>
        <script src="js/jquery-scrolltofixed-min.js"></script>
        <script src="js/jquery.scrollTo.min.js"></script>
        <script src="js/custom.js"></script>
    </body>
</html>
