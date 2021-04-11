package Uloha;

public class Square extends Cell {
    private int pointx;
    private int pointy;

    public Square(int x,int y) {
        super();
        this.pointx = x;
        this.pointy = y;
    }

    public int getPointx() {
        return pointx;
    }

    public int getPointy() {
        return pointy;
    }

    public int setPointx(int pointx) {
        this.pointx = pointx;
        return pointx;
    }

    public int setPointy(int pointy) {
        this.pointy = pointy;
        return pointy;
    }

}
