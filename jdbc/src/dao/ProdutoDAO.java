package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Produto;

public class ProdutoDAO {

	private Connection connection;

	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}

	public void salvar(Produto produto) throws SQLException {
		String insert = "INSERT INTO tb_produtos (nome, descricao) values(?,?)";
		try (PreparedStatement pstm = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS)) {

			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getDescricao());
			pstm.execute();

			try (ResultSet result = pstm.getGeneratedKeys()) {
				while (result.next()) {
					produto.setId(result.getInt(1));
				}
			}
		}

		System.out.println("O produto adicionado foi " + produto);
	}

	public List<Produto> listar() throws SQLException {
		List<Produto> produtos = new ArrayList<>();
		String query = "SELECT * FROM tb_produtos";

		try (PreparedStatement pstm = connection.prepareStatement(query)) {
			pstm.execute();
			try (ResultSet result = pstm.getResultSet()) {
				while (result.next()) {
					produtos.add(
							new Produto(result.getInt("id"), result.getString("nome"), result.getString("descricao")));
				}
			}
		}

		return produtos;
	}
	
	public void excluir(Produto produto) throws SQLException {
		
		String delete = "DELETE FROM tb_produtos WHERE id = ?";
		
		try( PreparedStatement pstm = connection.prepareStatement(delete)){
			pstm.setInt(1, produto.getId());
			pstm.execute();
			System.out.println(pstm.getUpdateCount());
		}
	}
	
	public void editar(Produto produto, String nome, String desc) throws SQLException {
		  String update = "UPDATE tb_produtos SET nome = ? , descricao = ? WHERE id = ?";
		  try( PreparedStatement pstm = connection.prepareStatement(update)){
			   pstm.setString(1, nome);
			   pstm.setString(2, desc);
			   pstm.setInt(3, produto.getId());
			   pstm.execute();
			   if(pstm.getUpdateCount() > 0) {
				   System.out.println("A operação foi realizada com sucesso " + pstm.getUpdateCount() +" Linhas Foram Afetadas!!");
			   }else {
				   System.out.println("Ihhhhhhhhhhhhhhhhhhhhhhhhhhhhhh tem algo errado ai irmao");
			   }
			   
		  }
		  
	}
	
	
	
	
	
	
	
	
	

}
