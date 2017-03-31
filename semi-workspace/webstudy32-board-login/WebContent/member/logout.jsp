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
	if(confirm("로그아웃 하시겠습니까?")){
		location.href= "${pageContext.request.contextPath}/DispatcherServlet?command=logout";
	}else{
		location.href= "${pageContext.request.contextPath}/index.jsp";
	}
</script>
</body>
</html>