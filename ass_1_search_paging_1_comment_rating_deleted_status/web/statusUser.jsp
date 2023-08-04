<%-- 
    Document   : statusUser
    Created on : Jul 1, 2023, 1:51:23 PM
    Author     : Tuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/footerdetail.css">
    <link rel="stylesheet" href="css/hienlen.css">
    <link rel="stylesheet" href="css/trangthainguoidung.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body >
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
    <div class="container-body">
        <div class="information-order">
            <div><h3 class="information">Order status information</h3></div>
          
        </div>
        <div style="text-align: center; align-items: center;" class="part2">
            <div class="status">
                <form action="statuscontroller">
                    <input type="hidden" name="sta" value="0">
                    <i class="fa fa-list"> <button type="submit" class="btn1" name="action" value="pending">Pending ${requestScope.listsize1} </button> </i>
                </form>
                <form action="statuscontroller">
                    <input type="hidden" name="sta" value="1">
                    <i class="fa fa-spinner"><button type="submit" name="action" value="progress">In progress ${requestScope.listsize2}</button> </i>
                </form>
                <form action="statuscontroller">
                    <input type="hidden" name="sta" value="2">
                    <i class="fa fa-home"> <button type="submit" name="action" value="complete">Completed ${requestScope.listsize3}</button> </i>
                </form>
                <form action="statuscontroller">
                    <input type="hidden" name="sta" value="-1">
                    <i class="fa fa-times"> <button type="submit" class="btn4" name="action" value="cancel">Cancel ${requestScope.listsize4}</button> </i>
                </form>

            </div>
            
          
             <c:if test="${requestScope.sta==0 && not empty requestScope.liststatusUser}"> 
            <div class="table-order">
                <table class="table-user">
                 
                    <thead>
                        <tr>
                        <td>No.</td>
                        <td>Order ID</td>                        
                        <td>DateBy</td>
                        <td>Total</td>
                        <td>View</td>
                        <td>Cancel</td>
                    </tr>
                    </thead>
                    <tbody id="table-body">
                     <c:set var="t" value="0" />
                     <c:forEach items="${requestScope.liststatusUser}" var="s">
                          <c:set var="t" value="${t+1}" />
                        <tr>
                            <td>${t}</td>
                            <td>
                               ${s.orderID}
                            </td>
                            <td>
                               ${s.dateBuy}
                            </td>
                            <td>${s.total}$</td>
                            <td>
                                <form action="view" method="post">
                                    <input type="hidden" name="status" value="0" >
                                    <input type="hidden" name="orderid" value="${s.orderID}" >
                                    <input class="cancel" type="submit" value="view">
                                </form>
                            </td>
                            <td>
                                <form action="cancel" method="post">
                                    <input type="hidden" name="sta" value="0">
                                    <input type="hidden" name="orderid" value="${s.orderID}" >
                                    <input class="cancel" type="submit" value="cancel">
                                </form>
                            </td>
                        </tr>
                      </c:forEach>
                    </tbody>
                     
                </table>
            </div>
            </c:if>   
             <c:if test="${requestScope.sta==1 && not empty requestScope.liststatusUser}"> 
            <div class="table-order">
                <table class="table-user">
                 
                    <thead>
                        <tr>
                        <td>No.</td>
                        <td>Order ID</td>                        
                        <td>DateBy</td>
                        <td>Total</td>
                        <td>View</td>
                    </tr>
                    </thead>
                    <tbody id="table-body">
                     <c:set var="t" value="0" />
                     <c:forEach items="${requestScope.liststatusUser}" var="s">
                          <c:set var="t" value="${t+1}" />
                        <tr>
                            <td>${t}</td>
                            <td>
                               ${s.orderID}
                            </td>
                            <td>
                               ${s.dateBuy}
                            </td>
                            <td>${s.total}$</td>
                            <td>
                                <form action="view" method="post">
                                    <input type="hidden" name="status" value="1" >
                                    <input type="hidden" name="orderid" value="${s.orderID}" >
                                    <input class="cancel" type="submit" value="view">
                                </form>
                            </td>
                        </tr>
                      </c:forEach>
                    </tbody>
                     
                </table>
            </div>
            </c:if>                
             <c:if test="${requestScope.sta==2  && not empty requestScope.liststatusUser}"> 
            
             <div class="table-order">
                <table class="table-user">
                    <thead>
                        <tr>
                        <td>No.</td>
                        <td>Order ID</td>                        
                        <td>DateBy</td>
                        <td>Total</td>
                        <td>View</td>
                        
                    </tr>
                    </thead>
                    <tbody id="table-body">
                     <c:set var="t" value="0" />
                     <c:forEach items="${requestScope.liststatusUser}" var="s">
                          <c:set var="t" value="${t+1}" />
                        <tr>
                            <td>${t}</td>
                            <td>
                               ${s.orderID}
                            </td>
                            <td>
                               ${s.dateBuy}
                            </td>
                            <td>${s.total}$</td>
                            <td>
                                <form action="view" method="post">
                                     <input type="hidden" name="status" value="2" >
                                    <input type="hidden" name="orderid" value="${s.orderID}" >
                                    <input class="cancel" type="submit" value="view">
                                </form>
                            </td>
                            
                        </tr>
                      </c:forEach>
                    </tbody>
                </table>
            </div>
            
            </c:if>
            <c:if test="${requestScope.sta==-1  && not empty requestScope.liststatusUser}"> 
            
            <div class="table-order">
                <table class="table-user">
                    <thead>
                        <tr>
                        <td>No.</td>
                        <td>Order ID</td>                        
                        <td>DateBy</td>
                        <td>Total</td>
                        <td>View</td>
                        
                    </tr>
                    </thead>
                    <tbody id="table-body">
                     <c:set var="t" value="0" />
                     <c:forEach items="${requestScope.liststatusUser}" var="s">
                          <c:set var="t" value="${t+1}" />
                        <tr>
                             <td>${t}</td>
                            <td>
                               ${s.orderID}
                            </td>
                            <td>
                               ${s.dateBuy}
                            </td>
                            <td>${s.total}$</td>
                            <td>
                                <form action="view" method="post">
                                    <input type="hidden" name="status" value="-1" >
                                    <input type="hidden" name="orderid" value="${s.orderID}" >
                                    <input class="cancel" type="submit" value="view">
                                </form>
                            </td>
                        </tr>
                      </c:forEach>
                    </tbody>
                    
                </table>
             
            </div>
            
            </c:if>
            <!--VIEW-->
            <c:choose>
            <c:when test="${not empty requestScope.orderid && requestScope.status == 0}"> 
              
            <div class="table-order">
                 <p>Total: ${requestScope.total}$</p>    
                <table class="table-user">
                    <thead>
                    <tr>
                        <td>No.</td>
                        <td>Status</td>
                        <td>OrderID</td>
                        <td>Name</td>                        
                        <td>Image</td>
                        <td>Price</td>
                        <td>Quantity</td>
                        <td>Sub-total</td>
                       
                    </tr>
                    </thead>
                    <tbody id="table-body">
                     <c:set var="t" value="0" />
                     <c:forEach items="${requestScope.viewlist}" var="s">
                          <c:set var="t" value="${t+1}" />
                        <tr>
                            <td>${t}</td>
                            <td>Pending</td>
                            <td>${s.orderID}</td>
                            <td>
                                <a class="status-a"  href="detailproduct?sid=${s.id}"> ${s.name}</a> 
                            </td>
                            <td>
                                <a  href="detailproduct?sid=${s.id}" ><img class="hinhanh" src="${s.imagePath}"></a>  
                            </td>
                            <td>${s.price}$</td>
                            <td>
                               ${s.quantity}
                            </td>
                            <td>
                              ${s.total}$
                            </td>
                           
                        </tr>
                      </c:forEach>
                    </tbody>
                </table>
            </div>
                   
            
            </c:when>
                 <c:when test="${not empty requestScope.orderid && requestScope.status == 1}"> 
           
            <div class="table-order">
                  <p>Total: ${requestScope.total}$</p>    
                <table class="table-user">
                    <thead>
                 
                    <tr>
                        <td>No.</td>
                        <td>Status</td>
                        <td>OrderID</td>
                        <td>Name</td>                        
                        <td>Image</td>
                        <td>Price</td>
                        <td>Quantity</td>
                        <td>Sub-total</td>
                       
                    </tr>
                    </thead>
                    <tbody id="table-body">
                     <c:set var="t" value="0" />
                     <c:forEach items="${requestScope.viewlist}" var="s">
                          <c:set var="t" value="${t+1}" />
                        <tr>
                            <td>${t}</td>
                            <td>In progress</td>
                            <td>${s.orderID}</td>
                            <td>
                                <a class="status-a"  href="detailproduct?sid=${s.id}"> ${s.name}</a> 
                            </td>
                            <td>
                                <a  href="detailproduct?sid=${s.id}" ><img class="hinhanh" src="${s.imagePath}"></a>  
                            </td>
                            <td>${s.price}$</td>
                            <td>
                               ${s.quantity}
                            </td>
                            <td>
                              ${s.total}$
                            </td>
                           
                        </tr>
                      </c:forEach>
                    </tbody>
                </table>
            </div>
                         
            
            </c:when>
            <c:when test="${not empty requestScope.orderid && requestScope.status == 2}"> 
         
            <div class="table-order">
                 <p>Total: ${requestScope.total}$</p>    
                <table class="table-user">
                    <thead>
                    <tr>
                        <td>No.</td>
                        <td>Status</td>
                        <td>OrderID</td>
                        <td>Name</td>                        
                        <td>Image</td>
                        <td>Price</td>
                        <td>Quantity</td>
                        <td>Sub-total</td>
                        
                        <td>Action</td>
                       
                    </tr>
                    </thead>
                    <tbody id="table-body">
                     <c:set var="t" value="0" />
                     <c:forEach items="${requestScope.viewlist}" var="s">
                          <c:set var="t" value="${t+1}" />
                        <tr>
                            <td>${t}</td>
                             <td>Completed</td>
                            <td>${s.orderID}</td>
                            <td>
                                <a class="status-a"  href="detailproduct?sid=${s.id}"> ${s.name}</a> 
                            </td>
                            <td>
                                <a  href="detailproduct?sid=${s.id}" ><img class="hinhanh" src="${s.imagePath}"></a>  
                            </td>
                            <td>${s.price}$</td>
                            <td>
                               ${s.quantity}
                            </td>
                            <td>
                              ${s.total}$
                            </td>
                            
                            <td>
                                <button class="buynow1"><a style="text-decoration: none;" href="detailproduct?sid=${s.id}">Evaluate</a></button>
                            </td>
                        
                        </tr>
                      </c:forEach>
                    </tbody>
                </table>
            </div>
                        
            
            </c:when>
            <c:when test="${not empty requestScope.orderid && requestScope.status == -1}"> 
                
            <div class="table-order">
                 <p>Total: ${requestScope.total}$</p>    
                <table class="table-user">
                    <thead>
                        <tr>
                        <td>No.</td>
                        <td>Status</td>
                        <td>OrderID</td>
                        <td>Name</td>                        
                        <td>Image</td>
                        <td>Price</td>
                        <td>Quantity</td>
                        <td>Sub-total</td>
                        <td>Buy again</td>
                    </tr>
                    </thead>
                    <tbody id="table-body">
                     <c:set var="t" value="0" />
                     <c:forEach items="${requestScope.viewlist}" var="s">
                          <c:set var="t" value="${t+1}" />
                        <tr>
                            <td>${t}</td>
                            <td>Cancel</td>
                            <td>${s.orderID}</td>
                            <td>
                               <a class="status-a"  href="detailproduct?sid=${s.id}"> ${s.name}</a> 
                            </td>
                            <td>
                                <a  href="detailproduct?sid=${s.id}" ><img class="hinhanh" src="${s.imagePath}"></a> 
                            </td>
                            <td>${s.price}$</td>
                            <td>
                               ${s.quantity}
                            </td>
                            <td>
                              ${s.total}$
                            </td>
                             <td>
                                <form action="maincontroller">
                                    <input type="hidden" name="numvalue" value="1" >    
                                    <input type="hidden" name="id" value="${s.id}" >                                   
                                    <button type="submit" name="action1" class="buynow1" value="buynow">Buy Again</button>
                                </form>
                            </td>
                        </tr>
                      </c:forEach>
                    </tbody>
                </table>
            </div>
                        
            
            </c:when>
            </c:choose>
            <!--ITEMS TRỐNG-->
              <c:if test="${requestScope.sta==1  && empty requestScope.liststatusUser}"> 
                <div style=" margin-top: 30px; margin-left: 330px; align-items: center; text-align: center; width: 450px; height: 450px;">
                    <img style="width: 100%; height: 100%;" src="images/istockphoto-1357822304-612x612.jpg" >
                </div>                                       
            </c:if>
             <c:if test="${requestScope.sta==0  && empty requestScope.liststatusUser}"> 
                  <div style="  margin-top: 30px;margin-left: 330px; align-items: center; text-align: center; width: 450px; height: 450px;">
                    <img style="width: 100%; height: 100%;" src="images/istockphoto-1357822304-612x612.jpg" >
                </div>                                      
            </c:if>
             <c:if test="${requestScope.sta==2  && empty requestScope.liststatusUser}"> 
                 <div style=" margin-top: 30px;margin-left: 330px; align-items: center; text-align: center; width: 450px; height: 450px;">
                    <img style="width: 100%; height: 100%;" src="images/istockphoto-1357822304-612x612.jpg" >
                </div>                                     
            </c:if>
             <c:if test="${requestScope.sta==-1  && empty requestScope.liststatusUser}"> 
                  <div style="  margin-top: 30px;margin-left: 330px; align-items: center; text-align: center; width: 450px; height: 450px;">
                    <img style="width: 100%; height: 100%;" src="images/istockphoto-1357822304-612x612.jpg" >
                </div>                                     
            </c:if>
        </div>
        
        
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
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script>
      document.getElementById('${sta}').style.color = "crimson";  
     </script>
<script>
    $(document).ready(function() {
        $('.status a').click(function(event) {
            
            $('.status a').removeClass('highlight');
            $(this).addClass('highlight');
        });
    });
</script>
</body>
</html>
