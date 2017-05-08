<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var checkResultId="";		
		$("#regForm").submit(function(){			
			if($(":input[name=id]").val().trim()==""){
				alert("아이디를 입력하세요");				
				return false;
			}
			if($(":input[name=password]").val().trim()==""){
				alert("패스워드를 입력하세요");				
				return false;
			}
			if($(":input[name=name]").val().trim()==""){
				alert("이름을 입력하세요");				
				return false;
			}
			if($(":input[name=address]").val().trim()==""){
				alert("주소를 입력하세요");				
				return false;
			}	
			if(checkResultId==""){
				alert("아이디 중복확인을 하세요");
				return false;
			}		
		});
		$(":input[name=id]").keyup(function(){
			var id=$(this).val().trim();
			if(id.length<4 || id.length>10){
				$("#idCheckView").html("아이디는 4자이상 10자 이하여야 함!").css(
						"background","pink");
				checkResultId="";
				return;
			}
			
			$.ajax({
				type:"POST",
				url:"idcheckAjax.do",				
				data:"id="+id,	
				success:function(data){						
					if(data=="fail"){
					$("#idCheckView").html(id+" 사용불가!").css("background","red");
						checkResultId="";
					}else{						
						$("#idCheckView").html(id+" 사용가능!").css(
								"background","yellow");		
						checkResultId=id;
					}					
				}//callback			
			});//ajax
		});//keyup
	});//ready
</script>
</head>
<body>
<a href="index.do">홈으로</a>
<form method="post" action="registerMember.do" id="regForm">
아이디 <input type="text" name="id"><span id="idCheckView"></span><br>
비밀번호 <input type="password" name="password"><br>
이름 <input type="text" name="name"><br>
주소 <input type="text" name="address"><br>
<input type="submit" value="가입하기">
</form>
<%--	  register.jsp -- MemberController
								|
								register_result.jsp 
								가입정보 출력 
								새로고침시 재등록 되지 않는다 
				ajax(jquery)로 
				id 중복확인을 한다 				
		 --%>
</body>
</html>











