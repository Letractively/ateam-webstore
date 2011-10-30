<%@page import="com.ateam.webstore.ui.views.ContentView"%>
<%@page import="com.ateam.webstore.ui.views.*"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<%@page import="com.ateam.webstore.model.Product"%>
<%@page import="com.ateam.webstore.ui.views.ProductDetailsView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%ProductDetailsView v = (ProductDetailsView) request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW); 
Product p=v.getProduct();
%>	
<h3>Product Details</h3>
			<table>
				<tr>
						<td><%=p.getImagePath() %></td>
						<td><%=p.getProductName() %>
						<br>by Samsumg
						<br><%=p.getPrice() %>
						<br><%=p.getSaleInd() %> </td>
						<td><input type="button" value="Add to cart">
						<br>or<br><input type="button" value="Add to wishlist"></td>
				</tr>
				
				<tr>
						<td>Product Description
						<br><%= p.getDescription() %></td>
						
		
				</table>