<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% MemberVO vo = (MemberVO)session.getAttribute("mvo");
if(vo==null){%>
<form name="loginForm" method="post" action="DispatcherServlet">
<input type="hidden" name="command" value="login">
	<table class="loginTable">
		<tr>
			<td>아이디</td><td><input type="text" name="id" size="10"></td>
		</tr>
		<tr>
			<td>비밀번호</td><td><input type="password" name="password" size="10"></td>
		</tr>
		<tr><td colspan="2"><input type="submit" value="로그인" id="submit_btn"></td></tr>
	</table>
</form>
<%}else{ %>
	<%= vo.getName() %>님 로그인 OK<br>
	<a href ="DispatcherServlet?command=logout">로그아웃</a><br>
	<a href="item_register.jsp">상품등록</a>
<%} %>