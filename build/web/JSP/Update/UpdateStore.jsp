<%-- 
    Document   : UpdateStore
    Created on : Feb 17, 2022, 3:43:26 PM
    Author     : ptuan
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
         String titlePage = (String) request.getAttribute("titlePage");
        %>
        <title><%=titlePage%></title>
    </head>
    <body>
        <%
            ResultSet rs = (ResultSet) request.getAttribute("vector");
            String titlTable = (String) request.getAttribute("titleTable");
        %>
        <h2><%=titlTable%></h2>
        <%
            if (rs.next()) {
        %>
        <form action="StoresController" method="post">
            <input type="hidden" name="go" value="updateStore">
            <table>
                <tr>
                    <td>Stor ID</td>
                    <td>
                        <input type="text" name = "stor_id" value="<%=rs.getString(1)%>">
                    </td>
                </tr>
                <tr>
                    <td>Store Name</td>
                    <td>
                        <input type="text" name = "stor_name" value="<%=rs.getString(2)%>">
                    </td>
                </tr>
                <tr>
                    <td>Store Address</td>
                    <td>
                        <input type="text" name = "stor_address" value="<%=rs.getString(3)%>">
                    </td>
                </tr>
                <tr>
                    <td>City</td>
                    <td>
                        <input type="text" name="city" value="<%=rs.getString(4)%>">
                    </td>
                </tr>
                <tr>
                    <td>State</td>
                    <td>
                        <input type="text" name = "state" value="<%=rs.getString(5)%>">
                    </td>
                </tr>
                <tr>
                    <td>Zip</td>
                    <td>
                        <input type="text" name ="zip" <%=rs.getString(6)%>>
                    </td>
                </tr>
            </table>
            <p>
                <input type="submit" value="update" name="submit">
                <input type="reset" value="reset">
            </p>
        </form>
        <%}%>
    </body>
</html>
