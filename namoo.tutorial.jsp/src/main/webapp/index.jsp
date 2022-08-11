<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

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
				<h2>TITLE HEADING</h2>
				<h5>Title description, Dec 7, 2017</h5>
				<div class="fakeimg" style="height: 200px;">Image</div>
				<p>Some text..</p>
				<p>Sunt in culpa qui officia deserunt mollit anim id est laborum
					consectetur adipiscing elit, sed do eiusmod tempor incididunt ut
					labore et dolore magna aliqua. Ut enim ad minim veniam, quis
					nostrud exercitation ullamco.</p>
			</div>
			<div class="card">
				<h2>TITLE HEADING</h2>
				<h5>Title description, Sep 2, 2017</h5>
				<div class="fakeimg" style="height: 200px;">Image</div>
				<p>Some text..</p>
				<p>Sunt in culpa qui officia deserunt mollit anim id est laborum
					consectetur adipiscing elit, sed do eiusmod tempor incididunt ut
					labore et dolore magna aliqua. Ut enim ad minim veniam, quis
					nostrud exercitation ullamco.</p>
			</div>
		</div>
		<!--aside start module  -->
		<jsp:include page="/include/aside.jsp"></jsp:include>
		<!--aside end module  -->
	</div>
	<!-- main body  end -->

	<!-- footer start -->
	<jsp:include page="/include/footer.jsp"></jsp:include>
	<!-- footer end -->
</body>
</html>
