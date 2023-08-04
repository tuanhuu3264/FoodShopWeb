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
    <title>Admin Product</title>

    </style>
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
                 <form action="productaction" method="post">
                     <input type="hidden" name="action" value="search">
                     <input type="text" placeholder="Search" class="search" name="search" value="${requestScope.search}">
                        <button class="button-search"><i class="fa fa-search"></i></button>
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
             <div class="product-admin" style="margin-top: 10%;">
                 <form action="productaction" method="post">
                     <input type="hidden" value="create" name="action">
                     <button class="create" style="height: 40px; color: black;">Create</button>
                 </form>
                 <div class="item">
                     <div class="item-list">
                        <table class="table-list">
                            <tr class="name-colums">
                                <th>ID</th>
                                <th>Name</th>
                                <th>Image</th>
                                <th>Price</th>
                                <th>Out Stock</th>
                                <th>Update</th>
                            </tr>
                            <c:forEach items="${requestScope.listP}" var="o">
                            <tr>
                                <td>${o.getId()}</td>
                                <td>${o.getName()}</td>
                                <td><img src="${o.getImagepath()}" style="width:140px; height: 140px;"></td>
                                <td>${o.getPrice()}</td>
                                <td class="button">
                                    <form action="productaction" method="post">
                                        <input type="hidden" value="outstock" name="action" >
                                        <input type="hidden" value="${o.getId()}" name="sid">
                                    <button class="delete" style="display:inline-block">Out Stock</button>
                                    </form>
                                    
                                    
                                </td>
                                <td>
                                    <form action="update" method="post">
                                        <input type="hidden" value="update" name="action">
                                        <input type="hidden" value="${o.getId()}" name="sid">
                                    <button class="update" style="display:inline-block">Update</button>
                                    </form>
                                </td>
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
   
