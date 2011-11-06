<%@page import="com.ateam.webstore.ui.views.ContentView"%>
<%@page import="com.ateam.webstore.ui.views.*"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<%@page import="com.ateam.webstore.model.Employee"%>
<%@page import="com.ateam.webstore.ui.views.AdminEmployeeListView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%AdminEmployeeListView v = (AdminEmployeeListView) request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW); 

%>

<h3><%=v.getListTitle()%></h3>
<table border="1">
	<tr>
			<th> Employee ID</th>
			<th> Person ID</th>
			<th>Full Name</th>
			<th> DOB</th>
			<th> Job Title</th>
			<th> Department Code</th>
	<tr>
	<%  for (Employee p : v.getEmployee()) { %>

	<tr>
		<td><%=p.getId()%></td>
		<td><%=p.getPerson()%></td>
		<td><%=p.getFirstName()%>,<%=p.getMiddleName()%>,<%=p.getLastName()%></td>
		<td><%=p.getDob()%></td>
		<td><%=p.getJobTitle()%></td>
		<td><%=p.getDepartmentCode()%></td>
		

	</tr>
	<%  } %>

</table>
<br><input type="button" value="Search employee">

