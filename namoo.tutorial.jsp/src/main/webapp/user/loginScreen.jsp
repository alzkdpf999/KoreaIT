<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/basic.css">
<style type="text/css">
body {
	display: flex;
	justify-content: center;
}

li {
	display: inline-block;
	position: relative;
}

ul {
	list-style: none;
	padding: 0px;
}
div.row {
	width: 100%;
	display: flex;
	justify-content: center;
	flex-direction: column;
	align-items: center;
}
a.logo{
	margin-top: 140px;
}

</style>
</head>
<body>
	<div class="row">
	<a href="/" class="logo">
	</a>
		<div class="main">
			<jsp:include page="/include/loginside.jsp" />
		</div>
		<div class="moveLink">
			<ul>
				<li><a href="/">홈으로</a></li>
				<li><a href="/user/userRegistForm.jsp">회원가입</a></li>
			</ul>
		</div>
	</div>
</body>
</html>