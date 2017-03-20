<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/board.css" type="text/css">
<script type="text/javascript">
function delAction(){
	var pass=document.delCheckForm.password.value;
	if(pass==""){
		alert("패스워드를 입력하세요!");
	}else{
		document.delCheckForm.submit();
	}	
}
</script>
</head>
<body>
<form name="delCheckForm" action="${pageContext.request.contextPath}/DispatcherServlet" method="post">
패스워드 <input type="password" name="password" required="required"><br>
<input type="hidden" name="command" value="deleteCheckPassword">
<input type="hidden" name="no" value="${param.no}">
<input type="button" value="삭제" onclick="delAction()">
<input type="button" value="창끄기" onclick="javascript:self.close()">
</form>
</body>
</html>