<%@page import="com.ateam.webstore.ui.views.ContentView"%>
<%@page import="com.ateam.webstore.ui.views.*"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<%@page import="com.ateam.webstore.model.CreditCard"%>
<%@page import="com.ateam.webstore.ui.views.CreditCardListView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%CreditCardListView v = (CreditCardListView) request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW);%>

			
			<h3>Edit or Delete a Payment Method </h3>
			<table>
			<%  for (CreditCard ccard : v.getCreditcard() ) { %>

				<tr>
						<td>Name on Card:</td>
						<td><%= ccard.getNameOnCard() %></td>
						<td><input type="button" value="Delete"> &nbsp&nbsp
						<input type="button" value="Edit"></td>
				</tr>
		
				<tr>
						<td>Account Number:</td>
						<td><%= ccard.getCardNmber() %></td>
				</tr>
				<tr>
						<td>Expiration:</td>
						<td><%= ccard.getExpMonth()%>/<%= ccard.getExpYear() %></td>
				</tr>
				<tr>
						<td>Billing address</td>
						<td><%= ccard.getBillingAddress().getStreetAddress1() %><br>
						<%= ccard.getBillingAddress().getStreetAddress2() %><br>
						<%= ccard.getBillingAddress().getCity() %><br>
						<%= ccard.getBillingAddress().getState() %>
						<%= ccard.getBillingAddress().getZip() %>
						</td>
				</tr>
				<%  } %>

			</table>
			
	
	