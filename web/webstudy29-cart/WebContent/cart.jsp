<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
<link rel="stylesheet" type="text/css" href="css/home.css">
<script type="text/javascript">
function deleteItem(no) {
	if(confirm("상품을 삭제하시겠습니까?") == true){ //삭제 버튼 누르면
		location.href="DispatcherServlet?command=delete&no="+no;
	}else{
		return;
	}
}
</script>
</head>
<body>
<div class="container">
	<div class="header"> <jsp:include page="layout/header.jsp"></jsp:include></div>
	<div class="left">
		<jsp:include page="layout/left.jsp"></jsp:include>
	</div>
	<div class="main">
<% if(session.getAttribute("cart") != null){ %>
<span class="centerTxt">쇼핑카트</span>
		<table class="cartTable">
			<c:forEach items="${sessionScope.cart }" var="cart">
				<tr>
				<td>${cart.itemNo }</td><td>${cart.name }</td><td>${cart.maker }</td><td>${cart.price }</td>
				<td><input type="button" value="삭제" onclick="deleteItem(${cart.itemNo})"></td>
				</tr>
			</c:forEach>
			<%-- 총합 계산 --%>
			<c:set var="total" value="${0}"/>
			<c:forEach var="list" items="${sessionScope.cart}">
			    <c:set var="total" value="${total + list.price}" />
			</c:forEach>
			<tr><td colspan="5">
			<c:out value="총액 : ${total}"/>
			</td><tr>
		</table>
<%}else{ %> 장바구니가 비었습니다!<%} %>
	</div>
	
	<div class="footer"><jsp:include page="layout/footer.jsp"></jsp:include></div>
</div>
</body>
</html>