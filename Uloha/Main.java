package Uloha;

import javax.swing.*;

    public class Main {
        public static void main(String[] args){
            Grid application = new Grid();
            JFrame frame = new JFrame();

            frame.setSize(500,500);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);

            frame.add(application);
        }
    }

