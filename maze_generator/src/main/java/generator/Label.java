package generator;

import javax.swing.*;

public class Label extends JLabel {
    int i;

    Label(){
        this.setText("Games won: " +i);
        this.setVerticalTextPosition(JLabel.TOP);
        this.setHorizontalTextPosition(JLabel.RIGHT);
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
