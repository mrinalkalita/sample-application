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
<s:form>
<table>
<tr><td><s:iterator value="list">
<p>Employee is: <s:property/></p>
</s:iterator>
</td></tr>
</table>
</s:form>
</body>
</body>
</html>