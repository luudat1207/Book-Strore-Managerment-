<%-- 
    Document   : DisplaySales
    Created on : Feb 10, 2022, 4:07:16 PM
    Author     : ptuan
--%>

<%@page import="java.util.Vector"%>
<%@page import="model.DAOsales,entity.sales"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%String titlepage = (String)request.getAttribute("titlepage");%>
        <title><%=titlepage%></title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <a href="index.html"> Home</a>
        <%
            Vector<sales> vector = (Vector<sales>)request.getAttribute("list");
            String titleTable = (String) request.getAttribute("titleTabale");

        %>
        <table border="1">
            <caption><%=titleTable%></caption>
            <thead>
                <tr>
                    <th>stor_id</th>
                    <th>ord_num</th>
                    <th>ord_date</th>
                    <th>qty</th>
                    <th>payterms</th>
                    <th>title_id</th>
                    <th>Status</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <%                    for (sales elem : vector) {
                %>
                <tr>
                    <td><%=elem.getStor_id()%></td>
                    <td><%=elem.getOrd_num()%></td>
                    <td><%=elem.getOrd_date()%></td>                  
                    <td><%=elem.getQty()%></td>                   
                    <td><%=elem.getPayterms()%></td>
                    <td><%=elem.getTitle_id()%></td>
                    <td><%=elem.getStatus()%></td>
                    <td><a href="SalesController?go=updateSale&storID=<%=elem.getStor_id()%>"> Update</td>
                    <td><a href="SalesController?go=delete&storID=<%=elem.getStor_id()%>"> Delete</td>
                    <%}%>
                </tr>
            </tbody>
        </table>       
    </body>
</html>
