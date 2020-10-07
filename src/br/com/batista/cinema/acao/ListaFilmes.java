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
import javax.servlet.http.HttpSession;

import br.com.batista.cinema.database.DatabaseConnection;
import br.com.batista.cinema.database.FilmeDAO;
import br.com.batista.cinema.model.Filme;

public class ListaFilmes implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		if (session.getAttribute("usuarioLogado") == null) {
			return "redirect:entrada?acao=FormularioLogin";
		}

		List<Filme> filmes = new ArrayList<>();

		try {
			
			Connection con = DatabaseConnection.initializeDatabase();

			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM filme;";
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
			
			rs.close();
			stmt.close();
			con.close();
			
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();

		} 

		request.setAttribute("filmes", filmes);
		return "forward:listaFilmes.jsp";

	}

}
