<%@page import="com.ateam.webstore.ui.views.ContentView"%>
<%@page import="com.ateam.webstore.ui.views.*"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<%@page import="com.ateam.webstore.model.Product"%>
<%@page import="com.ateam.webstore.ui.views.ProductListView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%ProductListView v = (ProductListView) request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW); 

%>

<h3><%=v.getListTitle()%></h3>
<table border="1">
	<tr>
			<th> Product ID</th>
			<th> Product Name</th>
			<th> Description</th>
			<th> Price</th>
			<th> Model#</th>
			<th> SKU</th>
			<th>Quantity</th>
			<th> Discount</th>
	<tr>
	<%  for (Product p : v.getProducts()) { %>

	<tr>
		<td><%=p.getId()%></td>
		<td><%=p.getProductName()%></td>
		<td><%=p.getDescription()%></td>
		<td><%=p.getPrice()%></td>
		<td><%=p.getModelNumber()%></td>
		<td><%=p.getSKU()%></td>
		<td><%=p.getQtyOnHand()%></td>
		<td><%=p.getPercentDiscount()%></td>
		

	</tr>
	<%  } %>

</table>
<br><input type="button" value="Edit">
