<%@page import="com.ateam.webstore.ui.views.ContentView"%>
<%@page import="com.ateam.webstore.ui.views.*"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%View v = (View) request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW); %>

<%if (v.getMessage() != null) { %><%=v.getMessage() %><br><% } %>

			<form method="post" action="<%=request.getContextPath()%>/<%=v.getServletPath()%>">
					<input type="hidden" name=<%=Constants.Parameters.FORM_ID.getId()%> 
						value="<%=Constants.FormName.CUSTOMER_FEEDBACK.getId()%>">
			
					<b>Please enter your comments:</b><br>
					<textarea name="<%=Constants.Parameters.MESSAGE.getId()%>" rows="15" cols="45"></textarea><br><br>
					<input type="submit" name="submit" value="Send Feedback">
			</form>