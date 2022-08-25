<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html> 
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<c:if test="${3 > 1 }">
hello
</c:if>

<c:if test="${!empty param.id}">
아이디 전달 오류
</c:if>
${param.id } <%--로그인같은거 할떄 --%>


</body>
</html>