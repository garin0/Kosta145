<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>content</title>
<script type="text/javascript">
	function sendList() {
		location.href= "DispatcherServlet?command=list&page=1";
	}
	function winOpen(kind){	
		if(confirm(kind+"하시겠습니까?")){
			location.href= "DispatcherServlet?command="+kind+"&no=${requestScope.no }";
		}else{return;}
		
	}
</script>
</head>
<body>
<jsp:include page="/template/header.jsp"></jsp:include>
	<table class="content">
		<tr>
			<td>NO : ${requestScope.no } </td>
			<td colspan="2">${requestScope.vo.title }</td>
		</tr>
		<tr>
			<td>작성자 : ${requestScope.writer }</td>
			<td> ${requestScope.vo.timePosted }</td>
			<td>조회수: ${requestScope.vo.hits }</td>
		</tr>
		<tr>
			<td colspan="3">
			<pre>${requestScope.vo.content }</pre>
			</td>
		</tr>
		<tr>
			<td valign="middle" align="center" colspan="3">
			 <img class="action" src="${pageContext.request.contextPath}/img/list_btn.jpg" onclick="sendList()" >
			 <c:if test="${sessionScope.mvo.id == requestScope.vo.id}" >
			 <img class="action"  onclick="winOpen('delete')" 	src="${pageContext.request.contextPath}/img/delete_btn.jpg" > 
			 <img class="action"  onclick="winOpen('update')"  src="${pageContext.request.contextPath}/img/modify_btn.jpg" >
			 </c:if>
			 </td>
		</tr>
	</table>
</body>
</html>