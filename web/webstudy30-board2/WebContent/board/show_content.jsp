<%@page import="model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>show_content.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/board.css" type="text/css">
<script type="text/javascript">
	function sendList() {
		location.href= "DispatcherServlet?command=list";
	}
	function winOpen(message){
		if(message == 'delete'){
			open("DispatcherServlet?flag=delete&command=pwcheck&no=${requestScope.vo.no }","패스워드 확인","width=200,height=200,top=150,left=400");
		}
		else if(message == 'update'){
			open("DispatcherServlet?flag=update&command=pwcheck&no=${requestScope.vo.no }","패스워드 확인","width=200,height=200,top=150,left=400");
		}
	}
</script>
</head>
<body>

<jsp:include page="/template/header.jsp"></jsp:include>
<table class="content">
		<tr>
			<td>NO :${requestScope.vo.no }</td>
			<td colspan="2">${requestScope.vo.title }</td>
		</tr>
		<tr>
			<td>작성자 :  ${requestScope.vo.writer }</td>
			<td> ${requestScope.vo.timePosted }</td>
			<td>조회수 : ${requestScope.vo.hits }</td>
		</tr>
		<tr>
			<td colspan="3">
			<pre>${requestScope.vo.content}</pre>
			</td>
		</tr>
		<tr>
			<td valign="middle" align="center" colspan="3">
			 <img class="action" src="${pageContext.request.contextPath}/img/list_btn.jpg" onclick="sendList()" >
			 <img class="action"  onclick="winOpen('delete')" 	src="${pageContext.request.contextPath}/img/delete_btn.jpg" > 
			 <img class="action"  onclick="winOpen('update')"  src="${pageContext.request.contextPath}/img/modify_btn.jpg" ></td>
		</tr>
	</table>
</body>
</html>