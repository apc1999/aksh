<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<% String name=(String)request.getAttribute("name");
   int result=(int)request.getAttribute("result");
%>
<h5>Welcome <%=name %></h5>
<%if(result>0){ %>
	<h5>Your Name is Inserted Successfully</h5>
<%}else{ %>
	<h5>Sorry Try again</h5> %>
<%}
%>

</body>
</html>