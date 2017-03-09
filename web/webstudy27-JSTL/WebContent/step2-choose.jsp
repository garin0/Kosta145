<%@page import="model.PersonVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>choose when otherwise(if~else if~else)</title>
</head>
<body>
<%
	PersonVO vo = new PersonVO("김호겸",1000);
	request.setAttribute("pvo", vo);
%> EL로 name과 money 출력
${requestScope.pvo.name } ${requestScope.pvo.money }
<hr>
<c:choose>
	<c:when test="${pvo.name=='간디' }">간디입니다.</c:when>
	<c:when test="${pvo.name=='김호겸' }">김호겸입니다.</c:when>
	<c:otherwise>else의 역할</c:otherwise>
</c:choose>
</body>
</html>