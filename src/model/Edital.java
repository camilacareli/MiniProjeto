package model;





public class Edital {
	private String nomeConcurso;
	private String regrasProva;
	private String taxaInscricao;
	private String dataFechamento;
	private String dataConcurso;
	
	


	//construtores
	public Edital(String nomeConcurso, String regrasProva, String taxaInscricao,
			String dataFechamento, String dataConcurso) {
		super();
		this.nomeConcurso = nomeConcurso;
		this.regrasProva = regrasProva;
		this.taxaInscricao = taxaInscricao;
		this.dataFechamento = dataFechamento;
		this.dataConcurso = dataConcurso;
	}


	public String getNomeConcurso() {
		return nomeConcurso;
	}


	public void setNomeConcurso(String nomeConcurso) {
		this.nomeConcurso = nomeConcurso;
	}


	public String getRegrasProva() {
		return regrasProva;
	}


	public void setRegrasProva(String regrasProva) {
		this.regrasProva = regrasProva;
	}


	public String getTaxaInscricao() {
		return taxaInscricao;
	}


	public void setTaxaInscricao(String taxaInscricao) {
		this.taxaInscricao = taxaInscricao;
	}


	public String getDataFechamento() {
		return dataFechamento;
	}


	public void setDataFechamento(String dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

public String getDataConcurso() {
		return dataConcurso;
	}


	public void setDataConcurso(String dataConcurso) {
		this.dataConcurso = dataConcurso;
	}

	
	


	@Override
	public String toString() {
		return "Nome Concurso: " + nomeConcurso + "\nRegrasProva: " + regrasProva + "\nTaxa Inscricao: "
				+ taxaInscricao +  "\nData do Fechamento das inscricoes: " + dataFechamento 
				+ "\nData do Concurso: " + dataConcurso ;
	}


	
	
		
}
