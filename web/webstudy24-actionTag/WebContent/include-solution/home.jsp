<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include test</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
이 부분은 body 영역입니다.
<%-- <jsp:include page="home2.jsp"></jsp:include> --%>
<a href="home2.jsp">home2</a>
<br><br><br><br><br><br>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>