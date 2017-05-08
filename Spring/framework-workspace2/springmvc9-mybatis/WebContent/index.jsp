<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>springmvc MyBatis</title>
</head>
<body>
<form action="findCustomerById.do">
ID <input type="text" name="id">
<input type="submit" value="검색">
</form>
<%-- views/find_ok.jsp에서 검색 결과 보여주고
	존재하지 않으면
	views/find_fail.jsp 에서 머머 아이디에 해당하는 
	고객정보 없습니다.
 --%>
</body>
</html>