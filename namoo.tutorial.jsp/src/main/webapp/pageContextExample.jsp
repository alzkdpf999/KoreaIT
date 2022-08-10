<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


<%
	application.setAttribute("global", "Global Data");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<%=application.getAttribute("global") %>
</body>
</html>