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
<link href="${ctx }/css/styles.css" rel="stylesheet" />
</head>
<body>
	<!-- Navigation-->
	<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
	<!-- Header-->
	<header class="bg-dark py-5">
		<div class="container px-4 px-lg-5 my-5">
			<div class="text-center text-white">
				<h1 class="display-4 fw-bolder text-warning">요리조리 요리책 서비스 </h1>
				<p class="lead fw-normal text-white-50 mb-0">
					세상의 모든 레시피가 여기에</p>
			</div>
		</div>
	</header>
	<!-- Section-->
	<section class="py-5">
		<div class="content px-4 px-lg-5 mt-5 container">
			<div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
				<div class="col mb-5">
					<div class="card">
						<!-- Product image-->
						<img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
						<!-- Product details-->
						<div class="cook-btn">
							<a href="/movies/detail-view/?midx=82120"
								class="cook_detail">상세보기</a>
						</div>
						<!-- Product actions-->
					</div>
					<div class="card-body p-4">
						<div class="text-center">
							<!-- Product name-->
							<h5 class="fw-bolder">요리책 이름</h5>
							<!-- Product price-->
						</div>
					</div>
				</div>
				<div class="col mb-5">
					<div class="card">
						<!-- Product image-->
						<img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
						<!-- Product details-->
						<div class="cook-btn">
							<a href="/movies/detail-view/?midx=82120"
								class="cook_detail">상세보기</a>
						</div>
						<!-- Product actions-->
					</div>
					<div class="card-body p-4">
						<div class="text-center">
							<!-- Product name-->
							<h5 class="fw-bolder">요리책 이름</h5>
							<!-- Product price-->
						</div>
					</div>
				</div>
				<div class="col mb-5">
					<div class="card">
						<!-- Product image-->
						<img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
						<!-- Product details-->
						<div class="cook-btn">
							<a href="/movies/detail-view/?midx=82120"
								class="cook_detail">상세보기</a>
						</div>
						<!-- Product actions-->
					</div>
					<div class="card-body p-4">
						<div class="text-center">
							<!-- Product name-->
							<h5 class="fw-bolder">요리책 이름</h5>
							<!-- Product price-->
						</div>
					</div>
				</div>
				<div class="col mb-5">
					<div class="card">
						<!-- Product image-->
						<img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
						<!-- Product details-->
						<div class="cook-btn">
							<a href="/movies/detail-view/?midx=82120"
								class="cook_detail">상세보기</a>
						</div>
						<!-- Product actions-->
					</div>
					<div class="card-body p-4">
						<div class="text-center">
							<!-- Product name-->
							<h5 class="fw-bolder">요리책 이름</h5>
							<!-- Product price-->
						</div>
					</div>
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
</body>
</html>
