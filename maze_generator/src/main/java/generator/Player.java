package generator;

public class Player extends Cell{
    private int x;
    private int y;

    public Player(int x, int y) {
        super(x, y);
        this.x = x;
        this.y = y;
    }

    public int getx() {
        return x;
    }

    public int setX(int x) {
        this.x = x;
        return x;
    }

    public void setXpos(int x){this.x = x;}

    public void setYpos(int y){this.y = y;}

    public int gety() {
        return y;
    }

    public int setY(int y) {
        this.y = y;
        return y;
    }
}
