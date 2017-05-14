<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- header.jsp

	stock_market.jsp에서 include할 로그인 화면
	비로그인 상태이면 로그인 화면 제공하고
	로그인 상태이면 판교에 사는 아이유님 [로그아웃]
--%>

<c:choose>
	<c:when test="${cvo==null}">
		<form method="post" action="login.do">
			ID  <input type="text" name="id"> &nbsp;&nbsp; 
			PASSWORD  <input type="password" name="password"> 
			<input type="submit" value="로그인">
		</form>
	</c:when>
	<c:otherwise>
		${cvo.address}에 사는 ${cvo.name}님 로그인 
		<input type="button" id="logoutBtn" value="로그아웃" onclick="javascript:location.href='logout.do'">
	</c:otherwise>
</c:choose>
