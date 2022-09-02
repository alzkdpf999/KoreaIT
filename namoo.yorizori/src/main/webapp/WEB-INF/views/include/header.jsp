<%@page import="namoo.yorizori.dto.user.User"%>
<%@page import="org.apache.catalina.core.AprLifecycleListener"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container px-4 px-lg-5">
	<%--163 * 30 --%>
		<a class="navbar-brand " href="${ctx}">
		YoriZori CookBook</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4" id="temp">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="${ctx }">홈</a></li>
				<li class="nav-item"><a class="nav-link" href="${ctx}/cookbook/list.do">요리책 목록</a></li>
				<li class="nav-item"><a class="nav-link" href="#!">레시피 목록</a></li>
				<li class="nav-item"><a class="nav-link" href="${ctx}/movie/reserve/list.do">상영 예정작 </a></li>

			</ul>
			<jsp:include page="/WEB-INF/views/include/loginside.jsp"></jsp:include>

		</div>
	</div>
</nav>