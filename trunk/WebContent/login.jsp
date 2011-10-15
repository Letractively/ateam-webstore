<%@page import="com.ateam.webstore.ui.views.ContentView"%>
<%@page import="com.ateam.webstore.ui.views.*"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%View v = (View) request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW); %>

			<form method="post" action="<%=request.getContextPath()%>/handler">
					<input type="hidden" name=<%=Constants.Parameters.FORM_ID.getId()%> 
						value="<%=Constants.FormName.LOGIN.getId()%>">
						Email:<br>
					<input type="text" name="email" value="<%=v.getVisitor().getEmail()%>"><br><br>
						Password:<br>
					<input type="password" name="password"><br><br>
					<input type="checkbox" name="rememberMe">Remember Me<br><br>
					<input type="submit" name="submit" value="Login">
			</form>