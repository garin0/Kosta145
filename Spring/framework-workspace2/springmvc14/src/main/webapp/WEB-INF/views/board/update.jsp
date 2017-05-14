<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update</title>
<link rel="stylesheet" href="/springmvc14/resources/css/board.css" type="text/css">
</head>
<body>
<jsp:include page="../member/login.jsp"></jsp:include> 
<hr>
<form method="post" id="updateForm" action="board_update.do?no=${bvo.no}">
	<table class="content">
	<tr>
		<td>
			<table>
				<tr>
					<td>
					글번호: <input type=text name=no value="${bvo.no}" readonly></input>
					| 타이틀:<input type=text id=title name=title value="${bvo.title}"></input>					
					</td>
				<tr>
					<td>						
	<textarea rows="15" cols="75" id="content" name="content">${bvo.content}</textarea>
					</td>
				</tr>
				<tr>
				<td valign="middle">						
					<input type="submit" value="수정하기" class="action"></input>			
					</td>				
				</tr>
			</table>
		</td>
	</tr>
</table>
</form>	
</body>
</html>