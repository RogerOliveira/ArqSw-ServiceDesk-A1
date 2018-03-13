<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Chamados</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>

<body>
	<!-- Barra superior com os menus de navegação -->
	<c:import url="Menu.jsp" />
	<!-- Container Principal -->
	<div id="main" class="container">
		<h3 class="page-header">
			<c:out value="${fila.nome}"></c:out>
		</h3>
		<table>
			<thead>
				<tr>
					<th>
						<p>Número</p>
					</th>
					<th>
						<p>Descrição</p>
					</th>
					<th>
						<p>Abertura</p>
					</th>
					<th>
						<p>Fechamento</p>
					</th>
					<th>
						<p>Status</p>
					</th>
					<th>
						<p>Tempo</p>
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="chamado" items="${chamados}">
					<tr>
						<td>${chamado.id_chamado}</td>
						<td>${chamado.descricao}</td>
						<td>${chamado.dt_abertura}</td>
						<td>${chamado.dt_fechamento}</td>
						<td>${chamado.status}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>