<%@page import="com.ateam.webstore.ui.views.ContentView"%>
<%@page import="com.ateam.webstore.ui.views.*"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<%@page import="com.ateam.webstore.model.CreditCard"%>
<%@page import="com.ateam.webstore.ui.views.CreditCardListView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%CreditCardListView v = (CreditCardListView) request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW); 
int i;
int count = v.getCreditcard().size();

%>

			
			<h3>Edit or Delete a Payment Method </h3>
			<table>
			<%  for (i = 0; i < count; i++) { %>

				<tr>
						<td>Name on Card:</td>
						<td><%= v.getCreditcard().get(i).getNameOnCard() %></td>
						<td><input type="button" value="Delete"> &nbsp&nbsp
						<input type="button" value="Edit"></td>
				</tr>
		
				<tr>
						<td>Account Number:</td>
						<td><%= v.getCreditcard().get(i).getCardNmber() %></td>
				</tr>
				<tr>
						<td>Expiration:</td>
						<td><%= v.getCreditcard().get(i).getExpMonth()%>/<%= v.getCreditcard().get(i).getExpYear() %></td>
				</tr>
				<tr>
						<td>Billing address</td>
						<td><%= v.getCreditcard().get(i).getBillingAddress().getStreetAddress1() %><br>
						<%= v.getCreditcard().get(i).getBillingAddress().getStreetAddress2() %><br>
						<%= v.getCreditcard().get(i).getBillingAddress().getCity() %><br>
						<%= v.getCreditcard().get(i).getBillingAddress().getState() %>
						<%= v.getCreditcard().get(i).getBillingAddress().getZip() %>
						</td>
				</tr>
				<%  } %>

			</table>
			
	
	