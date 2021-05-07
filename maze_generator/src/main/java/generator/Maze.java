package generator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Maze{
    Grid grid = new Grid();
    private int i = grid.i;
    Label label = grid.label;

    Maze(){
        ArrayList<Grid> grids= new ArrayList<>();
        JFrame frame = new JFrame("Maze Game");
        grids.add(grid);
        grid.draw();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(800, 600);

        frame.addWindowFocusListener(new WindowAdapter() {
            public void windowGainedFocus(WindowEvent e) {
                frame.requestFocusInWindow();
            }
        });

        var buttPanel = new JPanel();
        buttPanel.setLayout(new GridBagLayout());
        buttPanel.setBackground(Color.BLACK);


        GridBagConstraints c = new GridBagConstraints();

        JButton up = new JButton("^");
        c.gridx = 1;
        c.gridy = 0;
        up.setPreferredSize(new Dimension(50,50));
        buttPanel.add(up,c);

        JButton down = new JButton("v");
        c.gridx = 1;
        c.gridy = 2;
        down.setPreferredSize(new Dimension(50,50));
        buttPanel.add(down,c);

        JButton left = new JButton("<");
        c.gridx = 0;
        c.gridy = 1;
        left.setPreferredSize(new Dimension(50,50));
        buttPanel.add(left,c);

        JButton right = new JButton(">");
        c.gridx = 2;
        c.gridy = 1;
        right.setPreferredSize(new Dimension(50,50));
        buttPanel.add(right,c);

        JButton reset = new JButton("Reset");
        c.gridx = 1;
        c.gridy = 4;
        right.setPreferredSize(new Dimension(50,50));
        buttPanel.add(reset,c);

        frame.setLayout(new BorderLayout());
        frame.add(buttPanel, BorderLayout.CENTER);
        frame.add(grids.get(0), BorderLayout.LINE_START);
        frame.add(label, BorderLayout.NORTH);
        frame.setResizable(false);

        down.addActionListener(e -> {
            grid.moveFuckeeeeer(grid.player.getx(),grid.player.gety(),grid.player.setX(grid.player.getx()+1),grid.player.gety(), 1);
            if(grid.player.getx()==0 && grid.player.gety()==10)
                newWon();
            frame.requestFocusInWindow();
        });
        up.addActionListener(e -> {
            grid.moveFuckeeeeer(grid.player.getx(), grid.player.gety(), grid.player.setX(grid.player.getx() - 1), grid.player.gety(), 2);
            if(grid.player.getx()==0 && grid.player.gety()==10)
                newWon();
            frame.requestFocusInWindow();
        });
        left.addActionListener(e -> {
            grid.moveFuckeeeeer(grid.player.getx(),grid.player.gety(),grid.player.getx(),grid.player.setY(grid.player.gety()-1),3);
            if(grid.player.getx()==0 && grid.player.gety()==10)
                newWon();
            frame.requestFocusInWindow();
        });
        right.addActionListener(e -> {
            grid.moveFuckeeeeer(grid.player.getx(),grid.player.gety(),grid.player.getx(),grid.player.setY(grid.player.gety()+1),4);
            if(grid.player.getx()==0 && grid.player.gety()==10)
                newWon();
            frame.requestFocusInWindow();
        });
        reset.addActionListener(e -> {
            grid.i = 0;
            grid.reset();
            frame.requestFocusInWindow();
        });


        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_UP) {
                    grid.moveFuckeeeeer(grid.player.getx(), grid.player.gety(), grid.player.setX(grid.player.getx() - 1), grid.player.gety(), 2);
                    if(grid.player.getx()==0 && grid.player.gety()==10)
                        newWon();
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                    grid.moveFuckeeeeer(grid.player.getx(), grid.player.gety(), grid.player.setX(grid.player.getx() + 1), grid.player.gety(), 1);
                    if(grid.player.getx()==0 && grid.player.gety()==10)
                        newWon();
                }
                if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                    grid.moveFuckeeeeer(grid.player.getx(), grid.player.gety(), grid.player.getx(), grid.player.setY(grid.player.gety() - 1), 3);
                    if(grid.player.getx()==0 && grid.player.gety()==10)
                        newWon();
                }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    grid.moveFuckeeeeer(grid.player.getx(), grid.player.gety(), grid.player.getx(), grid.player.setY(grid.player.gety() + 1), 4);
                    if(grid.player.getx()==0 && grid.player.gety()==10)
                        newWon();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    public void newWon(){
        i = grid.i;
        i++;
        grid.i = i;
        grid.reset();
    }
}
