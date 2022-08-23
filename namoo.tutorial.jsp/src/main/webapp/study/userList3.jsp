<%@page import="namoo.yorizori.dto.user.User"%>
<%@page import="namoo.yorizori.common.factory.jdbcDaoFactory"%>
<%@page import="java.util.List"%>

<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%
request.setCharacterEncoding("utf-8");
String search = request.getParameter("searchValue");
String type = request.getParameter("searchType");
if (type == null)
	type = "all";
if (search == null)
	search = "";
String sizeNum = request.getParameter("searchList");

String pageSize = request.getParameter("page");

List<User> userList = null;
int cnt = 0;
int pageList = 1;
int showList = 10;

if (pageSize != null && !pageSize.equals("")) {
	pageList = Integer.parseInt(pageSize);
}
if (sizeNum != null && !sizeNum.equals("")) {
	showList = Integer.parseInt(sizeNum);
}
/* switch (showList) {
case 5:
	
case 15:
default
} */

/* if (type.equals("id") && search != null) {
	cnt = jdbcDaoFactory.getInstance().getUserDao().countByPage(type, search);
	userList = jdbcDaoFactory.getInstance().getUserDao().listByPage(pageList, showList, type, search);
} else if (type.equals("name") && search != null) {
	cnt = jdbcDaoFactory.getInstance().getUserDao().countByPage(type, search);
	userList = jdbcDaoFactory.getInstance().getUserDao().listByPage(pageList, showList, type, search);
} else if (type.equals("all") && search.equals("")) {
	cnt = jdbcDaoFactory.getInstance().getUserDao().countByPage(null, null);
	userList = jdbcDaoFactory.getInstance().getUserDao().listByPage(pageList, showList);
} else if (type.equals("all") && search != null) {
	cnt = jdbcDaoFactory.getInstance().getUserDao().countByPage("all", search);
	userList = jdbcDaoFactory.getInstance().getUserDao().listByPage(pageList, showList, type, search);
} */

//페이지 개수
int pageCount = (int) Math.ceil((double) cnt / showList);
//페이지번호 몇개씩 보여줄까?
int pageNum = 3;

//페이지 그룹별 시작페이지번호와 마지막페이지번호 계산
//페이지 그룹번호
int groupNo = (pageList - 1) / pageNum; // 목록 식별번호
//(1~10): 0, (11~20): 1, (21~30): 2, .....

int startPage = (groupNo * pageNum) + 1;
int endPage = (groupNo * pageNum) + pageNum;
if (endPage > pageCount) {
	endPage = pageCount;
}
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
						<%=cnt%>명)
					</h3>
				</div>
				<div class="search">
					<form method="post" >
					 <input type="hidden" name="searchList" value="<%=showList%>">
						<label for="Type"></label> <select name="searchType">
							<option value="all">전체</option>
							<option value="id">아이디</option>
							<option value="name">이름</option>
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
			
				if (pageList <= 0)
					pageList = 1;
				%>
					<%
				if (pageList == 1) {
				%>
					<a
					>&laquo;</a>
				<a>&lt;</a>
				<%
				} else {
				%>
				<a
					href="?page=<%=1%>&searchList=<%=showList%>&searchType=<%=type%>&searchValue=<%=search%>">&laquo;</a>
				<a
					href="?page=<%=pageList - 1%>&searchList=<%=showList%>&searchType=<%=type%>&searchValue=<%=search%>">&lt;</a>

				<%
				}
				for (int k = startPage; k <= endPage; k++) {
				if (k == pageList) {
				%>
				<a class="active"><%=k%></a>
				<%
				} else {
				%>
				<a
					href="?page=<%=k%>&searchList=<%=showList%>&searchType=<%=type%>&searchValue=<%=search%>"><%=k%></a>
				<%
				}
				}
				if (pageList % pageNum == 0) {
				if (pageList != pageCount) {
				%>
				<a
					href="?page=<%=startPage + pageNum%>&searchList=<%=showList%>&searchType=<%=type%>&searchValue=<%=search%>">&gt;
				</a>
				<%
				} else {
				%>
				<a>&gt; </a>
				<%
				}
				%>
				<%
				} else if (pageList == pageCount) {
				%>
				<a>&gt; </a>
				<a
					 >&raquo;</a>
				<%
				} else {
				%>
				<a
					href="?page=<%=pageList + 1%>&searchList=<%=showList%>&searchType=<%=type%>&searchValue=<%=search%>">&gt;
				</a>
				<a
					href="?page=<%=pageCount%>&searchList=<%=showList%>&searchType=<%=type%>&searchValue=<%=search%>">&raquo;</a>
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