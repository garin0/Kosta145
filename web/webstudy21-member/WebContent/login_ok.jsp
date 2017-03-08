<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% MemberVO vo = (MemberVO)session.getAttribute("memberVO");
if(vo!=null){%>
	<%= vo.getName() %>님 로그인 OK<br>
	<a href ="logout.jsp">로그아웃</a><br>
	<a href="cafe.jsp">카페가기</a><br>
	<hr><a href="index.jsp">홈으로</a>
<%}else{ %>
<script type="text/javascript">
 alert("비정상 접근!");
 location.href="index.jsp";
</script>
<%} %>
</body>
</html>