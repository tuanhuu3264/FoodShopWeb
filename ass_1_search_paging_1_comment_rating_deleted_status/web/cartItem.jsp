<%-- 
    Document   : cartItem
    Created on : Jun 25, 2023, 9:35:18 PM
    Author     : Tuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <link rel="stylesheet" href="css/footer.css">
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
                    
                 <c:if test="${not empty sessionScope.cart}">
                    <div id="cart-page" class="cart-toggle">
                        <div class="top-title">                      
                        <p id="cart-title">Cart Items</p>
                         <a href="list" id="cart-continue">Continue to order</a>
                        </div>
                        <p id="m-total-amount">Total Amount: $ 100</p>
                        <table>
                            <thead>
                                <td>No.</td>
                                <td>Item</td>
                                <td>Name</td>
                                <td>Quantity</td>
                                <td>Price</td>
                                <td>Total</td>
                                <td>Action</td>
                            </thead>
                            <tbody id="table-body">
                                <c:set var="t" value="0" />
                                <c:set var="o" value="${sessionScope.cart}" />
                                <c:forEach items="${o.product}" var="i">
                                    <c:set var="t" value="${t+1}" />
                                <tr>
                                    <td>${t}</td>
                                    <td>
                                        <a style="text-decoration: none;" href="detailproduct?sid=${i.item.id}"> <img src="${i.item.imagePath}" alt="img"></a>
                                    </td>
                                    <td><a style="text-decoration: none; color: black;" href="detailproduct?sid=${i.item.id}">${i.item.name}</a></td>
                                    <td>
                                        <button class="decrease-item"><a style="text-decoration: none;" href="process?num=-1&id=${i.item.id}">-</a></button>
                                        <span>${i.quantity}</span>
                                        <button class="increase-item"><a style="text-decoration: none;" href="process?num=1&id=${i.item.id}">+</a></button>
                                    </td>
                                    <td><fmt:formatNumber pattern="##.#" value="${i.price}"/>$ </td>
                                    <td><fmt:formatNumber pattern="##.#" value="${i.quantity*i.price}"/>$</td>
                                    <td>
                                        <form action="process" method="post">
                                            <input type="hidden" name="id" value="${i.item.id}" />
                                            <input class="remove-link" style="border: none;" type="submit" value="Remove">
                                        </form>
                                        
                                    </td>
                                </tr>
                                </c:forEach>
                               
                            </tbody>
                        </table>
                    </div>

              <!--</div>--> 
              <div id="checkout" class="cart-toggle">
                <c:set var="t" value="${sessionScope.totalquantity}" />
                <c:set var="p" value="${sessionScope.totalprice}" />
                <p id="total-item">Total Item : ${t}</p>
                <p id="total-price">Total Amount : ${p}</p>
             
                <button class="cart-btn"><a href="inforCheckout.jsp">Checkout</a></button>
              </div>
                  <div class="footer">      
                <div class="row-footer">
                    <div class="footer-col">
                        <h4>Company</h4>
                        <ul>
                            <li><a href="anoutus.jsp">About Us</a></li>
                         
                        </ul>
                    </div>
                    <div class="footer-col">
                        <h4>Get help</h4>
                        <ul>
                            <li><a href="">Contact with us</a></li>
                        </ul>
                    </div>
                    <div class="footer-col">
                        <h4>Online shop</h4>
                        <ul>
                            <li><a href="#">Chicken</a></li>
                            <li><a href="#">Pizza</a></li>
                            <li><a href="#">Vegetarian</a></li>
                            <li><a href="#">Noodles</a></li>
                            <li><a href="#">Drinking</a></li>
                        </ul>
                    </div>
                    <div class="footer-col">
                        <h4>Follow us</h4>
                        <div class="social-links">
                            <a href="https://www.facebook.com/profile.php?id=100037391781696"><i class="fa fa-facebook-f"></i></a>
                            <a href="https://www.instagram.com/nguyenngoctuan230/"><i class="fa fa-instagram"></i></a>
                        </div>
                    </div>         
                 </div>
             </div>
                </c:if>
              <c:if test="${empty sessionScope.cart}">
                  
                 <!--<div id="biryani">--> 
                 <div class="empty-cart" style=" margin-left: 100px;
                                                  position: relative;">
                     <div style="position: absolute;
                                top: 20px;"><a href="list" id="cart-continue">Continue to order</a></div>
                
                <img class="cart-empty" src="images/empty-cart.png" alt="">
                </div>
            </c:if>
            </div>
              
            </div>
            
        </div>
      
    </div>
    <script src="" type="module"></script>
</body>
</html>

