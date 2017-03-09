<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<link rel="stylesheet" type="text/css" href="product_style.css">
</head>
<body>
<h3>Model2 상품관리</h3>
<a href="register_product.jsp">상품등록</a><br>
<a href="DispatcherServlet?command=list">상품전체 리스트</a><br>
<jsp:forward page="DispatcherServlet">
	<jsp:param value="list" name="command"/>
</jsp:forward>
</body>
</html>