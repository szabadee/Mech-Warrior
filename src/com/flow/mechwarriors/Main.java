package com.flow.mechwarriors;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new Intro();
            View view = new View();
            view.setVisible(true);
        });
    }
}
