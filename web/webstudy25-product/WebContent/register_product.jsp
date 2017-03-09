<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register_product</title>
<link rel="stylesheet" type="text/css" href="product_style.css">
</head>
<body>
<a href="index.jsp">Home</a><hr>
<h3>상품등록</h3>
<form action="DispatcherServlet" method= "post">
상품명 <input type="text" name="name" required="required"><br>
제조사 <input type="text" name="maker" required="required"><br>
가 격 &nbsp;&nbsp;<input type="text" name="price" required="required"><br>
<input type="submit" value="등록">
<input type="hidden" name="command" value="register">
</form>
</body>
</html>