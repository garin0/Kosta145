<%@page import="model.ItemVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.ItemDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>detail_item.jsp</title>
<link rel="stylesheet" type="text/css" href="mystyle.css">
</head>
<body>
<% request.setCharacterEncoding("utf-8");
ItemDAO dao = ItemDAO.getInstance(); 
ArrayList<ItemVO> list = dao.detailItem();
%>
<table>
	<tr>
		<th>no</th><th>이름</th><th>제조사</th><th>가격</th>
	</tr>
	<%  int no = Integer.parseInt(request.getParameter("item_no"));%>
	<% for(int i=0;i<list.size();i++){
		if(list.get(i).getItem_no() == no){
	%>
	<tr>
		<td><%=list.get(i).getItem_no() %></td>
		<td><%=list.get(i).getName() %></td>
		<td><%=list.get(i).getMaker()%></td>
		<td><%=list.get(i).getPrice() %></td>
	</tr>
<%}} %>
</table>
</body>
</html>