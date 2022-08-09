<%@page import="java.util.Calendar"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%-- 선언문 !--%>
<%!private int count;%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
	<h2>JSP 동작원리입니다..</h2>


	<%
	String message;
	Calendar today = Calendar.getInstance();
	String ymd = String.format("%1$tF %1$tT", today);
	//out.println(ymd); 여기서는 똑같이 주석하면 됌
	%>
	<%-- 출력하게 만들어줌 ;는 찍으면 오류--%>
	<%=ymd%>
	<br> 당신은
	<%=++count%>번째 방문자입니다.

	<table border="1">
<%
	for(int i=2;i<10;i++){
		out.println("<tr>");
		for(int j=1;j<10;j++){
			out.println("<td>"+i + "x"+j +"="+i*j+"</td>");
		}
		out.println("</tr>");
	}
%>
	</table> <br>
	<table border="1">
<%
for(int i=2;i<10;i++){
%>
		<tr>
<% 		
for(int j=1;j<10;j++){	
%>		
	<td><%= i %> x <%= j %> = <%= i*j %></td>
		<% } %>
		</tr>
	<% } %>
</table>


</body>
</html>