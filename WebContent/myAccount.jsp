<%@page import="com.ateam.webstore.ui.views.ContentView"%>
<%@page import="com.ateam.webstore.ui.views.*"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<%@page import="com.ateam.webstore.model.CreditCard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		
			<table>
				<tr>
						<td valign="top"><b>Products</b></td>
						<td><a href="<%=request.getContextPath()%>/store?wishList">My Wish List</a>
						<br> <a href="<%=request.getContextPath()%>/store?cart">My Cart</a></td>
				</tr>
			
				<tr>
						<td valign="top"><b>Orders</b></td>
						<td><a href="<%=request.getContextPath()%>/store?orders">Order History</a>
						<br> <a href="<%=request.getContextPath()%>/store?openOrders">Open Orders</a></td>
				</tr>
		
				<tr>
						<td valign="top"><b>Payment</b></td>
						<td><a href="<%=request.getContextPath()%>/store?creditCardList">Manage Payment Options</a>
						<br> <a href="<%=request.getContextPath()%>/store?creditCard">Add a Debit or Credit Card</a></td>
				</tr>
				
				<tr>
						<td valign="top"><b>Settings</b></td>
						<td><a href="<%=request.getContextPath()%>/store?register">Edit Personal Info</a>
						(Name, e-mail, password, Security question)<br>
						<a href="<%=request.getContextPath()%>/store?addressList">Manage Address book</a><br>
						<a href="<%=request.getContextPath()%>/store?address">Add New Address</a>
						</td>
				</tr>
				
			</table>
	
