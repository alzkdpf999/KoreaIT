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
</head>
<body>
	<!-- Navigation-->
	<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
	<!-- Header-->
<form name="myForm" action="${ctx}/user/login.do" method="post">
<input type="hidden" name="id" value="${user.getId() }">
<input type="hidden" name="passwd" value="${user.getPasswd() }">
</form>
	<!-- Section-->
	<div class="container px-4 px-lg-5 mt-5">
		<div class="row gx-2 gx-lg-3 row-cols0 row-cols-md-1 row-cols-xl-1">
			<div class="titleContent">
				<h2 class="title">회원 가입을 환영합니다</h2>
				<ul>
					<li>아이디 : : ${user.getId() }
					</li>
					<li>이 름 : : ${user.getName() }
					</li>
					<li>이메일 : : ${user.getEmail() }
					</li>
				</ul>
			</div>

		</div>
		<div class="moveLink">
			<ul>
				<li><a href="${ctx}">홈으로</a></li>
				<li><a onclick="javascript:document.myForm.submit();">로그인</a></li>
			</ul>
		</div>
	</div>
	
	<!-- Footer-->
	<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
</body>
</html>
