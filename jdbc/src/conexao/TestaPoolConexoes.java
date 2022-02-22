package conexao;

import java.sql.SQLException;
import java.util.Iterator;

public class TestaPoolConexoes {

	public static void main(String[] args) throws SQLException {
		 
		ConnectionFactory conn = new ConnectionFactory();
		
		for (int i = 0; i < 20; i++) {
			conn.connexao();
			System.out.println("Conexão de numero: "  + i); 
		}
		
	
		
		
	}

}
