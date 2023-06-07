package model;

public class QuestaoDissertativa extends Questao {
	private String redacao;

	public QuestaoDissertativa(String questaoMateria, int pontuacaoQuestao, String redacao) {
		super(questaoMateria, pontuacaoQuestao);
		this.redacao = redacao;
	}

	public String getRedacao() {
		return redacao;
	}

	public void setRedacao(String redacao) {
		this.redacao = redacao;
	}

	@Override
	public String toString() {
		return "QuestaoDissertativa: [Redacao= " + redacao + "]";
	}

	
	
}
