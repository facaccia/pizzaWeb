<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="true" %>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome page Pizza Web</title>
</head>
<body>

					<c:url var="modificaLink" value="/ordineForm"></c:url>



	<div style="text-align: center">
		<h1>Benvenuto nella pagina Pizza Web</h1>
		<hr>
		<c:out value="${sessionScope.listPizza}"/>
		<h2>Per Creare un nuovo ordine clicca <a href="${modificaLink}">qui</a></h2>
	</div>
	


</body>
</html>