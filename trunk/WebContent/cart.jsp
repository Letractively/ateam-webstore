<%@page import="com.ateam.webstore.ui.views.ContentView"%>
<%@page import="com.ateam.webstore.ui.views.*"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<%@page import="com.ateam.webstore.model.Product"%>
<%@page import="com.ateam.webstore.ui.views.ProductListView"%>
<%@page import="com.ateam.webstore.ui.views.CartView"%>
<%@page import="com.ateam.webstore.ui.models.ProductInCart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<%CartView v = (CartView) request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW); %>
<h3> <%= v.getTitle() %></h3>

<table width="100%">

	<%  for (ProductInCart p : v.getProducts()) { %>  
	<tr>
		<td><input type="checkbox" name="Product" value="Cart item" ;/> <br /></td>
		<td><a href="<%=request.getContextPath()%>/store?product=<%=p.getProduct().getId()%>"><%=p.getProduct().getProductName()%></a></td>
		<td><%=p.getProduct().getPrice()%></td>
		<td> <select <%=p.getProduct().getId()%>  > style="width: 70%">  <option selected>1</option>  <option value="http://mousetrax.com">Mousetrax</option> </select></td>
        <td colspan=2><a href="p.getProduct().getId()">Remove</a></td>
	</tr>
	
	<%  } %>
	
<tr>
<td> </td><td > <input type="submit" value="Move to WishList" /> 
   <input type="submit" value="Update" /></td>
</tr>


<tr>
 <td> </td>  <td> </td> <td> </td><td> </td>    <td>

   <input type="submit" value="CheckOut" /></td></tr>
   
 </table>  
   
