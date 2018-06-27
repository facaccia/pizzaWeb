<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="true" %>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	<h2>Ordine</h2>
	
		<form:form   method="POST">
			
			<c:set var="count" value="-1" scope="page" />
			
			<table>
				<tbody>
				
				  <tr>
				    <th>Company</th>
				    <th>Contact</th>
				    <th>Country</th>
				  </tr>
					<c:forEach var="listPizza" items="${sessionScope.listPizza}">
					<c:set var="count" value="${count + 1}" scope="page"/>
					<tr><c:out value="${sessionScope.listPizza.get(count).getDescrizione()}"> </c:out></tr>
					
					</c:forEach>
					
					<tr>
						<td><label>Numero:</label></td>
						<td>
						<c:out value="${sessionScope.listPizza.get(1).getDescrizione()}"/>
						
					</tr>
					
				</tbody>
			
			</table>
		
		
		</form:form>
	</div>

</body>
</html>