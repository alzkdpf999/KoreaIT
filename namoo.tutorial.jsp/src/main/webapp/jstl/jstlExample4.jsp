<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="point" value="85"></c:set>
<!DOCTYPE html> 
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<c:choose>
	<c:when test="${100 >= point && point > 90}"> 수</c:when>
	<c:when test="${90 > point && point > 80}"> 우</c:when>
	<c:when test="${80 > point  }"> 미</c:when>
	<c:otherwise>
		조건 없습니다.
	</c:otherwise>
</c:choose>
</body>
</html>