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
<link rel="icon" type="image/x-icon" href="${ctx }/assets/favicon.ico" />
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="${ctx}/css/styles.css" rel="stylesheet" />
<script type="module" defer src="${ctx}/js/check.js"></script>
</head>
<body>
	<!-- Navigation-->
	<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
	<!-- Header-->

	<!-- Section-->
	<section class="py-5">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="col-auto h2">요리책 등록</div>
					<!-- cookbook Form -->
					<form method="post" action="${ctx}/cookbook/modify.do">
						<div class="row mb-3">
							<label for="book_name" class="col-sm-2 col-form-label">요리책명</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="book_name" name="book_name" value="${book.book_name }">
							</div>
						</div>
						<div class="row mb-3">
							<label for="author" class="col-sm-2 col-form-label">등록자</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" disabled
									id="book_author" value="${loginUser.getName()}"
									>
							</div>
						</div>
						<div class="row mb-3">
							<label for="book_desc" class="col-sm-2 col-form-label">설명</label>
							<div class="col-sm-10">
								<textarea class="form-control" id="book_desc" name="book_desc"
									rows="5">${book.book_desc}</textarea>
							</div>
						</div>

							<input type="hidden" value="${param.cbid }" name="book_id">
							<div class="col-12 modify" style="text-align: right;">
								<button type="submit" class="btn btn-primary bt	">수정</button>
								<input type="hidden" name="local" value=${local }>
								<a href="${local}" class="btn btn-primary">목록</a>
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
