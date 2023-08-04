<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Food website</title>
        <link rel="stylesheet" href="css/descripItem.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://fonts.googleapis.com/css?family=Karla" rel="stylesheet">
        <link rel="stylesheet" href="css/topdishes.css"> 
        <link rel="stylesheet" href="css/filterPrice.css">
        <link rel="stylesheet" href="css/hienlen.css">
        <link rel="stylesheet" href="css/footerdetail.css">
        <link rel="stylesheet" href="css/cartItem.css">
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
        <div style="background-color: whitesmoke;" id="container" class="container">

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
                <%
                    double avgRating = (double) request.getAttribute("avgRating");
                    int roundedRating = (int) Math.round(avgRating);
                %>

                <div id="food-items-description" >
                    <!--description item-->                   
                    <div id="item-card-description">
                        <div class="img-background">
                            <img src="${requestScope.item.getImagePath()}" alt="">
                        </div>
                        <div class="descript-item">
                            <p id="item-name-de">${requestScope.item.getName()}</p>
                            <p id="item-price-de">Price: $${requestScope.item.getPrice()}</p>

                            <p style="font-weight: bold;">Rating: <%=roundedRating%>/5 </p> 
                            <p><c:forEach begin="1" end="<%=roundedRating%>">
                                <div class="hinh_ngoi_sao " style="display:inline-block; "></div>
                            </c:forEach>
                            <c:forEach begin="<%=roundedRating + 1%>" end="5">
                                <div class="hinh_ngoi_sao2 " style="display:inline-block; "></div>
                            </c:forEach></p>                         
                            <div style="font-size: 25px;">Sold: ${requestScope.totalquantity}</div>
                            <p id="descript">${requestScope.item.getDesciption()}</p>


                            <div class="quantity-div">
                                <p>Quantity</p>
                                <form id="quantityForm" action="maincontroller">
                                    <button type="button" id="decreaseBtn">-</button>
                                    <input type="number" id="quantityValue" class="quantity" value="1" readonly name="numvalue"/>
                                    <button type="button" id="increaseBtn">+</button>
                                    <div>
                                        <input type="hidden" class="addToCard-de" name="id" value="${requestScope.item.getId()}"/>
                                        <button type="submit" name="action1" class="buynow" value="addtocart">Add to card</button>

                                    </div>
                                    <div class="add">
                                        <!--                                 <form class="add-quantity" action="buynow">-->
                                        <input type="hidden" class="addToCard-de"></input>
                                        <button type="submit" name="action1" class="buynow1" value="buynow">Buy now</button>
                                        <!--</form>-->
                                    </div>
                                </form>

                            </div>


                        </div>


                    </div>

                    <!--</div>--> 
                    <div class="comment">

                    </div>
                </div>
                <div style="margin-left: 30px;">
                    <p style="margin-top: 50px;" class="feedback">Feedback</p>
                    <c:choose> 
                        <c:when test="${sessionScope.account==null}"><p style="font-size: 120%; color:red;">Login to rating</p></c:when>
                        <c:when test="${requestScope.checkBought==false}"><p style="font-size: 120%; color:red;">You need to buy this product to comment and rating</p></c:when>
                        <c:when test="${requestScope.yourComment!=null}"><div ><p style="color:black; font-size: 180%; color:rgb(220, 119, 51); margin-bottom: 0; ">Your Rating: </p>
                                <div class="khung-comment" style="margin-top:0;">
                                    <p class="username-comment">${requestScope.yourComment.getUsername()}</p>
                                    <p><c:forEach begin="1" end="${requestScope.yourComment.getStar()}"><div class="hinh_ngoi_sao" style="display:inline-block"></div></c:forEach>
                                        <c:forEach begin="${requestScope.yourComment.getStar()+1}" end="5"><div class="hinh_ngoi_sao2" style="display:inline-block"></div></c:forEach></p>
                                    <p style="padding-left: 10px;">${requestScope.yourComment.getContent()}</p>

                                </div>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <form id="comment-form" action="ratingInsert">
                                <input type="hidden" name="sid" value="${requestScope.item.getId()}">
                                <input type="hidden" name="accountID" value="${sessionScope.account.getId()}">
                                <input type="hidden" name="accountName" value="${sessionScope.account.getUsername()}">
                                <div class="form-group">
                                    <label for="rating">Rating: </label>
                                    <div class="rating">
                                        <input type="radio" id="star1" name="rating" value="5" required>
                                        <label for="star1"></label>
                                        <input type="radio" id="star2" name="rating" value="4" required>
                                        <label for="star2"></label>
                                        <input type="radio" id="star3" name="rating" value="3" required>
                                        <label for="star3"></label>
                                        <input type="radio" id="star4" name="rating" value="2" required>
                                        <label for="star4"></label>
                                        <input type="radio" id="star5" name="rating" value="1" required>
                                        <label for="star5"></label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="comment">Comment:</label>
                                    <input id="comment" name="comment" rows="4" required/>
                                </div>
                                <button type="submit" class="submit">Submit</button>

                            </form></c:otherwise>

                    </c:choose>
                    <c:choose>
                        <c:when test="${empty requestScope.listR}">
                            <p style="color:black; font-size: 150%; color:rgb(220, 119, 51); margin-bottom: 0;">No comment in this product</p>
                        </c:when>
                        <c:otherwise>
                            <p style="color:black; font-size: 150%; color:rgb(220, 119, 51); margin-bottom: 0;">Other comments:</p>
                        </c:otherwise>
                    </c:choose>
                    <div class="scrollable-comments">
                        <c:forEach items="${requestScope.listR}" var="o">
                            <div class="khung-comment">
                                <p class="username-comment">${o.getUsername()}</p>
                                <p><c:forEach begin="1" end="${o.getStar()}"><div class="hinh_ngoi_sao" style="display:inline-block"></div></c:forEach>
                                <c:forEach begin="${o.getStar()+1}" end="5">
                                    <div class="hinh_ngoi_sao2 " style="display:inline-block; "></div>
                                </c:forEach></p>
                                <p style="padding-left: 10px;">${o.getContent()}</p>

                            </div>

                        </c:forEach>
                    </div>
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
        </div>
        <script src="" type="module"></script>
        <script>
            // Get references to the HTML elements
            const decreaseBtn = document.getElementById('decreaseBtn');
            const increaseBtn = document.getElementById('increaseBtn');
            const quantityValue = document.getElementById('quantityValue');

            // Event listener for the decrease button
            decreaseBtn.addEventListener('click', () => {
                let quantity = parseInt(quantityValue.value);
                if (quantity > 1) {
                    quantity--;
                    quantityValue.value = quantity;
                }
            });

            // Event listener for the increase button
            increaseBtn.addEventListener('click', () => {
                let quantity = parseInt(quantityValue.value);
                quantity++;
                quantityValue.value = quantity;
            });
        </script>
    </body>
</html>