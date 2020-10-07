package br.com.batista.cinema.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserDatabaseConnection {
	public static Connection initializeDatabase() throws SQLException, ClassNotFoundException {

		String dbDriver = "com.mysql.cj.jdbc.Driver";
		String dbURL = "jdbc:mysql://localhost/usersCrudCinema?useTimezone=true&serverTimezone=UTC";

		String dbUsername = "root";
		String dbPassword = "batista";

		Class.forName(dbDriver);
		Connection con = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
		return con;
	}
}
