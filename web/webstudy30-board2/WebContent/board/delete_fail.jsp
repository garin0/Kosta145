<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	alert("비밀번호가 일치하지 않습니다!");
	opener.document.location.href="${pageContext.request.contextPath}/DispatcherServlet?command=list";
	self.close();
</script>
</body>
</html>