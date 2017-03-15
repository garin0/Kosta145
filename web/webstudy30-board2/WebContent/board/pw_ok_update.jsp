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
	if(confirm("삭제하시겠습니까?")){
		opener.document.location.href="${pageContext.request.contextPath}/board/update.jsp?no=${sessionScope.no}";
		self.close();
	}else{
		self.close();
	}
</script>
</body>
</html>