<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*,java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% ArrayList<MemberVO> list = new ArrayList<MemberVO>();
	list.add(new MemberVO("java","1234","김호겸","야탑"));
	list.add(new MemberVO("spring","abcd","아이유","판교"));
	list.add(new MemberVO("jquery","dcba","김문일","야탑"));
	request.setAttribute("memberList", list);
	request.setAttribute("address", " 야탑 "); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step10-empty.jsp</title>
</head>
<body>
<c:choose>
	<c:when test="${empty requestScope.memberList }">
		리스트가 비어 있음
	</c:when>
	<c:otherwise>
		리스트가 비어 있지 않음
		회원수 ${fn:length(memberList) }
	</c:otherwise>
</c:choose>
</body>
</html>