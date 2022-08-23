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
			<form class="row row-cols-lg-auto g-3 align-items-center">

				<div class="col-12">
					<div class="form-check">
						<input class="form-check-input" type="checkbox" id="saveid">
						<label class="form-check-label" for="saveid">아이디저장</label>
					</div>
				</div>

				<input type="text" id="id" name="id"  class="id" placeholder="Id...">

			<input type="password" id="passwd" name="passwd"
				placeholder="Password..." class="passwd">

				<div class="col-12">
					<button type="submit" class="btn btn-primary">로그인</button>
				</div>

				<div class="col-12">
					<a href="user/signup.do" class="btn btn-warning">회원가입</a>
				</div>

			</form>
		</div>
	</div>
</nav>