<%@page import="com.ateam.webstore.ui.views.ContentView"%>
<%@page import="com.ateam.webstore.ui.views.*"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<%@page import="com.ateam.webstore.model.CreditCard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%Object v = request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW); 
//if (v instanceof EditAddressView) {
//	CreditCard cc = (CreditCard) v;
//}

%>

			<form method="post" action="<%=request.getContextPath()%>/store">
					<input type="hidden" name=<%=Constants.Parameters.FORM_ID.getId()%> 
						value="<%=Constants.FormName.CREDIT_CARD.getId()%>">


			<h3>Card Details</h3>
			<table>
				<tr>
						<td>Name on Card:</td>
						<td><input type="text" name="<%=Constants.Parameters.CARD_NAME%>"></td>
				</tr>
		
				<tr>
						<td>Account Number:</td>
						<td><input type="text" name="<%=Constants.Parameters.CARD_ACCOUNT_NUMBER%>"></td>
				</tr>
				<tr>
						<td>Expiration:</td>
						<td><input type="text" name="<%=Constants.Parameters.CARD_EXPIRATION%>"></td>
				</tr>
				<tr>
						<td>Security Code:</td>
						<td><input type="text" name="<%=Constants.Parameters.CARD_SECURITY_CODE%>"></td>
				</tr>
			</table>
			
			<jsp:include page="<%=Constants.JSP_ADDRESS%>" /> 
	
	
			<input type="submit" value="?Add">
			
			</form>
