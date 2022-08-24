<%@page import="namoo.yorizori.dto.user.User"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%
User loginUser = (User) session.getAttribute("loginUser");
String checkId = null;

Cookie[] cookies = request.getCookies();
if (cookies != null) {
	for (Cookie cookie : cookies) {
		if (cookie.getName().equals("id"))
	checkId = cookie.getValue();
	}
}
%>



<%
if (loginUser == null) {
%>
<form action="<%=application.getContextPath()%>/user/login.do"
	method="post" name="login"
	class="row row-cols-lg-auto g-3 align-items-center">

	<div id="saveCheck">
		<label for="save"> <input type="checkbox" name="yes"
			value="yes" id="save" checked> <i class="circle"></i> <span
			class="text">아이디 저장</span>
		</label>
	</div>
	<div class="col-12">
		<input type="text" size="8" maxlength="8" class="form-control" id="id"
			placeholder="아이디" value="<%=checkId%>">
	</div>
	<div class="col-12">
		<input type="password" size="8" maxlength="8" class="form-control"
			id="passwd" placeholder="비밀번호">
	</div>

	<div class="col-12">
		<button type="submit" class="btn btn-primary">로그인</button>
	</div>

	<div class="col-12">
		<a href="user/signup.do" class="btn btn-warning">회원가입</a>
	</div>

</form>
<%
} else {
%>
<form action="<%=application.getContextPath()%>/user/login.do"
	method="get" name="logout">
	<img src="/img/sample.png" id="profil">
	<h3 id="asid">${loginUser.getName() }님</h3>
	<input type="submit" value="로그아웃">
</form>
<%
}
%>