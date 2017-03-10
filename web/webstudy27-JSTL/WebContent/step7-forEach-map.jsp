<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step7 forEach map</title>
</head>
<body>
<% LinkedHashMap<String,MemberVO> map= new LinkedHashMap<String,MemberVO>();
MemberVO vo1 = new MemberVO("java","1234","김문일","판교");
MemberVO vo2 = new MemberVO("spring","abcd","김호겸","야탑");
MemberVO vo3 = new MemberVO("mybatis","aaaa","김규익","동대문");
map.put(vo1.getId(),vo1);
map.put(vo2.getId(),vo2);
map.put(vo3.getId(),vo3);
session.setAttribute("memMap", map);
%> 1.scriptlet으로 key, value(name,address)를 출력<br>

<% // key:java   value: 김문일 판교
   // key:spring value: 김호겸 야탑
   @SuppressWarnings("unchecked")
   LinkedHashMap<String,MemberVO> reMap = (LinkedHashMap<String,MemberVO>)session.getAttribute("memMap");
	Iterator<String> it = reMap.keySet().iterator();
	while(it.hasNext()){
	 String key = it.next();
%>
<br>key: <%=key %>	value: <%= reMap.get(key).getName() %>  <%= reMap.get(key).getAddress() %>
<%} %>
<hr>
2.  JSTL으로 key, value(name,address)를 출력<br><br>
<c:forEach items="${sessionScope.memMap }" var="m">
key: ${m.key } value: ${m.value.name } ${m.value.address }<br>

</c:forEach>
</body>
</html>