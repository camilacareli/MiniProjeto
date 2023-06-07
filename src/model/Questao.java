package model;

public abstract class Questao {
	protected String questaoMateria;
	protected int pontuacaoQuestao;
	
	
	public Questao(String questaoMateria, int pontuacaoQuestao) {
		super();
		this.questaoMateria = questaoMateria;
		this.pontuacaoQuestao = pontuacaoQuestao;
	}

    //metodos
	public String getQuestaoMateria() {
		return questaoMateria;
	}


	public void setQuestaoMateria(String questaoMateria) {
		this.questaoMateria = questaoMateria;
	}


	public int getPontuacaoQuestao() {
		return pontuacaoQuestao;
	}


	public void setPontuacaoQuestao(int pontuacaoQuestao) {
		this.pontuacaoQuestao = pontuacaoQuestao;
	}

	@Override
	public String toString() {
		return "Questao [questaoMateria=" + questaoMateria + ", pontuacaoQuestao=" + pontuacaoQuestao + "]";
	}

	
	
	
}
