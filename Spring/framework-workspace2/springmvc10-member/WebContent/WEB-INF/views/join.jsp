<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var userId = $(this).val();
		var idCheck = $("#idCheck");
		var checkFlag = false;
		$("#submitBtn").click(function(){
			 if(checkFlag==false){
				 alert("가입 불가능!");
				 return false;
			 }else{
				 return true;
			 }
		});
		$("#usrId").keyup(function() {
			if ($(this).val().length < 4 || $(this).val().length > 10) {
				idCheck.html("아이디는 4자 이상 10자 이하이어야 함!").css("background-color", "pink");
				return;
			}
			$.ajax({
				url : "idCheck.do",
				dataType : "json",
				type : "post",
				data : "id=" + $(this).val(),
				success : function(json) {
					if (json == true) {
						idCheck.html("아이디 사용가능").idCheck.css("background-color", "yellow");
						checkFlag= true;
					}else if(json ==false){
						idCheck.html("아이디 사용불가").css("background-color", "red");
					}
				}
			});

		});
	})
</script>
</head>
<body>
	<a href="index.do">홈</a>
	<br>
	<form id="joinForm" action="join.do" method="post">
		아이디 <input type="text" name="id" id="usrId">
		 <span id="idCheck"></span> <br> 
		 비밀번호 <input type="password" name="password"><br> 이름 <input type="text" name="name"><br>
		주소 <input type="text" name="address"><br> 
		<input type="submit" id="submitBtn" value="가입하기">
	</form>
</body>
</html>