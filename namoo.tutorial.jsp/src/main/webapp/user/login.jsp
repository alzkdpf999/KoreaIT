<%@page import="namoo.user.dto.User"%>
<%@page import="namoo.common.factory.jdbcDaoFactory"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<jsp:useBean id="user" class="namoo.user.dto.User" scope="request">
 	<jsp:setProperty name="user" property="*"/>
</jsp:useBean>

<%
	String method = request.getMethod();
//로그인 처리
if(method.equalsIgnoreCase("post")){
%>

<%
User loginUser = jdbcDaoFactory.getInstance().getUserDao().login(user.getId(), user.getPasswd());
if(loginUser != null){
	HttpSession loginsession = request.getSession();
	loginsession.setAttribute("loginUser", loginUser);
	response.sendRedirect("/index.jsp");
}else{
%>
<script>
	alert("아이디와 비밀번호를 확인해주세요");
</script>
<% }
}
//로그아웃 처리
else{
	request.getSession().invalidate();
	response.sendRedirect("/index.jsp");
}
%>
