<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<% 
//response.sendRedirect("hello.jsp");
response.sendError(HttpServletResponse.SC_NOT_FOUND); 
//404뜨도록 만들기
%>
정상처리