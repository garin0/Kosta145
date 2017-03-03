<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Model2</title>
</head>
<body>
<h2>Model2 Architecture(MVC pattern)</h2>
<a href="find.jsp">검색 서비스</a><br>
<a href="insert.jsp">정보 등록 서비스</a>
<%--
insert.jsp ---- InsertServlet ---- MockDAO
				| redirect 방식 이동
				|
				insert_result.jsp
 --%>
 <br>
 <a href="findByAddress.jsp">주소로 검색</a>
 <%--
 	findByAddress.jsp --- FindByAddressServlet -- MockDAO
 							|
 							findbyaddress_ok.jsp
 							목록을 제공
 							or
 							findbyaddress_fail.jsp
 							판교에 사는 회원 없음 alert 후 index.jsp 이동
  --%>
  <br><a href="update.jsp">정보수정</a>
  <br><br>
  <img src ="frontController1.jpg" >
</body>
</html>