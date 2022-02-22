package conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.ProdutoDAO;
import modelo.Produto;

public class TestaInsercaoListagemComProduto {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory cf = new ConnectionFactory();

		try(Connection conn = cf.connexao()){
			ProdutoDAO testePersistencia = new ProdutoDAO(conn);
			//testePersistencia.salvar(new Produto("Bicicleta monark", "aro 26 18 marchas"));
			Produto p1 = testePersistencia.listar().stream().filter(c -> c.getId() == 4).findAny().get();
			Produto p2 = testePersistencia.listar().stream().filter(c -> c.getId() == 7).findAny().get();
			testePersistencia.excluir(p1);
			//testePersistencia.listar().forEach(c -> System.out.println(c));
			
			//testePersistencia.editar(p1, "Dinossauro falante", "120 metros");
			
			
			
			testePersistencia.listar().forEach(c -> System.out.println(c));
			
			
		}
	}
}
