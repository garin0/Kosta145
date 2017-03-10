<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*,java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% ArrayList<MemberVO> list = new ArrayList<MemberVO>();
	list.add(new MemberVO("java","1234","김호겸","야탑"));
	list.add(new MemberVO("spring","abcd","아이유","판교"));
	list.add(new MemberVO("jquery","dcba","김문일","야탑"));
	request.setAttribute("memberList", list);
	request.setAttribute("address", "야탑"); 
%>
<%-- 아래 body 영역에서 table 형식으로 표현하되 
	 request 영역에 있는 address 정보에 해당하는
	 회원의 아이디 이름 주소를 출력한다.
	 1 java 김호겸 야탑 
	 3 jquery 김문일 야탑	--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step6-forEach-ex</title>
<style type="text/css">
	table{ border-collapse: collapse; }
	table,td { border: 1px solid black; }
	td{ padding: 15px; }
</style>
</head>
<body>
<table>
<c:forEach items ="${requestScope.memberList }" var="member" varStatus="order">
	<c:if test="${requestScope.address == member.address }">
		<tr>
			<td>${order.count }</td><td> ${member.id }</td><td> ${member.name }</td><td> ${member.address }</td>
		</tr>
	</c:if>
</c:forEach>
</table>
</body>
</html>