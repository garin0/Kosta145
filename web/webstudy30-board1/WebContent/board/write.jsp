<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글쓰기</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/board.css" type="text/css">
</head>
<body>
<jsp:include page="/template/header.jsp"></jsp:include>
<br>
  <form action="" method="post" name="write_form">  
   <table class="inputForm" >
    <caption>글쓰기</caption>
    <tbody>
    <tr>
     <td>제목</td>
     <td colspan="3">
     <input type="text" name="title" size="48">
     </td>
    </tr>
    <tr>
     <td>이름</td>
     <td><input type="text" name="writer" size="20"></td>
     <td>비밀번호</td>
     <td >
     <input type="password" name="password"  size="5">
     </td>
    </tr>
    <tr>
     <td colspan="4" align="left">
     &nbsp;&nbsp;
     <textarea cols="53" rows="15" name="content"></textarea>
     </td>
    </tr> 
    <tr>
     <td colspan="4" align="center" >
      <img class="action" src="${pageContext.request.contextPath}/img/write_btn.jpg" alt="글입력"  onclick="content_submit()">
      <img class="action" src="${pageContext.request.contextPath}/img/cancel.gif" onclick="cancel()">      
     </td>  
    </tr>
    </tbody>
   </table>
  </form>
</html>
