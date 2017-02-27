<%@page import="java.util.Iterator"%>
<%@page import="model.MemberVO"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login_action.jsp</title>

</head>
<body>
<%--전달받은 아이디와 패스워드가 ServletContext의 map 정보에 있는
회원정보 아이디 패스워드와 일치하면 <a>Home</a>송중기님 로그인 성공
or 아이디가 없거나 아이디에 따른 패스워드가 일치하지 않으면 로그인 실패 alert후 index.jsp로 이동
 --%>
 <% String id = request.getParameter("id");
 String password = request.getParameter("password");
  HashMap<String,MemberVO> map = (HashMap) application.getAttribute("map");

	 if(map.containsKey(id) && map.get(id).getId().equals(id) && map.get(id).getPassword().equals(password)){
		 session.setAttribute("id", id); 
		 session.setAttribute("name", map.get(id).getName());%>
 <a href="index.jsp">Home</a>
<%=map.get(id).getName() %>님 로그인 성공~<br>
<%}else{%>
	<script type="text/javascript">
	alert("로그인 실패!");
	location.href="index.jsp";</script>
<%} %>


</body>
</html>