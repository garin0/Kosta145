<%@page import="model.MemberVO"%>
<%@page import="model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findMemberById_action</title>
</head>
<body>
<% 
String id = request.getParameter("id");
MemberVO vo = MemberDAO.getInstance().findMemberById(id);
if(vo == null){%>
<script type="text/javascript">
	alert("<%=id%>에 해당하는 회원은 존재하지 않습니다.");
	location.href= "index.jsp";
</script>
<%}else{ %>
아이디: <%=vo.getId() %><br>
이름: <%=vo.getName()%><br>
주소: <%=vo.getAddress() %><br>
<%} %>
</body>
</html>