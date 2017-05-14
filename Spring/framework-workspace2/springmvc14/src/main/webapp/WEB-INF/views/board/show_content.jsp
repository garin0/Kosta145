<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>show_content</title>
<link rel="stylesheet" href="/springmvc14/resources/css/board.css" type="text/css">
<script src="//code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    $("#updateImg").click(function(){
    	if(confirm("수정하시겠습니까?")==true){
    		location.href="board_updateView.do?no="+${bvo.no};
    	}else{
    		return false;
    	}
    });
    $("#listImg").click(function(){
    	location.href="index.do";
    });
    $("#deleteImg").click(function(){
    	if(confirm("삭제 하시겠습니까?")==true){
    		location.href="board_deletePosting.do?no="+${bvo.no};
    	}else{
    		return false;
    	}
    });
});
</script>
</head>
<body>
<p>
<jsp:include page="../member/login.jsp"></jsp:include> 
</p>
<hr>
<table class="content">
		<tr>
			<td>NO : ${bvo.no}</td>
			<td colspan="2">${bvo.title}</td>
		</tr>
		<tr>
			<td>작성자 :  ${bvo.memberVO.name}</td>
			<td> ${bvo.time_posted}</td>
			<td>조회수 : ${bvo.hit}</td>
		</tr>
		<tr>
			<td colspan="3">
			<pre>${bvo.content}</pre>
			</td>
		</tr>
		<c:if test="${bvo.memberVO.id == sessionScope.mvo.id }">
			<tr>
			<td valign="middle" align="center" colspan="3">
			 <img id="listImg" class="action" src="/springmvc14/resources/img/list_btn.jpg" onclick="sendList()" >
			 
			 <img id="deleteImg" class="action" src="/springmvc14/resources/img/delete_btn.jpg" > 
			 <img id="updateImg" class="action" src="/springmvc14/resources/img/modify_btn.jpg" >
			 
			 <br><br>			
			 </td>
		</tr>
		</c:if>
	
	</table>
</body>
</html>