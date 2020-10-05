<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.batista.cinema.model.Filme"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alterando Filme</title>
</head>
<body>

	<form action="/cinema/entrada?acao=AlteraFilme&id=${filme.id}" method="post">
		Nome: <input type="text" name="nome" value="${filme.nome}"> <input
			type="hidden" nome="id" value="${filme.id}">
			<input type="hidden" name="acao" value="AlteraFilme">
			 <input type="submit">
	</form>

</body>
</html>