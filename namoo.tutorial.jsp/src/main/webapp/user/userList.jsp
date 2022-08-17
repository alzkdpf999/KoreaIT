<%@page import="namoo.user.dto.User"%>
<%@page import="namoo.common.factory.jdbcDaoFactory"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%
String search = request.getParameter("searchValue");
String type = request.getParameter("searchType");
List<User> userList = null ; 
int cnt = 0;
int pageList = 1;
if(request.getParameter("page") != null){
	 pageList = Integer.parseInt(request.getParameter("page"));
}
if(search == null && type == null){
cnt =  jdbcDaoFactory.getInstance().getUserDao().countByPage(type, search);
userList = jdbcDaoFactory.getInstance().getUserDao().listByPage(pageList);
}else if (type.equals("id") && search != null){
cnt =  jdbcDaoFactory.getInstance().getUserDao().countByPage(type,search);
userList = jdbcDaoFactory.getInstance().getUserDao().listByPage(pageList,10,type,search);
}else if (type.equals("name") && search != null){
cnt =  jdbcDaoFactory.getInstance().getUserDao().countByPage(type,search);
userList = jdbcDaoFactory.getInstance().getUserDao().listByPage(pageList,10,type,search);
}else if (type.equals("all") && search.equals("")){
	cnt =  jdbcDaoFactory.getInstance().getUserDao().countByPage(null, null);
	userList = jdbcDaoFactory.getInstance().getUserDao().listByPage(pageList,10);
}else if (type.equals("all") && search != null){
	cnt =  jdbcDaoFactory.getInstance().getUserDao().countByPage("all", search); 
	userList = jdbcDaoFactory.getInstance().getUserDao().listByPage(pageList,10,type,search);
}

/* userList = jdbcDaoFactory.getInstance().getUserDao().listByPage(pageList,10); */
/* userList = jdbcDaoFactory.getInstance().getUserDao().listByPage(pageList,10); */
/* List<User> userList = jdbcDaoFactory.getInstance().getUserDao().listByPage(1,1,"id","bangry"); */


// 일단 무조건 10개씩 나온다 치면
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
						회원 목록(총 <%=cnt%>명)
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

			</div>
			<div class="pagination">
				<a href="userList.jsp?page=1">&laquo;</a>
				<%
				for (int k = 1; k <= Math.ceil(cnt / 10.0); k++){
				%>
				<a href="userList.jsp?page=<%=k %>" ><%=k%></a>
				<%
				} 
				%>
				 <a href="userList.jsp?page=<%=Math.ceil(cnt / 10.0) %>">&raquo;</a>
			</div>
			<!-- 끝부분 -->

		</div>
		<jsp:include page="/include/aside.jsp"></jsp:include>
	</div>
	<jsp:include page="/include/footer.jsp"></jsp:include>
</body>
</html>