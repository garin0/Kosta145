<%@page import="model.TestVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL get,is method</title>
</head>
<body>
<% 
	TestVO vo = new TestVO();
	request.setAttribute("vo", vo);
%>
<%--
	!!!!! EL은 get method와 is method에 접근 가능하다.
--%>
1. name 출력: ${requestScope.vo.name }<br>
<%-- findNick()메서드는 EL로 접근불가, 즉 get으로 시작되어야 한다. --%>
2. nick 출력: ${requestScope.vo.nickName }<br>
<%-- ${requestScope.vo.nick } --%>
3. file 출력: ${requestScope.vo.file }<br>
4. money 출력 : ${requestScope.vo.money }<br>
5. 연산 테스트 :  ${requestScope.vo.money+200 }<br>
${requestScope.vo.money==200 }
${requestScope.vo.money<200 }
${requestScope.vo.money>200 && requestScope.vo.name =='김호겸' }
</body>
</html>