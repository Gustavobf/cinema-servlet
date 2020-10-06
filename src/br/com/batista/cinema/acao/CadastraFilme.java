package br.com.batista.cinema.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.batista.cinema.database.DatabaseConnection;

public class CadastraFilme implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Connection con = DatabaseConnection.initializeDatabase();

			PreparedStatement st = con.prepareStatement("INSERT INTO filme(nome, nota, ano) VALUES(?, ?, ?);");

			st.setString(1, request.getParameter("nome"));
			st.setDouble(2, Double.parseDouble(request.getParameter("nota")));
			st.setInt(3, Integer.parseInt(request.getParameter("ano")));

			st.executeUpdate();

			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:entrada?acao=ListaFilmes";

	}

}
