<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set value="<h2>JSTL set 연습입니다.</h2>" var="html" />
<!DOCTYPE html> 
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<%=request.getAttribute("html")%><br>
${html}<br>
<c:out value="${html}" escapeXml="false"></c:out>
</body>
</html>