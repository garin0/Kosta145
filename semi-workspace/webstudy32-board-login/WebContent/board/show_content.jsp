<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>content</title>
<script type="text/javascript">
	function sendList() {
		location.href= "DispatcherServlet?command=list&page=1";
	}
	function winOpen(kind){	
		if(confirm(kind+"하시겠습니까?")){
			location.href= "DispatcherServlet?command="+kind+"&no=${requestScope.no }";
		}else{return;}
		
	}
</script>
</head>
<body>
<jsp:include page="/template/header.jsp"></jsp:include>
	<table class="content">
		<tr>
			<td>NO : ${requestScope.no } </td>
			<td colspan="2">${requestScope.vo.title }</td>
		</tr>
		<tr>
			<td>작성자 : ${requestScope.writer }</td>
			<td> ${requestScope.vo.timePosted }</td>
			<td>조회수: ${requestScope.vo.hits }</td>
		</tr>
		<tr>
			<td colspan="3">
			<pre>${requestScope.vo.content }</pre>
			</td>
		</tr>
		<tr>
			 <td valign="middle" align="center" colspan="3">
			 <img class="action" src="${pageContext.request.contextPath}/img/list_btn.jpg" onclick="sendList()" >
			 <c:if test="${sessionScope.mvo.id == requestScope.vo.id}" >
			 <img class="action"  onclick="winOpen('delete')" 	src="${pageContext.request.contextPath}/img/delete_btn.jpg" > 
			 <img class="action"  onclick="winOpen('update')"  src="${pageContext.request.contextPath}/img/modify_btn.jpg" >
			 </c:if>
			 </td>
		</tr>
	</table>
	<hr>
	<div style="border: 1px solid; width: 800px; padding: 5px">
    <form name="form1" action="" method="post">
    	<table>
    		<tr>
    			작성자: ${sessionScope.mvo.name}
    			<td colspan="2"><input type="hidden" name="brdno" value=""></td>
    		</tr>
    		<tr>
    			<td><textarea name="rememo" rows="3" cols="80" maxlength="400" placeholder="댓글을 달아주세요."></textarea></td>
    			<td><input type="button" id="writeReplyBtn" value="등록" class="btn btn-warning" onclick="fn_formSubmit()"></td>
    		</tr>
    	</table>
    </form>
	</div> 

	<div style="border: 1px solid gray; width: 800px; padding: 5px; margin-top: 5px;
	      display: inline-block">    
	   	작성자 2017-04-01
	    <a href="#" >삭제</a>
	    <a href="#" >수정</a>
	    <a href="#" >댓글</a>
	    <br/>
	   <div id="#">안녕! 코멘트 내용이야</div>
	</div><br/>
	
		<div style="border: 1px solid gray; width: 800px; padding: 5px; margin-top: 5px;
	      display: inline-block">    
	   	작성자 2017-04-01
	    <a href="#" >삭제</a>
	    <a href="#" >수정</a>
	    <a href="#" >댓글</a>
	    <br/>
	   <div id="#">안녕! 코멘트 내용이야</div>
	</div><br/>
	
		<div style="border: 1px solid gray; width: 800px; padding: 5px; margin-top: 5px;
	      display: inline-block">    
	   	작성자 2017-04-01
	    <a href="#" >삭제</a>
	    <a href="#" >수정</a>
	    <a href="#" >댓글</a>
	    <br/>
	   <div id="#">안녕! 코멘트 내용이야</div>
	</div><br/>
	
		<div style="border: 1px solid gray; width: 800px; padding: 5px; margin-top: 5px;
	      display: inline-block">    
	   	작성자 2017-04-01
	    <a href="#" >삭제</a>
	    <a href="#" >수정</a>
	    <a href="#" >댓글</a>
	    <br/>
	   <div id="#">안녕! 코멘트 내용이야</div>
	</div><br/>
</body>
</html>