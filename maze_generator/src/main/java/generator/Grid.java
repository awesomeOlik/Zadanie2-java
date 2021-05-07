package generator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Stack;

public class Grid extends JPanel{
    private final int GRID_SIZE = 11;
    private final Cell[][] field = new Cell[GRID_SIZE][GRID_SIZE];
    public Cell cells = new Cell(0, 10);
    Player player = new Player(10,0);
    private final ArrayList<Cell> positions = new ArrayList<>();
    private int hlp = 0;
    public int i = 0;
    Label label = new Label();

    Grid(){
        setPreferredSize(new Dimension(500, 500));
        setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));
        setBorder(new EmptyBorder(11,11,11,11));
    }

    public void draw(){
        Stack<Cell> stack = new Stack<>();
        for(int x = 0; x < GRID_SIZE; x++){
            for(int y = 0; y <GRID_SIZE; y++){
                Cell cell = new Cell(x, y);
                if(cell.getxPos()==0 && cell.getyPos()==10) {
                    cell.setBackground(Color.RED);
                    cells=cell;
                }
                cell.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        hlp=1;
                        compare(cell, 1);

                        if(positions.contains(cell)){
                            Clear clr = new Clear(player.getx(), player.gety(), field);
                            clr.top();
                            clr.bottom();
                            clr.right();
                            clr.left();
                            field[player.getx()][player.gety()].setBackground(Color.BLACK);
                            player.setXpos(cell.getxPos());
                            player.setYpos(cell.getyPos());
                            cell.setBackground(Color.GREEN);
                            positions.clear();
                            if(player.getx()==0 && player.gety()==10) {
                                player.setXpos(10);
                                player.setYpos(0);
                                field[0][10].setBackground(Color.RED);
                                i++;
                                reset();
                            }
                            hlp=0;
                        }
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        compare(cell, 2);
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        if(hlp <= 0) {
                            Clear clr = new Clear(player.getx(), player.gety(), field);
                            clr.top();
                            clr.bottom();
                            clr.right();
                            clr.left();
                        }
                    }
                });

                add(cell);
                field[x][y] = cell;
            }
        }

        Cell currF = field[10][0];
        currF.setBackground(Color.GREEN);
        field[0][10].setBackground(Color.RED);
        Cell nextF = randomizedDFS(currF);

        boolean generationComplete = false;
        while(!generationComplete) {
            if (nextF != null) {
                nextF.setVisited(true);
                rmvWalls(currF, nextF);
                stack.push(currF);
                currF = nextF;
            } else if (!(stack.isEmpty()))
                currF = stack.pop();
            if (stack.isEmpty())
                generationComplete = true;
            nextF = randomizedDFS(currF);
        }
    }

    private void compare(Cell cell,int type) {
        if(cell.getxPos()==player.getx() && cell.getyPos()==player.gety()){
            possibleMovesUp(cell.getxPos(), cell.getyPos(), type);
            possibleMovesDown(cell.getxPos(), cell.getyPos(), type);
            possibleMovesRight(cell.getxPos(), cell.getyPos(), type);
            possibleMovesLeft(cell.getxPos(), cell.getyPos(), type);
        }
    }

    public Cell randomizedDFS(Cell cell){
        Stack<Cell> neighbours = new Stack<>();

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

    public void moveFuckeeeeer(int x, int y, int x2, int y2, int direction){
        switch(direction) {
            case 1:
                if(x2>=11) player.setX(x);
                else if(field[x2][y2].getTop() == 0 ) {
                    clear(x, y, x2, y2);
                } else player.setX(x);
                break;
            case 2:
                if(x2<0) player.setX(x);
                else if(field[x2][y2].getBottom() == 0 ) {
                    clear(x, y, x2, y2);
                } else player.setX(x);
                break;
            case 3:
                if(y2<0) player.setY(y);
                else if(field[x2][y2].getRight() == 0 ) {
                    clear(x, y, x2, y2);
                } else player.setY(y);
                break;
            case 4:
                if(y2 >=11) player.setY(y);
                else if(field[x2][y2].getLeft() == 0 ) {
                    clear(x, y, x2, y2);
                } else player.setY(y);
                break;
            default:
                break;
        }
    }


    private void clear(int x, int y, int x2, int y2) {
        Clear clr = new Clear(x,y,field);
        clr.top();
        clr.bottom();
        clr.left();
        clr.right();
        field[x][y].setBackground(Color.BLACK);
        field[x2][y2].setBackground(Color.GREEN);
        positions.clear();
    }

    public void possibleMovesUp(int x, int y, int type){
        int p = x-1;
        while(p>=0 && field[p][y].getBottom()==0){
            if(field[p][y].getBackground().equals(Color.RED)) field[p][y].setBackground(Color.RED);
            else field[p][y].setBackground(Color.BLUE);
            if(type == 1) {
                positions.add(field[p][y]);
            }
            p--;
        }
    }

    public void possibleMovesDown(int x, int y, int type){
        int p = x+1;
        while(p<=10 && field[p][y].getTop()==0){
            if(field[p][y].getBackground().equals(Color.RED)) field[p][y].setBackground(Color.RED);
            else field[p][y].setBackground(Color.BLUE);
            if(type == 1) {
                positions.add(field[p][y]);
            }
            p++;
        }
    }

    public void possibleMovesRight(int x, int y, int type){
        int p = y + 1;
        while(p<=10 && field[x][p].getLeft()==0){
            if(field[x][p].getBackground().equals(Color.RED)) field[x][p].setBackground(Color.RED);
            else field[x][p].setBackground(Color.BLUE);
            if(type == 1) {
                positions.add(field[x][p]);
            }
            p++;
        }
    }

    public void possibleMovesLeft(int x, int y, int type){
        int p = y - 1;
        while(p>=0 && field[x][p].getRight()==0){
            if(field[x][p].getBackground().equals(Color.RED)) field[x][p].setBackground(Color.RED);
            else field[x][p].setBackground(Color.BLUE);
            if(type == 1) {
                positions.add(field[x][p]);
            }
            p--;
        }
    }

    public void reset(){
        removeAll();
        revalidate();
        repaint();
        draw();
        label.setText("Games won: "+i);
        player.setXpos(10);
        player.setYpos(0);
        field[0][10].setBackground(Color.RED);
    }

}
