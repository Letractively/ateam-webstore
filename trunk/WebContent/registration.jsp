<%@page import="com.ateam.webstore.ui.views.ContentView"%>
<%@page import="com.ateam.webstore.ui.views.*"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<%@page import="com.ateam.webstore.model.SecurityQuestion"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%RegistrationView v = (RegistrationView) request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW); %>

			<form method="post" action="<%=request.getContextPath()%>/store">
					<input type="hidden" name=<%=Constants.Parameters.FORM_ID.getId()%> 
						value="<%=Constants.FormName.REGISTER.getId()%>">
<table>						
<tr>
<td><font size="2" >Email:</font></td><td>
					<input type="text" name="<%=Constants.Parameters.EMAIL.getId() %>" name="username" size="25"/></td>
					</tr>
<tr>
<td><font size="2" >Password:</font></td><td><input type="password" name="<%=Constants.Parameters.PASSWORD.getId()%>" size="26" /></td>
</tr>
<tr>
<td><font size="2" >Confirm Password:</font></td><td><input type="password" name="<%=Constants.Parameters.CONFIRMPASSWORD.getId()%>" size="26" /></td>
</tr>
<tr>
<td><font size="2" >Security Question:</font></td><td><select  name="<%=Constants.Parameters.SECURITY_QUESTION.getId()%>" size="1" >
					<%for(SecurityQuestion s : v.getSecurityQuestions()){%>
					<option  value= "<%=s.getId() %>"><%=s.getQuestion() %> </option> <% } %></select></td>
					<tr>
<td><font size="2" >Hint:</font></td><td><input type="text" name="<%=Constants.Parameters.SECURITY_ANSWER.getId()%>" size="25" /></td>
</tr>
<tr>	
   <td></td><td>	<input type="submit" name="submit" value="Reset"></td><td>	<input type="submit" name="submit" value="Login"></td><td></td>
</tr>
</table>
			</form>