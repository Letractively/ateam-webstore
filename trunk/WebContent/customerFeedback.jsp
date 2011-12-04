<%@page import="com.ateam.webstore.ui.views.ContentView"%>
<%@page import="com.ateam.webstore.ui.views.*"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%View v = (View) request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW); %>

<%if (v.getMessage() != null) { %><%=v.getMessage() %><br><% } %>

			<form method="post" action="<%=request.getContextPath()%>/<%=v.getServletPath()%>">
					<b>Please do enter your comments:</b><br>
					<!-- <input type="text" name="<%=Constants.Parameters.MESSAGE%>"><br><br> -->
					<textarea name="<%=Constants.Parameters.MESSAGE%>" rows="15" cols="45"></textarea><br><br>
					<input type="submit" name="submit" value="Send Feedback">
			</form>