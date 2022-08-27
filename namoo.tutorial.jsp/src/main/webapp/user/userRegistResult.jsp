<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<jsp:useBean id="user" class="namoo.user.dto.User" scope="request">
	<jsp:setProperty  name="user" property="*"/>
</jsp:useBean>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="/css/basic.css">
<style >
div.row{
display: flex;
    justify-content: center;
}
ul{
list-style: none;
}
.moveLink,h2.title{
    display: flex;
    justify-content: center;
}

</style>

</head>
<body>
	<!-- header start -->
	<jsp:include page="/include/header.jsp" />
	<!-- header end -->
<form name="myForm" action="/user/login.jsp" method="post">
<input type="hidden" name="id" value="<%=user.getId()%>">
<input type="hidden" name="passwd" value="<%=user.getPasswd()%>">
</form>
	<!-- main body start -->
	<div class="row">
		<div class="leftcolumn">
			<div class="card">
				<h2 class="title">회원 가입을 환영합니다</h2>
				<div style="height: 150px;display: flex;justify-content: center; padding-right: 50px;" >
					<ul>
						<li>아이디 : <%=user.getId() %></li>
						<li>이  름 : : <%=user.getName() %></li>
						<li>이메일 : : <%=user.getEmail() %></li>
					</ul>
				</div>
				
			</div>
			<div class="moveLink">
			<ul>
				<li><a href="/">홈으로</a></li>
				<li><a href="#" onclick="javascript:document.myForm.submit();">로그인</a></li>
			</ul>
		</div>
		</div>
		
		<!-- aside start -->
		<!-- aside end -->
	</div>
	<!-- main body end -->
	
	<!-- footer start -->
	<jsp:include page="/include/footer.jsp" />
	<!-- footer end -->
</body>
</html>
