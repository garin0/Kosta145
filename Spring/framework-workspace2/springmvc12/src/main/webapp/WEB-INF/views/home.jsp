<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home</title>
<script src="//code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#listBtn").click(function(){
			location.href="carList.do";
		});
	});
</script> 
</head>
<body>
<h3>자동차 총 ${totalCount}대</h3>
<input type="button" value="자동차목록보기" id="listBtn">
<%--carList.jsp에서 전체 자동차 목록을 제공한다. --%>
</body>
</html>