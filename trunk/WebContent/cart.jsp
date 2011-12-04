<%@page import="com.ateam.webstore.ui.views.ContentView"%>
<%@page import="com.ateam.webstore.ui.views.*"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<%@page import="com.ateam.webstore.model.Product"%>
<%@page import="com.ateam.webstore.model.Cart"%>
<%@page import="com.ateam.webstore.ui.views.ProductListView"%>
<%@page import="com.ateam.webstore.ui.views.CartView"%>
<%@page import="com.ateam.webstore.model.ProductsInCart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<%CartView v = (CartView) request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW);
Cart cart = (Cart) request.getSession().getAttribute(Constants.SESSION_ATTRIBUTE_CART);
%>

<%if (v.getMessage() != null) {out.print(v.getMessage());} %>

<% if (v.getProducts()== null) { %>
Empty Cart
<% } else {  %>

			<form method="post" action="<%=request.getContextPath()%>/store">
					<input type="hidden" name=<%=Constants.Parameters.FORM_ID.getId()%> 
						value="<%=Constants.FormName.EDIT_CART.getId()%>">


<table width="100%">

	<%  for (ProductsInCart p : v.getProducts()) { %>  
	
			<%
			if (p == null) {continue;}
			Product pd = p.getProduct();
			if (pd == null) {continue;} 
			
			%>
	
	<tr>
		<td><input type="checkbox" name="<%=p.getProduct().getId()%>"/></td>
		<td width="500" ><a href="<%=request.getContextPath()%>/store?product=<%=pd.getId()%>"><%=pd.getShortProductName(35)%></a></td>
		<td><%=pd.getPrice()%></td>
		<td><input type="text" name="<%=p.getId()+"_"+Constants.Parameters.PRODUCT_QUANTITY.getId()%>" value="<%=p.getQuantity()%>" size="3"/></td>
        <td colspan=2><a href="<%=request.getContextPath()%>/store?cart=<%=cart.getId()%>&remove=<%=p.getId()%>">Remove</a></td>
	</tr>
	
	<%  } %>
	
	<tr></tr>
	
	<tr align="right">
		<td></td>
		<td></td>
		<td><input type="submit" name="<%=Constants.Parameters.CART_ACTION.getId()%>" value="Move Selected to WishList" /></td>
		<td><input type="submit" name="<%=Constants.Parameters.CART_ACTION.getId()%>" value="Update Quantity" /></td>
		<td><input type="submit" name="<%=Constants.Parameters.CART_ACTION.getId()%>" value="Checkout" /></td>   
	</tr>

</table>  

</form>
<%} %>   
