<%@page import="model.PersonVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp에서 ArrayList 연습</title>
</head>
<body>
<% ArrayList<PersonVO> list= new ArrayList<PersonVO>();
	list.add(new PersonVO("김문일",22));
	list.add(new PersonVO("손연재",24));
	list.add(new PersonVO("박보검",25));
%>
<table border="1" cellpadding="10">
	<thead>
		<tr>
			<th>이름</th><th>나이</th>
		</tr>
	</thead>
	<tbody>
			<% for(int i =0; i<list.size();i++){ %>
			<tr><th><%= list.get(i).getName() %></th>
			<th><%= list.get(i).getAge() %></th></tr>
			<%} %>
	</tbody>
</table>
</body>
</html>