package generator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;
import java.util.Random;
import java.util.Stack;

public class Grid extends JPanel {
    private final int GRID_SIZE = 11;
    Cell[][] field = new Cell[GRID_SIZE][GRID_SIZE];

    Grid(){
        setPreferredSize(new Dimension(500, 500));
        setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));
        setBorder(new EmptyBorder(11,11,11,11));
    }

    public void draw(){
        Stack<Cell> stack = new Stack<Cell>();
        for(int x = 0; x < GRID_SIZE; x++){
            for(int y = 0; y <GRID_SIZE; y++){
                Cell cell = new Cell(x, y);
                add(cell);
                field[x][y] = cell;
            }
        }

        Cell currF = field[0][0];
        currF.setBackground(Color.GREEN);
        field[10][10].setBackground(Color.RED);
        Cell nextF = randomizedDFS(currF);

        boolean generationComplete = false;
        while(!generationComplete) {
            if (nextF != null) {
                nextF.setVisited(true);
                rmvWalls(currF, nextF);
                stack.push(currF);
                currF = nextF;
            } else if (!(stack.isEmpty())) {
                Cell help = stack.pop();
                currF = help;
            }
            if (stack.isEmpty()) {
                generationComplete = true;
            }
            nextF = randomizedDFS(currF);
        }
    }

    public Cell randomizedDFS(Cell cell){
        Stack<Cell> neighbours = new Stack<Cell>();

        int row  = cell.getxPos();
        int col = cell.getyPos();

        Cell top = row != 0 ? field[row - 1][col] : null;
        Cell right = col != GRID_SIZE - 1 ? field[row][col + 1] : null;
        Cell bottom = row != GRID_SIZE - 1 ? field[row + 1][col] : null;
        Cell left = col != 0 ? field[row][col - 1] : null;

        if((top != null) && !(top.isVisited())) neighbours.push(top);
        if((right != null) && !(right.isVisited())) neighbours.push(right);
        if((bottom != null) && !(bottom.isVisited())) neighbours.push(bottom);
        if((left != null) && !(left.isVisited())) neighbours.push(left);

        if(!(neighbours.isEmpty())){
            int random = (int) Math.floor(Math.random() * neighbours.size());
            return neighbours.get(random);
        }else{
            return null;
        }
    }

    public void rmvWalls(Cell cell1, Cell cell2){
        int x = cell1.getyPos() - cell2.getyPos();

        if(x==1){
            cell1.setLeft(0);
            cell2.setRight(0);
        }else if(x==-1){
            cell1.setRight(0);
            cell2.setLeft(0);
        }

        int y = cell1.getxPos() - cell2.getxPos();

        if(y==1){
            cell1.setTop(0);
            cell2.setBottom(0);
        }else if(y==-1){
            cell1.setBottom(0);
            cell2.setTop(0);
        }
    }


}
