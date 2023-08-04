<%-- 
    Document   : admin
    Created on : Jun 6, 2023, 8:29:13 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/admin.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    
    <title>Admin</title>
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
                    <input type="text" placeholder="Search" class="search">
                    <button type="submit" class="button-search"><i class="fa fa-search"></i></button>
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
             <div>

             </div>
        </div>
    </div>
</body>
</html>