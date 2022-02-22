package conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestarListagem {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection conn = connectionFactory.connexao();
		
		Statement stm = conn.createStatement();
		stm.execute("SELECT * FROM tb_produtos");
		
		ResultSet result = stm.getResultSet();
		
		while(result.next()) {
			
			String id = result.getString("id");
			System.out.printf("%s\t", id);
			
			String nome = result.getString("NOME");
			System.out.print(nome);
			
			String descricao = result.getString("descricao");
			System.out.print(descricao);
			
			System.out.println();
			
		}
		
		conn.close();
	}
}
