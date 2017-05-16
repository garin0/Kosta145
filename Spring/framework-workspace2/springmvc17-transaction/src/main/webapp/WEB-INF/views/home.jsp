<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home</title>
</head>
<body>
<%-- id로 회원검색

find_member_result.jsp 
java 아이디에 대한 검색 결과: 회원정보 --%>
<form action="findMemberById.do" method="post">
아이디 <input type="text" name="id">
<input type="submit" value="회원검색">
</form>
<br>
<form action="findPointById.do" method="post">
아이디 <input type="text" name="id">
<input type="submit" value="포인트 정보 검색">
<%--
	MemberController--MemberService -PointDAO
	find_point_result.jsp
 --%>
</form>
 <hr>
 <form action="register.do" method="post">
 	아이디 <input type="text" name="id"><br>
 	패스워드 <input type="password" name="password"><br>
 	이름 <input type="text" name="name"><br>
 	주소 <input type="text" name="address"><br>
 	포인트 <input type="text" name="point"><br>
 	포인트 타입 <input type="text" name="pointType"><br>
 	<input type="submit" value="등록">
 </form>
 <%-- MemberController - MemberService
 						register(){   
 								---> MemberDAO
 								---> PointDAO
 						
 			|	 			}
 		register_result.jsp : 회원 등록 및 포인트 등록 완료				
 --%>
</body>
</html>