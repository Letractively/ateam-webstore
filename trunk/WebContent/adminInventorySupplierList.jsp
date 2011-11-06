<%@page import="com.ateam.webstore.ui.views.ContentView"%>
<%@page import="com.ateam.webstore.ui.views.*"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<%@page import="com.ateam.webstore.model.Product"%>
<%@page import="com.ateam.webstore.ui.views.ProductListView"%>
<%@page import="com.ateam.webstore.model.Vendor"%>
<%@page import="com.ateam.webstore.ui.views.InventorySupplierListView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%ProductListView v = (ProductListView) request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW); %>
<%InventorySupplierListView s = (InventorySupplierListView) request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW); %>
<h3><%=v.getListTitle()%></h3>
<table border="1">
	<tr>
			<th> Inventory ID</th>
			<th> Inventory Name</th>
			<th> Model#</th>
			<th> Vendor ID</th>
			<th> In stock</th>
	<tr>
	<%  for (Product p : v.getProducts()) { %>

	<tr>
		<td><%=p.getId()%></td>
		<td><%=p.getProductName()%></td>
		<td><%=p.getModelNumber()%></td>
		<td><%=p.getSKU()%></td>
		<td><%=p.getQtyOnHand()%></td>
				

	</tr>
	<%  } %>

</table>
<br><input type="button" value="Search Inventory">

<h3><%=s.getListTitle()%></h3>
<table border="1">
	<tr>
			<th> vendor ID</th>
			<th> vendor Name</th>
			<th> Address</th>
			<th> last Order Date</th>
	<tr>
	<%  for (Vendor V : s.getVendor()) { %>

	<tr>
		<td><%=V.getId()%></td>
		<td><%=V.getName()%></td>
		<td><%=V.getStreetAddress1()%>,<%=V.getStreetAddress2()%>,<%=V.getCity()%>,<%=V.getState()%>,<%=V.getZip()%></td>
		<td><%=V.getLastOrderDate()%></td>
			

	</tr>
	<%  } %>

</table>
<br><input type="button" value="Search Vendor">

