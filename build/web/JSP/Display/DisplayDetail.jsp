<%-- 
    Document   : DisplayDetail
    Created on : Feb 17, 2022, 4:30:57 PM
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
    <script>
        function fun() {
            document.getElementById("status1").value = document.getElementById("dropbox").value;
        }
    </script>
    <body>
        <div class="box">
            <a href="index.html" class="home"> Home</a>
        </div>
        <%
            ResultSet rs = (ResultSet) request.getAttribute("rsDetail"),
                    rs1 = (ResultSet) request.getAttribute("status");
            rs1.absolute(1);
            int status = rs1.getInt(1);
            String storID = request.getParameter("storid");
            String storname = (String) request.getAttribute("stor_name");
            double Sum = 0;
        %>
        <h2>Order detail</h2>
        <h2>
            StoreID: <%=storID%>

            -----StoreName: <%=storname%>

            -----Status :

            <select name="status" id="dropbox" onchange="fun()">
                <option value="1"> wait  </option>
                <option value="2"> Process </option>
                <option value="3"> done  </option>
            </select>

        </h2>
        <h2>Detail:</h2>
        <form action="SalesController?go=updateStatus" method = "post">
            <input type="hidden" value="1" id="status1" name="status" />
            <input type="hidden" value="<%=storID%>" id="id" name="storID" />  
            <input type="submit" value="submit" name="submit"/>
            <table border="1">
                <thead>
                    <tr>
                        <th>OrderNum</th>
                        <th>Title</th>
                        <th>Quantity </th>
                        <th>Price</th>
                        <th>Total</th>
                    </tr>
                </thead>
                <tbody>
                    <%while (rs.next()) {%>
                    <tr>
                        <td><%=rs.getString(1)%></td>
                        <td><%=rs.getString(2)%></td>
                        <td><%=rs.getInt(3)%></td>
                        <td><%=rs.getDouble(4)%></td>
                        <td><%=rs.getDouble(5)%></td>
                        <%Sum += rs.getDouble(5);%>
                    </tr>
                    <%}%>
                </tbody>
            </table>
            <p>====>>>><b>Grand Total = <%=Sum%></p>
        </form>
    </body>
    <script>
        document.getElementById("dropbox").value =<%=status%>;
    </script>
</html>
