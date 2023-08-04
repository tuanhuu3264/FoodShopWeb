<%-- 
    Document   : orderSeeMore
    Created on : Jun 12, 2023, 7:58:38 AM
    Author     : DELL
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/admin.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/orderAdmin.css">
        <link rel="stylesheet" href="css/productAdmin.css">
        <title>Admin OrderSeeMore</title>
    </head>
    <body>
        <div class="container">
            <div class="float-left">
                <div class="logo"><img class="image-logo" src="images/Artboard 1.png" alt=""></div>
                <button class="categories out-of-stock"><a href="dashboard">Dashboard</a> <i class="fa fa-home "></i></button>
            <button class="categories out-of-stock"><a href="product">Product</a> <i class="fa fa-shopping-bag"></i></button>
            <button class="categories out-of-stock"><a href="outstock">Out Of Stock</a> <i class="fa fa-truck"></i></button>
            <button class="categories out-of-stock"><a href="accounts">Manage account</a> <i class="fa fa-users"></i></button>
            <button class="categories out-of-stock"><a href="order">Order</a> <i class="fa fa-cart-plus"></i></button>
            </div>
            <div class="float-right">

                <div class="login">
                    <div class="search-item">
                        <form action="orderaction" method="post">
                            <input type="hidden" name="action" value="search">
                            <input type="text" placeholder="Search" class="search" name="search" value="${requestScope.search}">
                            <button type="submit" class="button-search"><i class="fa fa-search"></i></button>
                        </form>
                    </div>
                    <div class="two-items">
                        <div>
                            <a href="">Hi admin ${sessionScope.account.name}</a>
                        </div>
                        <div>                       
                            <a href="logout"><i class="fa fa-arrow-circle-right"> Logout</i></a>
                        </div>
                    </div>

                </div>
                <div class="see-more" style="margin-top: 10%;">
                    <div style="display:flex; justify-content: space-between; width: 40%;">
                        <form action="order" method="post">
                            <button class="back-button button-seemore" >Back</button>
                        </form>
                        <c:choose>
                            <c:when test="${o.getStatus()==0}">
                                <div style="display:flex;">
                                    <form action="orderaction" method="POST">
                                        <input type="hidden" name="sid" value="${o.getId()}" >
                                        <input type="hidden" name="action" value="accept">
                                        <button class="accept-button button-seemore"  style="display: inline-block">Accept</button>
                                    </form>
                                    <form action="orderaction" method="POST">
                                        <input type="hidden" name="action" value="decline">
                                        <input type="hidden" name="sid" value="${o.getId()}" >   
                                        <button class="delete button-seemore" >Decline</button>
                                    </form>
                                </div>

                            </c:when>
                            <c:when test="${o.getStatus()==1}">
                                <div style="padding-left: 2%;">
                                    <form action="orderaction" method="POST">
                                        <input type="hidden" name="sid" value="${o.getId()}" >
                                        <input type="hidden" name="action" value="completed">
                                        <button class="completed-button button-seemore"  style="display: inline-block">Complete</button>
                                    </form>

                                </div>
                            </c:when>
                        </c:choose>
                    </div> 
                    <div class="information">
                        <div style="display:flex; justify-content: space-between;">
                            <div class="info-user" style="width:60%;">
                                <table>
                                    <tr>
                                        <td style="padding-top:1%; padding-bottom: 1%;">ID Order: ${requestScope.o.getId()}</td> 
                                        <td style="padding-top:1%; padding-bottom: 1%;">Username: ${requestScope.o.getUsername()}</td>
                                    </tr>
                                    <tr>
                                        <td style="padding-top:1%; padding-bottom: 1%;">Name of User: ${requestScope.o.getName()}</td> 
                                        <td style="padding-top:1%; padding-bottom: 1%;">Address: ${requestScope.o.getAddress()}</td>
                                    </tr>
                                  
                                    <tr>
                                        <td style="padding-top:1%; padding-bottom: 1%;">Date: ${requestScope.o.getDate()}</td> 
                                        <td style="padding-top:1%; padding-bottom: 1%;">Phone: ${requestScope.o.getPhone()}</td>
                                    </tr>
                                </table>

                            </div>
                            <div style="display: flex; justify-content: center; align-items: center;width:40%;"><c:choose>
                                    <c:when test="${o.getStatus()==0}">
                                        <div class="notice noctice-pending">Pending   <i class="fa fa-hourglass"></i></div>
                                        </c:when>
                                        <c:when test="${o.getStatus()==1}">
                                        <div class="notice noctice-proccessing">Processing  <i class="fa fa-truck"></i></div>
                                        </c:when>
                                        <c:when test="${o.getStatus()==-1}">
                                        <div class="notice noctice-cancel">Cancel  <i class="fa fa-times"></i></div>
                                        </c:when>
                                        <c:when test="${o.getStatus()==2}">
                                        <div class="notice noctice-completed">Completed <i class="fa fa-check"></i></div>
                                        </c:when>
                                    </c:choose>   </div> </div>

                        <div class="item-user">
                            <div class="item">
                                <c:set var="sum" value="0"/>
                                <table class="table-list">
                                    <tr class="name-colums">
                                        <th>ID</th>
                                        <th>Name</th>
                                        <th>Image</th>
                                        <th>Quantity</th>
                                        <th>Price</th>
                                        <th>Total</th>
                                    </tr>
                                    <c:forEach items="${requestScope.ot}" var="o">
                                        <tr>
                                            <td>${o.getProduct().getId()}</td>
                                            <td>${o.getProduct().getName()}</td>
                                            <td><img src="${o.getProduct().getImagepath()}" style="width: 120px; height:120px; margin: 0 auto;"></td>
                                            <td>${o.getQuantity()}</td>
                                            <td>${o.getProduct().getPrice()}</td> 

                                            <td>${o.getTotal()}</td>                        
                                        </tr>

                                    </c:forEach>
                                    <tr>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                       
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td><p style="font-weight: bold; font-size: 120%; color: #093759">Total:</p></td>
                                        <td><p style="font-size: 120%;">${requestScope.o.getTotal()}</p></td>
                                    </tr>      
                                </table>



                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
