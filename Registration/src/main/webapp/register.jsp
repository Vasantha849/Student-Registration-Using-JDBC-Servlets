<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String name=request.getParameter("name1");
	String email=request.getParameter("email1");
	String password=request.getParameter("pass1");
	out.println("Name: "+name+"<br>");
	out.println("Email: "+email+"<br>");
	out.println("Password: "+password+"<br>");
	%>
</body>
</html>