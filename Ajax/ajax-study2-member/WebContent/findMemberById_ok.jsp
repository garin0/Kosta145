<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="mystyle.css">
<title>findMemberById_ok.jsp</title>
</head>
<body bgcolor="yellow">
<% MemberVO vo = (MemberVO)request.getAttribute("result"); %>
아이디: <%=vo.getId() %><br>
이름: <%=vo.getName()%><br>
주소: <%=vo.getAddress() %><br>
</body>
</html>