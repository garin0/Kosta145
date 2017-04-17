<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employee</title>
<style type="text/css">
	table{
		border-collapse:collapse;
	}
	table,td,th{border:1px solid black;}
	th,td{padding: 15px;}
</style>
<script type="text/javascript">
	$(document).ready(function(){
 		$("#empNoInfo").change(function(){
 			var empno = $(this).val();
			$.ajax({
				type:"get",
				url:"DispatcherServlet",
				data:"command=ead&empno="+empno,
				dataType:"json",
				success:function(data){
					$("#empInfo").html("<tr><td>"+data.empno+"</td></tr>");
				}
			});//ajax
		}); 
	});
</script>
</head>
<body>
<select id="empNoInfo">
	<option value="">-사원번호-</option>
	<c:forEach items="${requestScope.list }" var="no">
		<option value="${no }">${no }</option>
	</c:forEach>
</select><br><br><br><br>
<table>
	<thead>
		<tr>
			<th>사원명</th><th>월급</th>
			<th>부서명</th><th>지역</th>
		</tr>

	</thead>
	<tbody id="empInfo"></tbody>
</table>
</body>
</html>