<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>step1-text-action.jsp</title>
</head>
<body>
<%
String name = request.getParameter("userName");
%>
<h2>전송하신 이름은 <%=name %> 입니다.</h2>
</body>
</html>