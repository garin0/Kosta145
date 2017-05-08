<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findMemberById</title>
<script type="text/javascript">
	function startAjax() {
		xhr = new XMLHttpRequest; // ajax 통신 객체 생성
	 	var idComp = document.getElementById("memberId");
		if(idComp.value==""){
			alert("아이디를 입력하세요!");
			document.getElementById("memberInfo").innerHTML ="";
			return;
		}
		xhr.onreadystatechange = callback;//응답시 실행할 함수 등록
		xhr.open("post","DispatcherServlet");
		//ajax post 방식일 때 content type을 지정해야 한다. 
		xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		xhr.send("command=findMemberByIdAjax&id="+idComp.value);  
	}
	function callback() {
		if(xhr.status == 200 && xhr.readyState == 4){
			document.getElementById("memberInfo").innerHTML = xhr.responseText;
		}
	} 
</script>
</head>
<body>
<h3>아이디로 회원검색</h3>
<form action="DispatcherServlet">
아이디 <input type="text" name="id" required="required">
<input type="hidden" name="command" value="findById">
<input type="submit" value="검색">
</form>
<hr>
아이디 <input type="text" id="memberId">
<input type="button" value="Ajax검색" onclick="startAjax()">
<span id="memberInfo"></span>
</html>