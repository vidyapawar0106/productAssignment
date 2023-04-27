<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="com.example.demo.ProductRepo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% int id=Integer.parseInt(request.getParameter("id")); 


// System.out.println("the id is"+id);
%>
<h1>Update Product</h1>
<form action="update">
Product Id<input type="text" value=<%=id %> name="id"><br/>
Product Name<input type="text" name="pname"><br/>
Product Prize<input type="text" name="prize"><br/>
Product Description<input type="text" name="description"><br>
<input type="submit" value="update Product">

</form>
</body>
</html>