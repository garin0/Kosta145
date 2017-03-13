<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<a href="index.jsp">Model2 상품관리</a>
<% MemberVO vo = (MemberVO)session.getAttribute("mvo");
if(vo!=null){%>
&nbsp;<a href="cart.jsp">장바구니 보기</a>
<%} %>
