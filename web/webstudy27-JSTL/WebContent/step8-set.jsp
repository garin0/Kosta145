<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	PersonVO pvo = new PersonVO();
	pvo.setName("김문일"); pvo.setCar(new CarVO("아우디",4000));
	request.setAttribute("person", pvo);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl test</title>
</head>
<body>
<%-- el로 접근시에는 getter를 호출!! --%>
${requestScope.person.car.model}<br>
${requestScope.person.name}<br>
<%-- 특정정보가 자주 사용될 때는 set을 이용한다. --%>
<c:set value="${requestScope.person }" var="p"/>
${p.name } ${p.car.model }
<hr>
<c:set value="${requestScope.person.car }" var="c"/>
${c.price }
</body> 
</html>