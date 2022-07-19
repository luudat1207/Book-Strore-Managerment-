<%-- 
    Document   : DisplayPubInfo
    Created on : Feb 10, 2022, 4:08:13 PM
    Author     : ptuan
--%>

<%@page import="java.util.Vector"%>
<%@page import="model.DAOpub_info,entity.pub_info"%>
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
            Vector<pub_info> vector = (Vector<pub_info>)request.getAttribute("list");
            String titleTable = (String) request.getAttribute("titleTabale");
        %>
        <table border="1">
            <caption>List Pub_info</caption>
            <thead>
                <tr>
                    <th>pub_id</th>
                    <th>logo</th>
                    <th>pr_info</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (pub_info elem : vector) {
                %>
                <tr>
                    <td><%=elem.getPub_id()%></td>
                    <td><%=elem.getLogo()%></td>
                    <td><%=elem.getPr_info()%></td>
                    <td><a href="PubInfoController?go=updatePubInfo&pub_id=<%=elem.getPub_id()%>"> Update</td>
                    <td><a href="PubInfoController?go=deletepub&pub_id=<%=elem.getPub_id()%>"> Delete</td>
                    <%}%>
                </tr>
                </tb
                </body>
                </html>
