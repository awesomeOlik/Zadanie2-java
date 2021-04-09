package Uloha;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Cell extends JPanel {

    public static final int CELL_SIZE = 1;
    private int xPos;
    private int yPos;

    public Cell (int x, int y) {
        xPos = x;
        yPos = y;
        setOpaque(true);
        setBorder(BorderFactory.createBevelBorder(CELL_SIZE));

        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(CELL_SIZE, CELL_SIZE));
    }
}
