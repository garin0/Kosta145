<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>address</title>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<style type="text/css">
tr,td {
padding:10px;
}
</style>
<script type="text/javascript">
 $(document).ready(function(){
	 $("#address").change(function(){
		 var addrVal = $(this).val();
		 var memberInfo = $("#memberInfo");
		 $.ajax({
			    url : "findMemberByAddress.do",
			    dataType : "json",
			    type : "post",
			    data : "address="+addrVal,
			    success: function(json) {
			    	var data = "";
			    	for(var i = 0;i<json.length;i++){
			    		 data += "<tr>";
			    		 data+= "<td>"+json[i].id+"</td>";
			    		 data += "<td>"+json[i].name+"</td>";
			    		 data += "</tr>";
			    	}
			    	$("#memberInfo").html(data);
			    }
			}); 
	 });
 })
</script>
</head>
<body>
<a href="index.do">홈</a><br>
<select id="address">
	<option value="">---</option>
	<c:forEach items="${requestScope.list}" var="addr" >
	<option value="${addr}">${addr}</option>
	</c:forEach>
</select>
<br><br><br><br>
<table cellpadding="10" border="1">
	<thead>
		<tr>
			<th>ID</th><th>Name</th>
		</tr>
	</thead>
	<tbody id="memberInfo"></tbody>
</table>
<%--ajax방식으로 요청 후 
	tbody 영역에 주소에 해당하는 회원 정보를 제공한다. --%>
</body>
</html>