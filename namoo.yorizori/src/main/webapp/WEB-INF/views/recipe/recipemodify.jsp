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
<link rel="icon" type="image/x-icon" href="${ctx }/ssets/favicon.ico" />
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="${ctx}/css/styles.css" rel="stylesheet" />
<!-- <script type="module" defer src="${ctx}/js/modify.js"></script> -->
<script type="module" defer src="${ctx}/js/modify.js"></script>
</head>
<style>

</style>
<body>
	<!-- Navigation-->
	<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
	<!-- Header-->

	<!-- Section-->
	<section class="py-5">
		<div class="container">
			<div class="row">
				<div class="col-lg-9">
					<div class="col-auto h2">레시피 등록</div>
					<!-- recipe Form -->
					<form class="row g-3" action="${ctx}/recipe/modify.do"
						method="post" enctype="multipart/form-data" id="recipeform">
						<div class="col-md-6">
							<label for="recipe_name" class="form-label">레시피명</label> <input
								type="text" class="form-control" id="recipe_name"
								name="recipe_name" value="${recipe.recipe_name}">
						</div>
						<div class="col-md-6">
							<label for="writer_name" class="form-label">등록자</label> <input
								type="text" class="form-control" id="writer_name"
								value="${loginUser.name}" disabled>
						</div>
						<div class="col-md-6">
							<label for="recipe_time" class="form-label">조리시간</label> <input
								type="number" class="form-control" id="recipe_time"
								name="recipe_time" value="${recipe.recipe_time}">
						</div>
						<div class="col-md-4">
							<label for="recipe_level" class="form-label">난이도</label> <select
								id="recipe_level" class="form-select" name="recipe_level">
								<c:forEach var="value" begin="1" end="3" step="1">
									<option value="${value }"
										${recipe.recipe_level eq value ? 'selected' : ''}>${value eq 3 ? '상' : (value eq 2 ? '중' : '하') }
									</option>
								</c:forEach>
							</select>
						</div>

						<div class="col-12">
							<label for="ingredients" class="form-label">재료</label>
							<textarea class="form-control" rows="5" id="ingredients"
								name="ingredients">${recipe.ingredients }</textarea>
						</div>
						<div class="col-12" id="sequence">
							<label for="seq_num1" class="form-label">조리절차</label>
							<c:forEach var="proc" items="${proc_list}">
								<input type="text" class="form-control seq_num" name="seq_num"
									value="${proc.pcd}">
							</c:forEach>
						</div>
						<c:forEach var="proc" items="${proc_list}">
							<input type="hidden" name="num" value="${proc.seq_num}">
						</c:forEach>

						<div class="col-12" id="recipe_sequence">
							<input type="button" class="btn btn-info btn-sm" value="추가"
								id="add"> <input type="button"
								class="btn btn-info btn-sm" value="삭제" id="del">
						</div>

						<div class="col-12">
							<label for="img_file_name" class="form-label">조리사진</label>
						</div>
						<div class="col-12" id="img">
							<input type="file" class="form-control" id="img_file_name"
								name="img_file_name">

							<button type="button" id="imgdelbtn"
								class="btn btn-outline-danger">기존 사진 삭제</button>
							<input type="hidden" name="imgdel" id="imgdel" value="no">
							<input type="hidden" name="recipeid" value="${param.recipeid }">
						</div>
						<input type="hidden" name="book_id" value="${recipe.book_id }">
						<div class="col-12 modify">
							<button type="submit" class="btn btn-primary bt">수정</button>
						<c:choose>
							<c:when
								test="${page eq '/yorizori/recipe/all.do' }">
								<a href="${page}" class="btn btn-success">목록</a>
							</c:when>
							<c:otherwise>	
								<a href="${page}?cbid=${recipe.book_id}" class="btn btn-success">목록</a>
							</c:otherwise>
						</c:choose>
						<input type="hidden"
								name="imgFileName" value="${recipe.img_file_name}"> <input
								type="hidden" name="contentType" value="${recipe.img_cont_type}">
						</div>
						<input type="hidden" name="local" value=${local }>
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
	<script src="${ctx}/js/scripts.js"></script>
</body>

</html>