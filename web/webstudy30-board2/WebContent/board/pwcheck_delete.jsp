<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/board.css" type="text/css">
<script type="text/javascript">
</script>
</head>
<body>
<form name="pwCheckForm" action="${pageContext.request.contextPath}/DispatcherServlet">
패스워드 <input type="password" name="password" required="required"><br>
<input type="hidden" name="command" value="pwDel">
<input type="submit" value="삭제" >
<input type="button" value="창끄기" onclick="javascript:self.close()">
</form>
</body>
</html>