<%-- 
    Document   : UpdateTitle
    Created on : Feb 17, 2022, 2:52:31 PM
    Author     : ptuan
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <%
            ResultSet rsTitle = (ResultSet) request.getAttribute("rsTitle"),
                    rspush = (ResultSet) request.getAttribute("rsPublisher");
        %>
        <h2> Update Title information</h2>
        <%if (rsTitle.next()) {
        %>
        <form action="TitleController" method="post">
            <input type="hidden" name="go" value="updateTitle">
            <table>
                <tr>
                    <td>Title ID</td>
                    <td>
                        <input type ="text" name="title_id" value="<%=rsTitle.getString(1)%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        Title
                    </td>
                    <td>
                        <input type="text" name="title" value="<%=rsTitle.getString(2)%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        Type
                    </td>
                    <td>
                        <input type="text" name="Type" value="<%=rsTitle.getString(3)%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="pubid">Publisher</label>
                    </td>
                    <td>
                        <select name="pubid" id="pubid">
                            <% while (rspush.next()) {
                                    if (rspush.getString(1).equals(rsTitle.getString(4))) {
                            %>
                            <option value="<%=rspush.getString(1)%>" selected ><%=rspush.getString(2)%></option>
                            <% } else {%>
                            <option value="<%=rspush.getString(1)%>" ><%=rspush.getString(2)%></option>
                            <%}}%>

                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td>
                        <input type="number" name="Price" value="<%=rsTitle.getDouble(5)%>">
                    </td>
                </tr>
                <tr>
                    <td>Advance</td>
                    <td>
                        <input type="number" name="Advance" value="<%=rsTitle.getDouble(6)%>">
                    </td>
                </tr>
                <tr>
                    <td>Royalty</td>
                    <td>
                        <input type="number" name="Royalty" value="<%=rsTitle.getInt(7)%>">
                    </td>
                </tr>
                <tr>
                    <td>Ytd_sales</td>
                    <td>
                        <input type="number" name="Ytd_sales" value="<%=rsTitle.getInt(8)%>" >
                    </td>
                </tr>
                <tr>
                    <td>Notes</td>
                    <td>
                        <textarea name="notes"><%=rsTitle.getString(9)%></textarea>
                    </td>
                </tr>
                <tr>
                    <td>PubDate</td>
                    <td>
                        <input type="date" name="Pubdate" value="<%=rsTitle.getDate(10)%>" >
                    </td>
                </tr>
                <tr>
                    <td>Image</td>
                    <td>
                        <input type="file" name="image" value="<%=rsTitle.getString(11)%>" >
                    </td>
                </tr>
            </table>
            <p>
                <input type="submit" value="update" name="submit">
                <input type="reset" value="clear">
            </p>
        </form>
        <%}%>
    </body>
</html>
