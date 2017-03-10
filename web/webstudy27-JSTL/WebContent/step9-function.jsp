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
<title>jstl function</title>
</head>
<body>
<% 
@SuppressWarnings("unchecked")
ArrayList<MemberVO> mList = (ArrayList<MemberVO>)request.getAttribute("memberList"); %>
<%= list.size() %>명
<br>
<%--EL로 메서드 호출은 get과 is 계열 메서드만 가능 --%>
EL로 list size 호출 <%-- ${requestScope.memberList } --%>
리스트 길이: ${fn:length(memberList) }<br>
첫번째 요소의 이름 길이: ${fn:length(memberList[0].name) }<br>
주소 길이: ${fn:length(address) }<br> <%-- 공란이 있어서 4 --%>
공란 제거 후 주소명 길이 ${fn:length(fn:trim(address)) }<br><br>
특정 문자열이 존재하는 지 확인
${fn:contains(address,'야')} <br><br>
특정 문자열로 시작하는지 확인
${fn:startsWith(fn:trim(address),'야')}<br><br>
<%-- jsp:include와 같은 역할 --%>
<c:import url="http://www.google.co.kr"></c:import>

step10-empty.jsp
</body>
</html>