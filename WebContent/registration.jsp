<%@page import="com.ateam.webstore.ui.views.ContentView"%>
<%@page import="com.ateam.webstore.ui.views.RegistrationView"%>
<%@page import="com.ateam.webstore.ui.forms.RegistrationForm"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<%@page import="com.ateam.webstore.model.SecurityQuestion"%>
<%@page import="com.ateam.webstore.model.Role"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%RegistrationView v = (RegistrationView) request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW); 
RegistrationForm f = v.getForm();
if (f == null) {
	f = new RegistrationForm();
}
%>

<%if (v.getMessage() != null) { %><%=v.getMessage() %><br><% } %>

			<form method="post" action="<%=request.getContextPath()%>/<%=v.getServletPath()%>">
					<input type="hidden" name=<%=Constants.Parameters.FORM_ID.getId()%> 
						value="<%=Constants.FormName.REGISTER.getId()%>">
<table>						
<tr>
		<td><font size="2" >First Name:</font></td><td>
		<input type="text" name="<%=Constants.Parameters.FIRST_NAME.getId() %>" value="<%=f.getFirstName()%>" size="25"/></td>
</tr>
<tr>
		<td><font size="2" >Last Name:</font></td><td>
		<input type="text" name="<%=Constants.Parameters.LAST_NAME.getId() %>" value="<%=f.getLastName()%>" size="25"/></td>
</tr>
<tr>
		<td><font size="2" >Email:</font></td><td>
		<input type="text" name="<%=Constants.Parameters.EMAIL.getId() %>" value="<%=f.getEmail()%>" size="25"/></td>
</tr>
<tr>
<td><font size="2" >Password:</font></td><td><input type="password" name="<%=Constants.Parameters.PASSWORD.getId()%>" size="26" /></td>
</tr>
<tr>
<td><font size="2" >Confirm Password:</font></td><td><input type="password" name="<%=Constants.Parameters.CONFIRMPASSWORD.getId()%>" size="26" /></td>
</tr>
<tr>
<%if (v.isAdmin()) {%>
<td><font size="2" >Role:</font></td><td><select  name="<%=Constants.Parameters.ROLE.getId()%>" size="1" >
					<%for(Role s : v.getRoles()){ String code = s.getCode()+"";%>
					<option  value= "<%=s.getCode() %>" <%if (code.equals(f.getRoleId())) {out.print("SELECTED");} %>><%=s.getDescription() %> </option> <% } %></select>
</td>
<%} else { %>
<td><font size="2" >Security Question:</font></td><td><select  name="<%=Constants.Parameters.SECURITY_QUESTION.getId()%>" size="1" >
					<%for(SecurityQuestion s : v.getSecurityQuestions()){%>
					<option  value= "<%=s.getId() %>" <%if (s.getId().toString().equals(f.getSecurityQuestionId())) {out.print("SELECTED");} %>><%=s.getQuestion() %> </option> <% } %></select>
</td>
<%} %>
<%if (!v.isAdmin()) {%>
<tr>
<td><font size="2" >Answer:</font></td><td><input type="text" name="<%=Constants.Parameters.SECURITY_ANSWER.getId()%>" value="<%=f.getSecurityAnswer()%>" size="25" /></td>
</tr>
<%} %>
<tr>
   <td></td><td></td><td>	<input type="submit" name="submit" value="Register"></td><td></td>
</tr>
</table>
			</form>