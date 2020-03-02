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
                    <h1>Micro Market</h1>
                    <h2>市場區域維護</h2>
                </div>
            </div>

            <div class="information pure-g">
                <div class="pure-u-1 pure-u-md-1-2">
                    <div class="l-box">
                        <div class="content">
                            <form:form modelAttribute="microMarket" class="pure-form" action="${pageContext.request.getContextPath()}/mvc/micro_market/${action}">
                                <fieldset>
                                    <legend> <h2 class="content-subhead">市場區域維護</h2></legend>

                                    <form:input path="zipCode" placeholder="區域碼" readonly="${readonly}" /><p />
                                    <form:input path="radius" placeholder="區域半徑" /><p />
                                    <form:input path="areaLength" placeholder="區域長度" /><p />
                                    <form:input path="areaWidth" placeholder="區域寬度" /><p />

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
                                    <legend><h2 class="content-subhead">市場區域列表</h2></legend>
                                    <table class="pure-table pure-table-bordered">
                                        <thead>
                                            <tr>
                                                <th nowrap>修改</th>
                                                <th nowrap>刪除</th>
                                                <th>zipCode</th>
                                                <th>radius</th>
                                                <th>areaLength</th>
                                                <th>areaWidth</th>
                                            </tr>
                                        </thead>

                                        <tbody>
                                            <c:forEach var="item" items="${list}">
                                                <tr>
                                                    <td nowrap><a href="${pageContext.request.getContextPath()}/mvc/micro_market/get/${item.zipCode}">修改</a></td>
                                                    <td nowrap><a href="${pageContext.request.getContextPath()}/mvc/micro_market/delete/${item.zipCode}">刪除</a></td>
                                                    <td>${item.zipCode}</td>
                                                    <td>${item.radius}</td>
                                                    <td>${item.areaLength}</td>
                                                    <td>${item.areaWidth}</td>
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

        </div>

        <!-- Foot -->
        <%@include file="include/foot.jspf"  %>

    </body>
</html>