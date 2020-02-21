<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <!-- Head -->
        <%@include file="/WEB-INF/jsp/include/head.jspf"  %>
    </head>
    <body>

        <div id="layout">
            <!-- Toggle -->
            <%@include file="/WEB-INF/jsp/include/toggle.jspf" %>

            <!-- Menu -->
            <%@include file="/WEB-INF/jsp/include/menu.jspf" %>
            
            <div id="main">
                <div class="header">
                    <h1>Sales</h1>
                    <h2>derby sample tables</h2>
                </div>
                <img src="/case/images/derby.png" >
            </div>
        </div>
        <!-- Foot -->
        <%@include file="/WEB-INF/jsp/include/foot.jspf" %>
    </body>
</html>