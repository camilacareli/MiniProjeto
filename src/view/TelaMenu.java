package view;

import java.awt.event.*;
import javax.swing.*;

// Tela inicial
public class TelaMenu implements ActionListener {
    private static JFrame f;
    private static JButton b1;
    private static JButton b2;

    // Construtor da classe
    public TelaMenu() {
        f = new JFrame("Estudo para Concurso!");
        b1 = new JButton("EDITAIS");
        b2 = new JButton("QUESTÕES");
        f.setSize(300, 100);
        b1.setBounds(80, 10, 120, 30);
        b2.setBounds(80, 50, 120, 30);
        f.setLayout(null);
        f.add(b1);
        f.add(b2);
        f.setVisible(true);
        
        // Adiciona o ActionListener ao botão "EDITAIS"
        b1.addActionListener(this);
    }

    public static void main(String[] args) {
        TelaMenu menu = new TelaMenu();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            // Cria uma instância da classe TelaEdital
            TelaEdital telaEdital = new TelaEdital();
        }
    }
}
