<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>step3-radio-action.jspe</title>
</head>
<body>
<% request.setCharacterEncoding("utf-8");
String name= request.getParameter("friend");%>
<% if(name.equals("서강준")){
name="a";
}else if(name.equals("이제훈")){ 
name="b";
}else{ 
name="c";
} %>
<img src="picture/<%=name %>.jpg">
</body>
</html>