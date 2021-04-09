package Uloha;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main {
    public static void main(String[] args){
        Grid application = new Grid();
        application.draw();
        JFrame frame = new JFrame();
        var button=(new JButton("^"));
        var buttonPanel=new JPanel();
        buttonPanel.setVisible(true);
        buttonPanel.add(button);
        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;
        button.setPreferredSize(new Dimension(50,30));
        buttonPanel.add(button,c);

        JButton button1 = new JButton("<");
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 1;
        button1.setPreferredSize(new Dimension(50,30));
        buttonPanel.add(button1,c);

        JButton button2 = new JButton("v");
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 1;
        button2.setPreferredSize(new Dimension(50,30));
        buttonPanel.add(button2,c);

        JButton button3 = new JButton(">");
        //c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 1;
        button3.setPreferredSize(new Dimension(50,30));
        buttonPanel.add(button3,c);

        JButton reset = new JButton("Reset");
        c.ipady = 20;      //make this component tall
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 2;
        reset.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.CYAN, 40),
                BorderFactory.createEmptyBorder(5, 5, 10, 10)));
        buttonPanel.add(reset,c);
        buttonPanel.setBackground(Color.CYAN);


        button2.setPreferredSize(new Dimension(50,30));
        buttonPanel.add(reset,c);

        frame.setLayout(new BorderLayout());
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.add(application,BorderLayout.CENTER);
        frame.add(buttonPanel,BorderLayout.LINE_START);

        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button.setBackground(Color.BLACK);
//TODO na kliknutie treba preklesit plochu a zobrazit novu polohu stvovrca

            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });



    }
}

