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
<h1>list of Product</h1>
<%
List<Product> list= (List<Product>)request.getAttribute("list");
%>
<table border="1">
<tr>
<th>Product Id</th>
<th> Product Name</th>
<th>Product Prize</th>
<th>Product DEscription</th>
<th>Update product</th>
<th>Delete product</th>
</tr>

<% for(Product p:list) 
{ %>
<tr>
<td><%=p.getId() %></td><td><%=p.getPname()%></td><td><%= p.getPrize()%></td><td><%=p.getDescription() %></td><td><a href="edit.jsp?id=<%=p.getId()%>">Edit</a></td><td><a href="/delete?id=<%=p.getId()%>">Delete</a></td></tr>
<%} %>

</table>


</body>
</html>