package br.com.batista.cinema.formularios;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.batista.cinema.acao.Acao;
import br.com.batista.cinema.database.dao.FilmeDAO;
import br.com.batista.cinema.model.Filme;

public class FormularioAlteraFilme implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer idFilme = Integer.parseInt(request.getParameter("id"));

		try {

			Filme filme = FilmeDAO.getById(idFilme);
			request.setAttribute("filme", filme);

		} catch (Exception e) {
			System.out.println("Erro no Formulario de alteracao dos dados: " + e);
		}
		return "forward:formAlteraFilme.jsp";

	}

}
