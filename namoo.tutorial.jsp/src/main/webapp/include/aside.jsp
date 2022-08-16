<%@page import="namoo.user.dto.User"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%
HttpSession loginSession = request.getSession();
User loginUser = (User) loginSession.getAttribute("loginUser");
%>


<div class="rightcolumn">
	<div class="card">
		<div>
			<%
			if (loginUser == null) {
			%>
			<form action="/user/login.jsp" method="post">
				<input type="text" id="id" name="id" placeholder="Identifier...">
				<input type="password" id="passwd" name="passwd"
					placeholder="Password..."> <input type="submit"
					value="Login">
			</form>
			<%
			} else { String name = loginUser.getName();
			%>
			<form action="/user/login.jsp" method="get">
			<img src="/img/sample.png" id="profil">
			<h3 id="asid"><%=name %>님</h3>
			<!-- <a href="/user/login.jsp">로그아웃</a> -->
			<input type="submit" value="로그아웃">
			</form>
			<%
			}
			%>
		</div>
	</div>

	<div class="card">
		<h3>Popular Post</h3>
		<div class="fakeimg">
			<p>Image</p>
		</div>
		<div class="fakeimg">
			<p>Image</p>
		</div>
		<div class="fakeimg">
			<p>Image</p>
		</div>
	</div>
	<div class="card">
		<h3>Follow Me</h3>
		<p>Some text..</p>
	</div>
</div>