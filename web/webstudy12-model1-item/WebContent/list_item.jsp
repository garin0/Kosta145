<%@page import="model.ItemVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.ItemDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>list_item.jsp</title>
<link rel="stylesheet" type="text/css" href="mystyle.css">
</head>
<body>
<% request.setCharacterEncoding("utf-8");
ItemDAO dao = ItemDAO.getInstance(); 
ArrayList<ItemVO> list = dao.listItem();
%>
<table>
	<tr>
		<th>no</th><th>이름</th>
	</tr>
	<% for(int i=0;i<list.size();i++){ %>
	<tr>
		<td><%=list.get(i).getItem_no() %></td>
		<td><a href= "detail_item.jsp?item_no=<%=list.get(i).getItem_no()%>"><%=list.get(i).getName() %></a></td>
	</tr>
<%} %>
</table>

</body>
</html>