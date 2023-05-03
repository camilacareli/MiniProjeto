package estudoparaconcurso;

public class AdministradorBanca extends Pessoa {
	private int idAdmin;
	
	
public AdministradorBanca(String nome, String email, String senha, int idAdmin) {
		super(nome, email, senha);
		this.idAdmin = idAdmin;
	}
	public int getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
