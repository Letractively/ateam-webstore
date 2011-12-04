<%@page import="com.ateam.webstore.utilities.Utilities"%>
<%@page import="com.ateam.webstore.ui.Constants.Parameters"%>
<%@page import="com.ateam.webstore.ui.views.ContentView"%>
<%@page import="com.ateam.webstore.ui.views.*"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<%@page import="com.ateam.webstore.model.Orders"%>
<%@page import="com.ateam.webstore.model.ItemsOrdered"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%OrderDetailsView v = (OrderDetailsView) request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW); 
Orders o = v.getOrder();
%>

<% if (v.isOrderPreview()) {%>
			<form method="post" action="<%=request.getContextPath()%>/store">
					<input type="hidden" name=<%=Constants.Parameters.FORM_ID.getId()%> 
						value="<%=Constants.FormName.ORDER_CONFIRM.getId()%>">

<%} else if (v.isAdmin()) {%>
			<form method="post" action="<%=request.getContextPath()%>/admin">
					<input type="hidden" name=<%=Constants.Parameters.FORM_ID.getId()%> 
						value="<%=Constants.FormName.ORDER_UPDATE.getId()%>">
					<input type="hidden" name=<%=Constants.Parameters.ORDER_ID.getId()%> 
						value="<%=o.getId()%>">

<%} %>


				<% if (!v.isOrderPreview()) {%><h3>Status: <%=o.getStatus()%></h3><%} %> 
				<% if (!v.isOrderPreview() && !v.isAdmin() && o.getTrackingNumber() != null) {%><h3>Tracking #: <%=o.getTrackingNumber()%></h3><%} %>

				<table width="100%">
					<tr>
							<td valign="top"><h3>Shipping Details:</h3>
							<%=o.getAddress().getStreetAddress1() %><br>
							<%=o.getAddress().getCity()%> <%=o.getAddress().getState()%> <%=o.getAddress().getZip()%><br>
							</td>
							
							<td valign="top"><h3>Payment Details</h3>
							<%=o.getCreditCard().getObfusticatedCardInfo()%><br>
							Billing Address:<br>
							<%=o.getCreditCard().getBillingAddress().getStreetAddress1() %><br>
							<%=o.getCreditCard().getBillingAddress().getCity()%> <%=o.getCreditCard().getBillingAddress().getState()%> <%=o.getCreditCard().getBillingAddress().getZip()%><br>
							
							</td>
							<td></td>
					</tr>
			
				</table>
				<br><br>
				<table width="100%">
					<tr>
							<td><b>Item</b></td>
							<td><b>Qty</b></td>
							<td><b>Price</b></td>
					</tr>
			
			
				<% if (v.getItems() != null) for (ItemsOrdered item : v.getItems()) { %>
					<tr>
							<td><%=item.getProduct().getShortProductName(40) %></td>
							<td><%=item.getItemQty() %></td>
							<td><%=Utilities.formatDouble(item.getUnitPrice())%></td>
					</tr>
			
				<%} %>
					<tr>
							<td></td>
							<td><b>SubTotal</b></td>
							<td><%=Utilities.formatDouble(o.getItemSubTotal())%></td>
					</tr>
			
					<tr>
							<td></td>
							<td><b>Tax</b></td>
							<td><%=Utilities.formatDouble(o.getSalesTax())%></td>
					</tr>
			
					<tr>
							<td></td>
							<td><b>Shipping</b></td>
							<td><%=Utilities.formatDouble(o.getShippingTotal())%></td>
					</tr>
			
					<tr>
							<td></td>
							<td><b>Grand Total</b></td>
							<td><%=Utilities.formatDouble(o.getGrandTotal())%></td>
					</tr>

<% if (v.isOrderPreview()) {%>
					<tr>
						<td><input type="submit" value="Go Back"></td><td><input type="submit" name="<%=Parameters.ORDER_CONFIRM.getId()%>" value="Cancel Order"></td><td><input type="submit" name="<%=Parameters.ORDER_CONFIRM.getId()%>" value="Place Order"></td>
					</tr>
<%} %>

<% if (v.isAdmin()) {%>

					<tr>
							<td></td>
							<td><b>Tracking #</b></td>
							<td><input type="text" name="<%=Constants.Parameters.TRACKING_NUMBER.getId() %>" <% if (o.getTrackingNumber() != null) {%>value="<%=o.getTrackingNumber()%>"<%}%>/></td>
					</tr>
					<% if (!o.isReturnInd()) {%>
					<tr>
						<td></td><td><input type="submit" name="<%=Parameters.ORDER_CONFIRM.getId()%>" value="Cancel Order"></td><td><input type="submit" name="<%=Parameters.ORDER_CONFIRM.getId()%>" value="Update Order"></td>
					</tr>
					<% } %>
<%} %>

				</table>	
<% if (v.isOrderPreview() || v.isAdmin()) {%>
			</form>
<%} %>
	