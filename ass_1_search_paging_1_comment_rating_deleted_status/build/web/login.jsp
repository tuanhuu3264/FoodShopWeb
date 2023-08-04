<%-- 
    Document   : login.jsp
    Created on : Jun 26, 2023, 4:48:46 PM
    Author     : Tuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/login.css">
    <title>Document</title>
</head>
<body  >
    
    <form class="login" action="login" method="post">
        <div class="logo">
            <img src="images/Artboard 1.png" alt="">
        </div>
        <div class="title">
            <h1>Sign in</h1>
        </div>
        <p style="color: red; font-size: 20px;">${error}</p>
        <div class="input-container">       
            <input type="text" id="username" name="username" placeholder="Username" value="${cookie.cuser.value}">
          <i class="fa fa-user"></i>
        </div>
        
        <div class="input-container">
         
          <input type="password" id="password" name="password" placeholder="Password"value="${cookie.cpass.value}">
          <i class="fa fa-lock"></i>
        </div>
        
        <div class="remember-me">
          <input ${(cookie.crem!=null?'checked':'')} type="checkbox" id="remember" name="remember" value="ON">
          <label for="remember">Remember me</label>
        </div>
        <div class="signin">
            <button type="submit"><i class="fa fa-arrow-circle-right"> Sign in</i></button>      
        </div>
        <div class="signup">        
          <button><i class="fa fa-user-plus"> 
            <a href="register.jsp">Sign up New Account</a>
        </i></button>
        </div>
         
      </form>
</body>
</html>