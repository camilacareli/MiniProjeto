package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TelaDissertativa extends JFrame {

    private JTextArea textoRedacao;
    private JButton botaoSalvar;
    private JComboBox<String> listaRedacoesAnteriores;

    public TelaDissertativa() {
        setTitle("Tela Dissertativa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel labelRedacao = new JLabel("Redação:");
        panel.add(labelRedacao);

        textoRedacao = new JTextArea();
        panel.add(new JScrollPane(textoRedacao));

        JLabel labelRedacoesAnteriores = new JLabel("Redações Anteriores:");
        panel.add(labelRedacoesAnteriores);

        listaRedacoesAnteriores = new JComboBox<>();
        listaRedacoesAnteriores.addItem("Redação 1");
        listaRedacoesAnteriores.addItem("Redação 2");
        listaRedacoesAnteriores.addItem("Redação 3");
        panel.add(listaRedacoesAnteriores);

        botaoSalvar = new JButton("Salvar");
        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarRedacao();
            }
        });
        panel.add(botaoSalvar);

        add(panel);
    }

    private void salvarRedacao() {
        String redacao = textoRedacao.getText();
        JOptionPane.showMessageDialog(this, "Redação salva:\n" + redacao);
        textoRedacao.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TelaDissertativa tela = new TelaDissertativa();
                tela.setVisible(true);
            }
        });
    }
}
