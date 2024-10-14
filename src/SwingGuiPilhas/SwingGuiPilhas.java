package SwingGuiPilhas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class SwingGuiPilhas {
    private JButton criarPilhaButton;
    private JButton pushButton;
    private JButton peekButton;
    private JButton popButton;
    private JTextArea pilhas;
    private JTextField inputElement;
    private JLabel topValue;
    private JPanel panelButtons;
    private JScrollPane panelPilhas;
    private JPanel panelPeek;
    private JPanel panelInput;
    private JPanel janela;
    private Stack<String> pilha;

    public SwingGuiPilhas() {

        pilha = new Stack<>();

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Pilhas");
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.add(janela, BorderLayout.CENTER);
        pilhas.setEnabled(false);
        pilhas.setVisible(false);


        criarPilhaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pilhas.setEnabled(true);
                pilhas.setVisible(true);
            }
        });


        pushButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputElement.getText();
                if(!input.isEmpty()){
                    pilha.push(input);
                    updateTextArea();
                    inputElement.setText("");
                }
            }
        });


        popButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!pilha.isEmpty()){
                    pilha.pop();
                    updateTextArea();
                }
            }
        });


        peekButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!pilha.isEmpty()){
                    String peek = pilha.peek().toString();
                    topValue.setText(peek);
                }
            }
        });
    }


    private void updateTextArea() {
        pilhas.setText("");
        for (int i = pilha.size() - 1; i>= 0; i--) {
            pilhas.append(pilha.get(i) + "\n");
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingGuiPilhas();
            }
        });
    }
}