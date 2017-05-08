<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
</head>
<body>
	<h3>Annotation 기반 SpringMVC 회원관리(총 회원수 ${count}명)</h3>
	<form action="findMemberById.do">
		아이디 <input type="text" name="id"> <input type="submit"
			value="검색">
	</form>
	<%-- MemberController MemberService(I) MemberDAO(I) MemberDAO(I)
회원정보가 있으면
views/findMemberById_ok.jsp
없으면
views/findMemberById_fail.jsp alert후 index로 이동--%>
	<br>
	<a href="getAddressKind.do">주소로 회원검색</a>
	<%-- 
address.jsp에서 select option으로 회원이 사는 주소의 종류를 제공한다. 
--%>
	<%--로그인 상태이면
아이유님 로그인
로그아웃

비로그인 상태이면
로그인폼을 제공한다. --%>
	<hr>
	<c:choose>
		<c:when test="${sessionScope.info !=null }">
 	${sessionScope.info.name}님 로그인<br>
			<a href="logout.do">로그아웃</a><br>
			<a href="enterCafe.do">카페가기</a><br>
			<a href="updateView.do">회원정보 수정</a>
			<%-- MemberContoller updateView() 
													 MemberController
									update.jsp-----> updateMember()
													 update_result.jsp
										 --%>
		</c:when>
		<c:otherwise>
			<form action="login.do" method="post">
				아이디 <input type="text" name="id"><br> 패스워드 <input
					type="password" name="password"><br> <input
					type="submit" value="로그인">
			</form>
			<a href="joinView.do">회원가입</a>
		</c:otherwise>
	</c:choose>
	

	<%-- 카페에서는
판교에 사는 아이유님 카페입장을 환영합니다.
 --%>


	<%--post방식만 실행가능하게 컨트롤러에서 처리한다. --%>

</body>
</html>