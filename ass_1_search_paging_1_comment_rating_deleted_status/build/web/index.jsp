<%-- 
    Document   : index
    Created on : May 24, 2023, 11:17:34 AM
    Author     : Tuan
--%>

<%@page import="java.util.List"%>
<%@page import="model.Items"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Food website</title>
    
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css?family=Karla" rel="stylesheet">
    <link rel="stylesheet" href="css/topdishes.css">
    <link rel="stylesheet" href="css/filterPrice.css">
    <link rel="stylesheet" href="css/alert.css">
    <link rel="stylesheet" href="css/hienlen.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/starrating.css">
    
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Pangolin&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Pangolin&family=Roboto+Mono:wght@300&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Pangolin&family=Roboto+Mono:wght@300&family=Ysabeau:wght@1;300&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Pangolin&family=Roboto+Mono:wght@300&family=Secular+One&family=Ysabeau:wght@1;300&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Alfa+Slab+One&family=Pangolin&family=Roboto+Mono:wght@300&family=Secular+One&family=Ysabeau:wght@1;300&display=swap" rel="stylesheet">
    <script type="text/javascript">
         function setCheck1(obj){
             var fries = document.getElementsByName('price');
             if((obj.id==='g0') && (fries[0].checked===true)){
                 for(var i = 1; i < fries.length; i++){
                     fries[i].checked=false;
                 }
             }
             else{
                 for(var i = 1; i < fries.length; i++){
                     if(fries[i].checked===true){
                         fries[0].checked=false;
                         break;
                     }
                 }
             }
             document.getElementById('f2').submit();
         }
     </script>
     <style>
      .het-hang {
    position: fixed;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    z-index: 9999;
    background-color: #f8d7da;
    color: #721c24;
    padding: 10px;
    border: 1px solid #f5c6cb;
}
    
     </style>
</head>
<body>
   
    <!--Desktop view-->
    <div id="container" class="container">
        <div id="cart">
            <div class="icon">
                <img src="images/Artboard 1.png" alt="list">
            </div>
            <div id="category-list">
                <div class="kindDish">
                    <p class="item-menu">Kinds Of Dishes</p>
                    <div class="border"></div>
                    <div class="list-card">
                        <a id="${0}" href="list?action=filter&cid=0" class="list-name">The whole dish</a>
                    </div>
                    <c:forEach items="${requestScope.listC}" var="i">
                        <div class="list-card">
                            <a id="${i.id}" href="ListCatogoriesServlet?cid=${i.id}" class="list-name ${cid == i.id ? "active":""}">${i.name}</a>
                         </div>   
                    </c:forEach>
                                   
                   
                </div>
                    
                   
                 <div class="filter-price">
                    <p class="title-price">Price</p>
                    <c:set var="pb" value="${requestScope.pb}"/>
                     <c:set var="pp" value="${requestScope.pp}"/>
                    <form id="f2" action="home1">
                        <div>
                            <input type="radio" name="price" id="g0"
                            ${pb[0]?"checked":""}
                            value="0" onclick="setCheck1(this)"
                                   > ALL
                        </div>
                            <c:forEach begin="0" end="${2}" var="i">
                                 <div><input type="radio" name="price" id="g1"                                                           
                                  ${pb[i+1]?"checked":""}
                                   value="${(i+1)}"
                                  onclick="setCheck1(this)"
                                             >${pp[i]}</div>                            
                            </c:forEach>
                       
                    </form>                 
                </div>
          
                 
            </div>
       
         </div>
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
            <div class="menu-background">
                <div class="slideshow-container">
                    <img src="images/menu-desktop-top-2x-1-w2732h822.jpg" alt="" class="slide active" >
                    <img src="images/banner2.jpg" alt="" class="slide">
                    <img src="images/banner3.jpg" alt="" class="slide">
                    <img src="images/banner4.jpg" alt="" class="slide">
                    <img src="images/banner5.jpg" alt="" class="slide">
                  </div>
                 
            </div>
            <div class="card">
                <div class="card-header">Top dishes</div>
               
                <c:forEach items="${requestScope.listtop4}" var="top4"> 
                <div id="item-card1">                       
                    <a href="detailproduct?sid=${top4.itemID}">  <img src="${top4.imagePath}" alt=""> </a>
                    <p id="item-name1"><a href="detailproduct?sid=${top4.itemID}">${top4.name}</a></p>
                    <div class="price-quantity1">
                        <p id="item-price1">Price : $${top4.price}</p>
                        <div class="line1"></div>
                        <p id="item-quantity1">Quantity sold: ${top4.totalquantity}</p>
                        <p><c:forEach begin="1" end="${top4.star}">
                                <div class="hinh_ngoi_sao " style="display:inline-block; "></div>
                       </c:forEach>
                        <c:forEach begin="${top4.star+1}" end="5">
                                <div class="hinh_ngoi_sao2 " style="display:inline-block; "></div>
                         </c:forEach>    
                       </p>
                    </div>
                      <c:choose>
                                <c:when test="${requestScope.action eq 'search'}"><c:set var="o" value="&search=${requestScope.searcht}" scope="request"></c:set></c:when>
                                <c:when test="${requestScope.action eq 'filter'}"><c:set var="o" value="&cid=${requestScope.cid}" scope="request"></c:set></c:when>
                                <c:when test="${requestScope.action eq 'checkbox'}"><c:set var="o" value="&price=${requestScope.price}" scope="request"></c:set></c:when>
                          </c:choose>     
                        <a class="addToCard1" href="buy?id=${top4.itemID}&action=${requestScope.action}${o}&num=${num}">Add to cart</a>  
                   
                </div>
                </c:forEach>  
               
            </div>  
            <div class="list-product">
                <p>-----------List Dishes-----------</p>
                
            </div>
                 <% if (request.getAttribute("hetHang") != null && (int) request.getAttribute("hetHang") == 0) { %>
                    <div class="alert-het-hang">
                        <div class="message">Out of stock <i class="fa fa-times"></i></div>
                        <span class="close-btn">&times;</span>
                    </div>
                <% } %>
                <% if (request.getAttribute("success") != null && (int) request.getAttribute("success") == 1) { %>
                    <div class="alert-het-hang">
                        <div class="message">Successfully <i class="fa fa-check"></i></div>
                        <span class="close-btn">&times;</span>
                    </div>
                <% } %>
            <div id="food-items" >
                 <!--<div id="biryani">-->
                  <c:forEach items="${requestScope.listItems}" var="i" >
                      
                          <input type="hidden" name="sid" value="${i.getId()}">
                    <div id="item-card">
                        <form action="detailproduct" method="post">
                        <img src="${i.imagePath}" alt="" href="detailproduct?sid=${i.getId()}">
                        <p id="item-name"><a href="detailproduct?sid=${i.getId()}">${i.name}</a></p>
                        <p id="item-price">Price : ${i.price}</p>
                         <c:choose>
                                <c:when test="${requestScope.action eq 'search'}"><c:set var="o" value="&search=${requestScope.searcht}" scope="request"></c:set></c:when>
                                <c:when test="${requestScope.action eq 'filter'}"><c:set var="o" value="&cid=${requestScope.cid}" scope="request"></c:set></c:when>
                                <c:when test="${requestScope.action eq 'checkbox'}"><c:set var="o" value="&price=${requestScope.price}" scope="request"></c:set></c:when>
                          </c:choose>     
                        <a class="addToCard" href="buy?id=${i.id}&action=${requestScope.action}${o}&num=${num}">Add to cart</a>  
                        </form>
                    </div>
                    
                  </c:forEach>   
                
              <!--</div>--> 

            </div>
                            <c:choose>
                                <c:when test="${requestScope.action eq 'search'}"><c:set var="o" value="&search=${requestScope.searcht}" scope="request"></c:set></c:when>
                                <c:when test="${requestScope.action eq 'filter'}"><c:set var="o" value="&cid=${requestScope.cid}" scope="request"></c:set></c:when>
                                <c:when test="${requestScope.action eq 'checkbox'}"><c:set var="o" value="&price=${requestScope.price}" scope="request"></c:set></c:when>
                            </c:choose>     
                <div class="paging-container">
                    <c:forEach begin="1" end="${requestScope.endP}" var="e" >
                            <div class="paging">
                                <a id="${e}" class="num-paging" href="list?num=${e}&action=${requestScope.action}${o}">${e}</a>
                             </div>
                    </c:forEach>
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
           
        </div>
    </div>
            <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
            <script>
                $(document).ready(function() {
                    $(".close-btn").click(function() {
                        $(".alert-het-hang").hide();
                    });
                });
            </script>
          
        
       <script>
      document.getElementById('${num}').style.color = "white";  
     </script>
    <script>
      document.getElementById('${index}').style.color = "white";  
     </script>
      <script>
      document.getElementById('${cid}').style.color = "orange";  
     
     </script>
  
    <script src="" type="module"></script>
    <script src="alert.js"></script>
    <script>
        var slides = document.querySelectorAll(".slide");
        var currentIndex = 0;
      
        function changeSlide() {
          slides[currentIndex].classList.remove("active");
          slides[currentIndex].classList.add("next");
          currentIndex = (currentIndex + 1) % slides.length;
          slides[currentIndex].classList.add("active");
          slides[currentIndex].classList.remove("next");
        }
      
        setInterval(changeSlide, 3000); // Change slide every 3 seconds
      </script>
    
      
</body>
</html>
