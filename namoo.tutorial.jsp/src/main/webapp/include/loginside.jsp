<%@page import="namoo.user.dto.User"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


<%
int rs = 1;
String result = request.getParameter("result");
String err = "";
if(result == null) {
	result = "";
}else if(result.equals("-1")){
	err = "아이디 오류";
	rs = -1;
}else if(result.equals("0")){
	err = "비밀번호 오류";
	rs = 0;
}




HttpSession loginSession = request.getSession();
User loginUser = (User) loginSession.getAttribute("loginUser");
String check = request.getParameter("yes");
String checkId = null;
String id = request.getParameter("id");
String passwd = request.getParameter("passwd");
if (id == null)
	id = "";
if (passwd == null)
	passwd = "";

Cookie[] cookies = request.getCookies();
if (cookies != null) {
	for (Cookie cookie : cookies) {
		if (cookie.getName().equals("id"))
	checkId = cookie.getValue();
	}
}
if (checkId == null)
	checkId = "";
%>


<div class="card">

	<div>
		<%
		if (loginUser == null) {
		%>
		<form action="/user/login.jsp" method="post" name="login">

			<input type="hidden" name="path" value="<%=request.getRequestURI()%>">
			<%
			if (!checkId.equals("")) {
			%>
			<input type="text" id="id" name="id" value="<%=checkId%>" class="id">

			<input type="password" id="passwd" name="passwd"
				placeholder="Password..." class="passwd">

			<div id="saveCheck">
			<%if(rs ==1){ %>
				<label for="save"> <input type="checkbox" name="yes"
					value="yes" id="save" checked> <i class="circle"></i> <span
					class="text">아이디 저장</span>
						</label>
					<%}else{ %>
					<label for="save"> <input type="checkbox" name="yes"
					value="yes" id="save" > <i class="circle"></i> <span
					class="text">아이디 저장</span>
						</label>
					<%} %>
			
				<%
				if(rs != 1){ 
				%>
				<span class="err"><%=err %></span>
				<%
				}
				%>
			</div>
			<%
			} else { 
				if(rs == 0){
			%>
			<input type="text" id="id" name="id" placeholder="id" class="id" value="<%=id%>">
			<input type="password" id="passwd" name="passwd"
				placeholder="Password..." class="passwd" autofocus="autofocus">
			<%
			}else{
				if(rs == 1){
				%>
				<input type="text" id="id" name="id" placeholder="id" class="id"> 
				<input type="password" id="passwd" name="passwd"
				placeholder="Password..." class="passwd">
				<%
				}else{%>
				<input type="text" id="id" name="id" placeholder="id" class="id" autofocus="autofocus"> 
				<input type="password" id="passwd" name="passwd"
				placeholder="Password..." class="passwd">
			<% 
				}
				}
			%>
		
			<div id="saveCheck">
				<%if(check!= null){
				%>
				<label for="save"> <input type="checkbox" name="yes"
					value="yes" id="save" checked> <i class="circle"></i> <span
					class="text">아이디 저장</span>
				</label>
				<%}else{ %>
				<label for="save"> <input type="checkbox" name="yes"
					value="yes" id="save" > <i class="circle"></i> <span
					class="text">아이디 저장</span>
				</label>
				<%} %>
				<%
				if(rs != 1){ 
				%>
				<span class="err"><%=err%></span>
				<%
				}
				%>
			</div>
			<%
			}
			%>
			<input type="submit" value="Login" id="submit">
		</form>
		<%
		} else {
		String name = loginUser.getName();
		%>
		<form action="/user/login.jsp" method="get" name="logout">
			<input type="hidden" name="path" value="<%=request.getRequestURI()%>">
			<img src="/img/sample.png" id="profil">
			<h3 id="asid"><%=name%>님
			</h3>
			<input type="submit" value="로그아웃">
		</form>
		<%
		}
		%>
	</div>
</div>