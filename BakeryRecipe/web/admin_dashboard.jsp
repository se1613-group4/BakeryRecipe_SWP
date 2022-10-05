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
    <title> Bakery Recipe Admin Management</title>
    <link rel="icon" type="image/x-icon" href="../../../../IdeaProjects/BakeryRecipe_SWP/BakeryRecipe/web/admin_img/favicon.png">
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,600" rel="stylesheet">
    <link rel="stylesheet" href="admin_font/css/font-awesome.min.css">
    <link rel="stylesheet" href="admin_css/prettify.css">
    <link rel="stylesheet" href="admin_css/style.css">
</head>
<body>
<div id="hdr">
    <div class="hdr-inner">
        <img src="https://img.icons8.com/external-phatplus-lineal-phatplus/64/000000/external-admin-marketing-and-seo-phatplus-lineal-phatplus.png" alt="">
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

                    <li><a href="#help" id="menu-help"><i class="fa fa-question-circle-o"></i>Thông Tin &#3Dùng; Hỗ Trợ</a></li>
                </ul>
            </div>
            <div class="tbl-cell container">
                	<div id="dashboard" class="main-content">
					<h2><i class="fa fa-info"></i>Tổng Quan:  <button> Làm mới </button> </h2>  
					<div class="content-container">
						<p>
                                                    <a href="#listuser" id="menu-user">  Tổng Số Tài Khoản :    </a>    <br/>
                                                    <a href="#listuser" id="menu-user">  Tài Khoản Hoạt động :</a>  <br/>
                                                      <a href="#listuser" id="menu-user">Tài Khoản Bị Khóa :  </a>  <br/>
                                                     <a href="#listuser" id="menu-user">  Tổng Số Bài Đăng : </a>  <br/>
						</p>
                                               
					</div>
				</div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
