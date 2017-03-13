<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
<link rel="stylesheet" type="text/css" href="css/home.css">
</head>
<body>
<div class="container">
	<div class="header"> <jsp:include page="layout/header.jsp"></jsp:include></div>
	<div class="left">
		<jsp:include page="layout/left.jsp"></jsp:include>
	</div>
	<div class="main">
		<form method="post" action="DispatcherServlet">
		<input type="hidden" name="command" value="register">
			<table class="registerTable">
				<tr>
					<td>name</td><td><input type="text" name="name" required="required"></td>
				</tr>
				<tr>
					<td>maker</td><td><input type="text" name="maker" required="required"></td>
				</tr>
				<tr>
					<td>price</td><td><input type="text" name="price" required="required"></td>
				</tr>
				<tr>
					<td>detail</td><td><textarea rows="5" cols="30" name="detail" required="required"></textarea></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="상품등록" onclick="alert('상품등록완료!')"></td>
				</tr>
			</table>
		</form>
	</div>
	<div class="footer"><jsp:include page="layout/footer.jsp"></jsp:include></div>
</div>
</body>
</html>


