<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
<link rel="stylesheet" type="text/css" href="css/home.css">
</head>
<body>
<div class="container">
	<div class="header"> <jsp:include page="layout/header.jsp"></jsp:include></div>
	<div class="left">
		<jsp:include page="layout/left.jsp"></jsp:include>
	</div>
	<div class="main">
		<table class="listTable">
				<tr>
					<th>번호</th><th>제품명</th><th>제조사</th>
				</tr>
			<c:forEach items="${sessionScope.list }" var="item">
				<tr>
					<td><a href="DispatcherServlet?command=detail&no=${item.itemNo}">${item.itemNo }</a></td><td>${item.name }</td><td>${item.maker }</td>
				</tr>
			</c:forEach>
		</table>

	</div>
	<div class="footer"><jsp:include page="layout/footer.jsp"></jsp:include></div>
</div>
</body>
</html>