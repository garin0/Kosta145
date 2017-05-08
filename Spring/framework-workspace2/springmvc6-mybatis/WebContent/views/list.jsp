<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 전체 리스트</title>
<style type="text/css">
table,tr,td,th{
border: solid 1px black;
}
td,th{
padding:10px;
}
</style>
</head>
<body>
회원 전체 리스트
<table>
	<tr>
		<th>아이디</th><th>이름</th><th>주소</th>
	</tr>
	<c:forEach items="${requestScope.culist }" var="list">
		<tr>
			<td>${list.id }</td><td>${list.name }</td><td>${list.address }</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>