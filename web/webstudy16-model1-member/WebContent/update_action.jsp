<%@page import="model.MemberDAO"%>
<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update_action.jsp</title>
</head>
<body>
<%	
request.setCharacterEncoding("utf-8");
response.setContentType("text/html;charset=utf-8");
String id = request.getParameter("id");
String password = request.getParameter("password");
String name = request.getParameter("name");
String address = request.getParameter("address");
MemberVO vo = new MemberVO(id, password, name, address);
MemberDAO.getInstance().updateMember(vo);
session.setAttribute("memberVO", vo);
%> 
<% %>
<a href="index.jsp">홈으로</a>
<hr>
<%= vo.getName() %> 님이 회원정보를 수정하였습니다.<br>
수정정보 <br>
아이디 <%= vo.getId() %><br>
패스워드 <%=vo.getPassword() %><br>
이름 <%= vo.getName() %><br>
주소 <%= vo.getAddress() %><br>
</body>
</html>