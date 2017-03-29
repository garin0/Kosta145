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
		var result=document.getElementById("result");
		
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4 && xhr.status==200)
				/* alert(xhr.responseText); */
				var arr = JSON.parse(xhr.responseText);
				var data = "";
				for(var i = 0 ; i < arr.length ; i++){
					 data += i+ "."+arr[i]+" ";
				}
				result.innerHTML = data;
		}
		xhr.open("get","JSONArrayServlet");
		xhr.send(null);
	}
</script>
</head>
<body>
<input type="button" value="JSONArray Test" onclick="startAjax()">
<span id="result"></span>
<%-- 0. 임경수 1.김규익... --%>
</body>
</html>