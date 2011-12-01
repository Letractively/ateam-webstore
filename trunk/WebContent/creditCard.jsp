<%@page import="com.ateam.webstore.ui.views.ContentView"%>
<%@page import="com.ateam.webstore.ui.views.*"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<%@page import="com.ateam.webstore.model.CreditCard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%View v = (View) request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW); 
//if (v instanceof EditAddressView) {
//	CreditCard cc = (CreditCard) v;
//}

%>

			<form method="post" action="<%=request.getContextPath()%>/store">
					<input type="hidden" name=<%=Constants.Parameters.FORM_ID.getId()%> 
						value="<%=Constants.FormName.CREDIT_CARD.getId()%>">
					<input type="hidden" name=<%=Constants.Parameters.CONTEXT.getId()%> 
						value="<%=v.getContext()%>">


			<h3>Card Details</h3>
			
			<%if (v.getMessage() != null) { %><%=v.getMessage() %><br><% } %>
			
			<table>
				<tr>
						<td>Name on Card:</td>
						<td><input type="text" name="<%=Constants.Parameters.CARD_NAME.getId()%>"></td>
				</tr>
				<tr>
						<td>Card Type:</td>
						<td>
						<select name="<%=Constants.Parameters.CARD_TYPE.getId()%>">
							<option value="AMEX">AMEX</option>
							<option value="MasterCard">MasterCard</option>
							<option value="Visa">Visa</option>
							<option value="Discover">Discover</option>
						</select>
						</td>
				</tr>
		
				<tr>
						<td>Account Number:</td>
						<td><input type="text" name="<%=Constants.Parameters.CARD_ACCOUNT_NUMBER.getId()%>"></td>
				</tr>
				<tr>
						<td>Expiration Month/Year:</td>
						<td>
							<select name="<%=Constants.Parameters.CARD_EXPIRATION_MONTH.getId()%>">
							<option value="01">01</option>
							<option value="02">02</option>
							<option value="03">03</option>
							<option value="04">04</option>
							<option value="05">05</option>
							<option value="06">06</option>
							<option value="07">07</option>
							<option value="08">08</option>
							<option value="09">09</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">12</option>
							/
							</select>
							<select name="<%=Constants.Parameters.CARD_EXPIRATION_YEAR.getId()%>">
							<option value="11">2011</option>
							<option value="12">2012</option>							
							<option value="13">2013</option>
							<option value="14">2014</option>
							<option value="15">2015</option>	
							</select>	
								
						</td>
				</tr>
				<tr>
						<td>Security Code:</td>
						<td><input type="text" name="<%=Constants.Parameters.CARD_SECURITY_CODE.getId()%>" size="4"></td>
				</tr>
			</table>
			
			<jsp:include page="<%=Constants.JSP_ADDRESS%>" /> 
	
	
			<input type="submit" value="Add Card">
			
			</form>
