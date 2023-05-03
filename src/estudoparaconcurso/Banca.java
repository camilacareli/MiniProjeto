package estudoparaconcurso;

import java.util.ArrayList;

public class Banca {
	private String nomeFantasia;
	private ArrayList<AdministradorBanca> administradorBanca;
	

	

	public Banca(String nomeFantasia, ArrayList<AdministradorBanca> administradorBanca) {
		super();
		this.nomeFantasia = nomeFantasia;
		this.administradorBanca = administradorBanca;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public ArrayList<AdministradorBanca> getAdministradorBanca() {
		return administradorBanca;
	}

	public void setAdministradorBanca(ArrayList<AdministradorBanca> administradorBanca) {
		this.administradorBanca = administradorBanca;
	}



}
