<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login login</title>
</head>
<body>

	<f:form action="login" commandName="credentials">
		<f:label path="username">Username</f:label><f:input path="username"/>
		<f:label path="password">Password</f:label><f:input type="password" path="password"/>
		<input type="submit" value="Login"/>
	</f:form>

</body>
</html>