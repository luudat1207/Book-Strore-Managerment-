<%-- 
    Document   : index
    Created on : Mar 7, 2022, 2:35:31 PM
    Author     : ptuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editer</title>
    </head>
    <body>
        <body>
        <div class="panner"> 
            <%@include file="/JSP/Client/ClientAdmin/Panner.jsp" %>
        </div>
        <div class="right">
            <%@include file="/JSP/Client/ClientAdmin/Menu.jsp" %>
        </div>
        <div class="left">
            <%@include file="/JSP/Client/ClientAdmin/Content.jsp" %>
        </div>
    </body>
</html>
