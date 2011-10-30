<%@page import="com.ateam.webstore.ui.views.ContentView"%>
<%@page import="com.ateam.webstore.ui.views.*"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<%@page import="com.ateam.webstore.model.CreditCard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

			<!--  <form method="post" action="<%=request.getContextPath()%>/store">
					<input type="hidden" name=<%=Constants.Parameters.FORM_ID.getId()%> 
						value="<%=Constants.FormName.CREDIT_CARD.getId()%>">-->
		
		<h3>My Account</h3>
							<br>

			<table>
				<tr>
						<td>Orders</td>
						<td><a href="/ateam/store?product=null">Order History</a>
						<br> <a href="/ateam/store?product=null">View Open Orders</a></td>
				</tr>
		
				<tr>
						<td>Payment</td>
						<td><a href="<%=request.getContextPath()%>/store?creditCardList">Manage Payment Options</a>
						<br> <a href="<%=request.getContextPath()%>/store?creditCard">Add a Debit or Credit Card</a></td>
				</tr>
				<tr>
						<td>Settings</td>
						<td><a href="<%=request.getContextPath()%>/store?register">Edit Personal Info</a>
						(Name, e-mail, password, Security question)<br>
						<a href="<%=request.getContextPath()%>/store?addressList">Manage Address book</a><br>
						<a href="<%=request.getContextPath()%>/store?address">Add New Address</a>
						</td>
				</tr>
				
			</table>
	
