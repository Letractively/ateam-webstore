<%@page import="com.ateam.webstore.model.Orders"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <%Orders v = (Orders) request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW); %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


 <table>

<tr></tr>
<tr></tr>

<tr><td>
					<h4>Order Number </h4>
		</td>
        <td> </td>
		<td><h4>Quantity</h4></td>
        <td width=47> </td>

		<td><h4>Date Ordered</h4></td>
          <td><h4>Shipped</h4></td>

</tr>

<tr>
<td   colspan=2><a href="tag_a.asp">Order Number referenced by customer</a>   </td>

<td   >  Quantity Ordered in that order </td>

<td> Date that Order has been Ordered</td>


<td>  Whether order shipped or not </td>


</tr>

</table>


</body>
</html>