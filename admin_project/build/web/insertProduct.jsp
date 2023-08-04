<%@page import="model.Product"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/productUpdate.css">
        <link rel="stylesheet" href="css/admin.css">
        <title>Admin InsertProduct</title>
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
                <div>
                    <% Product p = (Product) request.getAttribute("product");%> 

                       <form action="productaction" method="post">
                                    <button class="back-button" style="margin-top: 10%;" >Back</button>
                       </form>
                    <div style="display:flex; margin-top: -50px;">
                      
                        <div style="margin: 0 auto;" class="listUpdate">
                        
                         
                        <form action="editCreate" method="POST">
                            <div>
                                
                                <table>
                                <div class="input">
                                    <tr>
                                    <td> <p class="title">Name</p> </td>
                                    <td><input type="text" placeholder="Name Product"  name="name" value="${requestScope.name}"class="input-text <c:if test="${requestScope.messageName != null}">anno-red</c:if>"></td>
                                    <tr>
                                </div>
                                    
                                <c:if test="${requestScope.messageName != null}">
                                    <tr> <td></td><td><p class="anno" style="color:red; margin-top:0;">${requestScope.messageName}</p></td> </tr>
                                </c:if>
                                <div class="input">
                                    <tr>
                                    <td><p class="title">Image</p></td>
                                    <td><input type="text" placeholder="Image Link" name="imagepath" value="${requestScope.imagepath}" class="input-text <c:if test="${requestScope.messageImage != null}">anno-red</c:if>"></td>
                                </tr>
                                </div>
                                <c:if test="${requestScope.messageImage != null}">
                                        <tr><td></td><td><p class="anno" style="color:red; margin-top:0;">${requestScope.messageImage}</p></td></tr>
                                </c:if>
                                <div class="input">
                                    <tr>
                                        <td><p class="title">Price</p></td>
                                        <td><input type="text" placeholder="Price"  name="price"  value="${requestScope.price}" class="input-text <c:if test="${requestScope.messagePrice != null}">anno-red</c:if>"></td>
                                    </tr>
                                </div>
                                <c:if test="${requestScope.messagePrice != null}">
                                            <tr><td></td><td><p  class="anno" style="color:red; margin-top:0;">${requestScope.messagePrice}</p></td></tr>
                                </c:if>
                                <div class="input">
                                    <tr>
                                        <td><p class="title">Status</p></td>
                                            <td><input type="checkbox"  name="status" value="1" checked=${requestScope.status == 1 ? "checked" : ''}/></td>
                                    </tr>
                                </div>
                                
                                <div class="input">
                                    <tr>
                                        <td><p class="title">Category</p></td>
                                        <td><select name="category" id="cars" class="input-select">
                                        <c:forEach items="${requestScope.categoryList}" var ="o" >  
                                            <option value="${o.getId()}" <c:if test="${requestScope.categoryId==o.getId()}">selected</c:if>>${o.getName()}</option>
                                        </c:forEach>
                                    </select>
                                            </td>
                                    </tr>
                                </div>
                                <div class="input">
                                    <tr>
                                        <td><p class="title">Description</p></td>
                                        <td><textarea style="border-radius: 10px; padding: 10px;" name="description" rows="20" cols="50" placeholder="Description" class="<c:if test="${requestScope.messageDes != null}">anno-red</c:if>"> ${requestScope.description}</textarea>
                                 </td>
                                    </tr>
                                </div>

                                <c:if test="${requestScope.messageDes != null}">
                                    <tr><td></td><td><p  class="anno" style="color:red; margin-top:0;">${requestScope.messageDes}</p></td></tr>
                                </c:if>
                                </table>
                                <c:if test="${requestScope.message != null}">
                                    <p class="anno-title" style="color:red; margin-top:0;">${requestScope.message}</p>
                                </c:if>
                                 
                                <button class="classUpdate" type="submit">Create</button>
                            </div>
                                
                        </form>


                    </div>
                    </div>
                                 
                </div>
            </div>

    </body>
</html>
