<%@ page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%-- language타입을 기본으로 java이므로 보통 생략함 --%>
<!--  --> <%--이거는 그대로 출력하므로 주의 주석 처리로 안됌 %로 해야됌 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>JSP 수업</title>
</head>
<body>
<h2>JSP 동작원리 수업입니다...</h2>
<% 
Calendar today = Calendar.getInstance();
String ymd = String.format("%1$tF %1$tT",today);
out.println(ymd);
%>
</body>
</html>
