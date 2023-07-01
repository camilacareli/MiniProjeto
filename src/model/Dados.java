package model;


import java.util.ArrayList;


public class Dados {
	private ArrayList<Edital> editais = new ArrayList<>();
	private ArrayList<QuestaoDissertativa> questoesDissertativa = new ArrayList<>();
	private ArrayList<QuestaoMultiplaEscolha> questoesMultiplaEscolha = new ArrayList<>();
	
	
	
	
	
	
	
	
	
	
	public Dados() {
		
		
		
		editais.add(new Edital("Banco do Brasil" , "chegar no horario e levar caneta preta", "100","30/09/2023" ,
				"30/10/2023"));
		editais.add(new Edital("Departamento Estadual de Trânsito","chegar no horario e levar caneta preta", "100.00", "05/05/2023",
				"05/09/2023" ));
		editais.add(new Edital("Caixa Econômica Federal", "chegar no horario e levar caneta preta", "100.0" , "05/08/2023" ,
				"09/10/2023"));
		editais.add(new Edital("Polícia Rodoviária Federal", "nao levar lapiz. borracha, celular", "120.00" , 
				"30/09/2023" , "30/10/2023" ));
		editais.add(new Edital("Departamento de Trânsito", "o candidato devara fazer pelo menos 50% da prova", 
				"150.00" , "05/08/2023", "07/012/2023"));
		editais.add(new Edital("Receita Federal", "levar caneta preta e lanche em algo transparente",
				"90.00" , "18/11/2023", "05/01/2024"));
		
		editais.add(new Edital("Polícia Federal", "chegar no horario e levar caneta preta", "160.00" , 
				"07/12/2023", "05/02/2024"));
		editais.add(new Edital("Câmaras dos Deputados", "chegar 30 minutos antes do horario final", "120.00" ,
				"22/08/2023", "25/09/2023"));
		editais.add(new Edital("Tribunal de Contas da União" , "chegar no horario e levar caneta preta", "160.00" , 
				"22/08/2023", "05/02/2024"));
		
		
		
		
		questoesDissertativa.add(new QuestaoDissertativa("Portugues", "Escreva sobre um dos Romantisas do seculo XIX", "Redacao 1"));
		questoesDissertativa.add(new QuestaoDissertativa("Direito Juridico", "Escreva o porquê de ler os nosso direitos", "Redacao 2"));
		
		
		
		
		
	    questoesMultiplaEscolha.add(new QuestaoMultiplaEscolha("PORTUGUÊS", "Qual a primeira letra do alfabeto?",  
	    		"A primeira letra do Alfabeto é A", "A primeira letra do alfabeto é B"));
		
	   
	    questoesMultiplaEscolha.add(new QuestaoMultiplaEscolha("MATEMÁTICA", "Quanto é 2+2x4?", "O valor é 10", "O valor é 16"));
	    
	    questoesMultiplaEscolha.add(new QuestaoMultiplaEscolha("ATUALIDADES", "Qual cantor(a) brasileiro(a) que chegou no top 1 com a musica envolve?", 
	    		"Anita", "Neymar"));
	    
	    questoesMultiplaEscolha.add(new QuestaoMultiplaEscolha("DIREITO CONSTITUCIONAL", "(CONSULPLAN - 2017 - Prefeitura de Sabará/MG - Advogado) - Constitui um dos objetivos da"
	    		+ " República Federativa do Brasil:" , "Garantia do desenvolvimento nacional" , "Independência nacional"));
	  
	}		
		
		
	
	
	
	
	
	
	public ArrayList<Edital> getEditais() {
		return editais;
	}


	public void setEditais(ArrayList<Edital> editais) {
		this.editais = editais;
	}


	public ArrayList<QuestaoDissertativa> getQuestoesDissertativa() {
		return questoesDissertativa;
	}

	public void setQuestoesDissertativa(ArrayList<QuestaoDissertativa> questoesDissertativa) {
		this.questoesDissertativa = questoesDissertativa;
	}

	public ArrayList<QuestaoMultiplaEscolha> getQuestoesMultiplaEscolha() {
		return questoesMultiplaEscolha;
	}


	public void setQuestoesMultiplaEscolha(ArrayList<QuestaoMultiplaEscolha> questoesMultiplaEscolha) {
		this.questoesMultiplaEscolha = questoesMultiplaEscolha;
	}


	




	
	public static ArrayList<Edital> getTodosEditais() {
		ArrayList<Edital> todosEditais = new ArrayList<> ();
		return todosEditais;
		
		
	}
	
	public ArrayList<QuestaoDissertativa> getTodasQuestoesDissertativas(){
		ArrayList<QuestaoDissertativa> todasQuestoesDissertativas = new ArrayList<QuestaoDissertativa>();
		todasQuestoesDissertativas.addAll(questoesDissertativa);
		return todasQuestoesDissertativas;
		
		
		
		
	}
	
	public static ArrayList<QuestaoMultiplaEscolha> getTodasQuestoesMultiplaEscolha(){
		ArrayList<QuestaoMultiplaEscolha> todasQuestoesMultiplaEscolha = new ArrayList<QuestaoMultiplaEscolha>();
		return todasQuestoesMultiplaEscolha;
	}

	
	
	
	//Edital
	public Edital pesquisarPorData(String dataDigitada) {
		for (Edital edital : editais) {
			
			if(dataDigitada.equals(edital.getDataFechamento())) {
				return edital;
			}				
		}
			
		
	
		return null;
	}	
	 
	public  void criarEdital(String nomeConcurso, String regras, String taxaInscricao, String dataConcurso,
			String dataFechamento){
			editais.add(new Edital(nomeConcurso, regras, taxaInscricao ,dataConcurso, dataFechamento));	
	
		
		
		  
	 }




	public boolean excluirEdital(int indice) {
	    ArrayList<Edital> editais = getEditais();

	    // Verifica se o índice está dentro dos limites do ArrayList
	    if (indice >= 0 && indice < editais.size()) {
	        editais.remove(indice);
	        
	        return true; // Exclusão bem-sucedida
	    } else {
	        return false; // Índice inválido, não é possível excluir o edital
	    }
	}



	



	public Edital leituraEdital(String selectedEdital) {
		for (Edital edital: editais) {
			if(selectedEdital.contains(edital.getNomeConcurso())) {
				return edital;
			}
		}
		return null;
	}

	public boolean atualizarEdital(int indice, Edital editalAtualizado) {
	    ArrayList<Edital> editais = getEditais();

	    // Verifica se o índice está dentro dos limites do ArrayList
	    if (indice >= 0 && indice < editais.size()) {
	        // Atualiza o edital no índice especificado
	        editais.set(indice, editalAtualizado);

	        return true; // Atualização bem-sucedida
	    } else {
	        return false; // Índice inválido, não é possível atualizar o edital
	    }
	}


             //Questao multipla Escolha
	public boolean excluirQuestaoME(int indice) {
	    ArrayList<QuestaoMultiplaEscolha> questoesMultiplaEscolha = getQuestoesMultiplaEscolha();

	    // Verifica se o índice está dentro dos limites do ArrayList
	    if (indice >= 0 && indice < questoesMultiplaEscolha.size()) {
	        questoesMultiplaEscolha.remove(indice);
	        return true; // Exclusão bem-sucedida
	    } else {
	        return false; // Índice inválido, não é possível excluir o edital
	    }
	}

	public boolean atualizarQuestaoME(int indice, QuestaoMultiplaEscolha questaoMEAtualizado) {
		 ArrayList<QuestaoMultiplaEscolha> questoesMultiplaEscolha = getQuestoesMultiplaEscolha();

		    // Verifica se o índice está dentro dos limites do ArrayList
		    if (indice >= 0 && indice < questoesMultiplaEscolha.size()) {
		        // Atualiza a questão no índice especificado
		        questoesMultiplaEscolha.set(indice, questaoMEAtualizado);

		        return true; // Atualização bem-sucedida
		    } else {
		        return false; // Índice inválido, não é possível atualizar a questão
		    }
		}
	
	public String lerQuestaoME(String selectedQuestaoMultiplaEscolha) {
	    for (QuestaoMultiplaEscolha questaoME : questoesMultiplaEscolha) {
	        if (selectedQuestaoMultiplaEscolha.contains(questaoME.getPerguntaQuestão())) {
	            return questaoME.toString();
	        }
	    }
	    return null;
	}
	
	public  void cadastrarQuestaoME(String questaoMateria, String perguntaQuestao, String escolhaVerdadeira, String escolhaFalsa){
			questoesMultiplaEscolha.add(new QuestaoMultiplaEscolha(questaoMateria, perguntaQuestao, escolhaVerdadeira , escolhaFalsa));	
	  
	 }
	
	
	
	
	public ArrayList<String> listarMaterias() {
	    ArrayList<String> materias = new ArrayList<>();
	    
	    // Percorre todas as questões cadastradas
	    for (QuestaoMultiplaEscolha questaoME : questoesMultiplaEscolha) {
	        String materia = questaoME.getQuestaoMateria();
	        if (!materias.contains(materia)) {
	            materias.add(materia);
	        }
	    }
	    
	    return materias;
	}
	

	public ArrayList<QuestaoMultiplaEscolha> buscarMateriaME(String selectedMateria) {
	    ArrayList<QuestaoMultiplaEscolha> questoesFiltradas = new ArrayList<>();
	    for (QuestaoMultiplaEscolha questaoME : questoesMultiplaEscolha) {
	        if (selectedMateria.equals(questaoME.getQuestaoMateria())) {
	            questoesFiltradas.add(questaoME);
	        }
	    }
	    return questoesFiltradas;
	}
	
	
	}






	
	
	
	
	

