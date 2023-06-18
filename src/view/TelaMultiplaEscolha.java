package view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TelaMultiplaEscolha extends JFrame {
    private JList<String> listaQuestoes;
    private DefaultListModel<String> questoesModel;
    private JButton excluirButton;
    private JButton responderButton;
    private JButton buscarMateriaButton;
    private JComboBox<String> materiaFiltroComboBox;
    private List<String> questoesFiltradas; // Lista de questões filtradas

    public TelaMultiplaEscolha() {
        setTitle("Estudo para Concurso | MULTIPLA ESCOLHA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new GridLayout(2, 2));
        
     // Painel 1
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.MAGENTA); // Define o fundo verde

        JLabel tituloPanel1 = new JLabel("Lista de Questões");
        tituloPanel1.setHorizontalAlignment(SwingConstants.CENTER); // Centraliza o título
        tituloPanel1.setForeground(Color.WHITE); // Define a cor do texto como branco


        panel1.setLayout(new BorderLayout());
        panel1.add(tituloPanel1, BorderLayout.NORTH);

        questoesModel = new DefaultListModel<>();
        listaQuestoes = new JList<>(questoesModel);
        JScrollPane questoesScrollPane = new JScrollPane(listaQuestoes);
        panel1.add(questoesScrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout()); // Painel para os botões Excluir, Responder Questão e Buscar por Matéria
        excluirButton = new JButton("Excluir");
        responderButton = new JButton("Responder Questão");
        buscarMateriaButton = new JButton("Buscar por Matéria");

        // ComboBox para selecionar a matéria para filtrar as questões
        materiaFiltroComboBox = new JComboBox<>();
        materiaFiltroComboBox.addItem("Todas as Matérias");
        materiaFiltroComboBox.addItem("PORTUGUÊS");
        materiaFiltroComboBox.addItem("MATEMÁTICA");
        materiaFiltroComboBox.addItem("DIREITO CONSTITUCIONAL");
        materiaFiltroComboBox.addItem("ATUALIDADES");

        buttonPanel.add(excluirButton);
        buttonPanel.add(responderButton);
        buttonPanel.add(buscarMateriaButton);
        buttonPanel.add(materiaFiltroComboBox);
        panel1.add(buttonPanel, BorderLayout.SOUTH);

        add(panel1);

        // Painel 3
        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.PINK); // Define o fundo verde

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
        JTextField alternativaATextField = new JTextField();
        JTextField alternativaBTextField = new JTextField();
        JTextField alternativaCTextField = new JTextField();
        JTextField alternativaDTextField = new JTextField();
        JLabel materiaLabel = new JLabel("Matéria:");
        JComboBox<String> materiaComboBox = new JComboBox<>();
        materiaComboBox.addItem("PORTUGUÊS");
        materiaComboBox.addItem("MATEMÁTICA");
        materiaComboBox.addItem("DIREITO CONSTITUCIONAL");
        materiaComboBox.addItem("ATUALIDADES");
        JLabel corretaLabel = new JLabel("Alternativa correta:");
        JComboBox<String> corretaComboBox = new JComboBox<>();
        corretaComboBox.addItem("A");
        corretaComboBox.addItem("B");
        corretaComboBox.addItem("C");
        corretaComboBox.addItem("D");
        JLabel cadastrarLabel = new JLabel();
        JButton cadastrarButton = new JButton("Cadastrar");

        questaoInputPanel.add(questaoLabel);
        questaoInputPanel.add(questaoTextArea);
        questaoInputPanel.add(alternativasLabel);
        questaoInputPanel.add(new JLabel()); // Espaço vazio para alinhar com o campo de texto
        questaoInputPanel.add(new JLabel("A)"));
        questaoInputPanel.add(alternativaATextField);
        questaoInputPanel.add(new JLabel("B)"));
        questaoInputPanel.add(alternativaBTextField);
        questaoInputPanel.add(new JLabel("C)"));
        questaoInputPanel.add(alternativaCTextField);
        questaoInputPanel.add(new JLabel("D)"));
        questaoInputPanel.add(alternativaDTextField);
        questaoInputPanel.add(materiaLabel);
        questaoInputPanel.add(materiaComboBox);
        questaoInputPanel.add(corretaLabel);
        questaoInputPanel.add(corretaComboBox);
        questaoInputPanel.add(cadastrarLabel);
        questaoInputPanel.add(cadastrarButton);

        panel3.add(questaoInputPanel, BorderLayout.CENTER);

        add(panel3);

        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = listaQuestoes.getSelectedIndex();
                if (selectedIndex != -1) {
                    questoesModel.remove(selectedIndex);
                }
            }
        });

        responderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = listaQuestoes.getSelectedIndex();
                if (selectedIndex != -1) {
                    String selectedQuestion = questoesModel.getElementAt(selectedIndex);

                    // Exibe a questão selecionada em um diálogo de mensagem
                    JOptionPane.showMessageDialog(null, selectedQuestion, "Questão Selecionada", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        buscarMateriaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedMateria = (String) materiaFiltroComboBox.getSelectedItem();

                // Filtra as questões com base na matéria selecionada
                DefaultListModel<String> filteredModel = new DefaultListModel<>();
                for (int i = 0; i < questoesModel.size(); i++) {
                    String questao = questoesModel.getElementAt(i);
                    if (selectedMateria.equals("Todas as Matérias")) {
                        filteredModel.addElement(questao);
                    } else if (questao.contains("Matéria: " + selectedMateria)) {
                        filteredModel.addElement(questao);
                    }
                }

                // Atualiza o modelo da lista de questões com as questões filtradas
                listaQuestoes.setModel(filteredModel);
            }
        });


        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Código para cadastrar a questão
                String questao = questaoTextArea.getText();
                String alternativaA = alternativaATextField.getText();
                String alternativaB = alternativaBTextField.getText();
                String alternativaC = alternativaCTextField.getText();
                String alternativaD = alternativaDTextField.getText();
                String materia = (String) materiaComboBox.getSelectedItem();
                String correta = (String) corretaComboBox.getSelectedItem();

                // Adiciona a questão ao modelo da lista
                questoesModel.addElement(questao + "\n" +
                        "A) " + alternativaA + "\n" +
                        "B) " + alternativaB + "\n" +
                        "C) " + alternativaC + "\n" +
                        "D) " + alternativaD + "\n" +
                        "Matéria: " + materia + "\n" +
                        "Correta: " + correta);

                // Limpa os campos de entrada
                questaoTextArea.setText("");
                alternativaATextField.setText("");
                alternativaBTextField.setText("");
                alternativaCTextField.setText("");
                alternativaDTextField.setText("");
                materiaComboBox.setSelectedIndex(0);
                corretaComboBox.setSelectedIndex(0);
            }
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaMultiplaEscolha frame = new TelaMultiplaEscolha();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
