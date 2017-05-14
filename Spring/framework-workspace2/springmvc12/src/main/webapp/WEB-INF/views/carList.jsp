<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자동차 목록</title>
</head>
<body>
<a href="home.do">Home</a>
<hr>
<table cellpadding="10" border="1">
	<thead>
		<tr>
			<th>NO</th><th>Model</th><th>Price</th>
		</tr>
	</thead>
	<tbody>
		<%--jstl --%>
		<c:forEach items="${requestScope.carList }" var="list">
			<tr>
				<td>${list.no }</td><td>${list.model }</td><td>${list.price }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>