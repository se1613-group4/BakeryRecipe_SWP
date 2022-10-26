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
        <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,600" rel="stylesheet">
        <link rel="stylesheet" href="admin_font/css/font-awesome.min.css">
        <link rel="stylesheet" href="admin_css/prettify.css">
        <link rel="stylesheet" href="admin_css/style.css">
    </head>
    <body>
        <!--header-->
        <div id="hdr">
            <div class="hdr-inner">
                <h1>Trang Quản Trị Bakery Recipe</h1>
            </div>
        </div>
        <!--body-->
        <div class="div-center bdy">
            <div class="tbl">
                <!--nav menu-->
                <div class="tbl-row">
                    <div class="tbl-cell menu-container">
                        <ul id="menu">
                            <li><a href="#dashboard" id="menu-dashboard"><i class="fa fa-upload"></i>Overview </a></li>
                            <li><a href="#listuser" id="menu-user"><i class="fa fa-play"></i>List Account </a></li>
                            <li><a href="#userdetail" id="menu-userdetail"><i class="fa fa-sitemap"></i>Account Detail</a></li>
                            <li><a href="#listrecipe" id="menu-listpost"><i class="fa fa-upload"></i>User's Recipe</a></li>
                            <li><a href="#help" id="menu-help"><i class="fa fa-question-circle-o"></i>Thông Tin & Hỗ Trợ</a></li>
                        </ul>
                    </div>

                    <div class="tbl-cell container">
                        <div class="content">
                            <!--session 1--> 

                            <div id="dashboard" class="main-content">
                                <h2><i class="fa fa-info"></i>Tổng Quan :</h2>  


                                <div class="content-container">
                                    <c:set var="adminDashBoard" value="${sessionScope.ADMIN_DASHBOARD}"></c:set>
                                    <c:if test="${empty adminDashBoard}"> <H3> Lost Connection,Load file stored produce,Press Summit Button </h3></c:if>
                                        <c:if test="${not empty adminDashBoard}">
                                        <h3>  Total Account : ${adminDashBoard.get(0)} </h3> <br/>
                                        <h3>  Banned Account :   ${adminDashBoard.get(1)}  </h3> <br/>
                                        <h3>  Active Account :  ${adminDashBoard.get(2)} </h3> <br/>
                                    </c:if>
                                </div>
                            </div>

                            <!--session 2-->
                            <div id="listuser" class="main-content">
                                <h2><i class="fa fa-play"></i>Danh Sách Người Dùng : </h2>
                                <p><strong>[&] </strong>Search:</p>

                                <form action="adminListAccountController">

                                    <input class="search-form" type="text" name="a" placeholder="username,phonenumber,.." size="15" required /> 
                                </form>
                                <div class="content-container">
                                    <h5
                                        <c:forEach begin="1" end="${sessionScope.end_account}" var="i" >
                                            <a href="adminListAccountController?roww=${i}&a=${a}">${i}</a>
                                        </c:forEach>
                                    </h5>
                                    <table id="customers">
                                        <tr>
                                            <th>Id </th>  
                                            <th>Username </th>
                                            <th>Email </th>
                                            <th>Phone </th>
                                            <th>Last Modified </th> 
                                            <th>Status  </th>  
                                            <th>Action </th>
                                        </tr>
                                        <c:if test="${ empty sessionScope.ADMIN_LIST_USER}">
                                            <H3> No Result Found!  </h3>
                                            </c:if>
                                            <c:if test="${ not empty sessionScope.ADMIN_LIST_USER}">

                                            <form action="adminUsdetail" method="post">
                                                <c:forEach items="${sessionScope.ADMIN_LIST_USER}" var="account">
                                                    <tr>                                                                                
                                                        <td>
                                                            <input type="submit" name="usid" value="${account.userId}">
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
                                                            <c:if test="${account.isActived}">
                                                                Actived
                                                            </c:if>
                                                            <c:if test="${!account.isActived}">
                                                                Banned
                                                            </c:if>
                                                        </td>
                                                        <td>
                                                            <a href="adminUpdateAccount?usupid=${account.userId}&usupstt=${account.isActived}">Update status</a>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </form>

                                        </c:if>
                                        <a  href="adminListAccountController"  type="Submit"/> Làm Mới </a>
                                    </table>

                                </div>
                            </div>
                            <!--session 3-->
                            <div id="userdetail" class="main-content">
                                <h2><i class="fa fa-sitemap"></i> User Detail :</h2>  

                                <div class="content-container">
                                    <c:if test="${empty usinf}"> <H3>Please choose account you want !</h3></c:if>
                                        <c:if test="${not empty usinf}">
                                        Action :
                                        <h5>
                                            Name:  ${usinf.fullName} <br/>
                                            Gender: ${usinf.gender} <br/>
                                            Bio : ${usinf.biography} <br/>
                                            Last Modified: ${usinf.lastModified} <br/>

                                        </h5>


                                        <!--notification-->
                                        <br/>

                                    </c:if>
                                </div>
                            </div>
                            <div id="userdetail" class="main-content">
                                <h2><i class="fa fa-sitemap"></i> Notification :</h2>  

                                <div class="content-container">
                                    <c:if test="${empty usinf}"> <H3>Please choose account you want !</h3></c:if>
                                        <c:if
                                            test="${not empty usinf}">
                                        <h4>[!] send notification to this user:  <strong style="color:green">${REPORTSMS}</strong> </h4> 
                                        <form action="sendNotificationAdmin">
                                            <input  type="hidden" value="${usinf.userId}" name="summitNotiId"/> 
                                            <input class="search-form" type="text" name="sms" placeholder="Write notification here...." size="50" required /> 
                                        </form>
                                            <br/>
                                        <table id="customers">
                                            <tr>
                                                <th>Create date </th>  
                                                <th>Detail messeger </th>
                                            </tr>
                                            <c:if test="${ empty sessionScope.NOTIFICATION_LIST_ADMIN && not empty usinf}">
                                                <H3> No messeger found!  </h3>
                                                </c:if>
                                                <c:if test="${ not empty sessionScope.NOTIFICATION_LIST_ADMIN && not empty usinf}">

                                                <c:forEach items="${sessionScope.NOTIFICATION_LIST_ADMIN}" var="adminnotifii">
                                                    <tr>                                                                                
                                                        <td>
                                                            ${adminnotifii.createdDate}
                                                        </td>
                                                        <td>
                                                            ${adminnotifii.detail}
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                                </form>

                                            </c:if>
                                        </table>

                                    </c:if>
                                </div>
                            </div>
                            <!--session4-->
                            <div id="listrecipe" class="main-content">
                                <h2><i class="fa fa-upload"></i> User List Recipe: </h2>
                                <c:if test="${ not empty usinf.userId}">
                                    <h5><a href="listRecipeAdmin?usrecid=${usinf.userId}" type="submit"> Display this user recipe </a></h5>
                                </c:if>

                                <div class="content-container">
                                    <c:if test="${ not empty sessionScope.ADMIN_LIST_RECIPE}">

                                        <table id="customers">
                                            <tr>
                                                <th>Id </th>  
                                                <th>name </th>
                                                <th>total like </th>
                                                <th>total saved </th>                                      
                                                <th>create date </th>
                                                <th>Last Modified </th> 
                                                <th>Status  </th> 
                                                <th>Action </th>
                                            </tr>
                                            <form action="listRecipeAdmin" method="post">
                                                <c:forEach items="${sessionScope.ADMIN_LIST_RECIPE}" var="rec">
                                                    <tr>                                                                                
                                                        <td>
                                                            ${rec.recipeId}
                                                        </td>
                                                        <td>
                                                            ${rec.name}
                                                        </td>
                                                        <td>
                                                            ${rec.likedCount}
                                                        </td>

                                                        <td>
                                                            ${rec.savedCount}
                                                        </td>

                                                        <td>
                                                            ${rec.createdDate}
                                                        </td>
                                                        <td>
                                                            ${rec.lastModified}
                                                        </td>
                                                        <td>
                                                            <c:if test="${rec.isActived}">
                                                                Actived
                                                            </c:if>
                                                            <c:if test="${!rec.isActived}">
                                                                Disable
                                                            </c:if>
                                                        </td>
                                                        <td>

                                                            <a href="adminUpdateRecipe?recid=${rec.recipeId}&sttRec=${rec.isActived}">Update status this Recipe</a>
                                                        </td>
                                                    </tr>
                                                </c:forEach>


                                            </form>
                                        </table>

                                    </c:if>

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
