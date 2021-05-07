package generator;

import java.awt.*;

public class Clear{
    private final int x;
    private final int y;
    private final Cell[][] field;

    Clear(int x, int y, Cell[][] field){
        this.x=x;
        this.y=y;
        this.field=field;
    }

    public void top(){
        int p = x-1;
        while(p>=0 && field[p][y].getBottom()==0){
            if(field[p][y].getBackground().equals(Color.RED)) field[p][y].setBackground(Color.RED);
            else field[p][y].setBackground(Color.BLACK);
            p--;
        }
    }

    public void bottom(){
        int p = x + 1;
        while (p <= 10 && field[p][y].getTop() == 0) {
            if(field[p][y].getBackground().equals(Color.RED)) field[p][y].setBackground(Color.RED);
            else field[p][y].setBackground(Color.BLACK);
            p++;
        }
    }

    public void right(){
        int p = y + 1;
        while(p<=10 && field[x][p].getLeft()==0){
            if(field[x][p].getBackground().equals(Color.RED)) field[x][p].setBackground(Color.RED);
            else field[x][p].setBackground(Color.BLACK);
            p++;
        }
    }

    public void left(){
        int p = y - 1;
        while(p>=0 && field[x][p].getRight()==0){
            if(field[x][p].getBackground().equals(Color.RED)) field[x][p].setBackground(Color.RED);
            else field[x][p].setBackground(Color.BLACK);
            p--;
        }
    }
}
