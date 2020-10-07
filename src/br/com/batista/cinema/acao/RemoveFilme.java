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
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramId = request.getParameter("id");
		Integer id = Integer.parseInt(paramId);
		
		String sql = "DELETE FROM filme WHERE idFilme = ?";
		
		try {
			Connection con = CinemaDatabaseConnection.initializeDatabase();
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, id);

			st.execute();
			
		} catch (Exception e) {
			System.out.println(e);
		}

		return "redirect:entrada?acao=ListaFilmes";

	}

}
