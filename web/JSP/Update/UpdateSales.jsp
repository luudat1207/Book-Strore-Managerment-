<%-- 
    Document   : UpdateSales
    Created on : Feb 17, 2022, 3:43:37 PM
    Author     : ptuan
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            String page1 = (String) request.getAttribute("page");
            String titletable = (String) request.getAttribute("table");
        %>
        <title><%=page1%></title>
    </head>
    <body>
        <%
            ResultSet rs = (ResultSet) request.getAttribute("rs"),
                    rsTitle = (ResultSet) request.getAttribute("rstitles"),
                    rsStore = (ResultSet) request.getAttribute("rsStore");
        %>
        <h2>UPdate Information</h2>
        <%
            if (rs.next()) {
        %>
        <form action="SalesController" method="post">
            <input type="hidden" name ="go" value="updateSale">
            <table>
                <tr>
                    <td><label for="Stor_id">Store</label></td>
                    <td>
                        <select name="Stor_id" id="Stor_id">
                            <% while (rsStore.next()) {
                                    if (rsStore.getString(1).equals(rs.getString(1))) {
                            %>
                            <option value="<%=rsStore.getString(1)%>" selected ><%=rsStore.getString(2)%></option>
                            <%} else {
                            %>
                            <option value="<%=rsStore.getString(1)%>"><%=rsStore.getString(2)%></option>
                            <%}
                                }%>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Ord_num</td>
                    <td>
                        <input type="text" name="ord_num" value="<%=rs.getString(2)%>">
                    </td>
                </tr>
                <tr>
                    <td>Ord_date</td>
                    <td>
                        <input type="date" name="ord_date" value="<%=rs.getDate(3)%>">
                    </td>
                </tr>
                <tr>
                    <td>Quantity</td>
                    <td>
                        <input type="number" name="qty" value="<%=rs.getInt(4)%>">
                    </td>
                </tr>
                <tr>
                    <td>Payterms</td>
                    <td>
                        <input type="text" name="payterms" value="<%=rs.getString(5)%>">
                    </td>
                </tr>
                <tr>
                    <td><label for="tile_id">Title</label></td>
                    <td>
                        <select name="tile_id" id="tile_id">
                            <%
                                while (rsTitle.next()) {
                                    if (rsTitle.getString(1).equals(rs.getString(6))) {
                            %>
                            <option value="<%=rsTitle.getString(1)%>" selected><%=rsTitle.getString(2)%></option>
                            <%} else {%>
                            <option value="<%=rsTitle.getString(1)%>"><%=rsTitle.getString(2)%></option>
                            <%}
                                }%>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Status</td>
                    <td>
                        <%if (rs.getString(7).equals("1")) {
                        %>
                        <input type="radio" value="1" name="status" checked=""> 1
                        <input type="radio" value="2" name="status"> 2
                        <input type="radio" value="3" name="status"> 3
                        <%} else if (rs.getString(7).equals("2")) {

                        %>
                        <input type="radio" value="1" name="status"> 1
                        <input type="radio" value="2" name="status" checked> 2
                        <input type="radio" value="3" name="status"> 3
                        <%} else{%>
                        <input type="radio" value="1" name="status"> 1
                        <input type="radio" value="2" name="status"> 2
                        <input type="radio" value="3" name="status" checked> 3
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
