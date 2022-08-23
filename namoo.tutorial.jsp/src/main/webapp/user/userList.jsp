
<%@page import="namoo.common.web.myPageBuilder"%>
<%@page import="namoo.user.dao.UserDao"%>
<%@page import="namoo.common.web.Params"%>
<%@page import="namoo.user.dto.User"%>
<%@page import="namoo.common.factory.jdbcDaoFactory"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>

<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
HttpSession loginSession = request.getSession();
User loginUser = (User) loginSession.getAttribute("loginUser");
if (loginUser == null) {
	response.sendRedirect("/");
} else {
	HashMap<String, String> options = new HashMap<String, String>() {
		{
	put("all", "전체");
	put("id", "아이디");
	put("name", "이름");
		}
	};
	String check = request.getParameter("yes");
	request.setCharacterEncoding("utf-8");
	String search = request.getParameter("searchValue");
	String type = request.getParameter("searchType");
	if (type == null)
		type = "all";
	if (search == null)
		search = "";
	String sizeNum = request.getParameter("searchList");

	String pageSize = request.getParameter("page");

	List<User> userList = null; // 리스트
	int cnt = 0; // 지금 페이지의 목록 수
	int pageList = 1; // 지금이 몇페이지인지
	int showList = 10; //몇개의 정보씩
	int pageNum = 3; //페이지 최대 몇개씩 보여줄것인지
	if (pageSize != null && !pageSize.equals("")) {
		pageList = Integer.parseInt(pageSize);
	}
	if (sizeNum != null && !sizeNum.equals("")) {
		showList = Integer.parseInt(sizeNum);
	}
	Params params = new Params(pageList, showList, pageNum, type, search);

	UserDao userDao = jdbcDaoFactory.getInstance().getUserDao();

	userList = userDao.listByPage(params);
	cnt = userDao.countByPage(params);

	myPageBuilder pageBuilder = new myPageBuilder(params, cnt);
	pageBuilder.build();
	//페이지 개수
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>회원목록</title>
<link rel="stylesheet" type="text/css" href="/css/basic.css">
<link rel="stylesheet" type="text/css" href="/css/pagination.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<jsp:include page="/include/header.jsp" />


	<div class="row">
		<div class="leftcolumn">
			<div class="w3-container">
				<div class="w3-center">
					<h3>
						회원 목록(총
						<%=cnt%>
						명)
					</h3>
				</div>
				<div class="search">
					<form method="post">
						<input type="hidden" name="searchList" value="<%=showList%>">
						<label for="Type"></label> <select name="searchType">
							<%
							for (String option : options.keySet()) {
								if (type.equals(option)) {
							%>
							<option value="<%=type%>" selected="selected"><%=options.get(type)%></option>
							<%
							} else {
							%>
							<option value="<%=option%>"><%=options.get(option)%></option>
							<%
							}
							}
							%>


						</select> <input type="text" name="searchValue" placeholder="Search..">
						<input type="submit" value="검색">

					</form>
					<select name="searchList"
						onchange="if(this.value) location.href=(this.value);">
						<%
						for (int i = 1; i <= 4; i++) {
							int j = i * 5;
							if (j == showList) {
						%>
						<option value="<%=showList%>" selected="selected"><%=showList%></option>
						<%
						} else {
						%>

						<option
							value="http://localhost/user/userList.jsp?page=1&searchList=<%=j%>&searchType=<%=type%>&searchValue=<%=search%>"><%=j%></option>
						<%
						}
						}
						%>
					</select>
				</div>
				<!-- 시작 -->
				<div class="w3-responsive w3-card-4">
					<table class="w3-table w3-striped w3-bordered">
						<thead>
							<tr class="w3-theme">
								<th>번호</th>
								<th>아이디</th>
								<th>이름</th>
								<th>이메일</th>
								<th>가입일자</th>
							</tr>
						</thead>
						<tbody>
							<%
							int i = 1;
							for (User user : userList) {
							%>
							<tr class="w3-white">
								<td><%=i++%></td>
								<td><%=user.getId()%></td>
								<td><%=user.getName()%></td>
								<td><a href="mailto:<%=user.getEmail()%>"><%=user.getEmail()%></a></td>
								<td><%=user.getRegdate()%></td>
							</tr>
							<%
							}
							%>
						</tbody>
					</table>
				</div>

			</div>

			<div class="pagination">

				<%
				if (pageBuilder.pageListLessOne()) {
				%>
				<a>&laquo;</a> <a>&lt;</a>
				<%
				} else {
				%>
				<a href="<%=pageBuilder.getQueryString(1)%>">&laquo;</a> <a
					href="<%=pageBuilder.getQueryString(pageBuilder.getParams().getPage() - 1)%>">&lt;</a>

				<%
				}
				for (int k = pageBuilder.getStartPage(); k <= pageBuilder.getEndPage(); k++) {
				if (k == pageList) {
				%>
				<a class="active"><%=k%></a>
				<%
				} else {
				%>
				<a href="<%=pageBuilder.getQueryString(k)%>>"><%=k%></a>
				<%
				}
				}
				if (pageBuilder.pageListEqEndPage()) {
				if (!pageBuilder.pageListEqPageCount()) {
				%>

				<a
					href="<%=pageBuilder.getQueryString(pageBuilder.getNextStartPage())%>">&gt;
				</a><a
					href="<%=pageBuilder.getQueryString(pageBuilder.getPageCount())%>">&raquo;</a>
				<%
				} else {
				%>
				<a>&gt; </a> <a>&raquo;</a>
				<%
				}
				%>
				<%
				} else {
				%>
				<a
					href="<%=pageBuilder.getQueryString(pageBuilder.getParams().getPage() + 1)%>">&gt;
				</a> <a
					href="<%=pageBuilder.getQueryString(pageBuilder.getPageCount())%>">&raquo;</a>
				<%
				}
				%>



			</div>

			<!-- 끝부분 -->

		</div>
		<jsp:include page="/include/aside.jsp"></jsp:include>
	</div>
	<jsp:include page="/include/footer.jsp"></jsp:include>
</body>
</html>
<%
}
%>