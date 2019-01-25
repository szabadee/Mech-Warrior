package com.flow.mechwarriors;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
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

        JLabel background = new JLabel(new ImageIcon(backgroundImage));
        add(background);

        JOptionPane.showMessageDialog(null, "<html>Welcome to the Mech Warrior Game!<br>The first player will be select randomly<br>The player will win, if kill the other player's Mechs erlier");

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
}
