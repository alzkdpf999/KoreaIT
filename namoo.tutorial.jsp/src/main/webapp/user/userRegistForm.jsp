<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="/css/basic.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script type="module" defer src="/js/check.js"></script>
<style >
div.row{
display: flex;
    justify-content: center;
}
</style>
</head>
<body>
	<!-- header start -->
	<jsp:include page="/include/header.jsp" />
	<!-- header end -->

	<!-- main body start -->
	<div class="row">
		<div class="leftcolumn">
			<div class="w3-container">
				<div class="w3-center">
				</div>
				<div class="w3-responsive w3-card-4">
					<form class="row" method="post" action="userRegist.jsp" id="signup">
						<div class="mb-3">
							<label for="id" class="form-label">아이디 </label>
							<div id="ui">
								<input type="text" class="form-control" id="id" name="id"
									placeholder="Id"  >
								<button type="button" class="check" id="dbCheckId">중복체크</button>
							</div>
							<label id="idErr">영어 또는 숫자 조합을 사용하여 최소 4글자입니다.</label>
						</div>
						
						<div class="mb-3">
							<label for="passwd" class="form-label">비밀번호</label> <input
								type="password" class="form-control" id="passwd" name="passwd"
								placeholder="Password" >
								<label id="passwdErr">영어, 특수문자, 숫자의 조합을 사용하여 최소 8글자 입니다.</label>
						</div>

						<div class="mb-3">
							<label for="name" class="form-label">이름</label> <input
								type="text" class="form-control" id="name" name="name"
								placeholder="Name" >
						</div>

						<div class="mb-3">
							<label for="email" class="form-label">이메일</label> <input
								type="text" class="form-control" id="email" name="email"
								placeholder="name@example.com" >
						</div>
						<div class="col-auto">
							<button type="submit" class="btn btn-primary mb-3" id="signOk" disabled="disabled" >회원가입</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!--aside start module  -->
	
		<!--aside end module  -->
	</div>
	<!-- main body  end -->

	<!-- footer start -->
	<jsp:include page="/include/footer.jsp"></jsp:include>
	<!-- footer end -->
	
</body>
</html>
