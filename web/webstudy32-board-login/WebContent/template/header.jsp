<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/board.css" type="text/css">
<% MemberVO vo = (MemberVO)session.getAttribute("mvo");
if(vo!=null){%>
<p>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/index.jsp">홈</a> | 
<a href="${pageContext.request.contextPath}/board/write.jsp">글쓰기</a> | 
${sessionScope.mvo.name}님
| <a href="${pageContext.request.contextPath}/member/logout.jsp">로그아웃</a></p>
<%}else{ %>
<form name="loginForm" method="post" action="DispatcherServlet">
<input type="hidden" name="command" value="login">
		아이디 <input type="text" name="id" size="10" required="required">
		비밀번호 <input type="password" name="password" size="10" required="required">
		<input type="submit" value="로그인" id="submit_btn">
</form>
<%} %>
