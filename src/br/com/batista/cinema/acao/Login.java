package br.com.batista.cinema.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.batista.cinema.database.dao.UsuarioDAO;
import br.com.batista.cinema.model.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paramLogin = request.getParameter("login");
		String paramSenha = request.getParameter("senha");

		Usuario usuario = UsuarioDAO.hasUser(paramLogin, paramSenha);

		if (usuario != null) {
			HttpSession id = request.getSession();
			id.setAttribute("usuarioLogado", usuario);
			return "redirect:entrada?acao=ListaFilmes";
		} else {
			return "redirect:entrada?acao=FormularioLogin";
		}

	}

}
