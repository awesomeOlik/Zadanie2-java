package generator;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid();
        grid.draw();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(500, 500);

        frame.add(grid);
    }
}
