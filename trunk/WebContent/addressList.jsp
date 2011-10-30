<%@page import="com.ateam.webstore.ui.views.ContentView"%>
<%@page import="com.ateam.webstore.ui.views.*"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<%@page import="com.ateam.webstore.model.Address"%>
<%@page import="com.ateam.webstore.ui.views.AddressListView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%AddressListView v = (AddressListView) request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW); 
int i;
int count = v.getAddress().size();

%>

			
			<h3>Edit or Delete an address</h3>
			<table>
			<%  for (i = 0; i < count; i++) { %>

				<tr>
						<td><%= v.getAddress().get(i).getStreetAddress1() %>
						<br> <%= v.getAddress().get(i).getStreetAddress2() %>
						<br><%= v.getAddress().get(i).getCity() %>
						<br> <%= v.getAddress().get(i).getState() %><%= v.getAddress().get(i).getZip() %></td>
						<td><input type="button" value="Delete"> &nbsp&nbsp
						<input type="button" value="Edit"></td>
				</tr>
		
				<%  } %>

			</table>
			
	
	