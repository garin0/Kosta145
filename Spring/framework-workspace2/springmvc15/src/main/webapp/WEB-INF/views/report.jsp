<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>report</title>
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
<body>
	<table>
		<thead>
			<tr>
				<th>순위</th>
				<th>검색어</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="list" >
				<tr> 
					<td>${list.rk}</td><td>${list.keyword}</td><td>${list.count}</td> 
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>