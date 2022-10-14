<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="icon" type="image/x-icon" href="${ctx }/assets/favicon.ico" />
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<link href="${ctx }/css/styles.css" rel="stylesheet" />
<script type="module" defer src="${ctx}/js/dbCheckPop.js"></script>
</head>
<body>
	<form method="get" action="${ctx}/user/check.do" class="checkForm">
		<div class="mb-3">
			<label for='id' class='form-label'>아이디</label>
			<div id="ui">
				<input type="text" class="form-control idCheck" id="id" name="id"
					placeholder="Id" value="${param.id }">
				<button type="submit" class="check btn btn-primary" id="dbCheckId" ${empty check ? 'disabled' : ''}>중복체크</button>
			</div>
		</div>
		<c:choose>
			<c:when test="${empty check}">
				<h5 class="result">${param.id}사용가능합니다.</h5>
			</c:when>
			<c:when test="${!empty check}">
				<h5 class="result error">${param.id}사용불가합니다.</h5>
			</c:when>
		</c:choose>
		<div class="checkBtn">
			<button type="button" name="CheckId" id="CheckId"
				class="dbCheckId btn btn-success use" ${!empty check ? 'disabled' : '' }>사용하기</button>
			<button type="button" name="cancle" id="cancle"
				class="cancle btn btn-danger">취소</button>
		</div>
	</form>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="js/scripts.js"></script>
</body>

</html>