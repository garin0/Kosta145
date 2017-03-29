<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax</title>
<script type="text/javascript">
 var xhr;
 function startAjax() {
	xhr = new XMLHttpRequest; // ajax 통신 객체 생성
 	var idComp = document.getElementById("memberId");
	if(idComp.value == ""){
		alert("아이디를 입력하세용");
		idComp.focus();
		return; // 함수 실행 중단
	}
	xhr.onreadystatechange = callback;//응답시 실행할 함수 등록
	xhr.open("post","AjaxMemberServlet");
	//ajax post 방식일 때 content type을 지정해야 한다. 
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	xhr.send("id="+idComp.value);

 }
 function callback() {
		// 200 정상 수행 4 응답완료 
		if(xhr.status == 200 && xhr.readyState == 4){
			//아래 span 영역에 응답하는 데이터를 출력한다.
			document.getElementById("resultView").innerHTML = xhr.responseText;
		}
 }
</script>
</head>
<body>
<input type="text" id="memberId">
<input type="button" value="검색" onclick="startAjax()">
<span id="resultView"></span>
</body>
</html>