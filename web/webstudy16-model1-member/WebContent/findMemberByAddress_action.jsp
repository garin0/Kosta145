<%@page import="model.MemberDAO"%>
<%@page import="model.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findMemberByAddress_action.jsp</title>
<link rel="stylesheet" type="text/css" href="mystyle.css">
</head>
<body>
<% String address = request.getParameter("address");
ArrayList<MemberVO> list =MemberDAO.getInstance().findMemberByAddress(address);
if(list.size()!=0){%>
<a href="index.jsp">Home</a>
판교에 사는 회원 <%= list.size() %>명<br><br>
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
<% }else{ %>
<script type="text/javascript">
	alert("<%= address%> 에 사는 회원없음!");
	location.href= "index.jsp";
</script>
<%} %>
</body>
</html>