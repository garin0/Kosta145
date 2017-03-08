<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findMemberByAddress</title>
</head>
<body>
<h3>주소로 회원검색</h3>
<form action="DispatcherServlet">
주소 <input type="text" name="address" required="required"> <input type="submit" value="찾기">
<input type="hidden" name="command" value="findByAddress">
</form>
</body>
</html>