<%@page import="com.ateam.webstore.utilities.Utilities"%>
<%@page import="com.ateam.webstore.ui.views.ContentView"%>
<%@page import="com.ateam.webstore.ui.views.*"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<%@page import="com.ateam.webstore.model.Product"%>
<%@page import="com.ateam.webstore.ui.views.ProductDetailsView"%>
<%@page import="com.ateam.webstore.servlets.AteamContextListener"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<%ProductDetailsView v = (ProductDetailsView) request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW); 
Product p=v.getProduct();

String productImageRoot = (String) AteamContextListener.ateamProperties.get(Constants.PROPERTY_PRODUCT_IMAGE_ROOT);
%>	
			<form method="POST" action="<%=request.getContextPath()%>/admin">
			<input type="hidden" name=<%=Constants.Parameters.FORM_ID.getId()%> value="<%=Constants.FormName.EDIT_PRODUCT.getId()%>">
			<input type="hidden" name=<%=Constants.Parameters.PRODUCT_ID.getId()%> value="<%=p.getId()%>">
			
			<%if (v.getMessage() != null) {out.print(v.getMessage());} %>
			<table>
				<tr>

						<td><img src="<%=productImageRoot%>/<%=p.getSKU()%>.png"></td>
						<td align=top>
							<b>Price:</b>
							<input type="text" name="<%=Constants.Parameters.PRODUCT_PRICE.getId()%>" value="<%=Utilities.formatDouble(p.getPrice())%>" ><br>
							<b>Discount:</b>
							<input type="text" name="<%=Constants.Parameters.PRODUCT_DISCOUNT.getId()%>" value="<%=Utilities.formatDouble(p.getPercentDiscount())%>" >
						</td>
				</tr>
				
				<tr>
						<td>On Sale: <input type=checkbox name="<%=Constants.Parameters.ON_SALE.getId()%>" <% if (p.isOnSale()) {%>CHECKED<%}%>>
						</td>
				<tr>
				<tr>
						<td>Active: <input type=checkbox name="<%=Constants.Parameters.ACTIVE.getId()%>" <% if (p.isActive()) {%>CHECKED<%}%>>
						</td>
				<tr>
				
						<td colspan="2">						
						Description:<br><textarea rows="20" cols="50" name="<%=Constants.Parameters.PRODUCT_DESC.getId()%>"><%= p.getDescription() %></textarea>
						</td>
						
				</tr>
				<tr>
					<td><input name="<%=Constants.Parameters.PRODUCT_ACTION.getId()%>" type="submit" value="Update Product"></td>
				</tr>
			</table>
				