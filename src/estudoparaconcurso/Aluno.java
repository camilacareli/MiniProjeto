package estudoparaconcurso;

import java.util.ArrayList;

public class Aluno extends Pessoa {
	private int numeroMatricula;
	private ArrayList<Edital> edital;
	
	
	public Aluno(String nome, String email, String senha, int numeroMatricula) {
		super(nome, email, senha);
		this.numeroMatricula = numeroMatricula;
	}

	
	public int getNumeroMatricula() {
		return numeroMatricula;
	}

	public void setNumeroMatricula(int numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
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


	public ArrayList<Edital> getEdital() {
		return edital;
	}


	public void setEdital(ArrayList<Edital> edital) {
		this.edital = edital;
	}
	
		
}
