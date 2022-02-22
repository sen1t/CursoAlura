package crudUsuario;

public class Usuario {
	private String nome;
	private String endereco;
	private String senha;
	
	public Usuario(String nome, String endereco, String senha) {
		this.nome = nome;
		this.endereco = endereco;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", endereco=" + endereco + ", senha=" + senha + "]";
	}
	
	

}
