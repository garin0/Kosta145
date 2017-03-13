<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
<link rel="stylesheet" type="text/css" href="css/home.css">
<script type="text/javascript">
	function addCart(no) {
		if(confirm("상품을 추가하시겠습니까?") == true){ //삭제 버튼 누르면
			location.href="DispatcherServlet?command=addCart&no="+no;
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
		<table class="detailTable">
			<tr>
				<td>NO</td><td>${requestScope.vo.itemNo }</td>
			</tr>
			<tr>
				<td>Name</td><td>${requestScope.vo.name }</td>
			</tr>
			<tr>
				<td>Maker</td><td>${requestScope.vo.maker }</td>
			</tr>
			<tr>
				<td>Price</td><td>${requestScope.vo.price }</td>
			</tr>
			<tr>
				<td>Detail</td><td>${requestScope.vo.detail }</td>
			</tr>
			<% MemberVO vo = (MemberVO)session.getAttribute("mvo");
			if(vo!=null){%>
			<tr>
				<td colspan="2"><input type="button" value="장바구니에 담기" onclick="addCart(${requestScope.vo.itemNo})"></td>
			</tr>
			<%} %>
		</table>
	</div>
	<div class="footer"><jsp:include page="layout/footer.jsp"></jsp:include></div>
</div>
</body>
</html>
