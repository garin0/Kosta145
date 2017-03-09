<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL param test</title>
</head>
<body>
<a href="step1.jsp">step1</a><br><br>
1. 기존 방식으로 파라미터 출력
<%= request.getParameter("memberName") %><%-- null이어도 출력된다. --%>
 <%= request.getParameter("age")+1 %><%--문자열로 인식211 --%>
<hr>
2. EL로 파라미터 출력 <%-- EL은 null일 경우 출력 안됨 --%>
${param.memberName } ${param.age+1 } <%-- 자동 형 변환 22 --%>
<hr>
<form action="step3.jsp">
<input type="checkbox" name="food" value="피자">피자<br>
<input type="checkbox" name="food" value="족발">족발<br>
<input type="checkbox" name="food" value="맥주">맥주<br>
<input type="submit" value="주문">
</form>
</body>
</html>