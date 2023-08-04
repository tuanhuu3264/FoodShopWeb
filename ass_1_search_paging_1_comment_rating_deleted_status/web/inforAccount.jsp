<%-- 
    Document   : inforAccount
    Created on : Jun 29, 2023, 5:29:20 PM
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
     <form class="register" action="infor">
        <div class="inside-register">
            <div class="logo">
                <img src="images/Artboard 1.png" alt="">
            </div>
            <div class="title">
                <h3>My Account</h3>
            </div>
            <div class="main-input">
                Username<input type="text" name="username" placeholder="Enter username" readonly="${requestScope.inforaccount.username}" value="${requestScope.inforaccount.username}" >
                Password<input type="password" name="password" placeholder="Enter password" readonly="${requestScope.inforaccount.password}" value="${requestScope.inforaccount.password}">
                Email<input type="email" name="email" placeholder="Enter email" readonly="${requestScope.inforaccount.email}" value="${requestScope.inforaccount.email}">
                Name<input type="text" name="name" placeholder="Enter your name" readonly="${requestScope.inforaccount.name}" value="${requestScope.inforaccount.name}">
                Phone<input type="text" name="phone" placeholder="Enter your phone" readonly="${requestScope.inforaccount.phone}" value="${requestScope.inforaccount.phone}"> 
                Address<input type="text" name="address" placeholder="Enter your address" readonly="${requestScope.inforaccount.address}" value="${requestScope.inforaccount.address}">                    
               
            </div>  
            <div class="backToLogin">
                <i class="fa fa-arrow-circle-left"><a href="list">Back</a></i>
            </div>
            <div class="backToLogin">
          
                <i class="fa fa-arrow-circle-above"><a href="update">Update</a></i>
            </div>
        </div>
       
    </form>
     
</body>
</html>
