<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax 통신의 특징</title>
<script type="text/javascript">
	var xhr;
	function startAjax(){
		xhr = new XMLHttpRequest;
		// alert(xhr);
		// call back 함수 등록: 서버가 응답하면 동작될 함수
		xhr.onreadystatechange=callback;
		xhr.open("get","ASynServlet?id=java");// get방식으로 ASynServlet에 요청
		xhr.send(null);//post 방식일 때 데이터 전송용으로 사용
	}
	function callback(){
		// 200 정상 수행 4 응답완료 
		if(xhr.status == 200 && xhr.readyState == 4){
			//alert("콜백실행");
			document.getElementById("ajaxView").innerHTML = xhr.responseText;
		}
	}
</script>
</head>
<body>
<%-- 기존 동기적 통신은 클라이언트 요청시 새로운 페이지로 응답한다. --%>
<form action="SynServlet">
	<input type="submit" value="기존 통신">
</form>
<input type="button" value="ajax 통신" onclick="startAjax()">
<span id="ajaxView"></span>
<form action=""></form>
</body>
</html>