<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
*상품등록*
<hr>
<form action="product.do">
상품명: <input type="text" name="name"><br>
제조사: <input type="text" name="maker"><br>
가격: <input type="text" name="price"><br>
<input type="submit" value="상품등록">
<input type="hidden" name="command" value="register">
</form> 
<hr>
*검색*
<form action="product.do">
<select name="select">
  <option value="maker">제조사</option>
  <option value="name">상품명</option>
</select>
<input type="text" name="input">
<input type="submit" value="검색">
<input type="hidden" name="command" value="search">
</form>

</body>
</html>