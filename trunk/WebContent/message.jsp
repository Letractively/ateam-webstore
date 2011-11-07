<%@page import="com.ateam.webstore.ui.views.ContentView"%>
<%@page import="com.ateam.webstore.ui.views.*"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%MessageView v = (MessageView) request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW); %>


<%=v.getMessage()%>