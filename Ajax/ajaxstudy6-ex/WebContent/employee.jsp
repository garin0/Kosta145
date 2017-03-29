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
	var xhr;
	function startAjax() {
		var selComp = document.getElementById("empNoInfo").value;
		var empInfo = document.getElementById("empInfo");
 		xhr=new XMLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4 && xhr.status==200){
				//alert(xhr.responseText);
				var map = JSON.parse(xhr.responseText);
				empInfo.innerHTML = "<tr><td>"+map.ename+"</td><td>"+map.sal+"</td><td>"+map.dname+"</td><td>"+map.loc+"</td></tr>"
			}
		}
		xhr.open("get","DispatcherServlet?command=ead&empno="+selComp);
		xhr.send(null); 
	}
</script>
</head>
<body>
<select id="empNoInfo"  onchange="startAjax()">
	<option value="">-사원번호-</option>
	<c:forEach items="${requestScope.list }" var="list">
		<option value="${list }">${list }</option>
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