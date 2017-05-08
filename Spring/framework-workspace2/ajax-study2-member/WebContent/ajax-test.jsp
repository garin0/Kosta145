<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax test 용</title>
<script type="text/javascript">
function startAjax() {
	xhr = new XMLHttpRequest; // ajax 통신 객체 생성
	xhr.onreadystatechange = callback;//응답시 실행할 함수 등록
	xhr.open("post","DispatcherServlet");
	//ajax post 방식일 때 content type을 지정해야 한다. 
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	xhr.send("command=memberCount");  
}
function callback() {
	if(xhr.status == 200 && xhr.readyState == 4){
		document.getElementById("count").innerHTML = xhr.responseText;
	}
} 
</script>
</head>
<body>
<input type="button" value="총회원수보기" onclick="startAjax()">  <span id="count"></span>명
<%-- command: memberCount, MemberCountController --%>
</body>
</html>