package br.com.batista.cinema.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.batista.cinema.database.CinemaDatabaseConnection;

public class CadastraFilme implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sql = "INSERT INTO filme(nome, nota, ano) VALUES(?, ?, ?);";

		try {

			Connection conn = CinemaDatabaseConnection.initializeDatabase();
			PreparedStatement st = conn.prepareStatement(sql);

			st.setString(1, request.getParameter("nome"));
			st.setDouble(2, Double.parseDouble(request.getParameter("nota")));
			st.setInt(3, Integer.parseInt(request.getParameter("ano")));

			st.execute();

			conn.close();
			st.close();

		} catch (Exception e) {
			System.out.println("Erro no cadastro: " + e);
		}

		return "redirect:entrada?acao=ListaFilmes";

	}

}
