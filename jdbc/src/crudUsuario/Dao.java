package crudUsuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dao {

	private ConnectionFactory cf = new ConnectionFactory();
	private Connection con;

	public void insert(Usuario user) throws SQLException {

		con = cf.conectar();

		PreparedStatement stmt = con.prepareStatement("INSERT INTO tbusuario (nome, endereco, senha) VALUES(?,?,?)",
				Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1, user.getNome());
		stmt.setString(2, user.getEndereco());
		stmt.setString(3, user.getSenha());

		stmt.execute();

		ResultSet rst = stmt.getGeneratedKeys();

		while (rst.next()) {
			System.out.println("Usuario cadastrado com sucesso, ID: " + rst.getInt(1));
		}

		con.close();

	}

	public HashMap<Integer, Usuario> select() throws SQLException {

		HashMap<Integer, Usuario> resultado = new HashMap<Integer, Usuario>();
		con = cf.conectar();

		PreparedStatement stmt = con.prepareStatement("Select * from tbusuario");
		stmt.execute();
		ResultSet result = stmt.getResultSet();
		while (result.next()) {
			resultado.put(result.getInt("id"),
					new Usuario(result.getString("nome"), result.getString("endereco"), result.getString("senha")));

		}

		return resultado;

	}

}
