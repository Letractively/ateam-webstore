<%@page import="com.ateam.webstore.utilities.Utilities"%>
<%@page import="com.ateam.webstore.ui.views.ContentView"%>
<%@page import="com.ateam.webstore.ui.views.*"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<%@page import="com.ateam.webstore.servlets.AteamContextListener"%>
<%@page import="com.ateam.webstore.model.Product"%>
<%@page import="com.ateam.webstore.model.ProductListing"%>
<%@page import="com.ateam.webstore.ui.views.ProductListView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%ProductListingView v = (ProductListingView) request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW); 

String productImageRoot = (String) AteamContextListener.ateamProperties.get(Constants.PROPERTY_PRODUCT_IMAGE_ROOT);

%>

<% if (v == null || v.getProducts() == null) { %>
	No Products Found.
<%}  else { %>
<table width="100%">
	<%  for (ProductListing p : v.getProducts()) {	%>
	<tr>
		
		<td rowspan="2"><img src="<%=productImageRoot%>t_<%=p.getSku()%>.png"></td>
		<td colspan="2"><a href="<%=request.getContextPath()%>/store?product=<%=p.getProductID()%>"><%=p.getProductName()%></a></td>
	</tr>
	<tr>
		<%if (p.getDescription().length() > 100) { %> 
		<td><%=p.getDescription().substring(0, 100)%>...</td>
		<%} else { %>
		<td><%=p.getDescription()%></td>
		<%} %>
		<td><b><%=Utilities.formatDouble(p.getSalesPrice())%></b></td>

	</tr>
	<%  } %>

</table>

<%}%>

