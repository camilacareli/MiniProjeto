package estudoparaconcurso;

import java.util.ArrayList;

public class Prova {
	private String tipoDiscursiva;
	private ArrayList<Questao> tipoMultiplaescolha;
	
	
	public Prova(String tipoDiscursiva, ArrayList<Questao> tipoMultiplaescolha) {
		super();
		this.tipoDiscursiva = tipoDiscursiva;
		this.tipoMultiplaescolha = tipoMultiplaescolha;
	}
	public String getTipoDiscursiva() {
		return tipoDiscursiva;
	}
	public void setTipoDiscursiva(String tipoDiscursiva) {
		this.tipoDiscursiva = tipoDiscursiva;
	}
	
	public Prova (String tipoDiscursiva) {
		this.tipoDiscursiva = tipoDiscursiva;
		this.tipoMultiplaescolha = new ArrayList<Questao>();
	
	}
	
	public ArrayList<Questao> getTipoMultiplaescolha() {
		return tipoMultiplaescolha;
	}
	public void setTipoMultiplaescolha(ArrayList<Questao> tipoMultiplaescolha) {
		this.tipoMultiplaescolha = tipoMultiplaescolha;
	}
	
	
}
