<%@page import="namoo.common.web.PageBuilder"%>
<%@page import="namoo.common.web.Params"%>
<%@page import="namoo.user.dao.UserDao"%>
<%@ page import="java.util.List"%>
<%@ page import="namoo.common.factory.jdbcDaoFactory"%>
<%@ page import="namoo.user.dto.User"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<% request.setCharacterEncoding("utf-8"); %>

<%-- 선택페이지, 조회 목록개수, 검색유형, 검색값에 따른 사용자 목록 반환 & 페이징 처리 --%>
<%-- 선생님이 한것  --%>
<%
HttpSession loginSession = request.getSession();
User loginUser = (User) loginSession.getAttribute("loginUser");
if (loginUser != null) {
%>
<html>
<script>
	alert("회원목록은 로그인 사용자만 사용 가능합니다.");
</script>
</html>
<%
} else {
int requestPage = 1;
int listSize = 2;
String searchType = null;
String searchValue = null;
int pageSize = 2;

String selectPage = request.getParameter("page");
if (selectPage != null && !selectPage.equals("")) {
	requestPage = Integer.parseInt(selectPage);
}

String trSize = request.getParameter("size");
if (trSize != null && !trSize.equals("")) {
	listSize = Integer.parseInt(trSize);
}
searchType = request.getParameter("type");
searchValue = request.getParameter("value");
if (searchType == null)
	searchType = "";
if (searchValue == null)
	searchValue = "";

//요청파라메터 포장
Params params = new Params(requestPage, listSize, pageSize, searchType, searchValue);

List<User> list = null;
int rowCount = 0;
UserDao userDao = jdbcDaoFactory.getInstance().getUserDao();

if (searchType == null || searchType.equals("")) {// 전체검색

} else {// 조건검색
	list = jdbcDaoFactory.getInstance().getUserDao().listByPage(params);
	rowCount = userDao.countByPage(params);
}
//PageBuilder를 이용하여 페이징 계산
PageBuilder pageBuilder = new PageBuilder(params, rowCount);
pageBuilder.build();
%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="/css/basic.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" type="text/css" href="/css/pagination.css">
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
          <h3>
            회원 목록(총
            <%=rowCount%>명)
          </h3>
        </div>

        <!-- 검색폼 -->
        <div class="search">
          <form method="post">
            <input type="hidden" name="page" value="<%=requestPage%>">
            <input type="hidden" name="size" value="<%=listSize%>">
            <select name="type">
              <option value="">전체</option>
              <option value="id">아이디</option>
              <option value="name">이름</option>
            </select> <input type="text" name="value" placeholder="Search..">
            <input type="submit" value="검색">
          </form>
        </div>

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
              for (int i = 0; i < list.size(); i++) {
              	User user = list.get(i);
              %>
              <tr class="w3-white">
                <td><%=(rowCount - listSize * (params.getPage() - 1)) - i%></td>
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
      <%-- 페이징 처리 --%>
      <div class="pagination">
        <%
        if (pageBuilder.isShowFirst()) { //1페이지일 경우 처음으로와 이전 버튼이 안생김
        %>
        <a href="<%=pageBuilder.getQueryString(1)%>">처음으로</a>
        <%
        }
        %>

        <%
        if (pageBuilder.isShowPrevious()) { //이전 페이지로 이동
        %>
        <a
          href="<%=pageBuilder.getQueryString(pageBuilder.getPreviousStartPage())%>">&laquo;</a>
        <%
        }
        %>

        <%
        for (int i = pageBuilder.getStartPage(); i <= pageBuilder.getEndPage(); i++) {
        	if (i == params.getPage()) {
        %>
        <a class="active"><%=i%></a>
        <%
        } else {
        %>
        <a href="<%=pageBuilder.getQueryString(i)%>"><%=i%></a>
        <%
        }
        }
        %>

        <%
        if (pageBuilder.isShowNext()) {
        %>
        <a
          href="<%=pageBuilder.getQueryString(pageBuilder.getNextStartPage())%>">&raquo;</a>
        <%
        }
        %>
        <%
        if (pageBuilder.isShowLast()) {
        %>
        <a
          href="<%=pageBuilder.getQueryString(pageBuilder.getPageCount())%>">끝으로</a>
        <%
        }
        %>
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
<%
}
%>
