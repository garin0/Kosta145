<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="javax.sql.*,model.*,java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
데이터베이스커넥션풀로부터 커넥션을 빌려온다<br>
<%	DataSource dataSource = DataSourceManager.getInstance().getDataSource();
	Connection con = dataSource.getConnection();
%> <%= con %> 커넥션 클래스 명
<%
	con.close(); // 소멸이 아니라 dbcp로 반납한다는 의미.
%>
<hr>
참고 기존 커넥션 클래스명을 출력
<%  //커넥션을 새로 생성
Connection con2 = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","scott","tiger"); %>
<%=con2.getClass() %>
<% con2.close();// 커넥션을 소멸 %>
<hr>
<% ArrayList<CarVO> list = CarDAO.getInstance().getAllCarList();
for(CarVO vo:list){%>
<%= vo.getNo() %> <%= vo.getModel() %> <%= vo.getPrice() %><br>
<%} %>
</body>
</html>