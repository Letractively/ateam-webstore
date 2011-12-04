<%@page import="com.ateam.webstore.ui.views.ContentView"%>
<%@page import="com.ateam.webstore.ui.views.*"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
<%@page import="com.ateam.webstore.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%AdminAddEmployeeView v = (AdminAddEmployeeView) request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW); %>

			<form method="post" action="<%=request.getContextPath()%>/admin">
					<input type="hidden" name=<%=Constants.Parameters.FORM_ID.getId()%> 
						value="<%=Constants.FormName.ADD_EMPLOYEE.getId()%>">

                    Login:<br>
                    <input type="text" name="<%=Constants.Parameters.EMPLOGIN.getId()%>"><br><br>

                    Password:<br>
                    <input type="password" name="<%=Constants.Parameters.EMPPASSWORD.getId()%>"><br><br>

                    Confirm Password:<br>
                    <input type="password" name="<%=Constants.Parameters.EMPCONFIRMPASSWORD.getId()%>"><br><br>

                    FirstName:<br>
                    <input type="text" name="<%=Constants.Parameters.EMPFIRSTNAME.getId()%>"><br><br>

                    LastName:<br>
                    <input type="text" name="<%=Constants.Parameters.EMPLASTNAME.getId()%>"><br><br>
                   
                    <input type="submit" name="submit" value="Login">
            </form>