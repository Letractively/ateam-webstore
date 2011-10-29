<%@page import="com.ateam.webstore.ui.views.ContentView"%>
<%@page import="com.ateam.webstore.ui.views.*"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<%@page import="com.ateam.webstore.model.Address"%>
<%@page import="com.ateam.webstore.model.ShippingCode"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%OrderShippingView v = (OrderShippingView) request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW); %>

			<form method="post" action="<%=request.getContextPath()%>/store">
					<input type="hidden" name=<%=Constants.Parameters.FORM_ID.getId()%> 
						value="<%=Constants.FormName.ORDER_SHIPPING.getId()%>">


				<h3>Ship to:</h3>
				<select name="<%=Constants.Parameters.ADDRESS.getId()%>">
				<% for (Address a : v.getUserAddresses()) { %>
					<option value="<%=a.getId()%>"><%=a.getStreetAddress1() %></option>
				<%} %>
				</select>

				<br><br>
				<h3>Shipping Method:</h3>
				<% for (ShippingCode s : v.getShippers()) { %>
					<input type="radio" name="<%=Constants.Parameters.SHIPPING_CODE.getId()%>" value="<%=s.getShippingCode()%>"><%=s.getDescription()%><br>
				<%} %>
				
				<input type="submit" value="Back"><input type="submit" value="Continue">


			</form>