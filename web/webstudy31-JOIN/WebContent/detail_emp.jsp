<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/board.css" type="text/css">
</head>
<body>
<table>
	<tr>
		<th>사원번호</th><th>사원명</th><th>월급</th><th>부서명</th><th>부서번호</th><th>지역</th><th>TEL</th>
	</tr>
	<c:forEach items="${requestScope.list }" var="list">
		<tr>
			<td>${list.empno }</td>
			<td>${list.ename }</td>
			<td>${list.salary}</td>
			<td>${list.deptVO.dname }</td>
			<td>${list.deptVO.deptno}</td>
			<td>${list.deptVO.loc}</td>
			<td>${list.deptVO.tel}</td>
		</tr>
	</c:forEach> 
</table>
</body>
</html>