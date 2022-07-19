<%-- 
    Document   : DisplayTitleAuthor
    Created on : Feb 10, 2022, 4:09:06 PM
    Author     : ptuan
--%>

<%@page import="java.util.Vector"%>
<%@page import="model.DAOtilteauthor,entity.tileauthor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%String titlepage = (String)request.getAttribute("titlepage"); %>
        <title><%=titlepage%></title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <a href="index.html"> Home</a>
        <%
            DAOtilteauthor dao = new DAOtilteauthor();
            Vector<tileauthor> vecto = (Vector<tileauthor>)request.getAttribute("list");
            String titleTable = (String)request.getAttribute("titleTable");

        %>

        <table border="1">
            <caption><%=titleTable%></caption>
            <thead>  
                <tr>
                    <th>au_id</th>
                    <th>title_id</th>
                    <th>au_ord</th>
                    <th>royaltyper</th>
                    <th>update </th>
                    <th>delete</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (tileauthor elem : vecto) {
                %>
                <tr>
                    <td><%=elem.getAu_id()%></td>
                    <td><%=elem.getTitle_id()%></td>
                    <td><%=elem.getAu_rod()%></td>
                    <td><%=elem.getRoyltyper()%></td>
                    <td><a href="TitleAuthorController?go=updateTitleAuthor&authorID=<%=elem.getAu_id()%>&titleID=<%=elem.getTitle_id()%>">update</td>
                    <td><a href="TitleAuthorController?go=deleteTitleAuthor&authorID=<%=elem.getAu_id()%>&titleID=<%=elem.getTitle_id()%>">delete</td>
                    <%}%>
                </tr>
            </tbody>
        </table>
    </body>
</html>
