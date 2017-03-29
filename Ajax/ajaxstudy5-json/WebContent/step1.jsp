<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>json(javascript object notation)</title>
<script type="text/javascript">
	var xhr;
	function startAjax() {
		var id=document.getElementById("memberId").value;
		var nameView=document.getElementById("nameView");
		var addressView=document.getElementById("addressView");
 		if(id==""){
 			nameView.innerHTML="";
 			addressView.innerHTML="";
			return; //메서드 실행 중단 
		}
		xhr=new XMLHttpRequest();//ajax 통신 객체		
		//콜백함수 , 서버가 응답하면 실행될 함수를 등록 
		xhr.onreadystatechange=callback;
		xhr.open("get","FindMemberByIdServlet?id="+id);
		xhr.send(null); //get 방식일때는 null로 명시해야 함
	}
	 function callback(){
		  if(xhr.readyState==4){// 4 : 응답완료 
		   if(xhr.status==200){// 200 : 정상수행 
			   //javascript object 변환
		   		var memObj = JSON.parse(xhr.responseText);
		   		nameView.innerHTML = memObj.name;	
		   		addressView.innerHTML = memObj.address;
		   }
		  }
		 }
</script>
</head>
<body>
<select id="memberId" onchange="startAjax()">
	<option value="">----</option>
	<option value="java">java</option>
	<option value="spring">spring</option>
	<option value="ajax">ajax</option>
</select>
<hr><br><br>
회원이름 <span id="nameView"></span><br>
주소 <span id="addressView"></span>
<%-- 
	1. 선택한 아이디를 alert 출력
		아이디 정보가 공란이면 return으로 실행 중단
	2. Ajax 통신을 위한 XMLHttpRequest 객체 생성
	3. callback 익명 함수 정의 
	4. open("get","FindMemberByIdServlet");
	5. send(null) --> get 방식일때는 null로 명시해야 함
 --%>
</body>
</html>