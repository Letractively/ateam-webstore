<%@page import="com.ateam.webstore.ui.views.ContentView"%>
<%@page import="com.ateam.webstore.ui.views.*"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%View v = (View) request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW); %>

<%if (v.getMessage() != null) { %><%=v.getMessage() %><br><% } %>

			<form method="post" action="<%=request.getContextPath()%>/<%=v.getServletPath()%>">
					<input type="hidden" name=<%=Constants.Parameters.FORM_ID.getId()%> 
						value="<%=Constants.FormName.LOGIN.getId()%>">
					<%if (v.getLoginRedirectPath() != null) {%>
					<input type="hidden" name=<%=Constants.Parameters.REDIRECT.getId()%> 
						value="<%=v.getLoginRedirectPath()%>">
					<%} %>
						Email:<br>
					<input type="text" name="<%=Constants.Parameters.EMAIL.getId()%>" value="<%=v.getVisitor().getEmail()%>"><br><br>
						Password:<br>
					<input type="password" name="<%=Constants.Parameters.PASSWORD.getId()%>"><br>
					<a href="<%=request.getContextPath()%>/store?register">Register</a>    <a href="<%=request.getContextPath()%>/store?forgot">Forgot Password?</a>
					<br><br>
					<input type="checkbox" name="<%=Constants.Parameters.REMEMBER_ME.getId()%>">Remember Me<br><br>
					<input type="submit" name="submit" value="Login">
			</form>