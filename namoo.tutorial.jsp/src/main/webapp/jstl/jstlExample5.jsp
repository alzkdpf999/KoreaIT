<%@page import="namoo.user.dto.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
//서블릿 코드 영역
List<String> teams = new ArrayList<String>();

teams.add("두산 베어즈");
teams.add("LG 트윈즈");
teams.add("한화 이글즈");
teams.add("삼성 라이온즈");
teams.add("기아 타이거즈");

List<User> userList = new ArrayList<User>();

userList.add(new User("bangry", "1111", "정충효", "jstl@naver.com"));
userList.add(new User("bangry1", "1111", "정충효", "jstl@naver.com"));
userList.add(new User("bangry2", "1111", "정충효", "jstl@naver.com"));
userList.add(new User("bangry3", "1111", "정충효", "jstl@naver.com"));
userList.add(new User("bangry4", "1111", "정충효", "jstl@naver.com"));

request.setAttribute("teams", teams);
request.setAttribute("userList", userList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
	<c:forEach var="val" begin="1" end="5" step="1">
	${val}<br>
	</c:forEach>
	<br>

	<table border="1">
		<c:forEach var="i" begin="2" end="9" step="1">
			<tr>
				<c:forEach var="j" begin="1" end="9" step="1">
					<td>${i}X${j} = ${ i * j }</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>

	<select id="teams">
		<c:forEach var="team" items="${teams }">
			<%-- 이렇게해도 크기만큼 돔 --%>
			<option>${team}</option>
		</c:forEach>
	</select>

	<select id="userList">
		<c:forEach var="user" items="${userList}">
			<%-- 이렇게해도 크기만큼 돔 --%>
			<option>${user.getId()}</option>
		</c:forEach>
	</select>
	<table>
		<c:forEach var="user" items="${userList}" varStatus="varStatus">
			<%-- varStatus의 이름은 상관없음 --%>
			<tr>
				<th> ${varStatus.count}</th>
				<td>${user.id }</td>
				<td>${user.passwd }</td>
				<td>${user.name }</td>
				<td>${user.email }</td>
				
			</tr>
		</c:forEach>
	</table>

</body>
</html>