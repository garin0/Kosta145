<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>주소로 회원검색</title>
<script src="//code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){		
		$(":input[name=address]").change(function(){	
			var addrValue=$(this).val();
			$("#memberInfo").empty();
			if(addrValue==""){
				return;
			}
			$.ajax({
				type:"post",
				url:"findMemberListByAddress.do",
				data:"address="+addrValue,
				dataType:"json",
				success:function(json){					
						var data="";
						for(var i=0;i<json.length;i++){
							data+="<tr>";
							data+="<td>"+json[i].id+"</td>";
							data+="<td>"+json[i].name+"</td>";
							data+="</tr>";
						}					
						$("#memberInfo").html(data);				
				}//function
			});//ajax
		});//click
	});//jquery
</script>
</head>
<body>
<select name="address">
	<option value="">---</option>
	<c:forEach items="${requestScope.addrList}" var="addr">
		<option value="${addr}">${addr}</option>
	</c:forEach>
</select>
<br><br><br><br><br><br><br><br>
<table cellpadding="10" border="1">
	<thead>
		<tr>
			<th>ID</th><th>Name</th>
		</tr>
	</thead>
	<tbody id="memberInfo"></tbody>
</table>
<%--		ajax 방식(jquery)으로 요청 후 
			tbody 영역에 주소에 해당하는 회원정보를 제공한다
 --%>
</body>
</html>















