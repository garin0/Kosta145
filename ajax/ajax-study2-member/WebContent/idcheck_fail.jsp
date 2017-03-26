<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중복체크</title>
</head>
<body bgcolor="red">
<% String id = request.getParameter("id");%>
<%= id %>는 사용할 수 없는 아이디입니다.<br><br>
<script type="text/javascript">
	document.body.style.backgroundColor = "red";
	opener.registerForm.id.value = "";
	opener.registerForm.id.focus();
</script>
<input type="button" value="확인" onclick="javascript:self.close()"><br>
</body>
</html>