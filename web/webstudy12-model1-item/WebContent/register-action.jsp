<%@page import="model.ItemVO"%>
<%@page import="model.ItemDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>register-action.jsp</title>
</head>
<body>
<% request.setCharacterEncoding("utf-8");
ItemDAO dao = ItemDAO.getInstance();
String name = request.getParameter("itemName");
String maker = request.getParameter("itemMaker");
int price = Integer.parseInt(request.getParameter("itemPrice"));
dao.registerItem(new ItemVO(name,maker,price)); 
%>
<%= name %> 상품등록 완료
</body>
</html>