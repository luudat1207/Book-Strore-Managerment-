<%-- 
    Document   : index.jsp
    Created on : Mar 6, 2022, 4:53:30 PM
    Author     : ptuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Store</title>
    </head>
    <body>
        <div class="panner"> 
            <%
              RequestDispatcher dispath = request.getRequestDispatcher("/JSP/Client/ClientStore/Panner.jsp");
        dispath.forward(request, response);
            %>
        </div>
        <div class="right">
            <%
               dispath = request.getRequestDispatcher("/JSP/Client/ClientStore/Menu.jsp");
        dispath.forward(request, response);
            %>
        </div>
        <div class="left">
            <%
               dispath = request.getRequestDispatcher("/JSP/Client/ClientStore/Content.jsp");
        dispath.forward(request, response);
            %>
        </div>
    </body>
</html>
