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
				<td><input type="text" name="<%=Constants.Parameters.ADDRESS_2.getId()%>" 
					<% if (a.getStreetAddress2() != null) {%>value="<%=a.getStreetAddress2()%>"<%}%>></td>
		</tr>
		<tr>
				<td>City:</td>
				<td><input type="text" name="<%=Constants.Parameters.CITY.getId()%>" value="<%=a.getCity()%>"></td>
		</tr>
		<tr>
				<td>State</td>
				<td><select name="<%=Constants.Parameters.STATE.getId()%>">
				<option value="AL">AL</option>
				<option value="AK">AK</option>
				<option value="AZ">AZ</option>
				<option value="AR">AR</option>
				<option value="CA">CA</option>
				<option value="CO">CO</option>
				<option value="CT">CT</option>
				<option value="DE">DE</option>
				<option value="DC">DC</option>
				<option value="FL">FL</option>
				<option value="GA">GA</option>
				<option value="HI">HI</option>
				<option value="ID">ID</option>
				<option value="IL">IL</option>
				<option value="IN">IN</option>
				<option value="IA">IA</option>
				<option value="KA">KA</option>
				<option value="KY">KY</option>
				<option value="LA">LA</option>
				<option value="ME">ME</option>
				<option value="MD">MD</option>
				<option value="MA">MA</option>
				<option value="MI">MI</option>
				<option value="MN">MN</option>
				<option value="MS">MS</option>
				<option value="MO">MO</option>
				<option value="MT">MT</option>
				<option value="NE">NE</option>
				<option value="NV">NV</option>
				<option value="NH">NH</option>
				<option value="NY">NY</option>
				<option value="NC">NN</option>
				<option value="ND">ND</option>
				<option value="OH">OH</option>
				<option value="OR">OR</option>
				<option value="PA">PA</option>
				<option value="RI">RI</option>
				<option value="SC">SC</option>
				<option value="SD">SD</option>
				<option value="TN">TN</option>
				<option value="TX">TX</option>
				<option value="UT">UT</option>
				<option value="VA">VA</option>
				<option value="VT">VT</option>
				<option value="WA">WA</option>
				<option value="WV">WV</option>
				<option value="WI">WI</option>
				<option value="WY">WY</option>
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