<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원정보수정</title>
</head>
<body>
<h3>회원정보수정</h3>
		<form method="post" action="member_updateMember.do">
		<input type="hidden" name="command" value="update">
		아이디 : <input type="text" name="id" value="${sessionScope.mvo.id}" readonly>
		<br>패스워드 : <input type="password" name="password" 
		value="${sessionScope.mvo.password}" >		
		<br>이름 : <input type="text" name="name" 
		value="${sessionScope.mvo.name}" >	
		<br>주소 : <input type="text" name="address" 
		value="${sessionScope.mvo.address}" >	
		<br><input type="submit" value="회원정보수정">
		</form>
</body>
</html>