package Uloha;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Grid extends JPanel {
    public static final int GRID_SIZE = 10;

    public Grid() {
        final int[] x_ind = {0};
        final int[] y_ind = {0};
        setSize(new Dimension(300, 300));
        setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));

        for (int x = 0; x < GRID_SIZE; x++) {
            for (int y = 0; y < GRID_SIZE; y++) {
                final Cell cell = new Cell(x, y);
                add(cell);
                Border border = new LineBorder(Color.ORANGE, 1, true);
                cell.setBorder(border);
                cell.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                        click(e,cell);
                        x_ind[0] = cell.getX();
                        y_ind[0] = cell.getY();
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
    }

    public void click(MouseEvent e, Cell cell) {
        cell.setBackground(Color.BLACK);
    }

    // handlers for the other mouse events
}

