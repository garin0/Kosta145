<%@page import="model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>

<body>

<jsp:include page="/template/header.jsp"></jsp:include>

<hr>	
	<table class="list">
		<caption>목록</caption>
		<thead>
		<tr>
			<th class="no">NO</th>
			<th class="title">제목</th>
			<th class="name">이름</th>
			<th class="date">작성일</th>
			<th class="hit">HIT</th>
			</tr>
		</thead>
		<c:forEach items="${requestScope.listVO.list }" var="board">
			<tr>
			    <td>${board.no }</td>				
				<td><a href="DispatcherServlet?command=showContent&no=${board.no }" >
				${board.title }</a></td>
				<td>${board.writer }</td>
				<td>${board.timePosted }</td>
				<td>${board.hits }</td>
			</tr>			
		</c:forEach>						
		
	</table><br></br>		
<c:if test="${sessionScope.mvo != null}" >
<a href="${pageContext.request.contextPath}/board/write.jsp"><img  src="${pageContext.request.contextPath}/img/write_btn.jpg" border="0"></a>
</c:if>

	<br><br>	
	<p class="paging">
		<c:if test="${requestScope.listVO.pagingbean.previousPageGroup}">
			<a href="${pageContext.request.contextPath}/DispatcherServlet?command=list&page=${requestScope.listVO.pagingbean.startPageOfPageGroup-1}">◀</a>
		</c:if>
		<c:forEach begin="${requestScope.listVO.pagingbean.startPageOfPageGroup }" end="${requestScope.listVO.pagingbean.endPageOfPageGroup }" var="page" varStatus="order">
			<c:choose>
				<c:when test="${order.count == requestScope.listVO.pagingbean.nowPage }">[${page }]</c:when>
				<c:otherwise><a href="${pageContext.request.contextPath}/DispatcherServlet?command=list&page=${page }">[${page }]</a></c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${requestScope.listVO.pagingbean.nextPageGroup}">
			<a href="${pageContext.request.contextPath}/DispatcherServlet?command=list&page=${requestScope.listVO.pagingbean.endPageOfPageGroup+1}">▶</a>
		</c:if>
	</p>
</body>
</html>