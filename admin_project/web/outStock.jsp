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
    <link rel="stylesheet" href="css/outstock.css">
    <title>Admin OutStock</title>
   
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
                <form action="searchProductOut" method="post">
                    <input type="text" placeholder="Search" class="search" name="search" value="${requestScope.search}">
                    <button class="button-search" ><i class="fa fa-search"></i></button>
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
                        <div class="out-stock">
                 <h1 class="title">LIST OF OUT STOCK PRODUCT</h1>
                <div class="item">
                     <div class="item-list">
                         <form action="productaction" method="post" style="margin-top: -80px;">
                        
                        <button value="delete" name="action" class="delete-button" style="margin-top: 10%;">Delete</button>
                        <table class="table-list">
                            <tr class="name-colums">
                                <th>ID</th>
                                <th>Name</th>
                                <th>Image</th>
                                <th>Price</th>
                                <th>Delete</th>
                                <th>Status</th>
                                <th>toStock</th>
                            </tr>
                            <c:forEach items="${requestScope.listP}" var="o">
                            <tr>
                                <td class="row-display">${o.getId()}</td>
                                <td class="row-display">${o.getName()}</td>
                                <td class="row-display"><image src="${o.getImagepath()}" style="width:140px; height: 140px;"></td>
                                <td class="row-display">${o.getPrice()}</td>
                                <td class="row-display"><input type="checkbox" name="items" value="${o.getId()}"></td>
                                <form action="productaction" method="POST">
                                    <input type="hidden" name="action" value="tostock">
                                   <input type="hidden" value="${o.getId()}" name="sid">
                                <td><input type="checkbox" value="1" name="status" class="row-display"></td>
                                <td class="button">
                                    <input type="submit" class="delete-button" value="toStock" name="action">
                                </td>
                            </form>
                             </tr>
                             
                             </c:forEach>
                            
                        </table>
                        </form>
                     </div>
                </div>
             </div>
             </div>
        </div>
    </div>
</body>
</html>
<div>