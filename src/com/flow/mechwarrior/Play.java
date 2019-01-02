package com.flow.mechwarrior;

import java.awt.*;

public class Play {
    public static void main(String[] args) {
        EventQueue.invokeLater(()-> {
            TabletopGUI tabletopGUI = new TabletopGUI();
            tabletopGUI.setVisible(true);
        });
    }
}
