<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update</title>
<script type="text/javascript">
 function content_submit() {
	var f = document.update_form;
	f.submit();
}
 function cancel(){
	 location.href= "../DispatcherServlet?command=list";
 }
</script>
</head>
<body>
<jsp:include page="/template/header.jsp"></jsp:include>
<form name="update_form" method="post" action="DispatcherServlet">
	<input type="hidden" name="command" value="updatePosting"></input>	
	<table class="content">
	<tr>
		<td>
			<table>
				<tr>
					<td>
					글번호: <input type=text name=no value=<%=request.getAttribute("no") %> readonly ></input>
					| 타이틀:<input type=text name=title value=${bvo.title }></input>					
					</td>
				<tr>
					<td>						
	<textarea rows="15" cols="75" name="content">${bvo.content }</textarea>
					</td>
				</tr>
				<tr>
				    <tr>
				     <td colspan="4" align="center" >
				      <img class="action" src="${pageContext.request.contextPath}/img/write_btn.jpg" alt="수정하기"  onclick="content_submit()">
				      <img class="action" src="${pageContext.request.contextPath}/img/cancel.gif" onclick="cancel()">      
				     </td>  
				    </tr>
			</table>
		</td>
	</tr>
</table>
</form>	
</body>
</html>