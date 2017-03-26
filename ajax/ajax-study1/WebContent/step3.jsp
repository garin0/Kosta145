<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax</title>
<script type="text/javascript">
	function startAjax() {
		xhr = new XMLHttpRequest; // ajax 통신 객체 생성
	 	var idComp = document.getElementById("dept");
		if(idComp.value==""){
			alert("부서번호를 선택하세요!");
			document.getElementById("deptInfo").innerHTML ="";
			return;
		}
		xhr.onreadystatechange = callback;//응답시 실행할 함수 등록
		xhr.open("post","DeptServlet");
		//ajax post 방식일 때 content type을 지정해야 한다. 
		xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		xhr.send("no="+idComp.value); 
	}
	function callback() {
		if(xhr.status == 200 && xhr.readyState == 4){
			document.getElementById("deptInfo").innerHTML = xhr.responseText;
		}
    }
</script>
</head>
<body>
<select id="dept" onchange ="startAjax()">
	<option value="">---부서번호---</option>
	<option value="10">10</option>
	<option value="20">20</option>
	<option value="30">30</option>
</select>
<span id="deptInfo"></span>
</body>
</html>