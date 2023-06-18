package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaQuestoes extends JFrame {
    private JPanel telaQuestoes;
    private JPanel telaMultiplaEscolha;
    private JPanel telaDissertativa;

    public TelaQuestoes() {
        // Configurações da janela principal
        setTitle("Interface de Questões");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));

        // Inicialização dos painéis
        telaQuestoes = new JPanel();
        telaMultiplaEscolha = new JPanel();
        telaDissertativa = new JPanel();

        // Adicionar componentes na TelaQuestoes
        JButton btnMultiplaEscolha = new JButton("Questão de Múltipla Escolha");
        btnMultiplaEscolha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirTelaMultiplaEscolha();
            }
        });

        JButton btnDissertativa = new JButton("Questão Dissertativa");
        btnDissertativa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirTelaDissertativa();
            }
        });

        telaQuestoes.add(btnMultiplaEscolha);
        telaQuestoes.add(btnDissertativa);

        // Adicionar os painéis na tela principal
        getContentPane().setLayout(new CardLayout());
        getContentPane().add(telaQuestoes, "TelaQuestoes");
        getContentPane().add(telaMultiplaEscolha, "TelaMultiplaEscolha");
        getContentPane().add(telaDissertativa, "TelaDissertativa");

        pack();
        setLocationRelativeTo(null); // Centraliza a janela na tela
    }

    private void exibirTelaMultiplaEscolha() {
        CardLayout layout = (CardLayout) getContentPane().getLayout();
        layout.show(getContentPane(), "TelaMultiplaEscolha");
    }

    private void exibirTelaDissertativa() {
        CardLayout layout = (CardLayout) getContentPane().getLayout();
        layout.show(getContentPane(), "TelaDissertativa");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TelaQuestoes telaQuestoes = new TelaQuestoes();
                telaQuestoes.setVisible(true);
            }
        });
    }
}
