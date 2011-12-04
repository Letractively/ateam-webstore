<%@page import="com.ateam.webstore.ui.views.ContentView"%>
<%@page import="com.ateam.webstore.ui.views.*"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<%@page import="com.ateam.webstore.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%AdminEmployeeDetailsView v = (AdminEmployeeDetailsView) request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW); %>

<%if (v.getMessage() != null) { %><%=v.getMessage() %><br><% } %>

			<form method="post" action="<%=request.getContextPath()%>/admin">
					<input type="hidden" name=<%=Constants.Parameters.FORM_ID.getId()%> 
						value="<%=Constants.FormName.DELETE_EMPLOYEE.getId()%>">
											<input type="hidden" name=<%=Constants.Parameters.EMPLOYEE.getId()%> 
						value="<%=v.getEmployee().getId()%>">
						

			<table>
				<tr><td>ID</td><td><%=v.getEmployee().getId()%></td></tr>
				<tr><td>Name</td><td><%=v.getEmployee().getFullName()%></td></tr>
				<tr><td>Added</td><td><%=v.getEmployee().getDateOfHire()%></td></tr>
				<tr><td>Role</td><td>
				<% for (String r : v.getRoles()) { %>
					<%=v.getRoles()%>&nbsp
				<%} %>
				</td></tr>
			</table>
                    <input type="submit" name="submit" value="Delete">
            </form>