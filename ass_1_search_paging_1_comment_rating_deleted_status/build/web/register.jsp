<%-- 
    Document   : register
    Created on : Jun 26, 2023, 8:52:07 PM
    Author     : Tuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/register.css">
    <title>Document</title>
</head>
<body>
    <form class="register" action="register" method="post">
        <div class="inside-register">
            <div class="logo">
                <img src="images/Artboard 1.png" alt="">
            </div>
            <div class="title">
                <h3>Register Account</h3>
            </div>
            <p style="color: red;">${error}</p>
            <p style="color: red;">${error1}</p>
             <p style="color: red;">${error2}</p>
              <p style="color: red;">${error3}</p>
             <div style="margin-top: 15px;" class="main-input">
                 Username<input type="text" name="username" placeholder="Enter username" value="${param.username}" >
                Password<input type="password" name="password" placeholder="Enter password" value="${param.password}">
                Confirm Password<input type="password" name="repassword" placeholder="Confirm password" value="${param.cpass}">
                Email<input type="email" name="email" placeholder="Enter email" value="${param.email}">
                Name<input type="text" name="name" placeholder="Enter your name" value="${param.name}">
                Phone<input type="text" name="phone" placeholder="Enter your phone" value="${param.phone}"> 
                Address:<input type="text" name="address" placeholder="Enter your address" value="${param.address}"> 
            </div>  
            <div class="signup">
                <button type="submit"><i class="fa fa-user-plus"> Sign up</i></button>
            </div>
            <div class="backToLogin">
                <i class="fa fa-arrow-circle-left"><a href="login.jsp"> Back</a></i>
            </div>
        </div>
       
    </form>
          
</body>
</html>