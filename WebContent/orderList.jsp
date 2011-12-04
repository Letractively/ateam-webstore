<%@page import="com.ateam.webstore.ui.views.ContentView"%>
<%@page import="com.ateam.webstore.ui.views.*"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<%@page import="com.ateam.webstore.model.Orders"%>
<%@page import="com.ateam.webstore.ui.views.OrderListView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%OrderListView v = (OrderListView) request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW); 

%>
<table>
	<tr>
			<th>Order ID</th>
			<%if (v.getServletPath().equals("admin")) {%>
			<th>Customer</th>
			<%} %>
			<th>Items</th>
			<th>Time Placed</th>
			<th>Status</th>
	<tr>
	<%  for (Orders p : v.getOrders()) { %>

	<tr>
		<td><a href="<%=request.getContextPath()%>/<%=v.getServletPath()%>?order=<%=p.getId()%>"><%=p.getId()%></td>
		<%if (v.getServletPath().equals("admin")) {%>
		<td><%=p.getCustomer().getLastName()%>, <%=p.getCustomer().getFirstName()%></td>
		<%} %>
		<td><%=p.getNumOfItems()%></td>
		<td><%=p.getTimePlaced()%></td>
		<td><%=p.getStatus()%></td>
	</tr>
	<%  } %>

</table>

