<%@page import="namoo.user.dto.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 
<c:url var="naver" value="http://www.daum.net">
	<c:param name="id" value="bangry"/>
	<c:param name="name" value="bangry"/>
	<c:param name="email" value="bangry"/>
</c:url>
<%--https://www.daum.net/?id=bangry&name=bangry&email=bangry 이런 식으로 나옴 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
	<a href="${naver}">네이버</a>
</body>
</html>