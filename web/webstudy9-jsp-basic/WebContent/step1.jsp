<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp 기본문법</title>
</head>
<body>
<!-- 이 부분은 html 주석 -->
<%-- 이 부분은 jsp 주석 --%>
<h3>jsp 기본문법 테스트</h3>
<% 
//자바 코드 영역(스크립틀릿)
	 /* for 문을 이용해 1부터 100까지 화면에 출력해본다. */
for(int i = 1 ; i <= 100 ; i++){
	out.println(i+" ");
}%>
<hr>
<%-- 아래와 같은 형식의 코딩을 권장한다.
expression 태그를 이용해 표현 --%>
<% 
for(int i = 1 ; i <= 100 ; i++){ %>
<font color="blue" size="5"><%=i%></font>
<%} %>
<hr>
변수 테스트<br>
<% int age = 22; %> <%-- 지역변수로 선언된다.--%>
<%! int money =100; %><%-- 인스턴스 변수로 선언된다. --%>
money <%=money %>
age <%=age %>
</body>
</html>