<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AddCustomer page</title>
<style type="text/css">
	.error{
		color: red;
		font-family: serif;
		font-style: italic;
	}
</style>
</head>
<body>
<form:form action="addcustomer" method="post" modelAttribute="customer">
	<form:hidden path="id"/>
	Enter name: <form:input path="name"/><form:errors path="name" class="error"/><br/>
	Enter email: <form:input path="email"/><form:errors path="email" class="error"/><br/>
	Enter phoneno: <form:input path="phoneno"/><form:errors path="phoneno" class="error"/><br/>
	Enter address: <form:input path="address"/><form:errors path="address" class="error"/><br/>
	Enter salary: <form:input path="salary"/><form:errors path="salary" class="error"/><br/>
		<input type="submit"/>
</form:form>
</body>
</html>




