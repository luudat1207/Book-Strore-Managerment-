<%-- 
    Document   : showCart.jsp
    Created on : Feb 24, 2022, 3:59:38 PM
    Author     : ptuan
--%>

<%@page import="entity.Cart"%>
<%@page import="entity.tiltes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <script>
    function myFunction() {
                var a=document.getElementById('sum'+i+'').value;
                 document.getElementById('sum'+i+'').value=(document.getElementById('qlt'+i+'').value*document.getElementById('price'+i+'').value).toFixed(2);
                 var b=document.getElementById('sum'+i+'').value;
                 document.getElementById('total').value=(document.getElementById('total').value*1+(b-a)*1).toFixed(2);
                 var qlt=document.getElementById('qlt'+i+'').value;
    }
</script>
    <body>
        <h1>Shopping Cart Details</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Total</th>
                    <th>Remove</th>
                </tr>
            </thead>
            <tbody>
                <%
                    java.util.Enumeration em = session.getAttributeNames();
                    double sum = 0, total = 0;
                     try {
                    while (em.hasMoreElements()) {
                        
                        String key = em.nextElement().toString();
                        Cart tiltes = (Cart) session.getAttribute(key);
                        sum = tiltes.getQty() * tiltes.getPrice();
                        total += sum;
                %>
                <tr>
                   
                    <td><%=tiltes.getTitle_id()%></td>
                    <td><%=tiltes.getTitle()%></td>
                    <td><input type="textfield" value="<%=tiltes.getQty()%>" id="qty" onchange="myFunction()"></td>
                    <td><%=tiltes.getPrice()%></td>
                    <td><%=total%></td>
                    <td>remove</td>
                </tr>
                <%}               
                    } catch (Exception e) {
                        }
                %>
            </tbody>
            <tfoot>
                <tr>
                    <th colspan="4">Total</th>
                    <td><%= total%></td>
                    <td>Remove All</td>
                </tr>
            </tfoot>
        </table>
        <h2><a href="">Check-out</h2>
    </body>
</html>
