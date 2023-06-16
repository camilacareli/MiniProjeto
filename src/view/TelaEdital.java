package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.border.EmptyBorder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;



public class TelaEdital extends JFrame {
    private JPanel painel1;
    private JPanel painel2;
    private JPanel painel3;
    private JPanel painel4;
    private JList<String> listaEditais;
    private DefaultListModel<String> modelEditais;
    private JList<String> listaPrioridade;
    private DefaultListModel<String> modelPrioridade;
    private JTextField txtNomeConcurso;
    private JTextField txtRegrasProva;
    private JTextField txtTaxaInscricao;
    private JTextField txtDataConcurso;
    private JTextField txtDataFechamento;
    private JButton btnExcluirEdital;
    private JButton btnAdicionarPrioridade;
    private JButton btnRemoverPrioridade;
    private JButton btnAdicionarEdital;
    private JTextField txtDataAtual;
    private JButton btnBuscarEditais;

    public TelaEdital() {
        // Configurações básicas do JFrame
        setTitle("Estudo para Concurso | EDITAIS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 2));

        // Inicialização dos painéis
        painel1 = new JPanel(new BorderLayout());
        painel2 = new JPanel(new BorderLayout());
        painel3 = new JPanel(new BorderLayout());
        painel4 = new JPanel(new BorderLayout());
        
     // Títulos dos painéis
        JLabel tituloPainel1 = new JLabel("Editais Disponíveis");
        JLabel tituloPainel2 = new JLabel("Prioridade");
        JLabel tituloPainel3 = new JLabel("Adicionar Edital");
        JLabel tituloPainel4 = new JLabel("Buscar Editais");

        // Adicionando os títulos aos painéis
        painel1.add(tituloPainel1, BorderLayout.NORTH);
        painel2.add(tituloPainel2, BorderLayout.NORTH);
        painel3.add(tituloPainel3, BorderLayout.NORTH);
        painel4.add(tituloPainel4, BorderLayout.NORTH);
        
     // Cores para os fundos dos títulos
        Color corTituloPainel1 = Color.BLUE;
        Color corTituloPainel2 = Color.GREEN;
        Color corTituloPainel3 = Color.RED;
        Color corTituloPainel4 = Color.ORANGE;

        // Definindo as cores de fundo dos títulos
        tituloPainel1.setOpaque(true);
        tituloPainel1.setBackground(corTituloPainel1);
        tituloPainel2.setOpaque(true);
        tituloPainel2.setBackground(corTituloPainel2);
        tituloPainel3.setOpaque(true);
        tituloPainel3.setBackground(corTituloPainel3);
        tituloPainel4.setOpaque(true);
        tituloPainel4.setBackground(corTituloPainel4);
        
     // Configurando o alinhamento central dos títulos
        tituloPainel1.setHorizontalAlignment(SwingConstants.CENTER);
        tituloPainel2.setHorizontalAlignment(SwingConstants.CENTER);
        tituloPainel3.setHorizontalAlignment(SwingConstants.CENTER);
        tituloPainel4.setHorizontalAlignment(SwingConstants.CENTER);
        
     // Definindo o padding (espaçamento) dos títulos
        int padding = 7; // Defina o valor de espaçamento desejado
        tituloPainel1.setBorder(new EmptyBorder(padding, padding, padding, padding));
        tituloPainel2.setBorder(new EmptyBorder(padding, padding, padding, padding));
        tituloPainel3.setBorder(new EmptyBorder(padding, padding, padding, padding));
        tituloPainel4.setBorder(new EmptyBorder(padding, padding, padding, padding));
        
        // Definindo as cores de fundo e de letra dos títulos
        tituloPainel1.setOpaque(true);
        tituloPainel1.setBackground(corTituloPainel1);
        tituloPainel1.setForeground(Color.WHITE); // Cor da letra branca
        tituloPainel2.setOpaque(true);
        tituloPainel2.setBackground(corTituloPainel2);
        tituloPainel2.setForeground(Color.WHITE); // Cor da letra branca
        tituloPainel3.setOpaque(true);
        tituloPainel3.setBackground(corTituloPainel3);
        tituloPainel3.setForeground(Color.WHITE); // Cor da letra branca
        tituloPainel4.setOpaque(true);
        tituloPainel4.setBackground(corTituloPainel4);
        tituloPainel4.setForeground(Color.WHITE); // Cor da letra branca
        
     // Inicialização dos componentes do painel 1
        modelEditais = new DefaultListModel<>();

        listaEditais = new JList<>(modelEditais);
        JScrollPane scrollPane1 = new JScrollPane(listaEditais);
        painel1.add(scrollPane1, BorderLayout.CENTER);

        btnExcluirEdital = new JButton("Excluir Edital");
        btnAdicionarPrioridade = new JButton("Adicionar Prioridade");
        JPanel panelBotoes1 = new JPanel();
        panelBotoes1.add(btnExcluirEdital);
        panelBotoes1.add(btnAdicionarPrioridade);
        painel1.add(panelBotoes1, BorderLayout.SOUTH);

        // Lógica para adicionar os editais no painel 1 com o padrão nomeFantasia + dataFechamento
        String nomeFantasia = "Banco do Brasil";
        String dataFechamento = "30/06/2023";
        String edital1 = nomeFantasia + " - " + dataFechamento;
        modelEditais.addElement(edital1);

        nomeFantasia = "Ministério da Educação";
        dataFechamento = "15/07/2023";
        String edital2 = nomeFantasia + " - " + dataFechamento;
        modelEditais.addElement(edital2);

        nomeFantasia = "Departamento Estadual de Trânsito";
        dataFechamento = "05/05/2023";
        String edital3 = nomeFantasia + " - " + dataFechamento;
        modelEditais.addElement(edital3);


        // Inicialização dos componentes do painel 2
        modelPrioridade = new DefaultListModel<>();
        listaPrioridade = new JList<>(modelPrioridade);
        JScrollPane scrollPane2 = new JScrollPane(listaPrioridade);
        painel2.add(scrollPane2, BorderLayout.CENTER);

        btnRemoverPrioridade = new JButton("Remover Prioridade");
        JPanel panelBotoes2 = new JPanel();
        panelBotoes2.add(btnRemoverPrioridade);
        painel2.add(panelBotoes2, BorderLayout.SOUTH);

        // Inicialização dos componentes do painel 3
        JPanel panelCampos = new JPanel(new GridLayout(5, 2));
        panelCampos.add(new JLabel("Nome do Concurso:"));
        txtNomeConcurso = new JTextField();
        panelCampos.add(txtNomeConcurso);
        panelCampos.add(new JLabel("Regras da Prova:"));
        txtRegrasProva = new JTextField();
        panelCampos.add(txtRegrasProva);
        panelCampos.add(new JLabel("Taxa de Inscrição:"));
        txtTaxaInscricao = new JTextField();
        panelCampos.add(txtTaxaInscricao);
        panelCampos.add(new JLabel("Data Concurso:"));
        txtDataConcurso = new JTextField(); 
        panelCampos.add(txtDataConcurso);
        panelCampos.add(new JLabel("Data de Fechamento:"));
        txtDataFechamento = new JTextField();
        panelCampos.add(txtDataFechamento);
        btnAdicionarEdital = new JButton("Adicionar Edital");
        painel3.add(panelCampos, BorderLayout.CENTER);
        painel3.add(btnAdicionarEdital, BorderLayout.SOUTH);

        // Inicialização dos componentes do painel 4
        JPanel panelDataAtual = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Alteração do layout para FlowLayout
        panelDataAtual.add(new JLabel("Data Atual:"));
        txtDataAtual = new JTextField(15); // Aumentando o tamanho do campo de texto para 15 colunas
        panelDataAtual.add(txtDataAtual);

        btnBuscarEditais = new JButton("Buscar Editais");
        painel4.add(panelDataAtual, BorderLayout.CENTER); // Posicionando o painel no centro
        painel4.add(btnBuscarEditais, BorderLayout.SOUTH);
        
        btnBuscarEditais.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obter a data atual do computador
                Date dataAtual = new Date();

                // Obter a data digitada pelo usuário
                String dataDigitadaStr = txtDataAtual.getText();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date dataDigitada = null;
                try {
                    dataDigitada = dateFormat.parse(dataDigitadaStr);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(TelaEdital.this, "Data digitada inválida! Use o formato dd/MM/yyyy.", "Aviso", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                DefaultListModel<String> modelPainel4 = new DefaultListModel<>();
                listaEditais.setModel(modelPainel4);

                if (dataDigitada.equals(dataAtual) || dataDigitada.after(dataAtual)) {
                    for (int i = 0; i < modelEditais.size(); i++) {
                        String edital = modelEditais.getElementAt(i);
                        String dataEdital = edital.split(" - ")[1];

                        if (dataEdital.equals(dataDigitadaStr)) {
                            modelPainel4.addElement(edital);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(TelaEdital.this, "Data atual inválida! A data atual é anterior à data digitada.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });






        // Adicionando os painéis ao JFrame
        add(painel1);
        add(painel2);
        add(painel3);
        add(painel4);

        // Configurando os listeners dos botões
        btnExcluirEdital.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para excluir o edital selecionado na lista
                int selectedIndex = listaEditais.getSelectedIndex();
                if (selectedIndex != -1) {
                    modelEditais.remove(selectedIndex);
                }
            }
        });

        btnAdicionarPrioridade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para adicionar o edital selecionado na lista de prioridade
                String selectedEdital = listaEditais.getSelectedValue();
                if (selectedEdital != null) {
                    modelPrioridade.addElement(selectedEdital);
                }
            }
        });

        btnRemoverPrioridade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para remover o edital selecionado da lista de prioridade
                int selectedIndex = listaPrioridade.getSelectedIndex();
                if (selectedIndex != -1) {
                    modelPrioridade.remove(selectedIndex);
                }
            }
        });

        btnAdicionarEdital.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para adicionar um novo edital na lista do painel 1
                String nomeConcurso = txtNomeConcurso.getText();
                String dataConcurso = txtDataConcurso.getText();
                String novoEdital = nomeConcurso + " - " + dataConcurso;
                modelEditais.addElement(novoEdital);

                // Limpar os campos de entrada após adicionar o edital
                txtNomeConcurso.setText("");
                txtDataConcurso.setText("");
            }
        });

        btnBuscarEditais.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para buscar os editais com a data dentro do prazo no painel 1
                String dataAtual = txtDataAtual.getText();
                List<String> editaisNoPrazo = new ArrayList<>();
                for (int i = 0; i < modelEditais.size(); i++) {
                    String edital = modelEditais.getElementAt(i);
                    String dataEdital = edital.split(" - ")[1];
                    if (dataEdital.compareTo(dataAtual) >= 0) {
                        editaisNoPrazo.add(edital);
                    }
                }
                String[] editaisArray = new String[editaisNoPrazo.size()];
                editaisNoPrazo.toArray(editaisArray);
                listaEditais.setListData(editaisArray);
            }
        });

        // Configurações finais do JFrame
        pack();
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaEdital();
            }
        });
    }}


