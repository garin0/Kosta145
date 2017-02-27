<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>index</title>
</head>
<body>
<%-- 로그인 상태가 아니면 로그인폼을 제공
	 로그인 상태이면  송중기님 로그인--%>
<%	
if(session.getAttribute("id") == null){
%> 
<h3>로그인 페이지</h3>
<form name="loginForm" action="login_action.jsp" method="post">
ID: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<input type="text" name="id" required="required"><br>
Password: <input type="password" name="password" required="required"><br>
<input type="submit" value="제출">
 <%}else{ %>
<%= session.getAttribute("name") %>님 로그인 ok<br>
<a href ="logout.jsp">로그아웃</a>
<%} %> 
</form>
</body>
</html>