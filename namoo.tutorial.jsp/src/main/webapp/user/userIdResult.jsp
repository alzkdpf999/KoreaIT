<%@page import="namoo.common.factory.jdbcDaoFactory"%>
<%@page import="namoo.user.dto.User"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%
String result = request.getParameter("result");
String id = request.getParameter("id");
String user = request.getParameter("user");
String click = request.getParameter("disabled");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="/css/basic.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title></title>
<script type="module" defer src="/js/dbCheckPop.js"></script>
</head>
<body>
	<form method="post" action="userCheck.jsp">
		<div class="mb-3">
			<label for='id' class='form-label'>아이디</label>
			<div id="ui">
				<input type="text" class="form-control" id="id" name="id"
					placeholder="Id" required="required" value="<%=id%>" style="color:green">
				<button type="submit" class="check" id="dbCheckId">중복체크</button>
			</div>
		</div>
		<%
		out.println("<h5 class='result'>" + request.getParameter("id") + result + "</h5>");
		%>

		<div class="checkBtn">
			<button type="button" name="CheckId" id="CheckId" class="dbCheckId" <%=click %> >사용하기</button>
			<button type="button" name="cancle" id="cancle" class="cancle">취소</button>
		</div>
	</form>
</body>