<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="namoo.user.dao.UserDao"%>
<%@page import="namoo.common.factory.jdbcDaoFactory"%>
<%@page import="namoo.user.dto.User"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%
	//JSON 데이터 수신
BufferedReader in = request.getReader();
String json= null;
Gson gson =new Gson();
StringBuilder sb = new StringBuilder();
User user =gson.fromJson(in,User.class);
User responseUser = jdbcDaoFactory.getInstance().getUserDao().read(user.getId());
String objectString =null;
Map<String,Boolean> resultMap = new HashMap<String,Boolean> ();
if(responseUser == null){
	resultMap.put("result", true);
}else{
	resultMap.put("result", false);
}
String resultJson =gson.toJson(resultMap);
out.print(resultJson);
in.close();
out.close();
%>
