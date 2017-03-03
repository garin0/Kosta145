<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert</title>
</head>
<body>
<%--insert.jsp -- DispatcherServlet -- InsertController -- MockDAO
						| 재등록방지 위해 redirect
						insert_result.jsp --%>
<form action="DispatcherServlet" method="post">
이름 <input type="text" name="name"><br>
주소 <input type="text" name="address"><br>
<input type="hidden" name="command" value="insert">
<input type="submit" value="등록">
</form>
</body>
</html>