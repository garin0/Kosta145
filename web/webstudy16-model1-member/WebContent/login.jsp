<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
<%	
MemberVO vo = (MemberVO) session.getAttribute("memberVO");
if(vo == null){
%> 
<form name="loginForm" action="login_action.jsp" method="post">
아이디 <input type="text" name="id" required="required"><br>
패스워드 <input type="password" name="password" required="required"><br>
<input type="submit" value="로그인">
</form>
 <%}else{ %>
<%=vo.getName()%>님 로그인 상태입니다.<br>
<a href ="logout.jsp">로그아웃</a>
<%} %> 
</body>
</html>