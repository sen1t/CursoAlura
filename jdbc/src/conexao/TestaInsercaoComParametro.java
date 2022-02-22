package conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		try (Connection con = connectionFactory.connexao()) {
			con.setAutoCommit(false);

			try (PreparedStatement stm = con.prepareStatement(
					"INSERT INTO tbusuario (nome, endereco, senha) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS)) {

				adicionarVariavel("Siqueira", "rua das ortas socorro", "85454", stm);
				adicionarVariavel("Joao", "rua quartoze aracaju", "15877", stm);
				adicionarVariavel("Gabriel", "rua das ortas 37 bugio", "63125", stm);
				adicionarVariavel("joaquina", "rua 2, 32 soledade", "74125", stm);

				con.commit(); // Só execulta a string sql se todas os comandos 'funcionarem'

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ROLLBACK EXECULTADO");
				con.rollback();
			}
		}

	}

	private static void adicionarVariavel(String nome, String endereco, String senha, PreparedStatement stm)
			throws SQLException {

		stm.setString(1, nome);
		stm.setString(2, endereco);
		stm.setString(3, senha);

		stm.execute();

		try (ResultSet rst = stm.getGeneratedKeys()) {
			while (rst.next()) {
				System.out.println("O Id gerado foi " + rst.getInt(1));
			}
		}

	}

}
