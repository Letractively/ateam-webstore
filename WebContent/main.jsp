<%@page import="com.ateam.webstore.ui.views.ContentView"%>
<%@page import="com.ateam.webstore.ui.views.View"%>
<%@page import="com.ateam.webstore.ui.Constants"%>
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

<%View v = (View) request.getAttribute(Constants.REQUEST_ATTRIBUTE_VIEW); %>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/main.css" />



<title><%=v.getTitle() %></title>
</head>

<body>
    <div id="page">
		
        <div id="header">
        	<div id="headerTitle"><%=v.getHeaderTitle() %></div>
            <div id="headerSubText"><%=v.getHeaderSubText() %></div>
            
        </div>
        <div id="bar">
			<% for (java.util.Map.Entry<String,String> navLink : v.getNavLinks().entrySet()) {%>
        	<div class="navLink"><a href="<%=navLink.getValue()%>"><%=navLink.getKey() %></a></div>
        	<%} %>

      </div>
      
      <% if (v.getContentViews() != null) for (ContentView cv : v.getContentViews()) {%>
        <div class="contentTitle"><h1><%=cv.getContentHeader() %></h1></div>
        <div class="contentText">
        <p><%=cv.getContentText() %></p>
		<jsp:include page="<%=cv.getJspf() %>" />
        </div>
        <%} %>

</div>
        <div id="footer"><%=v.getFooterText() %></div>
</body>
</html>