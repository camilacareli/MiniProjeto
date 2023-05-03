package estudoparaconcurso;

import java.util.ArrayList;

public class Questao {
	private String questaoMateria;
	private ArrayList<String> alternativas;
	
	public Questao (String questaoMateria, ArrayList<String> alternativas) {
		this.questaoMateria = questaoMateria;
		this.alternativas = new ArrayList<String>();
	}
	
	public String getQuestaoMateria() {
		return questaoMateria;
	}
	public void setQuestaoMateria(String questaoMateria) {
		this.questaoMateria = questaoMateria;
	}
	public ArrayList<String> getAlternativas() {
		return alternativas;
	}
	public void setAlternativas(ArrayList<String> alternativas) {
		this.alternativas = alternativas;
	}
	
	
}
