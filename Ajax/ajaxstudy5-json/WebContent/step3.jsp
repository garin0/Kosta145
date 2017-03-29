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
		xhr=new XMLHttpRequest();
		// alert(xhr);
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4 && xhr.status==200){
				//alert(xhr.responseText);
				var arr = JSON.parse(xhr.responseText);
				for(var i = 0 ; i < arr.length;i++){
					alert(arr[i].model);
				}
			}
		}
		xhr.open("get","JSONArrayServlet2");
		xhr.send(null);
	}
</script>
</head>
<body>
<input type="button" value="JSONArray Test" onclick="startAjax()">
</body>
</html>