<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">


		<esta todo hecho mierda>
		
		jjjjjjjjjjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjj
		<esta todo hecho mierda>
		
		jjjjjjjjjjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjj
		
		<esta todo hecho mierda>
		
		jjjjjjjjjjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjj
		
		<esta todo hecho mierda>
		
		jjjjjjjjjjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjj
		
		<esta todo hecho mierda>
		
		jjjjjjjjjjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjj
		
		<esta todo hecho mierda>
		
		jjjjjjjjjjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjj
		
		<esta todo hecho mierda>
		
		jjjjjjjjjjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjjj
		jjjjjjjjjjjjjjjjjjjjj
		
<title>FORMULARIO DE USUARIOS</title>
</head>
<body>
	<div align="center">
		<h1>FORMULARIO DE USUARIOS (add/edit)</h1>
		<table>
			<form:form action="save" method="post" modelAttribute="user">
				<form:hidden path="id" />
				<tr>
					<td>Usuario:</td>
					<!--  sirve para automatizar la insercion en el objeto ( set) -->
					<td><form:input path="username" /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:password path="password" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Guardar Registro"></td>
				</tr>
			</form:form>
		</table>
	</div>

</body>
</html>