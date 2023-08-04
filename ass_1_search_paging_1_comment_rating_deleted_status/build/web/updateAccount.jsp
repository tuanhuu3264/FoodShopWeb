<%-- 
    Document   : updateAccount
    Created on : Jun 29, 2023, 5:29:43 PM
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
    <form class="register" action="updateAccount">
        <div class="inside-register">
            <div class="logo">
                <img src="images/Artboard 1.png" alt="">
            </div>
            <div class="title">
                <h3>Update My Account</h3>
            </div>
              <p style="color: red; font-size: 20px;">${error}</p>
              <p style="color: red; font-size: 20px;">${error1}</p>
            
              <div style="margin-top: 15px;" class="main-input">
                Username<input type="text" name="username" placeholder="Enter username" readonly value="${requestScope.inforaccount.username}" >
                Password<input type="password" name="password" placeholder="Enter password" value="${requestScope.inforaccount.password}">
                Confirm Password<input type="password" name="repassword" placeholder="Confirm password"  value="${requestScope.inforaccount.password}">               
            </div>  
            <div class="backToLogin">
                <input style="color: white; font-weight: 600" type="submit" class="Update" name="action" value="Confirm" >
            </div>
            <div class="backToLogin">
                  <i class="fa fa-arrow-circle-left"><a href="infor">Back</a></i>
            </div>
        </div>
       
    </form>
     
</body>
</html>
