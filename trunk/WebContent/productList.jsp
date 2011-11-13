<%@page import="com.ateam.webstore.ui.views.ContentView"%>
<%@page import="com.ateam.webstore.ui.views.*"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<%@page import="com.ateam.webstore.servlets.AteamContextListener"%>
<%@page import="com.ateam.webstore.model.Product"%>
<%@page import="com.ateam.webstore.ui.views.ProductListView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%ProductListView v = (ProductListView) request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW); 

String productImageRoot = (String) AteamContextListener.ateamProperties.get(Constants.PROPERTY_PRODUCT_IMAGE_ROOT);

%>

<h3><%=v.getListTitle()%></h3>
<table width="100%">
	<%  for (Product p : v.getProducts()) { %>

	<tr>
		<td><img src="<%=request.getContextPath()%>/<%=p.getImagePath()%>small.png"></td>
		<td><a href="<%=productImageRoot%>t_<%=p.getId()%>.png"><%=p.getProductName()%></a></td>
		<td><%=p.getPrice()%></td>
		<td><%=p.getDescription()%></td>

	</tr>
	<%  } %>

</table>

