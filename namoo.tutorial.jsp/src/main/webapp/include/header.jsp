<%@page import="namoo.user.dto.User"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%
User loginUser = (User)request.getSession().getAttribute("loginUser"); 
String path= "";
if(loginUser == null) path = "/";
else path = "/user/userList.jsp";
%>
<div class="header">
	<h1>My Website</h1>
	<p>Resize the browser window to see the effect.</p>
	<div class="topnav">
		<a href="#">Link</a> <a href="#">Link</a> <a href="#">Link</a> <a
			href="<%=path%>">Member List</a> <a href="/user/userRegistForm.jsp" style="float: right">Sign Up</a>
	</div>
</div>