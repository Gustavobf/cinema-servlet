package br.com.batista.cinema.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.batista.cinema.database.CinemaDatabaseConnection;

public class AlteraFilme implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		Double nota = Double.parseDouble(request.getParameter("nota"));
		Integer ano = Integer.parseInt(request.getParameter("ano"));

		String sql = "UPDATE filme SET nome = ?, nota = ?, ano = ? WHERE idFilme = ?";

		try {

			Connection conn = CinemaDatabaseConnection.initializeDatabase();
			PreparedStatement st = conn.prepareStatement(sql);

			st.setString(1, nome);
			st.setDouble(2, nota);
			st.setInt(3, ano);
			st.setInt(4, id);

			st.execute();

			conn.close();
			st.close();

		} catch (Exception e) {
			System.out.println("Erro na alteracao: " + e);
		}

		return "redirect:entrada?acao=ListaFilmes";

	}

}
