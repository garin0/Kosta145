<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
 function checkRegister(){
	 var d = document.registerItem;
	 if(d.itemName.value == ""){
		 alert("상품명을 입력해주세요");
		 return false;
	 }
	 if(d.itemMaker.value == ""){
		 alert("제조사 입력해주세요");
		 return false;
	 }
	 if(d.itemPrice.value == ""){
		 alert("상품 가격을 입력해주세요");
		 return false;
	 }
 }
</script>
</head>
<body>
	<form action="register-action.jsp" method="post" name="registerItem" onsubmit="return checkRegister()">
		상품명 <input type="text" name ="itemName"><br>
		제조사<input type="text" name ="itemMaker" ><br>
		가격<input type="text" name ="itemPrice"><br>
		<input type="submit" value="등록">
	</form>
</body>
</html>