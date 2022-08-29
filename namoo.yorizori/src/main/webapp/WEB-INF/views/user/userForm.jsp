<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
<meta name="요리책 상세보기port"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Shop Homepage - Start Bootstrap Template</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="${ctx}/css/styles.css"
	rel="stylesheet" />
	<script type="module" defer src="${ctx}/js/check.js"></script>
</head>
<body>
	<!-- Navigation-->
	<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
	<!-- Header-->

	<!-- Section-->
	<section class="py-5">
		<div class="container px-4 px-lg-5 mt-5">
			<div
				class="row gx-3 gx-lg-4 row-cols-1 row-cols-md-1 row-cols-xl-2 justify-content-center  ">
				<div class="w3-responsive w3-card-4">
					<form class="row justify-content-center" method="post"
						action="${ctx}/user/regist.do"
						id="signup">
						<div class="mb-3 ">
							<label for="id" class="form-label" >아이디 </label>
							<input type="hidden" name="check" value="unCheck" id="ok">
							<div id="ui">
								<input type="text" class="form-control signupId" id="id" name="id"
									placeholder="Id">
								<button type="button" class="check btn btn-primary" id="dbCheckId">중복체크</button>
							</div>
							<small id="idErr">영어 또는 숫자 조합을 사용하여 최소 4글자입니다.</small>
						</div>

						<div class="mb-3">
							<label for="passwd" class="form-label">비밀번호</label> <input
								type="password" class="form-control validPasswd" id="passwd" name="passwd"
								placeholder="Password"> <small id="passwdErr">영어,
								특수문자, 숫자의 조합을 사용하여 최소 8글자 입니다.</small>
						</div>

						<div class="mb-3">
							<label for="name" class="form-label">이름</label> <input
								type="text" class="form-control" id="name" name="name"
								placeholder="Name">
						</div>

						<div class="mb-3">
							<label for="email" class="form-label">이메일</label> <input
								type="text" class="form-control" id="email" name="email"
								placeholder="name@example.com">
						</div>
						<div class="col-auto">
							<button type="submit" class="btn btn-primary mb-3" id="signOk">회원가입</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
	<!-- Footer-->
	<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
<script src="js/scripts.js"></script>
</body>
</html>
