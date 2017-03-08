<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home</title>
</head>
<body>
<%	MemberVO vo = (MemberVO) session.getAttribute("memberVO");%> 
<h2>Model2 회원관리</h2>
<a href="findMemberById.jsp">아이디로 회원검색</a><br>
<%-- findMemberById -- DispatcherServlet -- HandlerMapping -- Controller
																|
															 FindMemberByIdController 
	forward 방식
	findMemberById_ok.jsp
	findMemberById_fail.jsp
--%>
<a href="findMemberByAddress.jsp">주소로 회원검색</a><br>
<%-- findMemberByAddress -- DispatcherServlet -- HandlerMapping -- Controller
																|
															 FindMemberByAddressController 	
	forward 방식
	findMemberByAddress_ok.jsp
	: 목록제공
	findMemberByAddress_fail.jsp
--%>
<% if(vo == null){ %>
<a href="login.jsp">로그인</a><br>
<a href="register.jsp">회원가입</a><br>
<%}else{ %>
<%=vo.getName()%>님 로그인<br>
<a href ="logout.jsp">로그아웃</a><br>
<a href="update.jsp">회원정보 수정</a><br>
<a href="cafe.jsp">카페가기</a>
<%} %>
</html>