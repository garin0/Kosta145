<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 ajax</title>
<script type="text/javascript">
var checkFlag;
function startAjax() {
	checkFlag =false;
	var checkResultView = document.getElementById("checkResult");
	if(idComp.length<4||idComp.length>10){
		checkResultView.innerHTML = "<font color=orange>아이디는 4자 이상 10자 이어야 함</font>";
		return;
	}
	xhr = new XMLHttpRequest; 
	xhr.onreadystatechange = function(){
		if(xhr.status == 200 && xhr.readyState == 4){ 
			checkResultView.innerHTML="";
			if(xhr.responseText=="true"){
				checkResultView.innerHTML = "<font color=red>사용불가</font>";
			}else{
				checkResultView.innerHTML = "<font color=blue>사용가능</font>";
				checkFlag = true;
			}
		}
	}
	var idComp = document.getElementById("id").value;
	xhr.open("get","DispatcherServlet?command=registerAjax&id="+idComp);
	xhr.send(null);

}

</script>
</head>
<body>
<h3>회원가입</h3>
<form name="registerForm" action="DispatcherServlet" method="post" onsubmit="return registerData()">
아이디: <input type="text" name="id" id="id" required="required" onkeyup="startAjax()"> 
<span id="checkResult"></span><br>
<input type="hidden" name="command" value="register">
패스워드: <input type="password" name="password" required="required"><br>
이름: <input type="text" name="name" required="required"><br>
주소: <input type="text" name="address" required="required"><br>
<input type="submit" value="회원가입">
</form>
<%-- MemberIdCheckController
	 아이디가 4자이상 10자 이하일 때만 가입 가능
	 반드시 중복확인해서 아이디 사용가능일때만
	 회원가입이 되도록 한다. 
	 
	 입력한 아이디가 4자 이상 10자 이하가 아닐때는
	 span checkResult 영역에 아이디는 4자 이상 10자 이하이어야 합니다.
	 아이디가 4자 이상 10자 이하일때는 사용가능 or 사용불가--%>
</body>
</html>