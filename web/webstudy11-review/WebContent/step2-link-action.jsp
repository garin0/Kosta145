<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>step2-link-action.jsp</title>
</head>
<body bgcolor="yellow">
<% String id = request.getParameter("id");
String name = request.getParameter("name");%>
<% if(id!=null){ %>
아이디 <%=id %>
<%} %>
<% if(name!=null){ %>
이름 <%=name %>
<%} %>
<script type="text/javascript">
<%if(id == null && name == null){ %>
	alert("아이디랑 이름 없어요ㅠㅠ");
	location.href = "step2-link.jsp";
<%} %>
</script>

</body>
</html>