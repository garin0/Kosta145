<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>stock market</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/broker.css" type="text/css">
<script src="//code.jquery.com/jquery.min.js"></script>
</head>
<script type="text/javascript">
$(document).ready(function(){
	$("#subBtn").click(function(){
		var sessionId= "${cvo.id}";
		var symbolChecked = $(':radio[name="symbol"]:checked').val();
		var transChecked= $(':radio[name="trans"]:checked').val();
		var quantity = $("#count").val();
		var infoData = $('#tradeForm').serialize();
		if(quantity > $("#q").val()){
			alert("더 많음");
			return;
		}
		if(symbolChecked == undefined){
			alert("주식명을 선택해주세여");
		}else if(transChecked == undefined){
			alert("매수 또는 매도를 선택해주세여");
		}else{
		  //ajax
			$.ajax({
				type:"POST",
				url:"stockTrans.do?id="+sessionId,		
				dataType:"json",
				data:infoData,
				success:function(json){		
					var data="";
						data+="<tr><td>주식명</td><td>수량</td><td>총액</td></tr>";
					for(var i=0;i<json.length;i++){
						data+="<tr>";
						data+="<td>"+json[i].symbol+"</td>";
						data+="<td>"+json[i].quantity+"</td>";
						data+="<td>"+json[i].total+"</td>";
						data+="</tr>";
					}					
					$("#sharesInfo").html(data);
				}//callback			
			});//ajax
		}//else
	});//click
});//ready
</script>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<h3> STOCK MARKET</h3>
	<form id="tradeForm">
	<table>
		<c:forEach items="${stockList}" var="stocks">
			<tr>
				<td><input type="radio" name="symbol" value="${stocks.symbol}"></td>
				<td>${stocks.symbol }</td>
				<td>${stocks.price }</td>
			</tr>
		</c:forEach>
	</table>	
	<c:if test="${sessionScope.cvo!=null}">
		<input type="radio" name="trans" value="매수">	매수
		<input type="radio" name="trans" value="매도">	매도
		<br>
		<input type="text" name="quantity"> 수량 
		<input type="button" id="subBtn" value="거래하기">
		<input type="reset" value="reset">
	</c:if>	
	
	</form>	
 	<c:if test="${sharesList!=null}">
		<table id="sharesInfo">
			<tr>
				<td>주식명</td><td>수량</td><td>총액</td>
			</tr>
			<c:forEach items="${sharesList}" var="shares">
				<tr>
					<td>${shares.symbol}</td><td id="q">${shares.quantity}</td><td>${shares.total}</td>
				</tr>
			</c:forEach> 
		</table>
	</c:if>
	<span id="info"></span>
</body>
</html>