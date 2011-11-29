<%@page import="com.ateam.webstore.ui.views.ContentView"%>
<%@page import="com.ateam.webstore.ui.views.View"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<%@page import="com.ateam.webstore.handlers.Handler"%>
<%@page import="com.ateam.webstore.model.Cart"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--
Design by Bryant Smith
http://www.bryantsmith.com
http://www.aszx.net
email: template [-at-] bryantsmith [-dot-] com
Released under Creative Commons Attribution 2.5 Generic.  In other words, do with it what you please; but please leave the link if you'd be so kind :)

Name       : Creative Inspiration
Description: One column, no nav
Version    : 1.0
Released   : 20081009
-->


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<%
	Handler h = new Handler(request);
	View v = h.getMainView();
%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<% if (v.getRedirectPath() != null) { %>
<meta http-equiv="REFRESH" content="0;url="<%=v.getRedirectPath()%>"/>
<%} %>
<link rel="stylesheet" type="text/css" href="css/main.css" />

<title><%=v.getTitle()%></title>
</head>

<body>
	<div id="page">

		<div id="header">
			<div id="headerTitle"><a href="<%=request.getContextPath()%>/store"><%=v.getHeaderTitle()%></a></div>
			<div id="headerSubText"><%=v.getHeaderSubText()%></div>

			
					<%
						if (v.showVisitorInfo()) {
					%>
			<div id="headerVisitor"><%=v.getGreeting()%><br>
				<%
					if (v.getVisitor().isAuthenticated()) { %>
				<a class="headerLink" href="<%=request.getContextPath()%>/store?logout">Logout</a> <a class="headerLink" href="<%=request.getContextPath()%>/store?myAccount">My Account&nbsp&nbsp</a>
				<%
					} else {
				%>
				<a class="headerLink" href="<%=request.getContextPath()%>/store?login">Login</a>
				<%
					}
				%>
			</div>
			<br>
					
					<%
						} else if (v.showLogonForm()) {
					%>
			<div id="headerLogon">
				<form method="post" action="<%=request.getContextPath()%>/store" id="headerLogonForm">
				<input type="hidden" name=<%=Constants.Parameters.FORM_ID.getId()%> value="<%=Constants.FormName.LOGIN.getId()%>">
				Email: <input type="text"  name="<%=Constants.Parameters.EMAIL.getId()%>" value="<%=v.getVisitor().getEmail()%>">
				Password: <input type="password" name="<%=Constants.Parameters.PASSWORD.getId()%>"> <input type="submit" value="Login">
				<a class="headerLink" href="<%=request.getContextPath()%>/store?register"> &nbsp Or Register</a>
				</form>
			</div> 
					
					<%
						} 
					%>
			
					<%
 	if (request.getSession().getAttribute(Constants.SESSION_ATTRIBUTE_CART) != null) {
 		Cart c = (Cart) request.getSession().getAttribute(Constants.SESSION_ATTRIBUTE_CART);
 %>
				<div id="headerCart">
					<%=c.getProducts().size()%> item(s) in Cart<br>
					<a class="headerLink" href="<%=request.getContextPath()%>/store?viewCart">View Cart</a>
				</div> <%
 	}
 %>
		</div>

		<div id="bar">
			<%
				for (java.util.Map.Entry<String, String> navLink : v.getNavLinks().entrySet()) {
			%>
			<div class="navLink">
				<a href="<%=navLink.getValue()%>"><%=navLink.getKey()%></a>
			</div>
			<%
				}
			%>

			<div method="post" action="<%=request.getContextPath()%>/store" id="searchField">
				<form id="searchFieldForm"><input type="hidden" name=<%=Constants.Parameters.FORM_ID.getId()%> value="<%=Constants.FormName.SEARCH.getId()%>">
				<input type="text" name="<%=Constants.Parameters.SEARCH_QUERY.getId()%>"/> 
				<input type="submit" value="Search" /> </form>
			</div>

		</div>


		<div class="contentTitle">
			<h1>Error</h1>
		</div>
		<div class="contentText">
			An internal error occurred.
		</div>

	</div>
	<div id="footer"><%=v.getFooterText()%></div>
</body>
</html>