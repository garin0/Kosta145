<%@page import="model.MemberDAO"%>
<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update.jsp</title>
</head>
<body>
<%	MemberVO vo = (MemberVO) session.getAttribute("memberVO");%>
<a href="index.jsp">홈으로</a><hr> 
<h3>회원정보 수정</h3>
<form action="update_action.jsp" method="post">
아이디 <input type="text" name="id" value="<%=vo.getId() %>" readonly> <br>
패스워드 <input type="password" name="password" required="required"><br>
이름 <input type="text" name="name" required="required"><br>
주소 <input type="text" name="address" required="required"><br>
<input type="submit" value="회원정보 수정">
</form>
</body>
</html>