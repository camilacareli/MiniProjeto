package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TelaEdital extends JFrame {
    public TelaEdital() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Estudo para Concurso | EDITAIS");

        JButton btnEdital1 = new JButton("Edital na data Atual");
        btnEdital1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dataInserida = JOptionPane.showInputDialog("Digite a data ATUAL (DD/MM/AAAA):");

                // Obtendo a data atual
                LocalDate dataAtual = LocalDate.now();

                // Convertendo a data inserida em LocalDate
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate dataInseridaFormatada = LocalDate.parse(dataInserida, formatter);

                // Comparando as datas
                if (dataInseridaFormatada.equals(dataAtual)) {
                    JOptionPane.showMessageDialog(null, "Edital está válido!");
                } else {
                    JOptionPane.showMessageDialog(null, "Edital está inválido!");
                }
            }
        });

        JButton btnEdital2 = new JButton("Editais Gerais");
        btnEdital2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para abrir a outra tela com a lista de editais completos
                // Implemente a lógica de abertura da nova tela aqui
                // Você pode criar outra classe que estende JFrame para representar a nova tela
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(btnEdital1);
        panel.add(btnEdital2);

        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaEdital();
            }
        });
    }
}

