<%@page import="model.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="mystyle.css">
<title>findMemberByAddress_ok</title>
</head>
<body>
<% @SuppressWarnings("all")
ArrayList<MemberVO> list = (ArrayList<MemberVO>)request.getAttribute("list");%>
<%=request.getParameter("address")%>에 사는 회원 명단
<table border="1" >
		<tr>
			<th>아이디</th><th>이름</th>
		</tr>
	<% for(int i = 0 ; i <list.size();i++){%>
		<tr>
			<td><%=list.get(i).getId()%></td>
			<td><%= list.get(i).getName() %></td>
		</tr>
	<%} %>
</table>
</body>
</html>