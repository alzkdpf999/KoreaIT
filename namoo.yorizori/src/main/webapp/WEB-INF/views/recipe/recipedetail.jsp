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
<link href="${ctx}/css/styles.css" rel="stylesheet" />
<script type="module" defer src="${ctx}/js/add.js"></script>
</head>
<body>
	<!-- Navigation-->
	<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
	<!-- Header-->

	<!-- Section-->
	<section>
		<div class="container px-4 px-lg-5 mt-5">
			<div class="row">
				<div class="col h2 fw-bold">
					레시피 상세 
				</div>
			</div>
		</div>

		<div class="container px-4 px-lg-5">
			<div
				class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
				<!-- 레시피 상세 -->
				<table class="table table-bordered border-dark table-light" id="tb">
					<tr>
						<td class="table-active">레시피명</td>
						<td>된장찌개</td>
						<td class="table-active">등록자</td>
						<td>한식매니아</td>
					</tr>
					<tr>
						<td class="table-active">조리시간</td>
						<td>30분</td>
						<td class="table-active">난이도</td>
						<td>상</td>
					</tr>
					<tr>
						<td class="table-active">재료</td>
						<td colspan="3">된장, 물, 대파, 돼지고기</td>
					</tr>
					<tr>
						<td class="table-active">조리절차</td>
						<td colspan="3">
							<ul>
								<li>1. 물을 넣고 끓인다.</li>
								<li>2. 끓는 물에 된장을 푼다.</li>
							</ul>

						</td>
					</tr>
					<tr>
						<td class="table-active">조리예</td>
						<td colspan="3">
							<div class="text-center">
								<img class="rounded img-thumbnail" style="width: 50rem"
									src="../assets/dj.jpg" alt="..." />
							</div>
						</td>
					</tr>
				</table>
<a href="#" class="btn btn-md btn-primary">목록</a>
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
