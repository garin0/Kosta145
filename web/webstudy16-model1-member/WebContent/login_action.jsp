<%@page import="model.MemberDAO"%>
<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login_action.jsp</title>
</head>
<body>
<% 
request.setCharacterEncoding("utf-8");
response.setContentType("text/html;charset=utf-8");
String id = request.getParameter("id");
String password = request.getParameter("password");
MemberVO vo = MemberDAO.getInstance().loginMember(id, password);
boolean flag = false;
if(vo!=null){
	session.setAttribute("memberVO", vo);
	flag= true;%>
	<%=vo.getName() %>님 로그인 OK<br>
	<a href="cafe.jsp">카페가기</a>
	<hr><a href="index.jsp">홈으로</a>
<%}

if(flag == false){%>
<script type="text/javascript">
		alert("로그인 실패!");
		location.href ="index.jsp";
</script>
<%} %>
</body>
</html>