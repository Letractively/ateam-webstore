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
			<table>
				<tr>
						<td><img src="<%=productImageRoot%>/<%=p.getSKU()%>.png"></td>
						<td>
						</td>
						<td align=top>
							<b><%=p.getPrice() %><b></b><br>
							<form method="POST" action="<%=request.getContextPath()%>/store">
							<input type="hidden" name=<%=Constants.Parameters.FORM_ID.getId()%> value="<%=Constants.FormName.ADD_TO_CART.getId()%>">
							<input type="hidden" name=<%=Constants.Parameters.PRODUCT_ID.getId()%> value="<%=p.getId()%>">
							<input type="submit" value="Add to cart"></form>
							<br>
							<br>
							<form method="POST" action="<%=request.getContextPath()%>/store">
							<input type="hidden" name=<%=Constants.Parameters.FORM_ID.getId()%> value="<%=Constants.FormName.ADD_TO_WISHLIST.getId()%>">
							<input type="hidden" name=<%=Constants.Parameters.PRODUCT_ID.getId()%> value="<%=p.getId()%>">
							<input type="submit" value="Add to Wish List"></form>
						</td>
				</tr>
				
				<tr>
						<td>
						<% if (p.getSaleInd().equals("T")) {%>
						On Sale!<br>
						<%} %>
						
						<br><%= p.getDescription() %></td>
						
		
				</table>