package br.com.batista.cinema.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.batista.cinema.model.Banco;
import br.com.batista.cinema.model.Filme;

public class FormularioAlteraFilme implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paramId = request.getParameter("id");
		Integer id = Integer.parseInt(paramId);

		Banco banco = new Banco();
		Filme filme = banco.buscarPeloId(id);

		request.setAttribute("filme", filme);
		return "forward:formAlteraFilme.jsp";

	}

}
