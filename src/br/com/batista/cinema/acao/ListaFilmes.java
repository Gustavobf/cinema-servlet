package br.com.batista.cinema.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.batista.cinema.model.Banco;
import br.com.batista.cinema.model.Filme;

public class ListaFilmes implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession id = request.getSession();
		
		if (id.getAttribute("usuarioLogado") == null) {
			return "redirect:entrada?acao=FormularioLogin";
		}
		
		Banco banco = new Banco();
		List<Filme> lista = banco.getAll();

		request.setAttribute("filmes", lista);
		return "forward:listaFilmes.jsp";

	}

}
