<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%-- <%@ page errorPage="/error/error_500.jsp" %> 에러페이지 나오게하는 오류뜰 시 --%>
<%-- web.xml에 한번에 설정하기 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<%
	String message = null;	
	int size = message.length();
%>
<%= size %>
</body>
</html>