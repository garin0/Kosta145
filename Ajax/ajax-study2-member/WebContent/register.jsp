<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register</title>
<script type="text/javascript">
	function openPopup(){
		var memId = document.registerForm.id.value;
		if(memId ==""){
			alert("아이디를 입력하세요!");
		}else{
			open("DispatcherServlet?command=idcheck&id="+memId,"mypopup","width=200,height=200,top=150,left=400");
		}
	}
	function registerData() {
		var hidden = document.registerForm.data.value;
		var id = document.registerForm.id.value;
		if (hidden != id) {
			alert("인증받은 아이디가 아닙니다. 다시 아이디 중복확인 하세요");
			return false;
		}
	}
</script>
</head>
<body>
<h3>회원가입</h3>
<form name="registerForm" action="DispatcherServlet" method="post" onsubmit="return registerData()">
아이디: <input type="text" name="id" required="required"> 
<input type="button" name="checkId" value="중복체크" onclick="openPopup()"><br>
<input type="hidden" name="data" value="false">
<input type="hidden" name="command" value="register">
패스워드: <input type="password" name="password" required="required"><br>
이름: <input type="text" name="name" required="required"><br>
주소: <input type="text" name="address" required="required"><br>
<input type="submit" value="회원가입">
</form>
</body>
</html>