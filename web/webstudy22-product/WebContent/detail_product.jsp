<%@page import="model.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detail_product</title>
<link rel="stylesheet" type="text/css" href="product_style.css">
<script type="text/javascript">
	 function deleteProduct(no) {
		if(confirm("상품을 삭제하시겠습니까?") == true){ //삭제 버튼 누르면
			location.href="DispatcherServlet?command=delete&no="+no;
		}else{
			return;
		}
	}
</script>
</head>
<body>
<a href="index.jsp">Home</a> <a href="list_product.jsp">상품목록</a><hr>
<% ProductVO vo = (ProductVO)request.getAttribute("vo");
if(vo!=null){%>
	<table>
		<tr>
			<td>상품번호</td><td><%= vo.getProductNO() %></td>
		</tr>
				<tr>
			<td>상품명</td><td><%= vo.getName() %></td>
		</tr>
				<tr>
			<td>제조사</td><td><%= vo.getMaker() %></td>
		</tr>
				<tr>
			<td>가격</td><td><%= vo.getPrice() %></td>
		</tr>
				<tr>
			<td>등록일시</td><td><%= vo.getDate() %></td>
		</tr>
		<tr>
			<td colspan="2"><div id="btn"><input type=button id="delete_btn" name="delete" value="삭제" onclick="deleteProduct(<%=vo.getProductNO()%>)"></div></td>
		</tr>
	</table>
<%} %>
</body>
</html>