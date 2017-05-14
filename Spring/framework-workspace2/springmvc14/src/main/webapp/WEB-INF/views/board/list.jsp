<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
<link rel="stylesheet" href="/springmvc14/resources/css/board.css" type="text/css">
</head>
<body>
	
<p>
<jsp:include page="../member/login.jsp"></jsp:include> 
</p>
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
		
		<tbody>			
			<c:forEach items="${map.list }" var="list">
			<tr>
			    <td>${list.no}</td>				
				<td>
				<c:choose>
					<c:when test="${sessionScope.mvo!=null}">
						 <a href="/springmvc14/board_showContentHit.do?no=${list.no}">${list.title }</a>
					</c:when>
					<c:otherwise>
						${list.title }
					</c:otherwise>
				</c:choose>
				</td>
				<%-- <<td>${list.smid }</td> --%>
				<td>${list.memberVO.name }</td>
				<td>${list.time_posted }</td>
				<td>${list.hit }</td>
			</tr>	
			</c:forEach>
		</tbody>					
	</table><br></br>	
	 <c:if test="${sessionScope.mvo!=null}">
	 <a href="board_writeView.do"><img  src="/springmvc14/resources/img/write_btn.jpg" border="0"></a>
	 </c:if>
	
	
	<br><br>	
<p class="paging">
		<c:if test="${map.pb.previousPageGroup}">
			<a href="/springmvc14/list.do?&page=${map.pb.startPageOfPageGroup-1}">◀</a>
		</c:if>
		<c:forEach begin="${map.pb.startPageOfPageGroup }" end="${map.pb.endPageOfPageGroup }" var="page" varStatus="order">
			<c:choose>
				<c:when test="${order.count == map.pb.nowPage }">[${page }]</c:when>
				<c:otherwise><a href="/springmvc14/list.do?&page=${page}">[${page }]</a></c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${map.pb.nextPageGroup}">
			<a href="/springmvc14/list.do?&page=${map.pb.endPageOfPageGroup+1}">▶</a>
		</c:if>
	</p>
</body>
</html>