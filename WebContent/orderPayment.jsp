<%@page import="com.ateam.webstore.ui.views.ContentView"%>
<%@page import="com.ateam.webstore.ui.views.*"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<%@page import="com.ateam.webstore.model.CreditCard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%OrderPaymentView v = (OrderPaymentView) request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW); %>


		<h3>Pay With:</h3>
		
			<form method="post" action="<%=request.getContextPath()%>/store">
					<input type="hidden" name=<%=Constants.Parameters.FORM_ID.getId()%> 
						value="<%=Constants.FormName.ORDER_PAYMENT.getId()%>">

				<select  name="<%=Constants.Parameters.CART_ID%>">
				<%for (CreditCard cc : v.getUserCards()) {%>
					<option value="<%=cc.getId()%>"><%=cc.getCardNmber() %></option>
				<%} %>
				</select>

				<input type="submit" value="Back" onClick="history.go(-1)"><input type="submit" value="Continue">
			</form>