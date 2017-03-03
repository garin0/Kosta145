<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>model2 review</title>
</head>
<body>
<%-- 
	forward와 redirect 이동방식 복습
 --%>
	<form method="post" action="UpdateServlet">
		닉네임<input type="text" name="nick">
		<input type="submit" value="수정하기">
	</form>
</body>
</html>