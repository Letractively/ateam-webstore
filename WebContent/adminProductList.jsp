<%@page import="com.ateam.webstore.ui.views.ContentView"%>
<%@page import="com.ateam.webstore.ui.views.*"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<%@page import="com.ateam.webstore.model.Product"%>
<%@page import="com.ateam.webstore.ui.views.ProductListView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%ProductListView v = (ProductListView) request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW); 

%>
<table>
	<tr>
			<th> Product ID</th>
			<th> Product Name</th>
			<th> Price</th>
			<th> Model#</th>
			<th> SKU</th>
			<th>Quantity</th>
			<th> Discount</th>
	<tr>
	<%  for (Product p : v.getProducts()) { %>

	<tr>
		<td><a href="<%=request.getContextPath()%>/<%=v.getServletPath()%>?product=<%=p.getId()%>"><%=p.getId()%></a></td>
		<td><%=p.getProductName()%></td>
		<td><%=p.getPrice()%></td>
		<td><%=p.getModelNumber()%></td>
		<td><%=p.getSKU()%></td>
		<td><%=p.getQtyOnHand()%></td>
		<td><%=p.getPercentDiscount()%></td>
		

	</tr>
	<%  } %>

</table>
<br><input type="button" value="Edit">
