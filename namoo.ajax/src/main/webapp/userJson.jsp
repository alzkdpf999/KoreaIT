<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@ page contentType="application/json; charset=utf-8" pageEncoding="utf-8"%>

<%
	//JSON 데이터 수신
	BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
String json= null;
StringBuilder sb = new StringBuilder();

//echo
while((json=in.readLine()) != null){
	sb.append(json);
}
out.print(sb.toString());
in.close();
out.close();
%>

