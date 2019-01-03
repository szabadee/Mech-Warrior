package com.flow.mechwarrior;

import javax.swing.*;
import java.awt.*;

public class TabletopGUI extends JFrame {
    private Table battlefield;
    private JButton[][] buttons;
    private JLabel mechProfile;
    private JLabel mechProfileTags;
    private JLabel gameRules;

    public TabletopGUI () {
        setTitle("Mech Warrior tabletop mini");
        setSize(800, 555);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel root = new JPanel();
        root.setLayout(null);
        add(root);

        mechProfileTags = new JLabel();
        mechProfileTags.setVerticalAlignment(JLabel.TOP);
        mechProfileTags.setVerticalTextPosition(JLabel.TOP);
        mechProfileTags.setBounds(540,20,90, 240);
        mechProfileTags.setText("<html><font style=\"font-family: 'Arial'; font-size: 12pt;\">" +
                "Mech's type:<br>Mech's name:<br>Weapon:<br>Weapon range:<br>Step range:<br><br>" +
                "- - - - - - - - - - - -<br>Left leg:<br>Right leg:<br>Left arm:<br>Right arm:<br>" +
                "Left shoulder:<br>Right shoulder:<br>Torso:<br>Head:</html>");
        root.add(mechProfileTags);

        mechProfile = new JLabel();
        mechProfile.setVerticalAlignment(JLabel.TOP);
        mechProfile.setVerticalTextPosition(JLabel.TOP);
        mechProfile.setBounds(640,20,150,240);
        MechLight mechLight = new MechLight("Johny");
        mechProfile.setText(String.valueOf(mechLight));
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
