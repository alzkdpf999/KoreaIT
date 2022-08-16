<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<jsp:useBean id="user" class="namoo.user.dto.User" scope="request">
	<jsp:setProperty  name="user" property="*"/>
</jsp:useBean>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="/css/basic.css">
</head>
<body>
	<!-- header start -->
	<jsp:include page="/include/header.jsp" />
	<!-- header end -->

	<!-- main body start -->
	<div class="row">
		<div class="leftcolumn">
			<div class="card">
				<h2>회원 가입을 환영합니다</h2>
				<div style="height: 150px;">
					<ul>
						<li>아이디 : <%=user.getId() %></li>
						<li>이  름 : : <%=user.getName() %></li>
						<li>이메일 : : <%=user.getEmail() %></li>
					</ul>
				</div>
				<a href="/">홈으로</a>
			</div>
			
		</div>
		
		<!-- aside start -->
		<jsp:include page="/include/aside.jsp" />
		<!-- aside end -->
	</div>
	<!-- main body end -->
	
	<!-- footer start -->
	<jsp:include page="/include/footer.jsp" />
	<!-- footer end -->
</body>
</html>
