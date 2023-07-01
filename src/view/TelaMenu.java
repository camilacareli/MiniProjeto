package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Dados;


public class TelaMenu extends JFrame {
	private static final long serialVersionUID = 1L;
	private JComboBox<String> filtroComboBox;
    private JButton filtrarButton;
    private Dados d;

    public TelaMenu(Dados d) {
        this.d = d;

        // Configurações básicas da tela
        setTitle("Planejando Meu Futuro | PRINCIPAL");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        // Painel principal com layout BorderLayout
        JPanel panel = new JPanel(new BorderLayout());

        // Cria o painel do título com fundo preto
        JPanel tituloPanel = new JPanel();
        tituloPanel.setBackground(Color.BLACK);

        // Cria o rótulo do título com texto branco
        JLabel tituloLabel = new JLabel("ESTUDO PARA CONCURSO");
        tituloLabel.setForeground(Color.WHITE);

        // Adiciona o rótulo ao painel do título
        tituloPanel.add(tituloLabel);

        // Adiciona o painel do título ao painel principal no norte (parte superior)
        panel.add(tituloPanel, BorderLayout.NORTH);

        // Cria o painel do filtro com layout FlowLayout
        JPanel filtroPanel = new JPanel();
        filtroPanel.setLayout(new FlowLayout());

        // ComboBox de filtro
        filtroComboBox = new JComboBox<>();
        filtroComboBox.addItem("ESCOLHA O QUE DESEJA ESTUDAR:");
        filtroComboBox.addItem("EDITAIS");
        filtroComboBox.addItem("QUESTÕES DE MULTIPLA ESCOLHA");
        filtroComboBox.addItem("QUESTÕES DISSERTATIVAS");
        filtroPanel.add(filtroComboBox);

        // Botão Filtrar
        filtrarButton = new JButton("Vamos estudar!");
        filtrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrarQuestoes();
            }
        });
        filtroPanel.add(filtrarButton);

        // Adiciona o painel do filtro ao painel principal no centro
        panel.add(filtroPanel, BorderLayout.CENTER);

        // Adiciona o painel à tela
        add(panel);

        // Exibe a tela
        setVisible(true);
    }


    public JComboBox<String> getFiltroComboBox() {
		return filtroComboBox;
	}

	public void setFiltroComboBox(JComboBox<String> filtroComboBox) {
		this.filtroComboBox = filtroComboBox;
	}

	public JButton getFiltrarButton() {
		return filtrarButton;
	}

	public void setFiltrarButton(JButton filtrarButton) {
		this.filtrarButton = filtrarButton;
	}

	private void filtrarQuestoes() {
        String filtro = (String) filtroComboBox.getSelectedItem();

        // Cria e exibe a tela correspondente ao filtro selecionado
        if (filtro.equals("EDITAIS")) {
        	Dados dados = new Dados();
            TelaEdital telaEdital = new TelaEdital(dados);
            telaEdital.setVisible(true);
        } else if (filtro.equals("QUESTÕES DE MULTIPLA ESCOLHA")) {
        	Dados dados = new Dados();
            TelaMultiplaEscolha telaMultiplaEscolha = new TelaMultiplaEscolha(dados);
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
            	Dados dados = new Dados();
                new TelaMenu(dados).setVisible(true);
            }
        });
    }
}



