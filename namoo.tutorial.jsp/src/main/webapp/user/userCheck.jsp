<%@page import="namoo.user.dao.UserDao"%>
<%@page import="namoo.common.factory.jdbcDaoFactory"%>
<%@page import="namoo.user.dto.User"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<%
jdbcDaoFactory.getInstance().getUserDao().read(request.getParameter("id"));
%>
<jsp:forward page="userIdResult.jsp"/>