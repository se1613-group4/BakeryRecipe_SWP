<%-- 
    Document   : registration
    Created on : Sep 25, 2022, 10:16:25 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Account</title>
        <link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <div class="regbox box">
                <img class="avatar" src="img/collaboration.png">
                <h1>
                    Register Account</h1>
                <form action="MainController" method="post">
                    <p>Username</p>
                    <input type="text" placeholder="Username" name="name" required>
                    <p>UserEmail</p>
                    <input type="text" placeholder="Useremail" name="email" required>
                    <p>Password</p>
                    <input type="password" placeholder="Password" name="password" required>
                    <p>phoneNumber</p>
                    <input type="text" placeholder="PhoneNumber" name="phoneNumber" required>
                    <input type="submit" value="Register" name="btAction">
                    <a href="index.jsp">Already have Account?</a>
                </form>
            </div>
        </div>
    </body>
</html>
