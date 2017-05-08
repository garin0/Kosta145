<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table, tr, td, th {
	border: solid 1px black;
}

td, th {
	padding: 10px;
}
</style>
</head>
<body>
	<hr>
	+검색 결과+
	<hr>
	<c:choose>
		<c:when test="${fn:length(list) > 0}">
			<table>
				<thead>
					<tr>
						<th>ID</th>
						<th>NAME</th>
						<th>MAKER</th>
						<th>PRICE</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${requestScope.list}" var="list">
						<tr>
							<th>${list.id}</th>
							<th>${list.name}</th>
							<th>${list.maker}</th>
							<th>${list.price}</th>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>검색 결과 없음</c:otherwise>
	</c:choose>

</body>
</html>