<%@page import="com.ateam.webstore.ui.views.*"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<%@page import="com.ateam.webstore.model.Address"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%View v = (View) request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW); 
Address a = null;
boolean embedded = false;
if (v != null && v instanceof AddressView) {
	a = ((AddressView) v).getAddress();	
}
else if (v != null && v instanceof OrderShippingView) {
	a = ((OrderShippingView) v).getAddress();	
}
else if (v != null && v instanceof OrderPaymentView) {
	a = ((OrderPaymentView) v).getAddress();
	embedded = true;
}
if (a == null)  {
	a = new Address("", "", "", "", false, null);
}

%>

<% if (! embedded) {  %>
<form method="post" action="<%=request.getContextPath()%>/store">
					<input type="hidden" name=<%=Constants.Parameters.FORM_ID.getId()%> 
						value="<%=Constants.FormName.ADDRESS.getId()%>">
					<input type="hidden" name=<%=Constants.Parameters.CONTEXT.getId()%> 
						value="<%=v.getContext()%>">

<%} %>
	<h3>Address</h3>
	<!--  <input type="checkbox"> Use shipping address -->

	<%if (!embedded && v.getMessage() != null) { %><%=v.getMessage() %><br><% } %>

	<table>
	<% if (! embedded) {  %>
		<tr>
				<td>Name:</td>
				<td><input type="text" name="name" value=""></td>
		</tr>
	<% }  %>
		<tr>
				<td>Address Line 1:</td>
				<td><input type="text" name="<%=Constants.Parameters.ADDRESS_1.getId()%>" value="<%=a.getStreetAddress1()%>"></td>
		</tr>
		<tr>
				<td>Address Line 2:</td>
				<td><input type="text" name="<%=Constants.Parameters.ADDRESS_2.getId()%>" value="<%=a.getStreetAddress2()%>"></td>
		</tr>
		<tr>
				<td>City:</td>
				<td><input type="text" name="<%=Constants.Parameters.CITY.getId()%>" value="<%=a.getCity()%>"></td>
		</tr>
		<tr>
				<td>State</td>
				<td><select name="<%=Constants.Parameters.STATE.getId()%>">
				<option value="NY">NY</option>
				<option value="NJ">NJ</option>
				<option value="CT">CT</option>
				</select></td>
		</tr>
		<tr>
				<td>Zip</td>
				<td><input type="text" name="<%=Constants.Parameters.ZIP.getId()%>" value="<%=a.getZip()%>"></td>
		</tr>

	</table>
<% if (! embedded) {  %>
		<input type="submit" value="Add">
		</form>
<%}%>