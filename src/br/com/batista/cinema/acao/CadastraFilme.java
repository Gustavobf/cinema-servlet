package br.com.batista.cinema.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.batista.cinema.model.Banco;
import br.com.batista.cinema.model.Filme;

public class CadastraFilme implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Filme filme = new Filme(request.getParameter("nome"), Double.parseDouble(request.getParameter("nota")), Integer.parseInt(request.getParameter("ano")));
		
		Banco banco = new Banco();
		banco.adiciona(filme);

		return "redirect:entrada?acao=ListaFilmes";

	}

}
