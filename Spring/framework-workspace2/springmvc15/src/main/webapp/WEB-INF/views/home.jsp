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
		$("#searchBtn").click(function(){
			var checked = $(':radio[name="type"]:checked');
			var keyword = $("#keyword").val();
			if(checked.length == 0){
				alert("라디오 버튼을 선택하세요!");
			}else if(keyword == ""){
				alert("검색어를 입력하세요!");
			}else{
				location.href=checked.val()+".do?keyword="+keyword;
			}
		});
	});
</script>
</head>
<body>
<h3>상품 서비스</h3><br><br><br>
<form action="registerProduct.do" method="post">
상품명 <input type="text" name="name" required="required"><br>
제조사 <input type="text" name="maker" required="required"><br>
가격 <input type="number" name="price" required="required"><br>
<input type="submit" value="상품등록"><br>
</form>
<br><br><br>
<form>
	<input type="radio" name="type" value="findProductListByName">상품명<br>
	<input type="radio" name="type" value="findProductListByMaker">제조사<br>
	<input type="text" name="keyword" size="8" id="keyword">
	<input type="button" value="검색" id="searchBtn">
</form>
<h3>회원 서비스 등 여러 검색 서비스가 있다고 가정한다.</h3>
<a href="report.do">검색어 통계 보기</a>
</body>
</html>