<%@page import="com.ateam.webstore.ui.views.ContentView"%>
<%@page import="com.ateam.webstore.ui.views.*"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<%@page import="com.ateam.webstore.model.Product"%>
<%@page import="com.ateam.webstore.model.ProductsInWishList"%>
<%@page import="com.ateam.webstore.ui.views.ProductListView"%>
<%@page import="com.ateam.webstore.ui.views.WishListView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<%WishListView v = (WishListView) request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW); %>

<%if (v.getMessage() != null) {out.print(v.getMessage());} %>

			<form method="post" action="<%=request.getContextPath()%>/store">
					<input type="hidden" name=<%=Constants.Parameters.FORM_ID.getId()%> 
						value="<%=Constants.FormName.WISHLIST_TO_CART.getId()%>">

<table width="100%">

	<%  for (ProductsInWishList p : v.getProductsInWishList()) { %>  
	<tr>
		<td><input type="checkbox" name="<%=p.getProduct().getId()%>"/></td>
		<td><a href="<%=request.getContextPath()%>/store?product=<%=p.getProduct().getId()%>"><%=p.getProduct().getProductName()%></a></td>
		<td><%=p.getProduct().getPrice()%></td>
        <td colspan=2><a href="<%=request.getContextPath()%>/store?wishList&remove=<%=p.getId()%>">Remove</a></td>
	</tr>
	
	<%  } %>
	
	<tr>
		<td></td>
		<td></td>
		<td></td>
		<td> <input type="submit" value="Move Selected to Cart" /> 
	</tr>

   
 </table>  
 
</form>
   
