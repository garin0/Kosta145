<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL로 ServletContext의 init parameter 접근</title>
</head>
<body>
<%= application.getInitParameter("adminEmail") %>
${initParam.adminEmail}
</body>
</html>