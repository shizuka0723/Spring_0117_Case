<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
    <head>
        <!-- Head -->
        <%@include file="include/head.jspf"  %>
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript">
            google.charts.load('current', {'packages': ['corechart','table']});
            google.charts.setOnLoadCallback(drawTable_1);
            google.charts.setOnLoadCallback(drawTable_2);
            google.charts.setOnLoadCallback(drawChart_1);
            google.charts.setOnLoadCallback(drawChart_2);
            function drawTable_1() {
                var data = new google.visualization.DataTable();
                data.addColumn('number', 'ID');
                data.addColumn('string', 'Name');
                data.addColumn('number', 'Subtotal');
                data.addRows([
                    <c:forEach var="item" items="${list_customers}">
                    [${item.customerId}, '${item.customerName}', {v: ${item.subtotal}, f: '$<fmt:formatNumber type="number" maxFractionDigits="0" value="${item.subtotal}" />'}],
                    </c:forEach>
                ]);
                var table = new google.visualization.Table(document.getElementById('table_div_1'));
                table.draw(data, {showRowNumber: true, width: '900px', height: '500px'});
            }
            function drawTable_2() {
            var data = new google.visualization.DataTable();
                data.addColumn('number', 'ID');
                data.addColumn('string', 'Name');
                data.addColumn('string', 'CodeName');
                data.addColumn('number', 'quantity');
                data.addRows([
                    <c:forEach var="item" items="${list_products}">
                    [${item.productId}, '${item.productName}','${item.productCodeName}', ${item.quantity}],
                    </c:forEach>
                ]);
                var table = new google.visualization.Table(document.getElementById('table_div_2'));
                table.draw(data, {showRowNumber: true, width: '900px', height: '500px'});
            }
            function drawChart_1() {
                var data = google.visualization.arrayToDataTable([
                    ['name', 'subtotal'],
                    <c:forEach var="item" items="${list_customers}">
                        ['${item.customerName}', ${item.subtotal}],
                    </c:forEach>
                ]);
                var options = {
                    title: '顧客消費分析-金額(US)'
                };
                var chart = new google.visualization.BarChart(document.getElementById('chart_div_1'));
                chart.draw(data, options);
            }
            function drawChart_2() {
                var data = google.visualization.arrayToDataTable([
                    ['name', 'subtotal'],
                    <c:forEach var="item" items="${list_products}">
                        ['${item.productName}', ${item.quantity}],
                    </c:forEach>
                ]);
                var options = {
                    title: '商品銷售分析-數量',
                    is3D:true,
                };
                var chart = new google.visualization.PieChart(document.getElementById('chart_div_2'));
                chart.draw(data, options);
            }
            
        </script>
    </head>
    <body>

        <div id="layout">
            <!-- Toggle -->
            <%@include file="include/toggle.jspf"  %>

            <!-- Menu -->
            <%@include file="include/menu.jspf"  %>

            <div id="main">
                <div class="header">
                    <h1>Report</h1>
                    <h2>報表分析</h2>
                </div>
            </div>

            <div class="information pure-g">
                <div class="pure-u-1 pure-u-md-1-2">
                    <div class="l-box">
                        <div class="content">
                            <form class="pure-form">
                                <fieldset>
                                    <legend><h2 class="content-subhead">顧客消費-金額</h2></legend>
                                    <table class="pure-table pure-table-bordered">
                                        <thead>
                                            <tr>
                                                <th nowrap>Id</th>
                                                <th nowrap>Name</th>
                                                <th nowrap>subtotal</th>
                                            </tr>
                                        </thead>

                                        <tbody>
                                            <c:forEach var="item" items="${list_customers}">
                                                <tr>
                                                    <td nowrap>${item.customerId}</td>
                                                    <td nowrap>${item.customerName}</td>
                                                    <td nowrap align="right">${item.subtotal}</td>
                                                </tr>
                                            </c:forEach>    
                                        </tbody>
                                    </table>
                                </fieldset>
                            </form>
                            
                        </div>
                    </div>
                </div>

                <div class="pure-u-1 pure-u-md-1-2">
                    <div class="l-box">
                        <div class="content">
                            <form class="pure-form">
                                <fieldset>
                                    <legend><h2 class="content-subhead">商品銷售-數量</h2></legend>
                                    <table class="pure-table pure-table-bordered">
                                        <thead>
                                            <tr>
                                                <th nowrap>Id</th>
                                                <th nowrap>Name</th>
                                                <th nowrap>CodeName</th>
                                                <th nowrap>quantity</th>
                                            </tr>
                                        </thead>

                                        <tbody>
                                            <c:forEach var="item" items="${list_products}">
                                                <tr>
                                                    <td nowrap>${item.productId}</td>
                                                    <td nowrap>${item.productName}</td>
                                                    <td nowrap>${item.productCodeName}</td>
                                                    <td nowrap align="right">${item.quantity}</td>
                                                </tr>
                                            </c:forEach>    
                                        </tbody>
                                    </table>
                                </fieldset>
                            </form>
                            
                        </div>
                    </div>
                </div>
                <!-- end information -->
            </div>
            <!-- Report Chart -->
            <div class="content">
                <div id="table_div_1" ></div>
                <div id="table_div_2" ></div>
                <div id="chart_div_1" style="width: 900px; height: 500px;"></div>
                <div id="chart_div_2" style="width: 900px; height: 500px;"></div>
            </div>
            <!-- Foot -->
            <%@include file="include/foot.jspf"  %>
        </div>
    </body>
</html>