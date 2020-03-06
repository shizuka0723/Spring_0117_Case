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
                    <h1>Manufacturer</h1>
                    <h2>製造商資料維護</h2>
                </div>
            </div>
            <table>
                <td valign="top">
                    <div class="content">
                        <form:form modelAttribute="manufacturer" class="pure-form" action="${pageContext.request.getContextPath()}/mvc/manufacturer/${action}">
                            <fieldset>
                                <legend> <h2 class="content-subhead">製造商維護</h2></legend>

                                <form:input path="manufacturerId" placeholder="id" readonly="${readonly}" /><p />
                                <form:input path="name" placeholder="名稱" /><p />
                                <form:input path="addressline1" placeholder="地址1" /><p />
                                <form:input path="addressline2" placeholder="地址2" /><p />
                                <form:input path="city" placeholder="city" /><p />
                                <form:input path="state" placeholder="state" /><p />
                                <form:input path="zip" placeholder="zip" /><p />
                                <form:input path="phone" placeholder="phone" /><p />
                                <form:input path="fax" placeholder="fax" /><p />
                                <form:input path="email" placeholder="email" /><p />
                                <form:input path="rep" placeholder="製造商代表" /><p />

                                <button type="submit" class="pure-button pure-button-primary">${action}</button>
                            </fieldset>
                        </form:form>
                    </div>
                </td>    
                <td valign="top">    
                    <div class="content">
                        <form class="pure-form">
                            <fieldset>
                                <legend><h2 class="content-subhead">製造商列表</h2></legend>
                                <table class="pure-table pure-table-bordered">
                                    <thead>
                                        <tr>
                                            <th nowrap>修改</th>
                                            <th nowrap>刪除</th>
                                            <th>manufacturerId</th>
                                            <th>name</th>
                                            <th>addressline1</th>
                                            <th>addressline2</th>
                                            <th>city</th>
                                            <th>state</th>
                                            <th>zip</th>
                                            <th>phone</th>
                                            <th>fax</th>
                                            <th>email</th>
                                            <th>rep</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                        <c:forEach var="item" items="${list}">
                                            <tr>
                                                <td nowrap><a href="${pageContext.request.getContextPath()}/mvc/manufacturer/get/${item.manufacturerId}">修改</a></td>
                                                <td nowrap><a href="${pageContext.request.getContextPath()}/mvc/manufacturer/delete/${item.manufacturerId}">刪除</a></td>
                                                <td>${item.manufacturerId}</td>
                                                <td>${item.name}</td>
                                                <td>${item.addressline1}</td>
                                                <td>${item.addressline2}</td>
                                                <td>${item.city}</td>
                                                <td>${item.state}</td>
                                                <td>${item.zip}</td>
                                                <td>${item.phone}</td>
                                                <td>${item.fax}</td>
                                                <td>${item.email}</td>
                                                <td>${item.rep}</td>
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