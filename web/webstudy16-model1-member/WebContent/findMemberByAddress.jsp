<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소로 찾기</title>
</head>
<body>
<h3>주소로 회원 검색</h3>
<form action="findMemberByAddress_action.jsp" name="findMemberForm" method="get">
주소 <input type="text" name="address" required="required">
<input type="submit" value="검색">
</form>
</body>
</html>