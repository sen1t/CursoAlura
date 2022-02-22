package conexao;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		   
			ConnectionFactory conexao = new ConnectionFactory();
			Connection conn = conexao.connexao();
			conn.close();
	}
}
