<%@page import="namoo.user.dao.UserDao"%>
<%@page import="namoo.common.factory.jdbcDaoFactory"%>
<%@page import="namoo.user.dto.User"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<%
	String result = "사용 가능합니다";
	String click = "";
	User user = jdbcDaoFactory.getInstance().getUserDao().read(request.getParameter("id"));
	if(user !=null) {result ="사용 불가능합니다."; click="disabled";}
%>
<jsp:forward page="userIdResult.jsp" >
	<jsp:param value="<%=user %>" name="user"/>
	<jsp:param value="<%=result %>" name="result"/>
	<jsp:param value="<%=click %>" name="disabled"/>
</jsp:forward>
