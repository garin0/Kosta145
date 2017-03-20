<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/board.css" type="text/css">
<script type="text/javascript">
function upAction(){
	var pass=document.upCheckForm.password.value;
	if(pass==""){
		alert("패스워드를 입력하세요!");
	}else{
		document.upCheckForm.submit();
	}	
}
</script>
</head>
<body>
<form name="upCheckForm" action="${pageContext.request.contextPath}/DispatcherServlet" method="post">
패스워드 <input type="password" name="password" required="required"><br>
<input type="hidden" name="command" value="updateCheckPassword">
<input type="hidden" name="no" value="${param.no}">
<input type="button" value="수정" onclick="upAction()">
<input type="button" value="창끄기" onclick="javascript:self.close()">
</form>
</body>
</html>