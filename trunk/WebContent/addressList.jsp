<%@page import="com.ateam.webstore.ui.views.ContentView"%>
<%@page import="com.ateam.webstore.ui.views.*"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<%@page import="com.ateam.webstore.model.Address"%>
<%@page import="com.ateam.webstore.ui.views.AddressListView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%AddressListView v = (AddressListView) request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW); %>

			
			<h3>Edit or Delete an address</h3>
			<table>
			<%  for (Address addr : v.getAddress()) { %>

				<tr>
						<td><%= addr.getStreetAddress1() %>
						<br> <%= addr.getStreetAddress2() %>
						<br><%= addr.getCity() %>
						<br> <%= addr.getState() %><%= addr.getZip() %></td>
						<td><input type="button" value="Delete"> &nbsp&nbsp
						<input type="button" value="Edit"></td>
				</tr>
		
				<%  } %>

			</table>
			
	
	