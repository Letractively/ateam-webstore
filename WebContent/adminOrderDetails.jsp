<%@page import="com.ateam.webstore.ui.views.ContentView"%>
<%@page import="com.ateam.webstore.ui.views.*"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<%@page import="com.ateam.webstore.model.Orders"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%OrderDetailsView v = (OrderDetailsView) request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW); 
Orders o = v.getOrder();
%>

			<form method="post" action="<%=request.getContextPath()%>/admin">
					<input type="hidden" name=<%=Constants.Parameters.FORM_ID.getId()%> 
						value="<%=Constants.FormName.ORDER_UPDATE.getId()%>">

			


				<table width="100%">
					<tr>
							<td><h3>Shipping Details:</h3>
							<br>
							<%=o.getAddress().getStreetAddress1() %><br>
							<%=o.getAddress().getStreetAddress2() %><br>
							<%=o.getAddress().getCity()%> <%=o.getAddress().getState()%> <%=o.getAddress().getZip()%><br>
							</td>
							<td><h3>Payment Details</h3>
							<%=o.getCreditCard().getCardNumber()%><br>
							Billing: <%=o.getCreditCard().getBillingAddress()%>
							</td>
							<td></td>
					</tr>
			
				</table>
				<br><br>
				<table width="100%">
					<tr>
							<td><b>Item</b></td>
							<td><b>Description</b></td>
							<td><b>Qty</b></td>
							<td><b>Price</b></td>
					</tr>
			
					<tr>
							<td>Widget</td>
							<td>A Widget</td>
							<td>2</td>
							<td>$12.99</td>
					</tr>
			
			
					<tr>
							<td></td>
							<td></td>
							<td>SubTotal</td>
							<td>$120.99</td>
					</tr>
			
					<tr>
							<td></td>
							<td></td>
							<td>Tax (NY)</td>
							<td>$120.99</td>
					</tr>
			
					<tr>
							<td></td>
							<td></td>
							<td>Shipping</td>
							<td>$120.99</td>
					</tr>
			
					<tr>
							<td></td>
							<td></td>
							<td>Grand Total</td>
							<td>$120.99</td>
					</tr>
			
				</table>	


				<input type="submit" value="Update Order">

			</form>
			
				<form method="post" action="<%=request.getContextPath()%>/admin">
					<input type="hidden" name=<%=Constants.Parameters.ORDER_ID.getId()%> 
						value="<%=Constants.FormName.ORDER_CANCEL.getId()%>">
						<input type="submit" value="Cancel Order">
						</form>
			