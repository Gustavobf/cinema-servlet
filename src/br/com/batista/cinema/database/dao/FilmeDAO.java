package br.com.batista.cinema.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.batista.cinema.database.CinemaDatabaseConnection;
import br.com.batista.cinema.model.Filme;

public class FilmeDAO {
	public static List<Filme> getAll() throws SQLException {

		List<Filme> filmes = new ArrayList<>();

		String sql = "SELECT * FROM filme";

		try {

			Connection con = CinemaDatabaseConnection.initializeDatabase();

			PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			st.execute();

			try (ResultSet rs = st.getResultSet()) {
				while (rs.next()) {
					Integer id = rs.getInt("idFilme");
					String nome = rs.getString("nome");
					Double nota = rs.getDouble("nota");
					Integer ano = rs.getInt("ano");
					Filme filme = new Filme(nome, nota, ano);
					filme.setId(id);
					filmes.add(filme);

				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return filmes;

	}
	
	public static Filme getById(int id) throws SQLException {

		String sql = "SELECT * FROM filme WHERE idFilme = ?";

		try {
			
			Connection con = CinemaDatabaseConnection.initializeDatabase();

			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, id);

			st.execute();

			try (ResultSet rst = st.getResultSet()) {
				while (rst.next()) {
					Integer idFilme = rst.getInt(1);
					if (idFilme == id) {
						Filme filme = new Filme(rst.getString(2), rst.getDouble(3), rst.getInt(4));
						filme.setId(id);
						return filme;
					} else {
						return null;
					}
				}
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}
	
}
