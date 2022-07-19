<%-- 
    Document   : adminLogin
    Created on : Mar 7, 2022, 1:54:13 AM
    Author     : ptuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <form> 
        <br action="LoginController" method="post">
        <input type="hidden" name="go" value="loginadmin">
            Username : <input type="text" name="userName"><br></br>
            Password : <input type="password" name="password"><br></br>
            <input type="submit" value="login" name="submit"><br></br>
        </form>
    </body>
</html>
