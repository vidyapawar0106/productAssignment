<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@  page import="com.example.demo.*" %>
    <%@  page import="java.util.*"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
List<Product> list= (List<Product>)request.getAttribute("newlist");
%>
<table border="1">
<tr>
<th>Product Id</th>
<th> Product Name</th>
<th>Product Prize</th>
<th>Product DEscription</th>
</tr>

<% for(Product p:list) 
{ %>
<tr>
<td><%=p.getId() %></td><td><%=p.getPname()%></td><td><%= p.getPrize()%></td><td><%=p.getDescription() %></td>
</tr>
<%} %>

</table>

</body>
</html>