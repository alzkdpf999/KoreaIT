<%@page import="namoo.user.dto.User"%>
<%@page import="namoo.common.factory.jdbcDaoFactory"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<jsp:useBean id="user" class="namoo.user.dto.User" scope="request">
	<jsp:setProperty name="user" property="*" />
</jsp:useBean>

<%

String path = request.getParameter("path");
if (path == null)
	path = "/";

else if(path.contains("user/userList.jsp")){
	path = "/user/userList.jsp";
}
String method = request.getMethod();
String check = request.getParameter("yes");
if (check == null)
	check = "";
//로그인 처리
if (method.equalsIgnoreCase("post")) {
%>

<%
User loginUser = jdbcDaoFactory.getInstance().getUserDao().login(user.getId(), user.getPasswd());
int result = jdbcDaoFactory.getInstance().getUserDao().loginResult(user.getId(),user.getPasswd());
if (loginUser != null) {
	HttpSession loginsession = request.getSession();
	loginsession.setAttribute("loginUser", loginUser);
	if (!check.equals("")) {
		Cookie idCookie = new Cookie("id", user.getId());
		idCookie.setPath("/");
		response.addCookie(idCookie);

	} else if (check.equals("")) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
	for (Cookie cookie : cookies) {
		if (cookie.getName().equals("id")) {
			cookie.setMaxAge(0);
			cookie.setPath("/");
			response.addCookie(cookie);
		}
	}
		}
	}

	response.sendRedirect(path);

}else{
	if (check.equals("")) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
	for (Cookie cookie : cookies) {
		if (cookie.getName().equals("id")) {
			cookie.setMaxAge(0);
			cookie.setPath("/");
			response.addCookie(cookie);
		}
	}
		}
	}
	%>
	<jsp:forward page="<%=path %>">
	<jsp:param value="<%=result %>" name="result"/>
</jsp:forward>
	<%
}
}
//로그아웃 처리
else {

request.getSession().invalidate();
if (path.equals("/user/userList.jsp")) path = "/";
response.sendRedirect(path);
}
%>
