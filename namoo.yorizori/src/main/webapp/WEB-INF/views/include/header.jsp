<%@page import="namoo.yorizori.dto.user.User"%>
<%@page import="org.apache.catalina.core.AprLifecycleListener"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container px-4 px-lg-5">
		<a class="navbar-brand" href="#!">YoriZori CookBook</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="#!">홈</a></li>
				<li class="nav-item"><a class="nav-link" href="#!">요리책 등록</a></li>
				<li class="nav-item"><a class="nav-link" href="#!">요리책 목록조회</a></li>

			</ul>
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
						value="yes" id="save"> <i class="circle"></i> <span
						class="text">아이디 저장</span>
					</label>
				</div>
				<div class="col-12">
					<input type="text" size="8" maxlength="8" class="form-control"
						id="id" placeholder="아이디">
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

		</div>
	</div>
</nav>