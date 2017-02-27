<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step5-ServletContext</title>
</head>
<body>
jsp에서는 ServletContext 객체를 반환받아 application(내장객체) 변수명에 할당한다.
<br>
<%= application.getContextPath() %>
<br>
서블릿 컨텍스트 초기 파라미터 관리자 이메일 출력
<%= application.getInitParameter("adminEmail") %>
<br> 서블릿컨텍스트에 저장된 정보를 반환
<%= application.getAttribute("memberInfo") %>

</body>
</html>