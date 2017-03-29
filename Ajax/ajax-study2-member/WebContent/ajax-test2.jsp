<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax-test2</title>
<script type="text/javascript">
	function startAjax() {
		var idComp = document.getElementById("memberId");
		if(idComp.value==""){
			alert("아이디를 입력하세요");
			return;
		}
		// 서버가 응답하면 실행할 익명함수를 등록(콜백함수)
		xhr = new XMLHttpRequest; // ajax 통신 객체 생성
		xhr.onreadystatechange = function(){
			if(xhr.status == 200 && xhr.readyState == 4){ //4:응답완료, 200:정상수행
				//alert(xhr.responseText);//서버가 응답한 데이터를 출력
				document.getElementById("idView").innerHTML = xhr.responseText;
			}//if
		}//callback0
		//응답시 실행할 함수 등록
		xhr.open("get","DispatcherServlet?command=idCheckAjax&id="+idComp.value);
		xhr.send(null);//post 방식일 때 데이터 전송용으로 사용,get방식일때 null로 명시
	}
</script>
</head>
<body>
<input type="text" id ="memberId">
<input type="button" value="확인" onclick="startAjax()">
<span id="idView"></span>
</body>
</html>