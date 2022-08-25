<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
//서블릿 영역 코드라 지정
request.setAttribute("html","<h2>JSTL out 연습입니다.</h2>");
request.setAttribute("somevalue",null);

%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<%=request.getAttribute("html")%><br>
${html}<br>
<c:out value="${html}"escapeXml="false"></c:out>
<c:out value="${somevalue }" default="1"></c:out>
</body>
</html>