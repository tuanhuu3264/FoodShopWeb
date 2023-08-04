<%-- 
    Document   : DashBoard
    Created on : Jun 12, 2023, 11:21:25 AM
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
        <link rel="stylesheet" href="/dist/apexcharts.css">    
        <link rel="stylesheet" href="css/dashboard.css">
        <title>Document</title>
    </head>
    <body>
        <div class="container">
            <div class="float-left">
                <div class="logo"><img class="image-logo" src="images/no background.png" alt=""></div>
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
                <div style="display: flex;">
                    <div style="width: 60%;">
                        <div class="list-box">
                            <div class="boxDash">
                                <h2>Day's Revenue</h2>
                                <p style="font-size: 150%; font-weight: bold;">${requestScope.dayrevenue}</p>
                            </div>
                            <div class="boxDash">
                                <h2>Year's Revenue</h2>
                                <p style="font-size: 150%; font-weight: bold;">${requestScope.yearrevenue}</p>
                            </div>
                        </div>
                        <div class="list-box" style="margin-top: 5%;">
                            <div class="boxDash">
                                <h2>Month's Revenue</h2>
                                <p style="font-size: 150%; font-weight: bold;">${requestScope.monthrevenue}</p>
                            </div>
                            <div class="boxDash">
                                <h2>Month's Refused</h2>
                                <p style="font-size: 150%; font-weight: bold;">${requestScope.refusedOrder}</p>
                            </div>
                        </div>
                    </div>
                    <div class="chart-card" style="width:80%; margin-top:10%;"> 
                        <div id="columnChart"></div>
                    </div>
                </div>


                <form id="revenueForm" action="dashboard" method="post">
                    <select name="revenue" onchange="submitForm()" style="margin-left: 5%; width: 10%; height: 30px;">
                        <option value="Month" ${checkSelect eq 'Month' ? 'selected' : ''}>Month</option>
                        <option value="Day" ${checkSelect eq 'Day' ? 'selected' : ''}>Day</option>
                    </select>
                </form>
                </form>
                <div class="charts" style="justify-content: center; ">
                    <div class="chart-card" style="width:100%;">
                        <div id="areaChart" ></div>
                    </div>
                </div>
            </div>

        </div>
        <script src="https://cdn.jsdelivr.net/npm/apexcharts"></script>
        <script>
                        var data = [];
            <c:forEach items="${requestScope.Tlist}" var="o">
                        var item = {
                            name: '${o.getName()}',
                            quantity: ${o.getQuantity()}
                        };
                        data.push(item);
            </c:forEach>

                        var quantities = data.map(function (item) {
                            return item.quantity;
                        });

                        var names = data.map(function (item) {
                            return item.name;
                        });

                        // Define an array of colors for each bar
                        var colors = ['#093759', '#34a853', '#d62d20', '#ffa700', '#4285f4'];

                        var options = {
                            series: [{
                                    name: 'Product',
                                    data: quantities
                                }],
                            chart: {
                                type: 'bar',
                                height: 350
                            },
                            plotOptions: {
                                bar: {
                                    horizontal: false,
                                    columnWidth: '55%',
                                    endingShape: 'rounded'
                                },
                            },
                            dataLabels: {
                                enabled: false
                            },
                            stroke: {
                                show: true,
                                width: 2,
                                colors: ['transparent']
                            },
                            xaxis: {
                                categories: names
                            },
                            yaxis: {
                                title: {
                                    text: 'Number Items'
                                }
                            },
                            title: {
                                text: 'Top 5 Products Bought',
                                align: 'left'
                            },
                            fill: {
                                colors: colors, // Use the defined array of colors
                                opacity: 1
                            },
                            tooltip: {
                                y: {
                                    formatter: function (val) {
                                        return  val + " Items";
                                    }
                                }
                            }
                        };

                        var chart = new ApexCharts(document.querySelector("#columnChart"), options);
                        chart.render();

                        // ---------Dashboard2------------//
                        var data2 = [];
            <c:forEach items="${requestScope.revenues}" var="o">
                        var revenue = {
                            time: '${ o.getTime()}',
                            money: ${o.getMoney()}
                        };
                        data2.push(revenue);
            </c:forEach>

                        var Times = data2.map(function (revenue) {
                            return revenue.time;
                        });

                        var Money = data2.map(function (revenue) {
                            return revenue.money;
                        });

                        var options2 = {
                            series: [{
                                    name: "Money($)",
                                    data: Money
                                }],
                            chart: {
                                height: 350,
                                type: 'line',
                                zoom: {
                                    enabled: false
                                }
                            },
                            dataLabels: {
                                enabled: false
                            },
                            stroke: {
                                curve: 'straight',
                                colors: ['#093759'] // Set purple color for the line
                            },
                            title: {
                                text: '${requestScope.titleDashBoard}',
                                align: 'left'
                            },
                            grid: {
                                row: {
                                    colors: ['#f3f3f3', 'transparent'],
                                    opacity: 0.5
                                }
                            },
                            xaxis: {
                                categories: Times
                            }
                        };

                        var chart2 = new ApexCharts(document.querySelector("#areaChart"), options2);
                        chart2.render();

        </script>
        <script>
            function submitForm() {
                document.getElementById("revenueForm").submit(); // Submit the form when an option is selected

            }


            ;
        </script>
    </body>
</html>