package estudoparaconcurso;

import java.sql.Date;

public class Edital {
	private String nomeConcurso;
	private String regrasProva;
	private Double taxaInscricao;
	private Date dataConcurso;
	private Date dataFechamento;
	private Prova prova;
	private Banca banca;
	
	
		
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
	public Double getTaxaInscricao() {
		return taxaInscricao;
	}
	public void setTaxaInscricao(Double taxaInscricao) {
		this.taxaInscricao = taxaInscricao;
	}
	public Date getDataConcurso() {
		return dataConcurso;
	}
	public void setDataConcurso(Date dataConcurso) {
		this.dataConcurso = dataConcurso;
	}
	public Date getDataFechamento() {
		return dataFechamento;
	}
	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}
	public Prova getProva() {
		return prova;
	}
	public void setProva(Prova prova) {
		this.prova = prova;
	}
	public Banca getBanca() {
		return banca;
	}
	public void setBanca(Banca banca) {
		this.banca = banca;
	}
	
	
	
	public Edital(String nomeConcurso, String regrasProva, Double taxaInscricao, java.util.Date d1, java.util.Date d2,
			Prova prova, Banca banca) {
		super();
		this.nomeConcurso = nomeConcurso;
		this.regrasProva = regrasProva;
		this.taxaInscricao = taxaInscricao;
		this.dataConcurso = (Date) d1;
		this.dataFechamento = (Date) d2;
		this.prova = prova;
		this.banca = banca;
	}

}
