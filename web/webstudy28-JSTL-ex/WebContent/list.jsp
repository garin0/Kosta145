<%@page import="model.ListVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>car list page</title>
<style type="text/css">
	table{ border-collapse: collapse; }
	table,td { border: 1px solid black; }
	td{ padding: 15px; }
</style>
</head>
<body>
<h3>car list</h3>
<table>
<tr>
	<td>NO</td><td>MODEL</td><td>PRICE</td>
</tr>
<c:forEach items ="${requestScope.listVO.carList }" var="car" varStatus="order">
		<tr>
			<td>${order.count }</td><td>${car.model }</td><td>${car.price }</td>
		</tr>
</c:forEach>


</table>
<hr>
<c:forEach begin="${requestScope.listVO.pagingbean.startPage }" end="${requestScope.listVO.pagingbean.endPage }" var="page" varStatus="order">
	<c:choose>
		<c:when test="${order.count == requestScope.listVO.pagingbean.nowPage }"> ${page }</c:when>
		<c:otherwise><a href="">${page }</a></c:otherwise>
	</c:choose>
</c:forEach>
</body>
</html>