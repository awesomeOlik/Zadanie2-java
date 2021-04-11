package Uloha;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args){
        Grid application = new Grid();
        application.draw();
        JFrame frame = new JFrame();
        var up=(new JButton("^"));
        var buttonPanel=new JPanel();
        buttonPanel.setVisible(true);
        buttonPanel.add(up);
        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;
        up.setPreferredSize(new Dimension(50,30));
        buttonPanel.add(up,c);

        JButton left = new JButton("<");
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 1;
        left.setPreferredSize(new Dimension(50,30));
        buttonPanel.add(left,c);

        JButton down = new JButton("v");
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 1;
        down.setPreferredSize(new Dimension(50,30));
        buttonPanel.add(down,c);

        JButton right = new JButton(">");
        c.gridx = 2;
        c.gridy = 1;
        right.setPreferredSize(new Dimension(50,30));
        buttonPanel.add(right,c);

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


        down.setPreferredSize(new Dimension(50,30));
        buttonPanel.add(reset,c);

        frame.setLayout(new BorderLayout());
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.add(application,BorderLayout.CENTER);
        frame.add(buttonPanel,BorderLayout.LINE_START);


        down.addActionListener(e -> application.repaint(application.point.getPointx(),application.point.getPointy(),application.point.setPointx(application.point.getPointx()+1),application.point.getPointy()));
        up.addActionListener(e -> application.repaint(application.point.getPointx(),application.point.getPointy(),application.point.setPointx(application.point.getPointx()-1),application.point.getPointy()));
        left.addActionListener(e -> application.repaint(application.point.getPointx(),application.point.getPointy(),application.point.getPointx(),application.point.setPointy(application.point.getPointy()-1)));
        right.addActionListener(e -> application.repaint(application.point.getPointx(),application.point.getPointy(),application.point.getPointx(),application.point.setPointy(application.point.getPointy()+1)));

    }
}

