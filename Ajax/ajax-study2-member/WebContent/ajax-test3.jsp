<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>javascript keyup</title>
<script type="text/javascript">
	function testKeyup() {
		//alert("test");
		// view 영역에 입력한 아이디 정보가 출력되게 한다.
		var mid = document.getElementById("memberId").value;
		
		document.getElementById("view").innerHTML = mid;
	}
</script>
</head>
<body>
<input type="text" id="memberId" onkeyup="testKeyup()">
<span id ="view"></span>
</body>
</html>