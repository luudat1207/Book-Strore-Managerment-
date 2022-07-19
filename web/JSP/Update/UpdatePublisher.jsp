<%-- 
    Document   : UpdatePublisher
    Created on : Feb 17, 2022, 3:44:08 PM
    Author     : ptuan
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            String Tpage = (String) request.getAttribute("page");
            String Ttable = (String) request.getAttribute("table");
        %>
        <title><%=Tpage%></title>
    </head>
    <body>
        <h2>Update Information</h2>
        <%
            ResultSet rs = (ResultSet) request.getAttribute("rs");
        %>
        <%  
            if(rs.next()){
        %>
         <form action="PublishersController">
            <input type="hidden" name="go" value="updatePublisher">
            <table>
                <tr>
                    <td>Publisher ID</td>
                    <td>
                        <input type="text" name = "pub_id" value="<%=rs.getString(1)%>">
                    </td>
                </tr>
                <tr>
                    <td>Publisher Name</td>
                    <td>
                        <input type="text" name="pub_name" value="<%=rs.getString(2)%>">
                    </td>
                </tr>
                <tr>
                    <td>City</td>
                    <td>
                        <input type="text" name="city" value="<%=rs.getString(3)%>">
                    </td>
                </tr>
                <tr>
                    <td>State</td>
                    <td>
                        <input type="text" name ="state" value="<%=rs.getString(4)%>">
                    </td>
                </tr>
                <tr>
                    <td>Country</td>
                    <td>
                        <input type="text" name="country" value="<%=rs.getString(5)%>">
                    </td>
                </tr>
                <tr>
                    <td>Image</td>
                    <td>
                        <input type="file" name="image" value="<%=rs.getString(6)%>">
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
