<%-- 
    Document   : productAdmin
    Created on : Jun 8, 2023, 1:16:22 AM
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
        <link rel="stylesheet" href="css/productAdmin.css">
        <link rel="stylesheet" href="css/orderAdmin.css">
        <title>Admin OrderTracking</title>
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
                            <div class="order-tracking">
                    <h1>Order Tracking</h1>

                    <div class="item">

                        <div class="item-list">
                            <table class="table-list">

                                <tr class="name-colums">
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Date</th>
                                    <th>Phone</th>
                                    <th>Address</th>
                                    <th>Total</th>
                                    <th>See more</th>
                                </tr>
                                <c:forEach items="${requestScope.oList}" var="o">
                                    <tr class="row-table">
                                        <td>${o.getId()}</td>
                                        <td>${o.getName()}</td>
                                        <td>${o.getDate()}</td>
                                        <td>${o.getPhone()}</td>
                                        <td>${o.getAddress()}</td>
                                        <td style="display: flex; justify-content: space-between;"><p class="total-price">${o.getTotal()}<p>
                                                <c:choose>
                                                    <c:when test="${o.getStatus()==0}">
                                                    <p class="status status-pending">Pending</p>
                                                </c:when>
                                                <c:when test="${o.getStatus()==1}">
                                                    <p class="status status-proccessing">Processing</p>
                                                </c:when>
                                                <c:when test="${o.getStatus()==-1}">
                                                    <p class="status status-cancel">Cancel</p>
                                                </c:when>
                                                    <c:when test="${o.getStatus()==2}">
                                                    <p class="status status-completed">Completed</p>
                                                </c:when>
                                            </c:choose>       
                                        </td>
                                        <td class="button" style="padding-left: 2%;">
                                            <form action="orderaction" method="POST">
                                                <input type="hidden" name="sid" value="${o.getId()}" >
                                                <input type="hidden" name="action" value="seemore">
                                                <button class="update" style="display: inline-block">See More</button>
                                            </form>
                                        </td>

                                        <c:choose>
                                            <c:when test="${o.getStatus()==0}">
                                                <td style="padding-left: 2%;">
                                                    <form action="orderaction" method="POST">
                                                        <input type="hidden" name="sid" value="${o.getId()}" >
                                                        <input type="hidden" name="action" value="accept">
                                                        <button class="accept-button"  style="display: inline-block">Accept</button>
                                                    </form>
                                                    <form action="orderaction" method="POST">
                                                        <input type="hidden" name="action" value="decline">
                                                        <input type="hidden" name="sid" value="${o.getId()}" >   
                                                        <button class="delete" >Decline</button>
                                                    </form>
                                                </td>
                                            </c:when>
                                            <c:when test="${o.getStatus()==1}">
                                                <td style="padding-left: 2%;">
                                                    <form action="orderaction" method="POST">
                                                        <input type="hidden" name="sid" value="${o.getId()}" >
                                                        <input type="hidden" name="action" value="completed">
                                                        <button class="completed-button"  style="display: inline-block">Complete</button>
                                                    </form>
                       
                                                </td>
                                            </c:when>
                                        </c:choose>       
                                    </tr>
                                </c:forEach>

                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
<div>

