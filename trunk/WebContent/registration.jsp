<%@page import="com.ateam.webstore.ui.views.ContentView"%>
<%@page import="com.ateam.webstore.ui.views.*"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<%@page import="com.ateam.webstore.model.SecurityQuestion"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%RegistrationView v = (RegistrationView) request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW); %>

			<form method="post" action="<%=request.getContextPath()%>/registrationHandler">
					<input type="hidden" name=<%=Constants.Parameters.FORM_ID.getId()%> 
						value="<%=Constants.FormName.REGISTER.getId()%>">
						Email:<br>
					<input type="text" name="<%=Constants.Parameters.EMAIL.getId() %>" ><br><br>
						Password:<br>
					<input type="password" name="<%=Constants.Parameters.PASSWORD.getId()%>"><br><br>
					Confirm Password:<br>
					<input type="password" name="<%=Constants.Parameters.CONFIRMPASSWORD.getId()%>"><br><br>
					Security Question:<br>
					<select name="<%=Constants.Parameters.SECURITY_QUESTION.getId()%>">
					<%for(SecurityQuestion s : v.getSecurityQuestions()){%>
					<option value= "<%=s.getId() %>"><%=s.getQuestion() %>> </option> <% } %>
					 
					</select>
					Hint:<br>
					<input type="text" name="<%=Constants.Parameters.SECURITY_ANSWER.getId()%>"><br><br>
					<input type="submit" name="submit" value="Login">
			</form>