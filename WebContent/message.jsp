<%@page import="com.ateam.webstore.ui.views.ContentView"%>
<%@page import="com.ateam.webstore.ui.views.*"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%View v = (View) request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW); %>

<%if (v.isError()) {%> <font color=red><%} %>
<%=v.getMessage()%>
<%if (v.isError()) {%> </font color=red><%} %>