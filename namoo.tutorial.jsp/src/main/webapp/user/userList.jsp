<%@page import="namoo.user.dto.User"%>
<%@page import="namoo.common.factory.jdbcDaoFactory"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%
String search = request.getParameter("searchValue");
String type = request.getParameter("searchType");
List<User> userList = jdbcDaoFactory.getInstance().getUserDao().list();
User searchUser = jdbcDaoFactory.getInstance().getUserDao().read(search);
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>회원목록</title>
<link rel="stylesheet" type="text/css" href="/css/basic.css">
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
						<%=userList.size()%>명)
					</h3>
				</div>
				<div class="search">
					<form action="userList.jsp">
						<select name="searchType">
							<option value="all">전체</option>
							<option value="id">아이디</option>
							<option value="name">이름</option>
						</select> <input type="text" name="searchValue" placeholder="Search..">
						<input type="submit" value="검색">
					</form>
				</div>
				<!-- 시작 -->
				<%
				if (search != null && searchUser != null && type.equals("id")) {
				%>
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
							<tr class="w3-white">
								<td><%=1%></td>
								<td><%=searchUser.getId()%></td>
								<td><%=searchUser.getName()%></td>
								<td><%=searchUser.getEmail()%></td>
								<td><%=searchUser.getRegdate()%></td>
							</tr>

						</tbody>
					</table>
				</div>
	
				<%
				out.println("</div>");
				} else {
				%>
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
								<td><%=user.getEmail()%></td>
								<td><%=user.getRegdate()%></td>
							</tr>

							<%
							}
							%>

						</tbody>
					</table>
				</div>
			
				<%
				out.println("</div>");
				}
				%>

				<!-- 끝부분 -->

			</div>
			<jsp:include page="/include/aside.jsp"></jsp:include>
		</div>
		<jsp:include page="/include/footer.jsp"></jsp:include>
</body>
</html>