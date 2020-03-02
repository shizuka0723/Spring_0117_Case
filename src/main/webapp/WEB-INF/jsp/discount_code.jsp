<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                    <h1>Discount Code</h1>
                    <h2>折扣碼維護</h2>
                </div>
            </div>

            <div class="information pure-g">
                <div class="pure-u-1 pure-u-md-1-2">
                    <div class="l-box">
                        <div class="content">
                            <form:form modelAttribute="discountCode" class="pure-form" action="${pageContext.request.getContextPath()}/mvc/discount_code/${action}">
                                <fieldset>
                                    <legend><h2 class="content-subhead">折扣碼維護</h2></legend>

                                    <form:input path="discountCode" placeholder="折扣代號" readonly="${readonly}" /><p />
                                    <form:input path="rate" placeholder="折扣" /><p />

                                    <button type="submit" class="pure-button pure-button-primary">${action}</button>
                                </fieldset>
                            </form:form>
                        </div>
                    </div>
                </div>

                <div class="pure-u-1 pure-u-md-1-2">
                    <div class="l-box">
                        <div class="content">
                            <form class="pure-form">
                                <fieldset>
                                    <legend><h2 class="content-subhead">折扣碼列表</h2></legend>
                                    <table class="pure-table pure-table-bordered">
                                        <thead>
                                            <tr>
                                                <th>修改</th>
                                                <th>刪除</th>
                                                <th>discountCode</th>
                                                <th>rate</th>
                                            </tr>
                                        </thead>

                                        <tbody>
                                            <c:forEach var="item" items="${list}">
                                                <tr>
                                                    <td><a href="${pageContext.request.getContextPath()}/mvc/discount_code/get/${item.discountCode}"> 按我修改 </a></td>
                                                    <td><a href="${pageContext.request.getContextPath()}/mvc/discount_code/delete/${item.discountCode}"> 按我刪除 </a></td>
                                                    <td>${item.discountCode}</td>
                                                    <td>${item.rate}</td>
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

            <!-- Foot -->
            <%@include file="include/foot.jspf"  %>
        </div>
    </body>
</html>