<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findbyaddress_ok</title>
</head>
<body>
<% @SuppressWarnings("all")
ArrayList<String> list = (ArrayList<String>)request.getAttribute("list");%>
<%=request.getParameter("address")%>에 사는 회원 명단
<table >
	<% for(int i = 0 ; i < list.size() ; i++){ %>
	<tr>
		<td><%= list.get(i) %></td>
	</tr>
	<%} %>
</table>
</body>
</html>