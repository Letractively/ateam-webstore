<%@page import="com.ateam.webstore.model.Product"%>
<%@page import="java.util.Collection"%>
<%@page import="com.ateam.webstore.ui.views.*"%>
<%@page import="com.ateam.webstore.servlets.AteamContextListener"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%ProductListView v = (ProductListView) request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW); 
Collection<Product> products = v.getProducts();
String productImageRoot = (String) AteamContextListener.ateamProperties.get(Constants.PROPERTY_PRODUCT_IMAGE_ROOT);
%>

	<table class="contentTable">
		<tr>
	<%
	int count = 1; 
	for (Product p : products) if (p != null) { %>

		<% if (count > 2) { 
			count = 1;%>
			</tr><tr>
		<%} %>

				<td>
				<h3><a href="<%=request.getContextPath()%>/store?product=<%=p.getId()%>"><%=p.getProductName()%></a></h3>
				<img src="<%=productImageRoot%>/<%=p.getSKU()%>.png"><br>
				<%if (p.getDescription().length() > 100) { %> 
				<%=p.getDescription().substring(0, 100)%>...
				<%} else { %>
				<%=p.getDescription()%>
				<%} %>
				<br>
				<b><%=p.getPrice()%></b>
				</td>
		
	<% count++; } %>
		</tr>
	</table>
