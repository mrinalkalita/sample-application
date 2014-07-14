<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Employee Data</title>
</head>
<body>
<s:form action="EmployeeDataViewer">
<table>
<tr><td><s:textfield name="employee.id" label="Volvo Id" /></td></tr>
<tr><td><s:textfield name="employee.name" label="Name" /></td></tr>

<tr><td>View all Data</td></tr>
<tr><td><s:checkbox name="employee.showAll" label="showAll" /></td></tr>
<tr><td><s:submit /></td></tr>
</table>
</s:form>
</body>
</body>
</html>