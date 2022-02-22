package crudUsuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	 public Connection conectar() throws SQLException {
		Connection connectionFactory = DriverManager
				.getConnection("jdbc:mysql://localhost/crudUsuario?useTimezone=true&serverTimezone=UTC", "root", "root");
		return connectionFactory;
	 }
}
