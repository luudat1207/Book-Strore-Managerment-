<%-- 
    Document   : UpdatePubInfo
    Created on : Feb 17, 2022, 3:44:20 PM
    Author     : ptuan
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            String tipage = (String) request.getAttribute("page"),
            titTabe = (String) request.getAttribute("table");
        %>
        <title><%=tipage%></title>
    </head>
    <body>
        <%
            ResultSet rs = (ResultSet) request.getAttribute("rs");
        %>
        <%
            if(rs.next()){
        %>
        <form action="PubInfoController" method="post">
            <input type="hidden" name="go" value="updatePubInfo">
            <table>
                <tr>
                    <td>Publisher ID</td>
                    <td>
                        <input type="text" name ="pub_id" value="<%=rs.getString(1)%>">
                    </td>
                </tr>
                <tr>
                    <td>Logo</td>
                    <td>
                        <input type="text" name ="logo" value="<%=rs.getString(2)%>">
                    </td>
                </tr>
                <tr>
                    <td>Pr_infor</td>
                    <td>
                        <input type="text" name ="pr_info" value="<%=rs.getString(3)%>">
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
