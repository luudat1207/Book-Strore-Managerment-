<%-- 
    Document   : DisplayTitle
    Created on : Feb 10, 2022, 3:19:20 PM
    Author     : ptuan
--%>


<%@page import="java.util.Vector"%>
<%@page import="entity.tiltes,model.DAOtiltes,controller.TitleController"%>
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
            Vector<tiltes> vector = (Vector<tiltes>)request.getAttribute("list");
            String titleTable = (String) request.getAttribute("titleTabale");
        %>
        <table border="1">
            <caption><%=titleTable%></caption>
            <h1> <a href="CartController?go=showCart"> Show cart</h1>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Type</th>
                    <th>Pub_ID</th>
                    <th>Price</th>
                    <th>Advance</th>
                    <th>Royalty</th>
                    <th>YTD_Sales</th>
                    <th>Notes</th>
                    <th>Pub date</th>
                    <th>Image</th>
                    <th>Update</th>
                    <th>Delete</th>
                    <th>Add to Cart</th>
                    
                </tr>
            </thead>
            <tbody>
                <%            for (tiltes elem : vector) {
                %>
                <tr>
                    <td><%=elem.getTitle_id()%></td>
                    <td><%=elem.getTitle()%></td>
                    <td><%=elem.getType()%></td>
                    <td><%=elem.getPub_id()%></td>
                    <td><%=elem.getPrice()%></td>
                    <td><%=elem.getAdvance()%></td>
                    <td><%=elem.getRoyalty()%></td>
                    <td><%=elem.getYtd_sales()%></td>
                    <td><%=elem.getNotes()%></td>
                    <td><%=elem.getPubdate()%></td>
                    <td><img src="<%=elem.getImage()%>"></td>
                    <td><a href="TitleController?go=updateTitle&titleID=<%=elem.getTitle_id()%>">Update</td>
                    <td></td>
                    <td><a href="CartController?go=addtoCart&titleId=<%=elem.getTitle_id()%>"> Add</td>
                    <%}%>
                </tr>
            </tbody>
        </table>
    </body>
</html>
