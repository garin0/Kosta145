<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSONArray</title>
<script type="text/javascript">
	var xhr;
	function startAjax() {
		var addrComp = document.addressForm.address;
		var memberInfo = document.getElementById("memberInfo");
		//alert(addrComp);
		xhr=new XMLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4 && xhr.status==200){
				//alert(xhr.responseText);
				var arr = JSON.parse(xhr.responseText);
				var data = "";
				for(var i=0;i<arr.length;i++){
					data += "<tr><td>"+arr[i].id+"</td><td>"+arr[i].name+"</td></tr>";
				}
				memberInfo.innerHTML = data;
			}
		}
		xhr.open("get","FindMemberListServlet?address="+addrComp.value);
		xhr.send(null);
	}
</script>
<style type="text/css">
	table{
		border-collapse:collapse;
	}
	table,td,th{border:1px solid black;}
	th,td{padding: 15px;}
</style>
</head>
<body>
<form name="addressForm">
<input type="radio" name="address" value="판교" onchange="startAjax()">판교<br>
<input type="radio" name="address" value="종로" onchange="startAjax()">종로<br>
</form>
<br><br><br>
<table>
	<thead>
		<tr>
			<th>아이디</th><th>이름</th>
		</tr>
	</thead>
	<tbody id="memberInfo">
	
	</tbody>
</table>
</body>
</html>