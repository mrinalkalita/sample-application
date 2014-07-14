<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello World</title>
</head>
<body>
<table width=300 bgcolor="#C0C0C0">
<tr><td><h1>How may I serve you today?</h1></td></tr>
<tr><td><a href="employee_data_entry.jsp">Employee Registration</a></td></tr>
<tr><td><a href="employee_data_view.jsp">View Employee Data</a></td></tr>
<tr><td><a href="employee_data_view.jsp">Book Itenary</a></td></tr>
</table>
<h1><s:property value="message" /></h1>
</body>
</html>