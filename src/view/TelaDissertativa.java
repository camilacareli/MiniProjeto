package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaDissertativa extends JFrame {
    private DefaultListModel<String> redacoesListModel;
    private JList<String> redacoesList;
    private JTextArea leituraTextArea;
    private JTextField temaTextField;
    private JTextArea redacaoTextArea;
    
    public TelaDissertativa() {
        // Configurações básicas do JFrame
        setTitle("Planejando Meu Futuro | DISSERTATIVAS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setLayout(new GridLayout(1,3));
        
        // Criação dos painéis
        JPanel painel1 = criarPainel1();
        JPanel painel2 = criarPainel2();
        JPanel painel3 = criarPainel3();
        
        // Adiciona os painéis ao JFrame
        add(painel1, BorderLayout.WEST);
        add(painel2, BorderLayout.CENTER);
        add(painel3, BorderLayout.EAST);
    }
    
    private JPanel criarPainel1() {
        JPanel painel1 = new JPanel(new BorderLayout());
        
     // Cria um painel para o título
        JPanel tituloPanel = new JPanel();
        tituloPanel.setBackground(new Color(173, 216, 230)); // Define o fundo azul claro do painel
        JLabel tituloLabel = new JLabel("Lista de redações por tema");
        tituloLabel.setForeground(Color.WHITE); // Define o texto branco
        tituloPanel.add(tituloLabel);


        
        // Cria uma lista de redações usando um DefaultListModel
        redacoesListModel = new DefaultListModel<>();
        redacoesListModel.addElement("Redação 1 - POLITICA");
        redacoesListModel.addElement("Redação 2 - SAUDE");
        redacoesListModel.addElement("Redação 3 - POLITICA");
        redacoesListModel.addElement("Redação 4 - EDUCAÇÃO");
        redacoesListModel.addElement("Redação 5 - SAUDE");
        redacoesListModel.addElement("Redação 6 - POLITICA");
        redacoesListModel.addElement("Redação 7 - EDUCAÇÃO");
        redacoesListModel.addElement("Redação 8 - SAUDE");
        redacoesListModel.addElement("Redação 9 - EDUCAÇÃO");
        JList<String> redacoesList = new JList<>(redacoesListModel);
        
        // Cria botões de excluir e ler redação
        JButton excluirButton = new JButton("Excluir redação");
        JButton lerButton = new JButton("Ler redação");
        
        // Adiciona os botões e a lista ao painel1
        JPanel botoesPanel = new JPanel();
        botoesPanel.add(excluirButton);
        botoesPanel.add(lerButton);
        
        painel1.add(tituloPanel, BorderLayout.NORTH);
        painel1.add(new JScrollPane(redacoesList), BorderLayout.CENTER);
        painel1.add(botoesPanel, BorderLayout.SOUTH);
        
        // Configura a ação do botão Excluir
        excluirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = redacoesList.getSelectedIndex();
                if (selectedIndex != -1) {
                    redacoesListModel.remove(selectedIndex);
                }
            }
        });
        
        // Configura a ação do botão Ler
        lerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String redacaoSelecionada = redacoesList.getSelectedValue();
                if (redacaoSelecionada != null) {
                    leituraTextArea.setText("Redação selecionada: " + redacaoSelecionada);
                }
            }
        });
        
        return painel1;
    }



    
    private JPanel criarPainel2() {
        JPanel painel2 = new JPanel(new BorderLayout());

     // Cria um painel para o título
        JPanel tituloPanel = new JPanel();
        tituloPanel.setBackground(new Color(255, 153, 153)); // Define o fundo verde escuro do painel
        JLabel tituloLabel = new JLabel("Campo de leitura");
        tituloLabel.setForeground(Color.WHITE); // Define o texto branco
        tituloPanel.add(tituloLabel);


        // Cria uma área de texto para exibir a leitura da redação
        leituraTextArea = new JTextArea();
        leituraTextArea.setEditable(false);

        // Configura o layout do painel2 com BorderLayout
        painel2.setLayout(new BorderLayout());

        // Adiciona o painel de título ao painel2
        painel2.add(tituloPanel, BorderLayout.NORTH);

        // Adiciona a área de texto ao painel2
        painel2.add(new JScrollPane(leituraTextArea), BorderLayout.CENTER);

        return painel2;
    }

    
    private JPanel criarPainel3() {
        JPanel painel3 = new JPanel(new BorderLayout());
        
     // Cria um painel para o título
        JPanel tituloPanel = new JPanel();
        tituloPanel.setBackground(new Color(72, 61, 139)); // Define o fundo roxo escuro do painel
        JLabel tituloLabel = new JLabel("Escreva sua redação:");
        tituloLabel.setForeground(Color.WHITE); // Define o texto branco
        tituloPanel.add(tituloLabel);

        
        // Cria um campo de texto para o tema da redação
        JPanel temaPanel = new JPanel(new BorderLayout());
        JLabel temaLabel = new JLabel("Tema: ");
        JTextField temaTextField = new JTextField();
        temaPanel.add(temaLabel, BorderLayout.WEST);
        temaPanel.add(temaTextField, BorderLayout.CENTER);
        
        // Cria um campo de texto maior para a redação
        JTextArea redacaoTextArea = new JTextArea();
        
        // Cria um JComboBox para a seleção do assunto
        JComboBox<String> assuntoComboBox = new JComboBox<>();
        assuntoComboBox.addItem("POLÍTICA");
        assuntoComboBox.addItem("SAÚDE");
        assuntoComboBox.addItem("EDUCAÇÃO");
        assuntoComboBox.addItem("TECNOLOGIA");
        
        // Configura o layout do painel3 com BorderLayout
        painel3.setLayout(new BorderLayout());
        
        // Adiciona o painel de título ao painel3
        painel3.add(tituloPanel, BorderLayout.NORTH);
        
        // Cria um painel para os campos de texto
        JPanel camposPanel = new JPanel(new BorderLayout());
        camposPanel.add(temaPanel, BorderLayout.NORTH);
        camposPanel.add(new JScrollPane(redacaoTextArea), BorderLayout.CENTER);
        camposPanel.add(assuntoComboBox, BorderLayout.SOUTH);
        
        // Adiciona o painel de campos de texto ao painel3
        painel3.add(camposPanel, BorderLayout.CENTER);
        
        // Cria um botão de cadastrar redação
        JButton cadastrarButton = new JButton("Cadastrar redação");
        
        // Adiciona o botão ao painel3
        painel3.add(cadastrarButton, BorderLayout.SOUTH);
        
        // Configura a ação do botão Cadastrar
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String tema = temaTextField.getText();
                String redacao = redacaoTextArea.getText();
                String assunto = (String) assuntoComboBox.getSelectedItem();
                if (!tema.isEmpty() && !redacao.isEmpty()) {
                    redacoesListModel.addElement(tema + " - " + assunto);
                    temaTextField.setText("");
                    redacaoTextArea.setText("");
                }
            }
        });
        
        return painel3;
    }


    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TelaDissertativa telaDissertativa = new TelaDissertativa();
                telaDissertativa.setVisible(true);
            }
        });
    }
}
