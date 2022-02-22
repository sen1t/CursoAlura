package conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestarInsercao {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		Connection con = connectionFactory.connexao();
		
		
		Statement stm = con.createStatement();
		
		stm.execute(
				"INSERT INTO tbcliente (CPF,NOME,ENDERECO1,ENDERECO2,BAIRRO,CIDADE,ESTADO,CEP,DATA_NASCIMENTO,IDADE,SEXO,LIMITE_CREDITO,VOLUME_COMPRA,PRIMEIRA_COMPRA) VALUES "
				+ "('02883918548','Gabriel Siqueira','R. D','','Soledade','Aracaju','SE','49089153','1996-08-17',26,'M',715000,95000,1)"		
				);
		
		
	}

}
