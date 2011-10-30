<%@page import="com.ateam.webstore.ui.views.ContentView"%>
<%@page import="com.ateam.webstore.ui.views.*"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<%@page import="com.ateam.webstore.model.Product"%>
<%@page import="com.ateam.webstore.ui.views.ProductListView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%ProductListView v = (ProductListView) request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW); 
int i;
int count = v.getProduct().size();

%>


<h3>Products List</h3>
<table>
	<%  for (i = 0; i < count; i++) { %>

	<tr>
		<td><%= v.getProduct().get(i).getImagePath() %></td>
		<td><%= v.getProduct().get(i).getProductName() %></td>
		<td><%= v.getProduct().get(i).getPrice() %></td>
		<td><%= v.getProduct().get(i).getSaleInd() %></td>

	</tr>
	<%  } %>

</table>

