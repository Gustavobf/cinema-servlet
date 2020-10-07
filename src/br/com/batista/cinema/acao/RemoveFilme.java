package br.com.batista.cinema.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.batista.cinema.database.CinemaDatabaseConnection;

public class RemoveFilme implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer id = Integer.parseInt(request.getParameter("id"));

		String sql = "DELETE FROM filme WHERE idFilme = ?";

		try {
			Connection conn = CinemaDatabaseConnection.initializeDatabase();
			PreparedStatement st = conn.prepareStatement(sql);

			st.setInt(1, id);

			st.execute();

			conn.close();
			st.close();

		} catch (Exception e) {
			System.out.println("Erro na remocao dos dados: " + e);
		}

		return "redirect:entrada?acao=ListaFilmes";

	}

}
