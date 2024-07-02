
<%@page import="Model.DTOClass"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details</title>
</head>
<body>
<% ArrayList<DTOClass> userlist = (ArrayList<DTOClass>) request.getAttribute("userlist"); %>
<table style="border: 2px solid black;">
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
        </tr>
    </thead>
    <tbody>
        <% for (DTOClass d : userlist) { %>
        <tr>
            <td><%= d.getId() %></td>
            <td><%= d.getName() %></td>
        </tr>
        <% } %>
    </tbody>
</table>

</body>
</html>