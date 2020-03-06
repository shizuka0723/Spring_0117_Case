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
                    <h1>Product</h1>
                    <h2>商品資料維護</h2>
                </div>
            </div>
            <table>
                <td valign="top">
                    <div class="content">

                        <form:form modelAttribute="product" class="pure-form" action="${pageContext.request.getContextPath()}/mvc/product/${action}">
                            <fieldset>
                                <legend><h2 class="content-subhead">商品維護</h2></legend>

                                <form:input path="productId" placeholder="商品代碼" readonly="${readonly}" /><p />
                                <form:input path="manufacturerId" placeholder="製造商ID"/><p/>
                                <form:select path="manufacturerId" 
                                             items="${list_mf}" 
                                             itemLabel="name" 
                                             itemValue="manufacturerId"/>
                                <p />
                                <form:select path="productCode" 
                                             items="${list_pc}" 
                                             itemLabel="label" 
                                             itemValue="prodCode"/>
                                <p />
                                <form:input path="purchaseCost" placeholder="商品成本" /><p />
                                <form:input path="quantityOnHand" placeholder="商品數量" /><p />
                                <form:input path="markup" placeholder="markup" /><p />
                                <form:input path="available" placeholder="商品是否足夠" /><p />
                                <form:input path="description" placeholder="商品描述" /><p />

                                <button type="submit" class="pure-button pure-button-primary">${action}</button>
                            </fieldset>
                        </form:form>
                    </div>
                </td>
                <td valign="top">
                    <div class="content">
                        <form class="pure-form">
                            <fieldset>
                                <legend><h2 class="content-subhead">商品列表</h2></legend>
                                <table class="pure-table pure-table-bordered">
                                    <thead>
                                        <tr>
                                            <th nowrap="nowrap">修改</th>
                                            <th nowrap="nowrap">刪除</th>
                                            <th>productId</th>
                                            <th>manufacturerId</th>
                                            <th>productCode</th>
                                            <th>purchaseCost</th>
                                            <th>quantityOnHand</th>
                                            <th>markup</th>
                                            <th>available</th>
                                            <th>description</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                        <c:forEach var="item" items="${list}">
                                            <tr>
                                                <td><a href="${pageContext.request.getContextPath()}/mvc/product/get/${item.productId}">修改</a></td>
                                                <td><a href="${pageContext.request.getContextPath()}/mvc/product/delete/${item.productId}">刪除</a></td>
                                                <td>${item.productId}</td>
                                                <td>${item.manufacturerId}</td>
                                                <td>${item.productCode}</td>
                                                <td>${item.purchaseCost}</td>
                                                <td>${item.quantityOnHand}</td>
                                                <td>${item.markup}</td>
                                                <td>${item.available}</td>
                                                <td nowrap="nowrap">${item.description}</td>
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