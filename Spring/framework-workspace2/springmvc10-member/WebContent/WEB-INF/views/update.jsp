<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
</head>
<body>
<a href="index.do">홈</a><br>
<form action="updateMember.do" method="post">
아이디: <input type="text" name="id" value="${sessionScope.info.id}" readonly="readonly"><br>
패스워드: <input type="text" name="password" value="${sessionScope.info.password}"><br>
이름: <input type="text" name="name" value="${sessionScope.info.name}"><br>
주소: <input type="text" name="address" value="${sessionScope.info.address}"><br>
<input type="submit" value="수정">
</form>
</body>
</html>