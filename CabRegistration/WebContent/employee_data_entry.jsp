<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Data Entry</title>
</head>
<body>
<s:form action="EmployeeRegistration">
<table>
<tr><td><s:textfield name="employee.volvoId" label="Volvo Id" /></td></tr>
<tr><td><s:textfield name="employee.password" label="Password" /></td></tr>
<tr><td><s:textfield name="employee.passwordRepeat" label="Repeat Password" /></td></tr>
<tr><td><s:textfield name="employee.name" label="Name" /></td></tr>
<tr><td><s:textarea name="employee.homeAddress" label="Home Address" /></td></tr>
<tr><td><s:textfield name="employee.contactNumber" label="Contact Number" /></td></tr>
<tr><td><s:textarea name="employee.officeAddress" label="Office Address" /></td></tr>
<tr><td><s:submit /></td></tr>
</table>
</s:form>
</body>
</body>
</html>