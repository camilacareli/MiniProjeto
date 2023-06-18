package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TelaMenu extends JFrame {
    private JComboBox<String> filtroComboBox;
    private JButton filtrarButton;

    public TelaMenu() {
        // Configurações básicas da tela
        setTitle("Filtro de Questões");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // ComboBox de filtro
        filtroComboBox = new JComboBox<>();
        filtroComboBox.addItem("Todos");
        filtroComboBox.addItem("EDITAIS");
        filtroComboBox.addItem("QUESTÕES DE MULTIPLA ESCOLHA");
        filtroComboBox.addItem("QUESTÕES DISSERTATIVAS");
        panel.add(filtroComboBox);

        // Botão Filtrar
        filtrarButton = new JButton("Filtrar");
        filtrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrarQuestoes();
            }
        });
        panel.add(filtrarButton);

        // Adiciona o painel à tela
        add(panel);

        // Exibe a tela
        setVisible(true);
    }

    private void filtrarQuestoes() {
        String filtro = (String) filtroComboBox.getSelectedItem();

        // Cria e exibe a tela correspondente ao filtro selecionado
        if (filtro.equals("EDITAIS")) {
            TelaEdital telaEdital = new TelaEdital();
            telaEdital.setVisible(true);
        } else if (filtro.equals("QUESTÕES DE MULTIPLA ESCOLHA")) {
            TelaMultiplaEscolha telaMultiplaEscolha = new TelaMultiplaEscolha();
            telaMultiplaEscolha.setVisible(true);
        } else if (filtro.equals("QUESTÕES DISSERTATIVAS")) {
            TelaDissertativa telaDissertativa = new TelaDissertativa();
            telaDissertativa.setVisible(true);
        }
    }

    public static void main(String[] args) {
        // Cria a tela principal
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TelaMenu();
            }
        });
    }
}



