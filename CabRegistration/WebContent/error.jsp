<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<title>Registration Successful</title>
</head>
<body>
<h3>There was error while registering.</h3>
 
<p>Your registration information: <s:property value="employee" /> </p>
 
<p><a href="<s:url action='index' />" >Return to home page</a>.</p>
</body>
</html>