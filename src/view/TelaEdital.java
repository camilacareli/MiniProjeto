package view;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

class ItemLista {
    private String nome;
    private Date data;

    public ItemLista(String nome, Date data) {
        this.nome = nome;
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public Date getData() {
        return data;
    }

    public String getFormattedDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(data);
    }

    @Override
    public String toString() {
        return nome + " - " + getFormattedDate();
    }
}

public class TelaEdital {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Estudo para Concurso | EDITAIS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Cria um array de objetos ItemLista com nome e data
        ItemLista[] itens = {
                new ItemLista("Banco do Brasil", new Date(2023, 5, 13)),
                new ItemLista("Polícia Federal", new Date(2023, 6, 25)),
                new ItemLista("DETRAN", new Date(2023, 9, 18)),
                new ItemLista("Ministério da Fazenda", new Date(2023, 1, 3)),
                new ItemLista("INSS", new Date(2023, 11, 25))
        };

        // Cria uma JList com o array de itens
        JList<ItemLista> lista = new JList<>(itens);

        // Define o modo de seleção para permitir seleção de vários itens
        lista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        // Define um renderer personalizado para exibir apenas a data formatada dos itens
        lista.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {
                Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (renderer instanceof JLabel && value instanceof ItemLista) {
                    ItemLista item = (ItemLista) value;
                    ((JLabel) renderer).setText(item.getNome() + " - " + item.getFormattedDate());
                }
                return renderer;
            }
        });

        // Adiciona a JList a um JScrollPane para permitir a rolagem, se necessário
        JScrollPane scrollPane = new JScrollPane(lista);

        // Adiciona o JScrollPane ao frame
        frame.getContentPane().add(scrollPane);

        // Cria os botões
        JButton button1 = new JButton("Ler");
        JButton button2 = new JButton("Download");
        JButton button3 = new JButton("Criar");
        JButton button4 = new JButton("Deletar");

        // Cria o painel para os botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);

        // Adiciona o painel de botões ao frame
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Adiciona um ListSelectionListener para capturar os eventos de seleção
        lista.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    // Verifica se algum item foi selecionado
                    if (lista.getSelectedIndex() != -1) {
                        // Exibe os botões
                        buttonPanel.setVisible(true);
                    } else {
                        // Oculta os botões
                        buttonPanel.setVisible(false);
                    }
                }
            }
        });
        
        

        // Define o tamanho do frame e o torna visível
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
