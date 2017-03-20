<%@page import="model.BoardDAO"%>
<%@page import="model.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/board.css" type="text/css">
<script type="text/javascript">
 function content_submit() {
	var f = document.write_form;
	f.submit();
}
 function cancel(){
	 location.href= "../DispatcherServlet?command=list";
 }
</script>
</head>
<body>
<jsp:include page="/template/header.jsp"></jsp:include>
<br>
<% 
int no = Integer.parseInt(request.getParameter("no"));
BoardVO vo = BoardDAO.getInstance().findBoardByNo(no); %>
  <form action="../DispatcherServlet" method="post" name="write_form"> 
  <input type="hidden" name="command" value="updatePosting">
   <table class="inputForm" >
    <caption>글 수정</caption>
    <tbody>
    <tr>
    <td>글 번호 <input type="text" name="no" value="<%=no%>"size="5" readonly="readonly"> </td> 
    <td>타이틀 <input type="text" name="title" size="15" value="<%= vo.getTitle() %>" required="required"></td>
    </tr>
    <tr>
     <td>작성자: 
     <input type="text" name="writer" value ="<%= vo.getWriter() %>" size="15" required="required"></td>
     
     <td>작성일시 <%= vo.getTimePosted() %></td>
    </tr>
    
    <tr>
     <td colspan="4" align="left">
     &nbsp;&nbsp;
     <textarea cols="53" rows="15" name="content" required="required" ><%= vo.getContent() %></textarea>
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
