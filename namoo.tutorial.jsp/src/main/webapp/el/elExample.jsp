<%@page import="org.apache.catalina.ant.jmx.JMXAccessorQueryTask"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
${"문자열" },${'문자열' }
${10 + 20 },${10  / 20 },
<%String name = null;
String id= "";
List<String>list = new ArrayList<String>();

request.setAttribute("name", name);
request.setAttribute("id", id);
request.setAttribute("list", list);

%>
====================================

<%=request.getAttribute("name") %>
<%=request.getAttribute("id") %>
<%=request.getAttribute("list") %>
====================================
<%-- null이면 빈문자열로 바꿔줌 
			empty는 빈문자열 ,null 빈 리스트 모두 true로 나옴
			requestScope는 굳이 쓸 필요없다. 
			문자열과 숫자를 비교하면 숫자로 취급
--%>

${requestScope.name} ==  ${name }
${requestScope.id}==  ${id }
${requestScope.list} ==  ${list } 
${requestScope["list"]}

</body>
</html>