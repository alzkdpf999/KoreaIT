<%@page import="namoo.user.dto.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:redirect url="jstlExample5.jsp" conterxt="/yorizori"> <%-- context는 application  이름을 쓸 곳  --%>
	<c:param name="id" value="bangry"></c:param>
</c:redirect>
