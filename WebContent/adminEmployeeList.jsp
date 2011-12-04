<%@page import="com.ateam.webstore.ui.views.ContentView"%>
<%@page import="com.ateam.webstore.ui.views.*"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<%@page import="com.ateam.webstore.model.Employee"%>
<%@page import="com.ateam.webstore.ui.views.AdminEmployeeListView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%AdminEmployeeListView v = (AdminEmployeeListView) request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW);

%>

<%if (v.getMessage() != null) { %><%=v.getMessage() %><br><% } %>

<br><a href="<%=request.getContextPath()%>/admin?addEmployee">Add Employee</a><br> 
<table>
    <tr>
            <th>Employee ID</th>
            <th>Name</th>
            <th>Roles</th>


    <tr>
    <%  for (Employee p : v.getEmployee()) { %>

    <tr>
        <td><a href="<%=request.getContextPath()%>/admin?<%=Constants.Parameters.EMPLOYEE.getId()%>=<%=p.getId()%>"><%=p.getId()%></a></td>
        <td><%=p.getFullName()%></td>
        <td><%=p.getJobTitle()%></td>
    </tr>
    <%  } %>

</table>
