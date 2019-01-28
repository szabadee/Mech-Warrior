package com.flow.mechwarriors;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Intro extends JFrame {

    private BufferedImage backgroundImage;
    public static String playerOneName;
    public static String playerTwoName;

    public Intro() {
        setTitle("Mech Warrior tabletop mini");
        setSize(1280, 800);
        setLocationRelativeTo(null);
        setVisible(true);

        setImage();

        JLabel background = new JLabel(new ImageIcon(backgroundImage));
        background.setSize(1280, 800);
        background.setVisible(true);
        background.setOpaque(true);
        add(background);

        JTextField playerOneField = new JTextField("Player One");
        playerOneField.setBounds(480,500, 150,35);
        background.add(playerOneField);

        JTextField playerTwoField = new JTextField();
        playerTwoField.setBounds(650,500, 150,35);
        background.add(playerTwoField);

        JButton nextButton = new JButton("Go play!");
        nextButton.setBounds(600,550, 80,35);
        background.add(nextButton);

        nextButton.addActionListener(e -> {
            playerOneName = playerOneField.getText();
            playerTwoName = playerTwoField.getText();
            dispose();
            View view = new View();
            view.setVisible(true);
        });

        setLayout(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }

    public void setImage() {
        try {
            backgroundImage = ImageIO.read(new File("/Users/user/Works/Flow/Java/Projects/MechWarriors/src/com/flow/mechwarriors/images/background.jpg"));
        } catch (
                IOException exp) {
            exp.printStackTrace();
        }
    }

}
