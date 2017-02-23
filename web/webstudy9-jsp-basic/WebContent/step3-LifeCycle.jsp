<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp step3-LifeCycle</title>
</head>
<body>
<%!
//메서드 오버라이딩
 public void jspInit(){
	System.out.println("jspInit");
}
 public void jspDestroy(){
	 System.out.println("jspDestroy");
 }
%>
<% System.out.println("jspService"); %>
JSP LifeCycle Test
</body>
</html>