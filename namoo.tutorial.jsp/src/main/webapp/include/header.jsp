<%@page import="namoo.user.dto.User"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%
User loginUser = (User)request.getSession().getAttribute("loginUser"); 
String path= "";
if(loginUser == null) path = "/login.do/";

%>
<div class="header">
	<a href="/" class="logo">
	</a>
	<div class="topnav">
		<a href="#">Link</a> <a href="#">Link</a> <a href="#">Link</a> <a
			href="<%=path+"user/userList.jsp"%>">Member List</a> <a href="/user/userRegistForm.jsp" style="float: right">Sign Up</a>
			<a href="/yorizori/" target="_blank">Model2 기반 요리책</a>
	</div>
</div>