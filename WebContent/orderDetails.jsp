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

<%} %>


				<table width="100%">
					<tr>
							<td valign="top"><h3>Shipping Details:</h3>
							<%=o.getAddress().getStreetAddress1() %><br>
							<%=o.getAddress().getStreetAddress2() %><br>
							<%=o.getAddress().getCity()%> <%=o.getAddress().getState()%> <%=o.getAddress().getZip()%><br>
							</td>
							
							<td valign="top"><h3>Payment Details</h3>
							<%=o.getCreditCard().getObfusticatedCardInfo()%><br>
							Billing Address:<br>
							<%=o.getCreditCard().getBillingAddress().getStreetAddress1() %><br>
							<%=o.getCreditCard().getBillingAddress().getStreetAddress2() %><br>
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
							<td><%=item.getUnitPrice() %></td>
					</tr>
			
				<%} %>
					<tr>
							<td></td>
							<td><b>SubTotal</b></td>
							<td><%=o.getItemSubTotal() %></td>
					</tr>
			
					<tr>
							<td></td>
							<td><b>Tax</b></td>
							<td><%=o.getSalesTax()%></td>
					</tr>
			
					<tr>
							<td></td>
							<td><b>Shipping</b></td>
							<td><%=o.getShippingTotal() %></td>
					</tr>
			
					<tr>
							<td></td>
							<td><b>Grand Total</b></td>
							<td><%=o.getGrandTotal()%></td>
					</tr>
			
				</table>	

<% if (v.isOrderPreview()) {%>
				<input type="submit" value="Place Order">
				</form>
<%} %>
	