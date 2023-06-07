package model;

import java.util.ArrayList;

public class Main {
	static Edital e;
	static Questao q;
	static QuestaoMultiplaEscolha qm;
	static QuestaoDissertativa qd;
	static ArrayList<Questao> prova;
	

	
	
	public static void main(String[] args) {
		e = new Edital("Banco do Brasil", "chegar no horario e levar caneta preta", 100.00 , 
				"20/07/2023", "20/06/2023", prova);
		
		char meuChar = 'A';
		char falsoChar = 'B';
		qm = new QuestaoMultiplaEscolha("Questao 1", 10, meuChar, falsoChar);
		qd = new QuestaoDissertativa("Questao 2", 20, "Minha Redacao");
		
		
		System.out.println(e.toString());
		System.out.println(qm.toString());
		System.out.println(qd.toString());
		
	
	}

}
