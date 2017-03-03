<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update_result</title>
</head>
<body>
<%-- forward 방식으로 이동되면 request가 유지되므로 nick을 출력해줄 수 있다. --%>
<%-- <%= request.getParameter("nick") %> --%>
 닉네임 수정 완료
 <%-- forward 방식으로 이동되면 Controller에서 request에 attribute정보를
 setting 하면 아래와 같이 반환받아 출력할 수 있다. --%>
 <%--<%= request.getAttribute("info") %> --%>
</body>
</html>