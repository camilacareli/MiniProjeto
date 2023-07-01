package view;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.Dados;
import model.QuestaoMultiplaEscolha;

public class TelaMultiplaEscolha extends JFrame {
	private static final long serialVersionUID = 1L;
	private JList<String> listaQuestoes;
    private DefaultListModel<String> questoesModel;
    private JButton excluirButton;
    private JButton atualizarButton;
    private JButton buscarMateriaButton;
    private JButton lerQuestaoButton; // Botão para ler a questão
    private JComboBox<String> materiaFiltroComboBox;
    private JTextField alternativaATextField = new JTextField();
    private JTextField alternativaBTextField = new JTextField();;
    @SuppressWarnings("unused")
	private Dados d;
    

    public TelaMultiplaEscolha(Dados d) {
    	this.d = d;
    	
        setTitle("Planejando Meu Futuro | MULTIPLA ESCOLHA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new GridLayout(2, 2));

        // Painel 1
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.MAGENTA); // Define o fundo magenta

        JLabel tituloPanel1 = new JLabel("Lista de Questões");
        tituloPanel1.setHorizontalAlignment(SwingConstants.CENTER); // Centraliza o título
        tituloPanel1.setForeground(Color.WHITE); // Define a cor do texto como branco

        panel1.setLayout(new BorderLayout());
        panel1.add(tituloPanel1, BorderLayout.NORTH);
        
        
        questoesModel = new DefaultListModel<>();
        for (QuestaoMultiplaEscolha questaoMultiplaEscolha : d.getQuestoesMultiplaEscolha()) {
        	 questoesModel.addElement( "Questão:" + "  " + questaoMultiplaEscolha.getPerguntaQuestão());
        }

       
        listaQuestoes = new JList<>(questoesModel);
        JScrollPane questoesScrollPane = new JScrollPane(listaQuestoes);
        panel1.add(questoesScrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout()); // Painel para os botões Excluir, Atualizar Questão e Buscar por Matéria
        excluirButton = new JButton("Excluir");
        atualizarButton = new JButton("Atualizar Questão");
        buscarMateriaButton = new JButton("Buscar por Matéria");
        lerQuestaoButton = new JButton("Ler Questão"); // Botão para ler a questão

        // ComboBox para selecionar a matéria para filtrar as questões
        materiaFiltroComboBox = new JComboBox<>();
        materiaFiltroComboBox.addItem("Todas as Matérias");
        materiaFiltroComboBox.addItem("PORTUGUÊS");
        materiaFiltroComboBox.addItem("MATEMÁTICA");
        materiaFiltroComboBox.addItem("DIREITO CONSTITUCIONAL");
        materiaFiltroComboBox.addItem("ATUALIDADES");
        

        buttonPanel.add(excluirButton);
        buttonPanel.add(atualizarButton);
        buttonPanel.add(buscarMateriaButton);
        buttonPanel.add(lerQuestaoButton); // Adiciona o botão "Ler Questão"
        buttonPanel.add(materiaFiltroComboBox);
        panel1.add(buttonPanel, BorderLayout.SOUTH);

        add(panel1);

        // Painel 3
        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.PINK); // Define o fundo rosa

        JLabel tituloPanel3 = new JLabel("Cadastro de Questões");
        tituloPanel3.setHorizontalAlignment(SwingConstants.CENTER); // Centraliza o título
        tituloPanel3.setForeground(Color.WHITE); // Define a cor do texto como branco

        panel3.setLayout(new BorderLayout());
        panel3.add(tituloPanel3, BorderLayout.NORTH);

        JPanel questaoInputPanel = new JPanel();
        questaoInputPanel.setLayout(new GridLayout(0, 2));

        JLabel questaoLabel = new JLabel("Questão:");
        JTextArea questaoTextArea = new JTextArea();
        JLabel alternativasLabel = new JLabel("Alternativas:");
       
        JLabel materiaLabel = new JLabel("Matéria:");
        JComboBox<String> materiaComboBox = new JComboBox<>();
        materiaComboBox.addItem("PORTUGUÊS");
        materiaComboBox.addItem("MATEMÁTICA");
        materiaComboBox.addItem("DIREITO CONSTITUCIONAL");
        materiaComboBox.addItem("ATUALIDADES");
        
 
       
        JLabel cadastrarLabel = new JLabel();
        JButton cadastrarButton = new JButton("Cadastrar");

        questaoInputPanel.add(questaoLabel);
        questaoInputPanel.add(questaoTextArea);
        questaoInputPanel.add(alternativasLabel);
        questaoInputPanel.add(new JLabel()); // Espaço vazio para alinhar com o campo de texto
        questaoInputPanel.add(new JLabel("Escolha verdadeira: "));
        questaoInputPanel.add(alternativaATextField);
        questaoInputPanel.add(new JLabel("Escolha falsa"));
        questaoInputPanel.add(alternativaBTextField);
       
        questaoInputPanel.add(materiaLabel);
        questaoInputPanel.add(materiaComboBox);
      
     
        questaoInputPanel.add(cadastrarLabel);
        questaoInputPanel.add(cadastrarButton);

        panel3.add(questaoInputPanel, BorderLayout.CENTER);

        add(panel3);
        
       //certo/ conectado com a dados 

        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	int selectedIndex = listaQuestoes.getSelectedIndex();
   	         if (selectedIndex != -1) {
   	             boolean res = d.excluirQuestaoME(selectedIndex);
   	             if (res) {
   	                 JOptionPane.showMessageDialog(null, "Edital removido com sucesso!");
                       listaQuestoes.updateUI();
   	                 // Atualizar a lista de editais após a remoção
                       DefaultListModel<String> questoesModel = (DefaultListModel<String>) listaQuestoes.getModel();
   	                 questoesModel.remove(selectedIndex);
   	                 listaQuestoes.setModel(questoesModel); // Atualizar o modelo da lista
   	             } else {
   	                 JOptionPane.showMessageDialog(null, "Erro ao remover o edital!");
   	             }
   	         } else {
   	             JOptionPane.showMessageDialog(null, "Selecione um edital para remover!");
   	         }
   	         
            }
        });
            
//conectado com Dados
        
        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	listaQuestoes.addListSelectionListener(new ListSelectionListener() {
            	    public void valueChanged(ListSelectionEvent e) {
            	        if (!e.getValueIsAdjusting()) {
            	            // Obtém o índice do edital selecionado
            	            int selectedIndex = listaQuestoes.getSelectedIndex();

            	            // Verifica se um edital foi selecionado
            	            if (selectedIndex != -1) {
            	                // Obtém o edital selecionado a partir do objeto Dados
            	                QuestaoMultiplaEscolha questaoMESelecionado = d.getQuestoesMultiplaEscolha().get(selectedIndex);
            	                
            	                
            	                // Preenche os campos de texto com os dados do edital
            	                questaoTextArea.setText(questaoMESelecionado.getPerguntaQuestão());
            	                alternativaATextField.setText(questaoMESelecionado.getEscolhaVerdadeira());
            	                alternativaBTextField.setText(questaoMESelecionado.getEscolhaFalsa());
            	                materiaComboBox.setSelectedItem(questaoMESelecionado.getQuestaoMateria());
            	               
            	                
            	            }
            	        }
            	    }
            	});	 
            
        
           }
        });

        
        
        //arrumar
        buscarMateriaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	ArrayList<String> materias = d.listarMaterias();

                // Preenche o JComboBox com as matérias
                for (String materia : materias) {
               	 materiaFiltroComboBox.addItem(materia);
                }


                // Percorre todas as questões cadastradas
                for (int i = 0; i < questoesModel.size(); i++) {
                    String questao = questoesModel.getElementAt(i);
                    String materia = getMateriaFromQuestao(questao);
                    if (!materias.contains(materia)) {
                        materias.add(materia);
                    }
                }
                

                if (materias.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nenhuma matéria encontrada.");
                } else {
                    // Exibe a lista de matérias em um JOptionPane
                    Object[] materiasArray = materias.toArray();
                    String selectedMateria = (String) JOptionPane.showInputDialog(null, "Selecione uma matéria:",
                            "Buscar por Matéria", JOptionPane.PLAIN_MESSAGE, null, materiasArray, materiasArray[0]);

                    listaQuestoes.updateUI();
                    if (selectedMateria != null) {
                        DefaultListModel<String> filteredModel = new DefaultListModel<>();
                        ArrayList<QuestaoMultiplaEscolha> questoesFiltradas = d.buscarMateriaME(selectedMateria);
                        for (QuestaoMultiplaEscolha questaoME : questoesFiltradas) {
                        	filteredModel.addElement(questaoME.toString());
                        
                        }
                        
                        
                        
                        // Filtra as questões com base na matéria selecionada
                        for (int i = 0; i < questoesModel.size(); i++) {
                            String questao = questoesModel.getElementAt(i);
                            String materia = getMateriaFromQuestao(questao);
                            if (selectedMateria.equals(materia)) {
                                filteredModel.addElement(questao);
                            }
                        }

                        // Atualiza o modelo da lista de questões com as questões filtradas
                        listaQuestoes.setModel(filteredModel);
                    }
                }
            }

            // Método auxiliar para extrair a matéria de uma questão
            private String getMateriaFromQuestao(String questao) {
                String[] lines = questao.split("\n");
                for (String line : lines) {
                    if (line.startsWith("Matéria:")) {
                        return line.substring(line.indexOf(":") + 1).trim();
                    }
                }
                return "";
            }
        });

        //certo
        lerQuestaoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 int selectedIndex = listaQuestoes.getSelectedIndex();
                 if (selectedIndex != -1) {
                     String selectedQuestion = (String) listaQuestoes.getModel().getElementAt(selectedIndex);

                     String questaoString = d.lerQuestaoME(selectedQuestion);
                     listaQuestoes.updateUI();

                     if (questaoString != null) {
                         JOptionPane.showMessageDialog(null, questaoString, "Questão", JOptionPane.PLAIN_MESSAGE);
                     } else {
                         JOptionPane.showMessageDialog(null, "Questão não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
                     }
                 }
             }
         });
        





        //certo/ conectado com a dados 
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String questao = questaoTextArea.getText();
                String alternativaA = alternativaATextField.getText();
                String alternativaB = alternativaBTextField.getText();
                
                String materia = (String) materiaComboBox.getSelectedItem(); 
                
                
                d.cadastrarQuestaoME(materia, questao, alternativaA, alternativaB);

                String novaQuestao = "Questão: " + questao + "    ";
                        
                        
                       
                       
                        

                questoesModel.addElement(novaQuestao);
                JOptionPane.showMessageDialog(null, "Questão cadastrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                // Limpar os campos de entrada após cadastrar a questão
                questaoTextArea.setText("");
                alternativaATextField.setText("");
                alternativaBTextField.setText("");
                
            }
        });

    }
    
    public  ArrayList<String[]> getQuestaoMultiplaEscolha() {
        ArrayList<String[]> QuestoesMultiplaEscolha = new ArrayList<>();
        ArrayList<QuestaoMultiplaEscolha> D = Dados.getTodasQuestoesMultiplaEscolha();
        
        for (int i=0; i<D.size();i++) {
        
        }
       
        return QuestoesMultiplaEscolha;
    }
    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	Dados dados = new Dados();
            	new TelaMultiplaEscolha(dados).setVisible(true);
            }
               
            
        });
    }
}
