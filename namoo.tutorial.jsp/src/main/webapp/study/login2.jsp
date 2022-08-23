<%@page import="namoo.yorizori.dto.user.User"%>
<%@page import="namoo.yorizori.common.factory.jdbcDaoFactory"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<jsp:useBean id="user" class="namoo.yorizori.dto.user.User" scope="request">
	<jsp:setProperty name="user" property="*" />
</jsp:useBean>

<%
String method = request.getMethod();
String check = request.getParameter("yes");
if (check == null)
	check = "";
//로그인 처리
if (method.equalsIgnoreCase("post")) {
%>

<%
User loginUser = jdbcDaoFactory.getInstance().getUserDao().login(user.getId(), user.getPasswd());
if (loginUser != null) {
	HttpSession loginsession = request.getSession();
	loginsession.setAttribute("loginUser", loginUser);
	if (!check.equals("")) {
		Cookie idCookie = new Cookie("id", user.getId());
		idCookie.setPath("/");
		response.addCookie(idCookie);

	} else if (check.equals("")) {
		Cookie delCookie = new Cookie("id", "");
		delCookie.setPath("/");

		delCookie.setMaxAge(0);
		response.addCookie(delCookie);

	}

	response.sendRedirect("/index	.jsp");

} else {
%>

<script>
	alert("아이디와 비밀번호를 확인해주세요");
</script>
<%
}
}
//로그아웃 처리
else {

request.getSession().invalidate();
response.sendRedirect("/index.jsp");
}
%>
