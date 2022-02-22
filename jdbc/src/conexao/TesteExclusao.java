package conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteExclusao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();

		Connection con = connectionFactory.connexao();

		
		
		PreparedStatement stm = con.prepareStatement("DELETE FROM tbusuario");
		//stm.setInt(1, 23);
		stm.execute();
		System.out.println("Quantidade de linhas modificadas " + stm.getUpdateCount());

	}

}
