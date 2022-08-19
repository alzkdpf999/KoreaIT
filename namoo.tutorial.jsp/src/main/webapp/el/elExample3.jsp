<%@page import="org.apache.catalina.ant.jmx.JMXAccessorQueryTask"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%

Cookie exampleCookie = new Cookie("bye", "See you again");
response.addCookie(exampleCookie);
response.sendRedirect("elExample2.jsp");

%>