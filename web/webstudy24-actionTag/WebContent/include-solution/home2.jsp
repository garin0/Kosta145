<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include test2</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h2>이 부분은 home2 body 영역입니다.</h2>
<a href="home.jsp">home</a>
<br><br><br><br><br><br>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>