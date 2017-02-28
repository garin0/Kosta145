<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
<%	MemberVO vo = (MemberVO) session.getAttribute("memberVO");

%> 
<h2>Model 1</h2>
<a href="findMemberById.jsp">아이디로 회원 검색</a><br>
<a href="findMemberByAddress.jsp">주소로 회원 검색</a><br>
<%if(vo == null){ %>
<a href="login.jsp">로그인</a>
<%}else{ %>
<%=vo.getName()%>님 로그인<br>
<a href ="logout.jsp">로그아웃</a><br>
<a href="update.jsp">회원정보 수정</a><br>
<a href="cafe.jsp">카페가기</a>
<%} %> 
</body>
</html>