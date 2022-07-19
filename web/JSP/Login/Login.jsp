<%-- 
    Document   : Login
    Created on : Mar 6, 2022, 4:19:04 PM
    Author     : ptuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <%String status1 = (String) request.getAttribute("status");
            
         
         %>
            <script>
            if( <%=status1%> != null){
                    alert("Username Or Password is faile")
                }
            </script>
                
        <title>Login</title>
    </head>
    <body>
        <form> 
        <br action="LoginController" method="post">
        <input type="hidden" name="go" value="login">
            Username : <input type="text" name="userName"><br></br>
            Password : <input type="password" name="password"><br></br>
            <input type="submit" value="login" name="submit"><br></br>
        </form>
    </body>
</html>
