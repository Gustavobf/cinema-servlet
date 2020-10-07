package br.com.batista.cinema.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.batista.cinema.database.UserDatabaseConnection;
import br.com.batista.cinema.model.Usuario;

public class UsuarioDAO {

	public static List<Usuario> getAll() throws SQLException {

		List<Usuario> usuarios = new ArrayList<>();

		String sql = "SELECT * FROM usuario";

		try {

			Connection con = UserDatabaseConnection.initializeDatabase();

			PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			st.execute();

			try (ResultSet rs = st.getResultSet()) {
				while (rs.next()) {
					Integer idUsuario = rs.getInt("idUsuario");
					String login = rs.getString("login");
					String senha = rs.getString("senha");
					Usuario usuario = new Usuario(login, senha);
					usuario.setId(idUsuario);
					usuarios.add(usuario);
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return usuarios;
	}

	public static Usuario hasUser(String login, String senha) {

		try {
			List<Usuario> listaUsuarios = getAll();

			for (Usuario usuario : listaUsuarios) {
				if (usuario.equals(login, senha)) {
					return usuario;
				}
			}
		} catch (Exception e) {
			System.out.println("Erro na leitura de usuarios: " + e);
		}

		return null;
	}

}
