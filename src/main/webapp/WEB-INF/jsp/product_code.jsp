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
                    <h1>Product Code</h1>
                    <h2>商品分類維護</h2>
                </div>
            </div>
            <table>
                <td valign="top">
                    <div class="content">

                        <form:form modelAttribute="productCode" class="pure-form" action="${pageContext.request.getContextPath()}/mvc/product_code/${action}">
                            <fieldset>
                                <legend><h2 class="content-subhead">商品代碼維護</h2></legend>

                                <form:input path="prodCode" placeholder="商品代碼" readonly="${readonly}" /><p />
                                <form:select path="discountCode" 
                                             items="${list_dc}" 
                                             itemLabel="label" 
                                             itemValue="discountCode"/>
                                <p />
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
                                <legend><h2 class="content-subhead">商品代碼列表</h2></legend>
                                <table class="pure-table pure-table-bordered">
                                    <thead>
                                        <tr>
                                            <th nowrap>修改</th>
                                            <th nowrap>刪除</th>
                                            <th>prodCode</th>
                                            <th>discountCode</th>
                                            <th>description</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                        <c:forEach var="item" items="${list}">
                                            <tr>
                                                <td nowrap><a href="${pageContext.request.getContextPath()}/mvc/product_code/get/${item.prodCode}">修改</a></td>
                                                <td nowrap><a href="${pageContext.request.getContextPath()}/mvc/product_code/delete/${item.prodCode}">刪除</a></td>
                                                <td>${item.prodCode}</td>
                                                <td>${item.discountCode}</td>
                                                <td>${item.description}</td>
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