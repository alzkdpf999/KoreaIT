<%@ page contentType="text/plain; charset=utf-8" pageEncoding="utf-8"%>

<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	out.print(id +","+ pw);
%>

