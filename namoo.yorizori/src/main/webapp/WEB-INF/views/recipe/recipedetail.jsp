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
<script type="module" defer src="${ctx}/js/add.js"></script>
</head>
<style>
.modify {
	padding-right: 0px;
	padding-bottom: 10px;
}
</style>
<body>
	<!-- Navigation-->
	<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
	<!-- Header-->

	<!-- Section-->
	<section>
		<div class="container px-4 px-lg-5 mt-5">
			<div class="row">
				<div class="col h2 fw-bold">레시피 상세</div>
			</div>
		</div>

		<div class="container px-4 px-lg-5">
			<form class="row g-3" action="${ctx}/recipe/${move}delete.do" method="post">
				<div
					class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 rowdel">
					<!-- 레시피 상세 -->
					<table class="table table-bordered border-dark table-light" id="tb">
						<tr>
							<td class="table-active">레시피명</td>
							<td>${recipe.recipe_name}</td>
							<td class="table-active">등록자</td>
							<td>${recipe.writer_id}</td>
						</tr>
						<tr>
							<td class="table-active">조리시간</td>
							<td>${recipe.recipe_time}분</td>
							<td class="table-active">난이도</td>
							<td>${recipe.recipe_level eq 3 ? '상' : (recipe.recipe_level eq 2 ? '중' : '하')}</td>
						</tr>
						<tr>
							<td class="table-active">재료</td>
							<td colspan="3">${recipe.ingredients}</td>
						</tr>
						<tr>
							<td class="table-active">조리절차</td>
							<td colspan="3">
								<ul>
									<c:forEach var="proc" items="${proc_list}">
										<li>${proc.pcd}</li>
									</c:forEach>
								</ul>

							</td>
						</tr>
						<tr>
							<td class="table-active">조리예</td>
							<td colspan="3">
								<div class="text-center">
									<img class="card-img-top"
										src="${ctx}/recipe/image.do?recipeid=${param.recipeid}"
										alt="..." />
								</div>
							</td>
						</tr>
					</table>
					<input type="hidden" name="recipeid" value="${param.recipeid}">
					<input type="hidden" name="book_id" value="${recipe.book_id}">
					<input type="hidden" value="${page}">
					<div class="col-12 modify">
						<c:if test="${loginUser.id eq recipe.writer_id }">
							<button type="submit" class="btn btn-primary bt" >삭제</button>
						</c:if>
						<c:choose>
							<c:when
								test="${page eq '/yorizori/recipe/all.do' }">
								<a href="${page}" class="btn btn-success">목록</a>
							</c:when>
							<c:otherwise>	
								<a href="${page}?cbid=${recipe.book_id}" class="btn btn-success">목록</a>
							</c:otherwise>
						</c:choose>

					</div>
				</div>
			</form>
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
