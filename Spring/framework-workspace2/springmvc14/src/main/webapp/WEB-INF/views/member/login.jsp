<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:choose>
   	<c:when test="${sessionScope.mvo==null}">
	 	<form method="post" action="login.do">
		아이디  <input type="text" name="id" size="7" >
		비밀번호  <input type="password" name="password" size="7">
		<input type="submit" value="로그인">
		</form>
 	</c:when>
 	<c:otherwise>
	 	<a href="index.do">홈</a>
		<a href="writeView.do">| 글쓰기</a> 
		| ${sessionScope.mvo.name }님 | <a href="logout.do" >로그아웃</a>
 	</c:otherwise>
 </c:choose>   



