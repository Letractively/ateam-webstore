<%@page import="com.ateam.webstore.model.Product"%>
<%@page import="java.util.Collection"%>
<%@page import="com.ateam.webstore.ui.views.*"%>
<%@page import="com.ateam.webstore.servlets.AteamContextListener"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%View v = (View) request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW);
%> 

<%if (v.getMessage() != null) { %><%=v.getMessage() %><br><% } %>

<% if (v.getVisitor().getEmployee().hasRole(102) || v.getVisitor().getEmployee().hasRole(105) || v.getVisitor().getEmployee().hasRole(106)) {%>
	<li><a href="<%=request.getContextPath()%>/<%=v.getServletPath()%>?products">Product Management</a></li>
<%} %>
<% if (v.getVisitor().getEmployee().hasRole(102) || v.getVisitor().getEmployee().hasRole(108)) {%>
	<li><a href="<%=request.getContextPath()%>/<%=v.getServletPath()%>?orders">Order Management</a></li>
<%} %>
<% if (v.getVisitor().getEmployee().hasRole(102)) {%>
	<li><a href="<%=request.getContextPath()%>/<%=v.getServletPath()%>?employees">Employee Management</a></li>
<%} %>
<% if (v.getVisitor().getEmployee().hasRole(-1)) {%>
	<li><a href="<%=request.getContextPath()%>/<%=v.getServletPath()%>?db">Database Management</a></li>
<%} %>


