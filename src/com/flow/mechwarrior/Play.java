package com.flow.mechwarrior;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Play {
    public static void main(String[] args) {
        EventQueue.invokeLater(()-> {
            TabletopGUI tabletopGUI = new TabletopGUI();
            tabletopGUI.setVisible(true);
        });

        // MechLight mechLight = new MechLight("Johny", 21,31);
        // System.out.println(mechLight);
    }
}
