<%-- 
    Document   : Panner
    Created on : Mar 7, 2022, 2:35:37 PM
    Author     : ptuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            String username = (String) session.getAttribute("u");
        %>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container_swap">

            <div class="div_left">HE150124 Pham Tuan Anh</div>
            <%
                 if(username != null){
            %>
            <div class="div_right"> Wellcome: Admin:<%=username%></div>
            <%}%>
            <div class="div_botomm">
                <%
                    if(username == null){
                %>
                <a href="LoginController?go=login"> Login
                    <%}else{%>
                    <a href="LoginController?go=logout"> Logout
                    <%}%>
            </div> 

        </div>
    </body>
</html>
