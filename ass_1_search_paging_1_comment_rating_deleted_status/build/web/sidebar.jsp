<%-- 
    Document   : sidebar
    Created on : Jun 22, 2023, 7:31:18 PM
    Author     : Tuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<a href="css/index.css"></a>
<div id="category-list">
                <div class="kindDish">
                    <p class="item-menu">Kinds Of Dishes</p>
                    <div class="border"></div>
                    <div class="list-card">
                        <a href="" class="list-name">The whole dish</a>
                    </div>
                    <c:forEach items="${requestScope.listC}" var="c" >
                    <div class="list-card">
                        <a href="" class="list-name">${c.name}</a>
                    </div>                  
                    </c:forEach>
                </div>
                <div class="filter-price">
                    <p class="title-price">Price</p>
                    <div><input type="checkbox" name="" id=""> UNDER $2</div>
                    <div><input type="checkbox" name="" id=""> $2 TO $4</div>
                    <div><input type="checkbox" name="" id=""> ABOVE $4</div>                  
                </div>
                <!--<div class="card">
                     <div class="card-header">Top dishes</div>
                     <div class="card-body">
                         <img class="img-fluid" src="images/chicken/01.jpg" />
                         <h5 class="card-title">Chicken</h5>
                         <p class="card-text">One of the features that differentiate it from most other birds is that it has a comb and two wattles</p>
                         <p class="bloc_left_price">100$</p>
                     </div>
                 </div>       -->
                 
            </div>