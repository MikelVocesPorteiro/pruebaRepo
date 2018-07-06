<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>


<html>
<head>
<meta charset="UTF-8">

        <spring:url value="static/css/bootstrap.css" var="bootstrap"/>
        <link href="${bootstrap}" rel="stylesheet" />
        <spring:url value="static/css/custom.css" var="custom"/>
        <link href="${custom}" rel="stylesheet" />  
        
		<spring:url value="/resources/css/bootstrap.css" var="estilos1" />
		<link href="${estilos1}" rel="stylesheet" />
		
		<spring:url value="/resources/css/custom.css" var="estilos3" />
		<link href="${estilos3}" rel="stylesheet" />		
	
		<spring:url value="css/bootstrap.css" var="estilos2" />
		<link href="${estilos2}" rel="stylesheet" />	
		
        <link href="<c:url value='/static/css/custom.css' />" rel="stylesheet"></link>    
        
        <link href="static/css/custom.css" rel="stylesheet" type="text/css" />    
         <link href="static/custom.css" rel="stylesheet" type="text/css" />    
           

<title>LISTADO DE USUARIOS</title>
</head>
<body>
	<div align="center">
		<h1>LISTADO DE USUARIOS</h1>
		<h3>
			<a href="new">Clic para crear un NUEVO USUARIO</a>
		</h3>

		<table border="1">
		<tr>
			<th>Nº</th>
			<th>Usuario</th>
			<th>Email</th>
			<th>Acciones</th>
			</tr>

			<c:forEach var="user" items="${userList}" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${user.username}</td>
					<td>${user.email}</td>
					<td><a href="edit?id=${user.id}">Modificar</a>
								 edit?pepe=12
						&nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=${user.id}">Eliminar</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>