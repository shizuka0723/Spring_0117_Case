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
                    <h1>Customer</h1>
                    <h2>客戶資料維護</h2>
                </div>
            </div>
            <table>
                <td valign="top">
                    <div class="content">
                        <form:form modelAttribute="customer" class="pure-form" action="${pageContext.request.getContextPath()}/mvc/customer/${action}" method="post">
                            <fieldset>
                                <legend>
                                    <h2 class="content-subhead">客戶資料維護</h2>
                                </legend>
                                <table>
                                    <tr>
                                        <td valign="top" style="padding: 5px"> 
                                            <form:input path="customerId" placeholder="客戶 id" readonly="${readonly}"/><p/>
                                            <form:select
                                                path="discountCode"
                                                items="${list_dc}"
                                                itemLabel="label"
                                                itemValue="discountCode"
                                                />
                                            <p />
                                            <form:select
                                                path="zip"
                                                items="${list_mm}"
                                                itemLabel="zipCode"
                                                itemValue="zipCode"
                                                />
                                            <p />
                                            <form:input path="name" placeholder="客戶名稱" />
                                        </td>
                                        <td valign="top" style="padding: 5px">
                                            <form:input path="addressline1" placeholder="地址1" /><p/>
                                            <form:input path="addressline2" placeholder="地址2" /><p/>
                                            <form:input path="city" placeholder="城市" /><p/>
                                            <form:input path="state" placeholder="地區/州" />
                                        </td>
                                        <td valign="top" style="padding: 5px">
                                            <form:input path="phone" placeholder="電話" /><p/>
                                            <form:input path="fax" placeholder="傳真" /><p/>
                                            <form:input path="email" placeholder="電子郵件" /><p/>
                                            <form:input path="creditLimit" placeholder="信用額度" type="number" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="3">
                                            <button type="submit" class="pure-button pure-button-primary">${action}</button>
                                        </td>
                                    </tr>
                                </table>
                            </fieldset>
                        </form:form>
                    </div>    
                    <div class="content">
                        <form class="pure-form">
                            <fieldset>
                                <legend><h2 class="content-subhead">客戶資料列表</h2></legend>

                                <table class="pure-table pure-table-bordered">
                                    <thead>
                                        <tr>
                                            <th nowrap="nowrap">修改</th>
                                            <th nowrap="nowrap">刪除</th>
                                            <th>customerId</th>
                                            <th>discountCode</th>
                                            <th>zip</th>
                                            <th>name</th>
                                            <th>addressline1</th>
                                            <th>addressline2</th>
                                            <th>city</th>
                                            <th>state</th>
                                            <th>phone</th>
                                            <th>fax</th>
                                            <th>email</th>
                                            <th>creditLimit</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="item" items="${list}">
                                            <tr>
                                                <td><a href="${pageContext.request.getContextPath()}/mvc/customer/get/${item.customerId}">修改</a></td>
                                                <td><a href="${pageContext.request.getContextPath()}/mvc/customer/delete/${item.customerId}">刪除</a></td>
                                                <td>${item.customerId}</td>
                                                <td>${item.discountCode}</td>
                                                <td>${item.zip}</td>
                                                <td>${item.name}</td>
                                                <td>${item.addressline1}</td>
                                                <td>${item.addressline2}</td>
                                                <td>${item.city}</td>
                                                <td>${item.state}</td>
                                                <td>${item.phone}</td>
                                                <td>${item.fax}</td>
                                                <td>${item.email}</td>
                                                <td>${item.creditLimit}</td>
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