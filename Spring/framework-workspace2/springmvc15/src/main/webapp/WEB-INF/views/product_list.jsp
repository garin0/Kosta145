<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>product_list</title>
<style type="text/css">
table {
    border-collapse: collapse;
    text-align: left;
    line-height: 1.5;
    margin : 20px 10px;
}
table th {
    width: 150px;
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    border: 1px solid #ccc;
}
table td {
    width: 350px;
    padding: 10px;
    vertical-align: top;
    border: 1px solid #ccc;
}
</style>
</head>
<a href="home.do">HOME</a><hr>
<body>
	<table>
		<thead>
			<tr>
				<th>아이디</th><th>상품명</th><th>제조사</th><th>가격</th>
			</tr>
		</thead>
		
		<tbody>
			<!-- jstl로 loop -->
			<c:forEach items="${list }" var="list">
				<tr>
				<th>${list.id}</th><th>${list.name}</th>
				<th>${list.maker}</th><th>${list.price}</th>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>