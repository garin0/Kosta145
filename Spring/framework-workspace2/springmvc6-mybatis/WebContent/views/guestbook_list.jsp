<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<table>
	<tr>
		<th>NO</th><th>제목</th><th>내용</th>
	</tr>
	<c:forEach items="${guestList }" var="list">
		<tr>
			<td>${list.no }</td><td>${list.title }</td><td>${list.content }</td>
		</tr>
	</c:forEach>
</table> 
</body>
</html>