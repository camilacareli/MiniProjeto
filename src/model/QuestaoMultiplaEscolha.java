package model;

public class QuestaoMultiplaEscolha extends Questao {
	private char escolhaVerdadeira;
	private char escolhaFalsa;
	
	
	
	public QuestaoMultiplaEscolha(String questaoMateria, int pontuacaoQuestao, char escolhaVerdadeira, char escolhaFalsa) {
		super(questaoMateria, pontuacaoQuestao);
		this.escolhaVerdadeira = escolhaVerdadeira;
		this.escolhaFalsa = escolhaFalsa;
	}


	

	public char getEscolhaVerdadeira() {
		return escolhaVerdadeira;
	}

	public void setEscolha(char escolhaVerdadeira) {
		this.escolhaVerdadeira = escolhaVerdadeira;
	}


	public char getEscolhaFalsa() {
		return escolhaFalsa;
	}




	public void setEscolhaFalsa(char escolhaFalsa) {
		this.escolhaFalsa = escolhaFalsa;
	}




	@Override
	public String toString() {
		return "QuestaoMultiplaEscolha: [Escolha Verdadeira= " + escolhaVerdadeira + ", Escolha Falsa= " + escolhaFalsa
				+ "]";
	}




	

	

}
