<%@page import="model.ProductVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 상품 목록</title>
<link rel="stylesheet" type="text/css" href="product_style.css">
</head>
<body>
<a href="index.jsp">Home</a> <a href="register_product.jsp">등록</a><hr>
<% 
@SuppressWarnings("unchecked")
ArrayList<ProductVO> list = (ArrayList<ProductVO>)session.getAttribute("list");
if(list.isEmpty()){%>
ㅠㅠ상품이 없어요ㅠㅠ
<%}else{%>
<table>
<tbody>
<% for(int i=0;i<list.size();i++){  %>
	<tr>
		<td><%=list.get(i).getProductNO() %></td>
		<td>  <a href="DispatcherServlet?command=detail&no=<%=list.get(i).getProductNO()%>">
		        <%=list.get(i).getName() %>
		       </a>
		</td>
		<td><%= list.get(i).getDate() %></td>
	</tr>	
<%} %>	 
</tbody>
</table>
<%} %>
</body>
</html>