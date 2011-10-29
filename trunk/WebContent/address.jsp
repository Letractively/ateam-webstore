<%@page import="com.ateam.webstore.ui.views.ContentView"%>
<%@page import="com.ateam.webstore.ui.views.*"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<%@page import="com.ateam.webstore.model.CreditCard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%Object v = request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW); 
//if (v instanceof EditAddressView) {
//	CreditCard cc = (CreditCard) v;
//}

%>


	<h3>?Address</h3>
	<input type="checkbox"> ?Use shipping address

	<table>
		<tr>
				<td>Name:</td>
				<td><input type="text"></td>
		</tr>

		<tr>
				<td>Address Line 1:</td>
				<td><input type="text"></td>
		</tr>
		<tr>
				<td>Address Line 1:</td>
				<td><input type="text"></td>
		</tr>
		<tr>
				<td>City:</td>
				<td><input type="text"></td>
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
				<td><input type="text"></td>
		</tr>

	</table>

		<input type="submit" value="Add">