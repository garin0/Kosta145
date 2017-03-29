<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findMemberById_fail.jsp</title>
</head>
<body bgcolor="orange">
<%-- forward 방식으로 이동했으므로 request가 유지된다. --%>
	<%= request.getParameter("id")%> 아이디에 대한
	검색결과가 없습니다.
</body>
</html>