package model;

import java.util.ArrayList;

public class Edital {
	private String nomeConcurso;
	private String regrasProva;
	private Double taxaInscricao;
	private String dataConcurso;
	private String dataFechamento;
	private ArrayList<Questao> prova;
	
	
	//construtores
	public Edital(String nomeConcurso, String regrasProva, Double taxaInscricao, String dataConcurso,
			String dataFechamento, ArrayList<Questao> prova) {
		super();
		this.nomeConcurso = nomeConcurso;
		this.regrasProva = regrasProva;
		this.taxaInscricao = taxaInscricao;
		this.dataConcurso = dataConcurso;
		this.dataFechamento = dataFechamento;
		this.prova = prova;
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


	public Double getTaxaInscricao() {
		return taxaInscricao;
	}


	public void setTaxaInscricao(Double taxaInscricao) {
		this.taxaInscricao = taxaInscricao;
	}


	public String getDataConcurso() {
		return dataConcurso;
	}


	public void setDataConcurso(String dataConcurso) {
		this.dataConcurso = dataConcurso;
	}


	public String getDataFechamento() {
		return dataFechamento;
	}


	public void setDataFechamento(String dataFechamento) {
		this.dataFechamento = dataFechamento;
	}


	public ArrayList<Questao> getProva() {
		return prova;
	}


	public void setProva(ArrayList<Questao> prova) {
		this.prova = prova;
	}


	@Override
	public String toString() {
		return "Nome Concurso: " + nomeConcurso + ", RegrasProva: " + regrasProva + ", Taxa Inscricao: "
				+ taxaInscricao + ", Data do Concurso: " 
				+ dataConcurso + ", Data do Fechamento das inscricoes: " + dataFechamento + ", Prova: "
				+ prova;
	}


	
	
		
}
