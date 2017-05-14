<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/board.css" type="text/css">
<script src="//code.jquery.com/jquery.min.js"></script>
    <script type="text/javascript">
    $(document).ready(function(){
    	$("#listImg").click(function(){    		
    		location.href="${pageContext.request.contextPath}/list.do";
    	});
    	$("#deleteImg").click(function(){ 
    		if(confirm("게시물을 삭제하시겠습니까?"))
    		location.href="${pageContext.request.contextPath}/deleteBoard.do?no=${requestScope.bvo.no}";
    	});
    	$("#updateImg").click(function(){  
    		if(confirm("게시물을 수정하시겠습니까?"))
    		location.href="${pageContext.request.contextPath}/updateView.do?no=${requestScope.bvo.no }";
    	});
    });	
</script>
</head>
<body>
	<jsp:include page="../member/login.jsp"></jsp:include>
	<table class="content">
		<tr>
			<td>NO : ${requestScope.bvo.no } </td>
			<td colspan="2">${requestScope.bvo.title} </td>
		</tr>
		<tr>
			<td>작성자 :  ${requestScope.bvo.memberVO.name }</td>
			<td> ${requestScope.bvo.timePosted }</td>
			<td>조회수 : ${requestScope.bvo.hits }</td>
		</tr>
		<tr>
			<td colspan="3">
			<pre>${requestScope.bvo.content}</pre>
			</td>
		</tr>
		<tr>
			<td valign="middle" align="center" colspan="3">
			 <img id="listImg" class="action" src="${pageContext.request.contextPath}/resources/img/list_btn.jpg" onclick="sendList()" >
			 <c:if test="${requestScope.bvo.memberVO.id==sessionScope.mvo.id}">
			 <img id="deleteImg" class="action"  onclick="deleteBoard()" src="${pageContext.request.contextPath}/resources/img/delete_btn.jpg" > 
			 <img id="updateImg" class="action"  onclick="updateBoard()" src="${pageContext.request.contextPath}/resources/img/modify_btn.jpg" >
			 </c:if>
			 <br><br>			
			 </td>
		</tr>
	</table>
</body>
</html>