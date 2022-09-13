<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
</head>
<style>
.card:after {
	content: '';
}
</style>
<body>
	<!-- Navigation-->
	<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
	<!-- Header-->

	<!-- Section-->
	<section class="py-5">

		<div class="container px-4 px-lg-5 mt-5">
			<div class="row">
				<div class="col h2">
					요리~조리~ 
					<c:if test="${!empty loginUser}">
					<a href="${ctx}/cookbook/regist.do"
						class="btn btn-md btn-primary">요리책 등록</a>
						</c:if>
				</div>
			</div>
			<div class="row" style="height: 15px">
				<p class="col">
					요리조리는 함께 참여하여 만들어가는 요리책 서비스 입니다.<br> 요리조리와 함께 나만의 레시피를 요리
					매니아들과 공유해 보세요.
				</p>
			</div>
		</div>

		<div class="container px-4 px-lg-5 mt-5">
			<div
				class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
				<!-- 요리책 목록 -->
				<c:forEach var="book" items="${book_list}">
						<div class="col mb-5">
							<div class="card h-70">
								<!-- book details-->
								<img class="card-img-top"
              src="${ctx}/cookbook/image.do?book_id=${book.book_id}" alt="..." />
								<div class="card-body p-4">
									<div class="text-center">
										<!-- book name-->
										<h5 class="fw-bolder">${book.book_name}</h5>
										<!-- author-->
										${book.author_name}
									</div>
								</div>
								<!-- Product actions-->
								<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
									<div class="cook-btn">
									<c:if test="${loginUser.id eq book.author_id }">
										<a href="${ctx}/cookbook/modify.do?cbid=${book.book_id}" class="btn btn-primary">수정</a>
										</c:if>
										<a href="${ctx}/recipe/my/list.do?cbid=${book.book_id}" class="btn btn-primary">상세보기</a>
									</div>
									
								</div>
							</div>
						</div>
				</c:forEach>
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
