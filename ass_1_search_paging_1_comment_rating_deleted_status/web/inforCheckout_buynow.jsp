<%-- 
    Document   : inforCheckout
    Created on : Jun 26, 2023, 4:13:17 PM
    Author     : Tuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Food website</title>
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css?family=Karla" rel="stylesheet">
    <link rel="stylesheet" href="css/topdishes.css">
    <link rel="stylesheet" href="css/cartItem.css">
    <link rel="stylesheet" href="css/hienlen.css">
    <link rel="stylesheet" href="css/inforCheckout.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Pangolin&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Pangolin&family=Roboto+Mono:wght@300&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Pangolin&family=Roboto+Mono:wght@300&family=Ysabeau:wght@1;300&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Pangolin&family=Roboto+Mono:wght@300&family=Secular+One&family=Ysabeau:wght@1;300&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Alfa+Slab+One&family=Pangolin&family=Roboto+Mono:wght@300&family=Secular+One&family=Ysabeau:wght@1;300&display=swap" rel="stylesheet">
</head>
<body>
    <!--Desktop view-->
    <div id="container" class="container">
       
        <div id="food-container">
             <div id="header">
                <div class="util">
                    <form class="search-item" action="search">
                            <input type="text" placeholder="Search" name="search" value="${param.search}" >
                            <button type="submit" class="button-search"><i class="fa fa-search"></i></button>
                        </form>
                    <c:set var="size" value="${sessionScope.size}" />
                    <div class="home">
                        <i class="fa fa-home"><a href="list"> Home</a></i>
                        <i class="fa fa-cart-plus" id="cart-plus"><a href="cartItem.jsp"> ${size} Items</a></i>
                    </div>                                        
                 
                    <div class="taste-header">               
                        
                            
                            <c:if test="${sessionScope.account!=null}">
                                
                                    
                                    <div class="header__navbar-item">
                                    <p class="hello">${sessionScope.account.name}</p>
                                    
                                    <ul class="header__navbar-user-menu">
                                        <li class="header__navber-user-item">
                                            <a href="infor">Account</a>              
                                        </li>
                                        <li class="header__navber-user-item">
                                            <a href="statuscontroller?sta=0&action=pending">My purchase order</a>             
                                        </li>
                                         
                                            <li class="header__navber-user-item">                                      
                                            <a href="logout">Logout</a>
                                             </li>
                                    </ul>
                                 </div>
                               <div>
                                
                               </div>
                                
                                 
                            </c:if>       
                            <c:if test="${sessionScope.account==null}">
                                 <i class="fa fa-user-circle">
                                    <a href="login.jsp">Login</a>
                                </i>
                            </c:if>
                        <!--<a href="">Hello TTP</a>-->
                         
                            
                       
                   </div>
                </div>
               
            </div>
            
            <div class="check-items" >
                 <!--<div id="biryani">--> 
                    <div class="form-container">
                        <form action="checkoutbuynow" method="post">
                            <p >Fill in your information before delivery</p>
                           <h3 style="color: red">Instructions for filling in information to place an order:</h3>
                          <ul>
                            <li style="color: gray">With the address, you need to enter clearly and fully information including: district - ward - house number</li>
                            <li style="color: gray">With phone number, please enter the correct phone number</li>   
                            <li style="color: gray">Please read the information before filling in the information form, thank you!</li>                       
                          </ul>
                           <label style="margin-top: 20px;" for="name">Address:</label>
                          <input type="text" id="name" name="address" placeholder="Enter your address" required>
                    
                          <label for="phone">Phone:</label>
                          <input type="text" id="phone" name="phone" placeholder="Enter your phone number" required>
                    
                    <!--      <label for="phone">Address:</label>
                          <input type="text" id="address" name="address" placeholder="Enter your address" required> -->
                        <button type="submit">Confirm</button>
                        </form>
                        
                      </div>               
            </div>
            
        </div>
      
    </div>
    <script src="tinhthanh.js" type="module"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.26.1/axios.min.js" integrity="sha512-bPh3uwgU5qEMipS/VOmRqynnMXGGSRv+72H/N260MQeXZIK4PG48401Bsby9Nq5P5fz7hy5UGNmC/W1Z51h2GQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>





