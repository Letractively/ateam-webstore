<%@page import="com.ateam.webstore.ui.views.ContentView"%>
<%@page import="com.ateam.webstore.ui.views.*"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<%@page import="com.ateam.webstore.model.Orders"%>
<%@page import="com.ateam.webstore.ui.views.AdminOrderListView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%AdminOrderListView v = (AdminOrderListView) request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW); 

%>

<h3><%=v.getListTitle()%></h3>
<table border="1">
	<tr>
			<th> Order ID</th>
			<th> Customer</th>
			<th> Address</th>
			<th> Card Number</th>
			<th> Time Placed</th>
			<th> Time Shipped</th>
			<th> Tracking Number</th>
			<th> Transact Number</th>
	<tr>
	<%  for (Orders p : v.getOrder()) { %>

	<tr>
		<td><%=p.getId()%></td>
		<td><%=p.getCustomer().getFirstName()%>,<%=p.getCustomer().getLastName()%></td>
		<td><%=p.getAddress().getStreetAddress1()%>,<%=p.getAddress().getZip()%></td>
		<td><%=p.getCreditCard().getCardNmber()%></td>
		<td><%=p.getTimePlaced()%></td>
		<td><%=p.getTimeShipped()%></td>
		<td><%=p.getTrackingNumber()%></td>
		<td><%=p.getTransactNumber()%></td>
		

	</tr>
	<%  } %>

</table>
<br><input type="button" value="Search order">
