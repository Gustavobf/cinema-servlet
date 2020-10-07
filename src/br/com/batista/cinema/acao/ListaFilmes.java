package br.com.batista.cinema.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.batista.cinema.database.CinemaDatabaseConnection;
import br.com.batista.cinema.model.Filme;

public class ListaFilmes implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Filme> filmes = new ArrayList<>();
		String sql = "SELECT * FROM filme;";

		try {

			Connection conn = CinemaDatabaseConnection.initializeDatabase();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Integer id = rs.getInt("idFilme");
				String nome = rs.getString("nome");
				Double nota = rs.getDouble("nota");
				Integer ano = rs.getInt("ano");
				Filme filme = new Filme(nome, nota, ano);
				filme.setId(id);
				filmes.add(filme);

			}

			conn.close();
			stmt.close();
			rs.close();

		} catch (SQLException | ClassNotFoundException se) {
			System.out.println("Erro na leitura de dados:" + se);
		}

		request.setAttribute("filmes", filmes);
		return "forward:listaFilmes.jsp";

	}

}
