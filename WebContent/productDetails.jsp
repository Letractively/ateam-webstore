<%@page import="com.ateam.webstore.ui.views.ContentView"%>
<%@page import="com.ateam.webstore.ui.views.*"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<%@page import="com.ateam.webstore.model.Product"%>
<%@page import="com.ateam.webstore.ui.views.ProductDetailsView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<%ProductDetailsView v = (ProductDetailsView) request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW); 
Product p=v.getProduct();
%>	
<h3>Product Details</h3>
			<table>
				<tr>
						<td><%=p.getImagePath() %></td>
						<td><%=p.getProductName() %>
						<br>
						<br><%=p.getPrice() %>
						<br><%=p.getSaleInd() %> </td>
						<td>
							<form method="post" action="<%=request.getContextPath()%>/store">
							<input type="hidden" name=<%=Constants.Parameters.FORM_ID.getId()%> value="<%=Constants.FormName.ADD_TO_CART.getId()%>">
							<input type="hidden" name=<%=Constants.Parameters.PRODUCT_ID.getId()%> value="<%=p.getId()%>">
							<input type="button" value="Add to cart"></form>
							
							<form method="post" action="<%=request.getContextPath()%>/store">
							<input type="hidden" name=<%=Constants.Parameters.FORM_ID.getId()%> value="<%=Constants.FormName.ADD_TO_CART.getId()%>">
							<input type="hidden" name=<%=Constants.Parameters.PRODUCT_ID.getId()%> value="<%=p.getId()%>">
							<input type="button" value="Add to wishlist"></form>
						</td>
				</tr>
				
				<tr>
						<td>Description
						<br><%= p.getDescription() %></td>
						
		
				</table>