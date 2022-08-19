<%@page import="org.apache.catalina.ant.jmx.JMXAccessorQueryTask"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%
session.setAttribute("loginId", "bangry");
application.setAttribute("global", "globalData");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<%=session %>
${sessionScope}
${loginId }
${global } ${applicationScope.global }
${request.method} <%--아무것도 안나옴 요청 방식은 아래와 같이  --%>
${pageContext.request.method}
${pageContext.request.requestURI}
------
${param.id}
${paramValues.hobby[0]},${paramValues.hobby[1]}<br>
${header['user-agent']}<br>
${initParam.message}

----------------------------------------------
${cookie.buy.value }
</body>
</html>