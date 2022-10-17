<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>회원 목록</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />
<style>
@media ( min-width : 1200px) {
	.container {
		max-width: 970px;
	}
}
</style>
</head>
<body>
	<div class="container">
		<div class="py-5 text-center">
			<h2>회원 목록</h2>
		</div>
		<div class="row">
			<div class="col">
				<form method="get" action="/pages/search">
					<input type="text" name="id" placeholder="Search..">
					<button type="button" class="btn btn-primary">검색</button>
					<a href="/users/form" class="btn btn-primary float-end">회원 등록</a>
				</form>

			</div>
		</div>
		<hr class="my-4">
		<div>
		<h3>${pageResults.totalElements}</h3>
			<table class="table">
				<thead>
					<tr>
						<th>아이디</th>
						<th>이름</th>
						<th>이메일</th>
						<th>가입일자</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${empty pageResults}">
						<tr>
							<td><a href="/users/${user.id}"> ${user.id}</a></td>
							<td>${user.name}</td>
							<td><a href="mailto:${user.email}">${user.email}</a></td>
							<td>${user.regdate}</td>
						</tr>
					</c:if>
					<c:if test="${!empty pageResults}">
						<c:forEach var="user" items="${pageResults.content}">
							<tr>
								<td><a href="/users/${user.id}"> ${user.id}</a></td>
								<td>${user.name}</td>
								<td><a href="mailto:${user.email}">${user.email}</a></td>
								<td>${user.regdate}</td>
							</tr>
						</c:forEach>
					</c:if>

				</tbody>
			</table>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>