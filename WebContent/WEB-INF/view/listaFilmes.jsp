<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.batista.cinema.model.Filme"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Página Inicial - Filmes Listados</title>
</head>
<body>

<a href="/cinema/entrada?acao=Logout">logout</a>

<h3>Lista de Filmes:</h3>

	<ul>
		<c:forEach items="${filmes}" var="filme">
			<li>
				${filme.nome}
				<a href="/cinema/entrada?acao=RemoveFilme&id=${filme.id}">Excluir</a>
				<a href="/cinema/entrada?acao=FormularioAlteraFilme&id=${filme.id}">Alterar</a>
			</li>
		</c:forEach>
	</ul>

	<a href="/cinema/entrada?acao=FormularioNovoFilme">Adicionar</a>

</body>
</html>