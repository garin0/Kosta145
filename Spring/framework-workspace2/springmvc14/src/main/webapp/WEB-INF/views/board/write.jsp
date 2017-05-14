<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>write</title>
<link rel="stylesheet" href="/springmvc14/resources/css/board.css" type="text/css">
<script src="//code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    $("#writeBtn").click(function(){
    	$("#write_form").submit();
    });
});
</script>
</head>
<body>
<jsp:include page="../member/login.jsp"></jsp:include> 
<hr>
<form action="board_write.do" method="post" id="write_form">
   <table class="inputForm" >
    <caption>글쓰기</caption>
    <tbody>
    <tr>
     <td>제목</td>
     <td colspan="3">
     <input type="text" id="title" name="title" size="48">
     </td>
    </tr>
    <tr>
     <td>이름</td>
     <td> ${sessionScope.mvo.name}
     <input type="text" id="smid" name="smid" value="${sessionScope.mvo.id}"> 
     </td>     
    </tr>
    <tr>
     <td colspan="4" align="left">
     &nbsp;&nbsp;
     <textarea cols="53" rows="15" id="content" name="content"></textarea>
     </td>
    </tr> 
    <tr>
     <td colspan="4" align="center" >
      <img id="writeBtn" class="action" src="/springmvc14/resources/img/write_btn.jpg" alt="글입력" >
      <img id="resetBtn" class="action" src="/springmvc14/resources/img/cancel.gif" >      
     </td>  
    </tr>
    </tbody>
   </table>
  </form>
</body>
</html>