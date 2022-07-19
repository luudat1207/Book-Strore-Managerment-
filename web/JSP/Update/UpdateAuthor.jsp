<%-- 
    Document   : UpdateAuthor
    Created on : Feb 17, 2022, 3:45:28 PM
    Author     : ptuan
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            String tiPage = (String) request.getAttribute("page");
            String tiTable = (String) request.getAttribute("table");
        %>
        <title>%=tipage%></title>
    </head>
    <body>
        <%
            ResultSet rs = (ResultSet) request.getAttribute("rs");
        %>
        <h2>Update Information</h2>
        <%
            if (rs.next()) {
        %>
       <form action="AuthorsController" method="post">
            <input type="hidden" name="go" value="updateAuthor">
            <table>
                <tr>
                    <td>Author ID</td>
                    <td>
                        <input type="text" name = "au_id" value="<%=rs.getString(1)%>">
                    </td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td>
                        <input type="text" name ="au_lname" value="<%=rs.getString(2)%>">
                    </td>
                </tr>
                <tr>
                    <td>First Name</td>
                    <td>
                        <input type="text" name="au_fname" value="<%=rs.getString(3)%>">
                    </td>
                </tr>
                <tr>
                    <td>Phone</td>
                    <td>
                        <input type="text" name ="phone" value="<%=rs.getString(4)%>">
                    </td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td>
                        <input type="text" name ="address" value="<%=rs.getString(5)%>">
                    </td>
                </tr>
                <tr>
                    <td>City</td>
                    <td>
                        <input type="text" name ="city" value="<%=rs.getString(6)%>">
                    </td>
                </tr>
                <tr>
                    <td>State</td>
                    <td>
                        <input type="text" name ="state" value="<%=rs.getString(7)%>">
                    </td>
                </tr>
                <tr>
                    <td>Zip</td>
                    <td>
                        <input type="text" name ="zip" value="<%=rs.getString(8)%>">
                    </td>
                </tr>
                <tr>
                    <td>Contract</td>
                    <td>
                        <%
                            if(rs.getString(9).equals("1")){
                        %>
                        <input type="radio" name ="contract" value="0"> 0
                        <input type="radio" name ="contract" value ="1" checked> 1
                        <%}else{%>
                        <input type="radio" name ="contract" value="0" checked> 0
                        <input type="radio" name ="contract" value ="1"> 1
                        <%}%>
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
