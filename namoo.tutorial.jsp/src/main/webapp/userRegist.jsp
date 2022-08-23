<%@page import="namoo.yorizori.dao.user.UserDao"%>
<%@page import="namoo.yorizori.common.factory.jdbcDaoFactory"%>
<%@page import="namoo.yorizori.dto.user.User"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<%-- jsp는 post,get 둘 다 처리 --%>
<%-- 이런 방식을 써야하지마 이제 이런 방식 안씀
userBean을 씀
String id = request.getParameter("id");
String name = request.getParameter("name");
String passwd = request.getParameter("passwd");
String email = request.getParameter("email");
//=================다른 방식들========================
User user = new User();
user.setId(id);
user.setName(name);
user.setPasswd(passwd);
user.setEmail(email);
request.setAttribute("user",user);
--%>
<%-- getParameter에서 처럼 param에 넣은 값을 id에 저장해주세요
	String id가 property로 getParameter("id")의 id가 param으로 
 --%>
<jsp:useBean id="user" class="namoo.yorizori.dto.user.User" scope="request">
<%-- 여기서  더 간략하게  
	<jsp:setProperty name="user" property="id" param="id"/>
	<jsp:setProperty name="user" property="name" param="name"/>
	<jsp:setProperty name="user" property="passwd" param="passwd"/>
	<jsp:setProperty name="user" property="email" param="email"/>
	요청 파라미터 이름과 빈 프로퍼티 이름이 동일한 모든 프로퍼티 자동 설정
- 폼 데이터를 빈에 설정할 때 유용하게 사용
이름을 같게 해줘야 함
 --%>
 	<jsp:setProperty name="user" property="*"/>
 </jsp:useBean>
<%
jdbcDaoFactory.getInstance().getUserDao().create(user);
%>
<jsp:forward page="userRegistResult.jsp"/>