<%-- 
    Document   : UpdateDiscounts
    Created on : Feb 17, 2022, 3:44:58 PM
    Author     : ptuan
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            String TitPage = (String) request.getAttribute("page");
            String TitTable = (String) request.getAttribute("table");
        %>
        <title><%=TitPage%></title>
    </head>
    <body>
        <%
            ResultSet rs = (ResultSet) request.getAttribute("rs"),
            rsStores = (ResultSet) request.getAttribute("rsStores");
        %>
        <%
            if(rs.next()){
        %>
        <form action="DiscountsController" method="post">
        <input type="hidden" name="go" value="updateDicount">
        <table>
            <tr>
                <td>Discounttype</td>
                <td>
                    <input type="text" name="discounttype" value="<%=rs.getString(1)%>">
                </td>
            </tr>
            <tr>
                <td><label for="stor_id">Stores</label></td>
                <td>
                    <select name="stor_id" id="stor_id">
                        <%
                                while(rsStores.next()){
                                    if(rsStores.getString(1).equals(rs.getString(2))){
                            %>
                            <option value="<%=rsStores.getString(1)%>" selected ><%=rsStores.getString(2)%></option>
                            <%}else{%>
                            <option value="<%=rsStores.getString(1)%>"><%=rsStores.getString(2)%></option>
                            <%}}%>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Low Quantity</td>
                <td>
                    <input type="number" name ="lowqty" value="<%=rs.getString(3)%>">
                </td>
            </tr>
            <tr>
                <td>Hight Quantity</td>
                <td>
                    <input type="number" name ="hightqty" value="<%=rs.getString(4)%>">
                </td>
            </tr>
            <tr>
                <td>Dicount</td>
                <td>
                    <input type="number" name="discount" value="<%=rs.getString(5)%>">
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
