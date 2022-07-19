<%-- 
    Document   : Menu
    Created on : Mar 7, 2022, 2:35:54 PM
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
         <table border="1">
            <thead>
                <tr>
                    <th> <a href="AuthorsController?go=listAllAuthors">Authors</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><a href="DiscountsController?go=listAllDicsount"> Discount</td>
                </tr>
                <tr>
                    <td><a href="EmployeeController?go=listAllEmployee"> Employee</td>
                </tr>
                <tr>
                    <td><a href="JobsController?go=listAllJobs"> Jobs</td>
                </tr>
                <tr>
                    <td><a href="PubInfoController?go=listAllPubInfo"> PubInfo</td>
                </tr>
                <tr>
                    <td><a href="PublishersController?go=listAllPublisher"> Publisher</td>
                </tr>
                <tr>
                    <td><a href="RoyschedController?go=listAllRoysched"> Roysched</td>
                </tr>
                <tr>
                    <td><a href="SalesController?go=listAllSales"> Salse</td>
                </tr>
                <tr>
                    <td><a href="StoresController?go=listAllStores"> Store</td>
                </tr>
                <tr>
                    <td><a href="TitleAuthorController?go=listAllTitleAu"> TitleAuthor</td>
                </tr>
                <tr>
                    <td><a href="TitleController?go=listAllTitle"> Tile</td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
