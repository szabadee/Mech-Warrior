package com.flow.mechwarriors;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Intro extends JFrame {

    private BufferedImage backgroundImage;

    public Intro() {
        setTitle("Mech Warrior tabletop mini");
        setSize(1280, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        setImage();

        /*JPanel contentPanel = new JPanel();
        contentPanel.setBounds(100, 100, 400,200);
        contentPanel.setLayout(null);
        contentPanel.setVisible(true);
        contentPanel.setOpaque(true);
        add(contentPanel);

        JTextField playerOneField = new JTextField();
        playerOneField.setBounds(20,50, 150,30);
        contentPanel.add(playerOneField);

        JTextField playerTwoField = new JTextField();
        playerTwoField.setBounds(200,50, 150,30);
        contentPanel.add(playerTwoField);

        JButton ok = new JButton("Go play!");
        ok.setBounds(150,100, 70,20);
        contentPanel.add(ok);*/

        JLabel background = new JLabel(new ImageIcon(backgroundImage));
        add(background);

        /*if (!playerOneField.getText().isEmpty() && !playerTwoField.getText().isEmpty()) {
            ok.addActionListener(e -> {
                Table.playerOne.setName(playerOneField.getName());
                Table.playerTwo.setName(playerTwoField.getName());
            });
        }*/

        JOptionPane.showMessageDialog(null, "Welcome to the Mech Warrior Game!");
        setVisible(false);
    }

    public void setImage() {
        try {
            backgroundImage = ImageIO.read(new File("/Users/user/Works/Flow/Java/Projects/MechWarriors/src/com/flow/mechwarriors/images/background.jpg"));
        } catch (
                IOException exp) {
            exp.printStackTrace();
        }
    }

    //<br>The first player will be select randomly<br>The player will win, if kill the other player's Mechs erlier
}
