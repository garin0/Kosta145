<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step4-choose-result</title>
</head>
<body>
<c:choose>
	<c:when test="${param.userAge>18}">
		${param.userName}님 ${param.userAge }세 성인입니다.
	</c:when>
	<c:when test="${param.userAge>12 && param.userAge<19}">
		${param.userName}님 ${param.userAge }세 청소년입니다.
	</c:when>
		<c:when test="${param.userAge>0 && param.userAge<13}">
		${param.userName}님 ${param.userAge }세 어린이입니다.
	</c:when>
	<c:otherwise>${param.userName}님 사람이 아닙니다.</c:otherwise>
</c:choose>
</body>
</html>