<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>json test</title>
<script type="text/javascript">
	var xhr;
	function startAjax() {
		xhr=new XMLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4 && xhr.status==200){
				//alert(xhr.responseText);
				var json = JSON.parse(xhr.responseText);
				alert(json.deptNo+" "+json.dname+" "+json.location);
			}
		}
		xhr.open("get","JSONTestServlet");
		xhr.send(null);
	}
</script>
</head>
<body>
<input type="button" value="json test" onclick="startAjax()">
</body>
</html>