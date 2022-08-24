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
			<jsp:include page="/WEB-INF/views/include/loginside.jsp"></jsp:include>

		</div>
	</div>
</nav>