package br.com.batista.cinema.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.batista.cinema.database.DatabaseConnection;

public class AlteraFilme implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer paramId = Integer.parseInt(request.getParameter("id"));
		String paramNome = request.getParameter("nome");
		Double paramNota = Double.parseDouble(request.getParameter("nota"));
		Integer paramAno = Integer.parseInt(request.getParameter("ano"));
		
		String sql = "UPDATE filme SET nome = ?, nota = ?, ano = ? WHERE idFilme = ?";

		try {

			Connection con = DatabaseConnection.initializeDatabase();
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, paramNome);
			st.setDouble(2, paramNota);
			st.setInt(3, paramAno);
			st.setInt(4, paramId);

			st.execute();

		} catch (Exception e) {
			System.out.println("Erro no Update: " + e);
		}

		return "redirect:entrada?acao=ListaFilmes";

	}

}
