<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
<form action="customer.do">
id <input type="text" name="id"><br>
<input type="hidden" name="command" value="findCustomerById"> 
<input type="submit" value="검색">
</form>
<hr>
<form action="customer.do" method="post">
id <input type="text" name="id"><br>
name <input type="text" name="name"><br>
address <input type="text" name="address"><br>
<input type="submit" value="등록">
<input type="hidden" name="command" value="register">
</form>
<hr>
<a href="customer.do?command=getAllCustomerList">전체 고객 명단</a>
<%-- views/list.jsp에서 테이블로 명단을 제공한다.(jstl) --%>
<hr>
<a href="guestbook.do?command=getAllGuestBookList">방명록 목록 보기</a>
<%-- /views/guestbook_list.jsp에서 방명록 리스트를 제공
GuestBookController-GuestBookDAO -- guestbook.xml(기존 것 사용) --%>
</body>
</html>