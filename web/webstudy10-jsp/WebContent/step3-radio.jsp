<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function checkFriend() {
		var f = document.friendForm.friend.value;
		if(f == ""){
			alert("선택하세요");
			return false;
		}
	}

</script>
</head>
<body>
<form method="post" action="step3-radio-action.jsp" name ="friendForm" onsubmit="return checkFriend()">
<input type="radio" name="friend" value="서강준">서강준<br>
<input type="radio" name="friend" value="이제훈">이제훈<br>
<input type="radio" name="friend" value="박보검">박보검<br>
<input type="submit" value="선택">

</form>
</body>
</html>