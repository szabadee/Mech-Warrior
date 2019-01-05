package com.flow.mechwarrior;

import javax.swing.*;
import java.awt.*;

public class TabletopGUI extends JFrame {
    private Table battlefield;
    private JButton[][] buttons;
    private JLabel gameRules;


    public TabletopGUI () {
        setTitle("Mech Warrior tabletop mini");
        setSize(800, 555);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel root = new JPanel();
        root.setLayout(null);
        add(root);

        JLabel mechProfileTags = new JLabel();
        mechProfileTags.setVerticalAlignment(JLabel.TOP);
        mechProfileTags.setVerticalTextPosition(JLabel.TOP);
        mechProfileTags.setBounds(540,20,90, 240);
        mechProfileTags.setText("<html><font style=\"font-family: 'Arial'; font-size: 12pt;\">" +
                "Mech's type:<br>Mech's name:<br>Weapon:<br>Weapon range:<br>Step range:<br><br>" +
                "- - - - - - - - - - - -<br>Left leg:<br>Right leg:<br>Left arm:<br>Right arm:<br>" +
                "Left shoulder:<br>Right shoulder:<br>Torso:<br>Head:</html>");
        root.add(mechProfileTags);

        JLabel mechProfile = new JLabel();
        mechProfile.setVerticalAlignment(JLabel.TOP);
        mechProfile.setVerticalTextPosition(JLabel.TOP);
        mechProfile.setBounds(640,20,150,240);
        mechProfile.setText("");
        root.add(mechProfile);

        final int size = 20;
        battlefield = new Table(size);
        buttons = new JButton[size][size];


        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                JButton button = new JButton();
                button.setBounds(20 + i * 25,20 + j * 25, 20,20);
                button.setFont(new Font("Arial", Font.PLAIN, 9));
                button.getInsets(new Insets(0, 0, 0, 0));
                root.add(button);
                buttons[i][j] = button;

                button.setActionCommand(i + " " + j);

                button.addActionListener(e -> {
                    String event = e.getActionCommand();
                    String[] array = event.split(" ");
                    int a = Integer.parseInt(array[0]);
                    int b = Integer.parseInt(array[1]);
                    if (battlefield.getCell(a, b).getStandingOnIt()) {
                        mechProfile.setText(String.valueOf(battlefield.getCell(a, b).getMech()));
                    } else {
                        mechProfile.setText("");
                    }
                });
            }
        }

        drawBattlefield();

        JButton up = new JButton("UP");
        up.setBounds(620,250, 70,35);
        up.setFont(new Font("Arial", Font.PLAIN, 10));
        up.getInsets(new Insets(0, 0, 0, 0));
        up.addActionListener(e -> {});
        root.add(up);

        JButton right = new JButton("RIGHT");
        right.setBounds(670,295, 70,35);
        right.setFont(new Font("Arial", Font.PLAIN, 10));
        right.getInsets(new Insets(0, 0, 0, 0));
        root.add(right);

        JButton down = new JButton("DOWN");
        down.setBounds(570,295, 70,35);
        down.setFont(new Font("Arial", Font.PLAIN, 10));
        down.getInsets(new Insets(0, 0, 0, 0));
        root.add(down);

        JButton left = new JButton("LEFT");
        left.setBounds(620,340, 70,35);
        left.setFont(new Font("Arial", Font.PLAIN, 10));
        left.getInsets(new Insets(0, 0, 0, 0));
        root.add(left);

    }

    public void drawBattlefield () {
        for (int i = 0; i < buttons.length; i++) {
            for ( int j = 0; j < buttons.length; j++) {
                if (battlefield.getCell(i, j).getStandingOnIt() == true) {
                    if (battlefield.getCell(i, j).getMech() instanceof MechLight) {
                        buttons[i][j].setText("L");
                    } else if (battlefield.getCell(i, j).getMech() instanceof MechMedium) {
                        buttons[i][j].setText("M");
                    } else if (battlefield.getCell(i, j).getMech() instanceof MechHeavy) {
                        buttons[i][j].setText("H");
                    } else if (battlefield.getCell(i, j).getMech() instanceof MechAssault) {
                        buttons[i][j].setText("A");
                    }
                } else {
                    buttons[i][j].setText(battlefield.getCell(i, j).toString());
                }
            }
        }
    }
}
