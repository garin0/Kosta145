<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 실패</title>
</head>
<body>
<script type="text/javascript">
 	alert("아이디와 패스워드 불일치!");
 	location.href="${pageContext.request.contextPath}/stockmarket.do";
</script>
</body>
</html>