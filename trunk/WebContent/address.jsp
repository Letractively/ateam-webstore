<%@page import="com.ateam.webstore.ui.views.ContentView"%>
<%@page import="com.ateam.webstore.ui.views.*"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<%@page import="com.ateam.webstore.model.Address"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%View v = (View) request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW); 
Address a;
if (v != null && v instanceof AddressView) {
	a = ((AddressView) v).getAddress();	
}
else {
	a = new Address("", "", "", "", false, null);
}

%>

<form method="post" action="<%=request.getContextPath()%>/store">
					<input type="hidden" name=<%=Constants.Parameters.FORM_ID.getId()%> 
						value="<%=Constants.FormName.ADDRESS.getId()%>">


	<h3>Address</h3>
	<input type="checkbox"> Use shipping address

	<table>
		<tr>
				<td>Name:</td>
				<td><input type="text" name="name" value=""></td>
		</tr>

		<tr>
				<td>Address Line 1:</td>
				<td><input type="text" name="addressLine1" value="<%=a.getStreetAddress1()%>"></td>
		</tr>
		<tr>
				<td>Address Line 2:</td>
				<td><input type="text" name="addressLine2" value="<%=a.getStreetAddress2()%>"></td>
		</tr>
		<tr>
				<td>City:</td>
				<td><input type="text" name="city" value="<%=a.getCity()%>"></td>
		</tr>
		<tr>
				<td>State</td>
				<td><select>
				<option>NY</option>
				<option>NJ</option>
				<option>CT</option>
				</select></td>
		</tr>
		<tr>
				<td>Zip</td>
				<td><input type="text" name="zip" value="<%=a.getZip()%>"></td>
		</tr>

	</table>

		<input type="submit" value="Add">
		</form>