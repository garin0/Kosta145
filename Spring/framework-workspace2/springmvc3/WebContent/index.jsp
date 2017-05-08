<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>springmvc3</title>
</head>
<body>
springmvc3<br>
<form action="findCustomerById.do">
	고객아이디 <input type="text" name="customerId">
	<input type="submit" value="검색">
</form>
<!-- controller.FindCustomerByIdController
views/find_ok.jsp or view/find_fail.jsp로 응답 -->
</body>
</html>