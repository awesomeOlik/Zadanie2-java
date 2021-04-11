package Uloha;

import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.stream.IntStream;


public class Grid extends JPanel {
    public static final int GRID_SIZE = 11;
    Square point;
    Cell[][] field = new Cell[GRID_SIZE][GRID_SIZE];
    public Grid() {
        this.point=new Square(0,0);
        setPreferredSize(new Dimension(300, 300));
        setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));
        setBorder(new EmptyBorder(10, 10, 10, 10));
    }
    public void draw(){
        for (int x = 0; x < GRID_SIZE; x++) {
            for (int y = 0; y < GRID_SIZE; y++) {
                if (x == point.getPointx() && y == point.getPointy()) {
                    point.setBackground(Color.RED);
                    add(point);
                    field[x][y]=point;
                    continue;
                }
                final Cell cell = new Cell(x, y);
                field[x][y]=cell;
                add(cell);
                Border border = new LineBorder(Color.BLACK, 1, true);
                cell.setBorder(border);

                cell.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        cell.setBackground(Color.WHITE);
                        cell.setBorder(new LineBorder(Color.WHITE, 1, true));

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
                point.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                    }
                    @Override
                    public void mousePressed(MouseEvent e) {
                    }
                    @Override
                    public void mouseReleased(MouseEvent e) {
                    }
                    @Override
                    public void mouseEntered(MouseEvent e) {

                        IntStream.range(1, GRID_SIZE).forEach(key -> field[point.getPointx()][key].setBackground(Color.CYAN));
                        IntStream.range(1, GRID_SIZE).forEach(key -> field[key][point.getPointx()].setBackground(Color.CYAN));
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        IntStream.range(1, GRID_SIZE).forEach(key -> field[point.getPointx()][key].setBackground(Color.WHITE));
                        IntStream.range(1, GRID_SIZE).forEach(key -> field[key][point.getPointx()].setBackground(Color.WHITE));
                    }

                });

            }
        }
    }
    public void repaint(int x1,int y1,int x2, int y2){
            field[x1][y1].setBackground(Color.WHITE);
            field[x2][y2].setBackground(Color.RED);

    }


}



