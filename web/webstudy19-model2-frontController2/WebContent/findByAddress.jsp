<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findByAddress</title>
</head>
<body>
<%-- DispatcherServlet -- Controller
							|
						  FindByAddressController --%>
<form action="DispatcherServlet">
주소 <input type="text" name="address"><br>
<input type="hidden" name="command" value="findByAddress">
<input type="submit" value="찾기">
</form>
</body>
</html>