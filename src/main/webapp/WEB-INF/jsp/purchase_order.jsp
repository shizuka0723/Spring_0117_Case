<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="en">
    <head>
        <!-- Head -->
        <%@include file="include/head.jspf"  %>
    </head>
    <body>

        <div id="layout">
            <!-- Toggle -->
            <%@include file="include/toggle.jspf"  %>

            <!-- Menu -->
            <%@include file="include/menu.jspf"  %>

            <div id="main">
                <div class="header">
                    <h1>Purchase Order</h1>
                    <h2>採購訂單維護</h2>
                </div>
            </div>
            <table>
                <td valign="top">
                    <div class="content">

                        <form:form modelAttribute="purchaseOrder" class="pure-form" action="${pageContext.request.getContextPath()}/mvc/purchase_order/${action}">
                            <fieldset>
                                <legend><h2 class="content-subhead">商品採購維護</h2></legend>

                                <form:input path="orderNum" placeholder="採購代碼" readonly="${readonly}" /><p />
                                <form:select path="customerId" 
                                             items="${list_c}" 
                                             itemLabel="name" 
                                             itemValue="customerId"/>
                                <p />
                                <form:select path="productId" 
                                             items="${list_p}" 
                                             itemLabel="description" 
                                             itemValue="productId"/>
                                <p />
                                <form:input path="quantity" placeholder="採購數量" /><p />
                                <form:input path="shippingCost" placeholder="運費" /><p />
                                <form:input path="salesDate" placeholder="Sales 日期" value="2020-03-06"/><p />
                                <form:input path="shippingDate" placeholder="Shipping 日期" value="2020-03-06"/><p />
                                <form:input path="freightCompany" placeholder="運輸公司" /><p />

                                <button type="submit" class="pure-button pure-button-primary">${action}</button>
                            </fieldset>
                        </form:form>
                    </div>
                </td>
                <td valign="top">
                    <div class="content">
                        <form class="pure-form">
                            <fieldset>
                                <legend><h2 class="content-subhead">商品代碼列表</h2></legend>
                                <table class="pure-table pure-table-bordered">
                                    <thead>
                                        <tr>
                                            <th nowrap="nowrap">修改</th>
                                            <th nowrap="nowrap">刪除</th>
                                            <th>orderNum</th>
                                            <th>customerId</th>
                                            <th>productId</th>
                                            <th>quantity</th>
                                            <th>shippingCost</th>
                                            <th>salesDate</th>
                                            <th>shippingDate</th>
                                            <th>freightCompany</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                        <c:forEach var="item" items="${list}">
                                            <tr>
                                                <td><a href="${pageContext.request.getContextPath()}/mvc/purchase_order/get/${item.orderNum}">修改</a></td>
                                                <td><a href="${pageContext.request.getContextPath()}/mvc/purchase_order/delete/${item.orderNum}">刪除</a></td>
                                                <td>${item.orderNum}</td>
                                                <td>${item.customerId}</td>
                                                <td>${item.productId}</td>
                                                <td>${item.quantity}</td>
                                                <td>${item.shippingCost}</td>
                                                <td>${item.salesDate}</td>
                                                <td>${item.shippingDate}</td>
                                                <td>${item.freightCompany}</td>
                                            </tr>
                                        </c:forEach>    
                                    </tbody>
                                </table>
                            </fieldset>
                        </form>
                    </div>
                </td>
            </table>
        </div>

        <!-- Foot -->
        <%@include file="include/foot.jspf"  %>

    </body>
</html>