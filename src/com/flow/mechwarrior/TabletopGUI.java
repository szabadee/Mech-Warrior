package com.flow.mechwarrior;

import javax.swing.*;
import javax.swing.plaf.multi.MultiLabelUI;
import java.awt.*;
import java.util.Arrays;

public class TabletopGUI extends JFrame {
    private Table battlefield;
    private JButton[][] buttons;
    private JTextPane mechProfile;
    private JLabel gameRules;

    public TabletopGUI () {
        setTitle("Mech Warrior tabletop mini");
        setSize(800, 555);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel root = new JPanel();
        root.setLayout(null);
        add(root);

        mechProfile = new JTextPane();
        mechProfile.setMargin(new Insets(10,10,10,10));
        mechProfile.setBounds(550,20,220, 200);
        root.add(mechProfile);

        final int size = 20;
        battlefield = new Table(size);
        buttons = new JButton[size][size];


        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                JButton button = new JButton();

                button.setBounds(20 + i * 25,20 + j * 25, 20,20);
                root.add(button);
                button.setFont(new Font("Arial", Font.PLAIN, 9));
                button.getInsets(new Insets(0, 0, 0, 0));
                buttons[i][j] = button;
                // button.setActionCommand(i + " " + j);

            }
        }

        MechLight mechLight = new MechLight("Johny", 21,31);
        mechProfile.setText(String.valueOf(mechLight));
    }
}
