<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cafe</title>
</head>
<body>
<a href="index.do">홈</a><br>
${sessionScope.info.address }에 사는 ${sessionScope.info.name}님 카페입장을 환영합니다.
</body>
</html>