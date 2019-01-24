package com.flow.mechwarriors;

import com.flow.mechwarriors.items.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main extends JFrame implements MainContract.View {

    private ActionListener actionListener;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Main main = new Main();
            main.setVisible(true);
        });
    }

    private MainContract.Presenter presenter;

    private JPanel layoutButtons;
    private JPanel layoutPlayers;
    private JLabel layoutBackground;
    private JLabel mechProfile;
    private JLabel mechProfileTags;
    private JLabel mechArmy;
    private JLabel mechArmySize;
    private JLabel message;
    private JLabel header;
    private BufferedImage backgroundImage;
    private BufferedImage headerImage;


    public Main() {
        setTitle("Mech Warrior tabletop mini");
        setSize(1280, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel root = new JPanel();
        root.setLayout(null);
        add(root);

        layoutButtons = new JPanel();
        layoutButtons.setBounds(0, 0, 720, 800);
        layoutButtons.setBackground(Color.LIGHT_GRAY);
        layoutButtons.setLayout(null);
        root.add(layoutButtons);

        layoutPlayers = new JPanel();
        layoutPlayers.setBounds(750, 120, 500, 40);
        layoutPlayers.setBackground(Color.LIGHT_GRAY);
        layoutPlayers.setLayout(new GridLayout(1, 2,0,5));
        layoutPlayers.setBorder(new EmptyBorder(3,3,3,3));
        root.add(layoutPlayers);

        mechProfileTags = new JLabel();
        mechProfileTags.setVerticalAlignment(JLabel.TOP);
        mechProfileTags.setVerticalTextPosition(JLabel.TOP);
        mechProfileTags.setBounds(750,230,120, 280);
        mechProfileTags.setFont(new Font("Arial", Font.PLAIN, 14));
        mechProfileTags.setText("<html>" +
                "Mech's type:<br>" +
                "Mech's name:<br>" +
                "Weapon:<br>" +
                "Weapon range:<br>" +
                "Attack Force:<br>" +
                "Step range:<br><br>" +
                "- - - - - - - - - - - -<br>" +
                "Left leg:<br>Right leg:<br>" +
                "Left arm:<br>Right arm:<br>" +
                "Left shoulder:<br>" +
                "Right shoulder:<br>" +
                "Torso:<br" +
                ">Head:</html>");
        root.add(mechProfileTags);

        mechProfile = new JLabel();
        mechProfile.setVerticalAlignment(JLabel.TOP);
        mechProfile.setVerticalTextPosition(JLabel.TOP);
        mechProfile.setBounds(860,230,150,280);
        mechProfile.setText("");
        root.add(mechProfile);

        mechArmy = new JLabel();
        mechArmy.setVerticalAlignment(JLabel.TOP);
        mechArmy.setVerticalTextPosition(JLabel.TOP);
        mechArmy.setBounds(750,180,240,40);
        mechArmy.setFont(new Font("Arial", Font.PLAIN, 14));
        mechArmy.setText("<html>" + "Size of the Mech Army:<br>" + "- - - - - - - - - - - - - - - - - - - - - - - - - - - -<br></html>");
        root.add(mechArmy);

        mechArmySize = new JLabel();
        mechArmySize.setVerticalAlignment(JLabel.TOP);
        mechArmySize.setVerticalTextPosition(JLabel.TOP);
        mechArmySize.setBounds(905,180,150,40);
        mechArmySize.setFont(new Font("Arial", Font.PLAIN, 14));
        mechArmySize.setText("");
        root.add(mechArmySize);


        message = new JLabel();
        message.setVerticalAlignment(JLabel.TOP);
        message.setVerticalTextPosition(JLabel.TOP);
        message.setOpaque(true);
        message.setForeground(Color.yellow);
        message.setBackground(Color.darkGray);
        message.setFont(new Font("Courier", Font.ITALIC, 14));
        message.setBounds(750,540,240,70);
        message.setBorder(new EmptyBorder(10,10,0,0));
        message.setText("");
        root.add(message);

        images();
        header = new JLabel(new ImageIcon(headerImage));
        header.setBounds(750,27,500,61);
        root.add(header);


        /*images();
        layoutBackground = new JLabel(new ImageIcon(background));
        layoutBackground.setBounds(0,0,1280, 800);
        root.add(layoutBackground);*/

        actionListener = e -> {
            String[] array = e.getActionCommand().split(" ");

            int x = Integer.valueOf(array[0]);
            int y = Integer.valueOf(array[1]);

            presenter.onTableItemClicked(new Position(x, y));

            if (Battlefield.battlefield[x][y].getStandingOnIt()) {
                mechProfile.setText(Battlefield.battlefield[x][y].getMech().toString());
                mechArmySize.setText("<html><font style=\"color: red;\">" +
                        String.valueOf(Battlefield.battlefield[x][y].getMech().getOwner().getUniqueMechs().size()) +
                        "</html>");
            } else {
                mechProfile.setText("");
                mechArmySize.setText("");
            }
        };

        presenter = new MainPresenter(this);
        // JOptionPane.showMessageDialog(null, "A basic JOptionPane message dialog");

    }

    @Override
    public void showBattlefield(Battlefield battlefield) {
        layoutButtons.removeAll();
        layoutButtons.repaint();

        for (int i = 0; i < Battlefield.battlefield.length; i++) {
            for (int j = 0; j < Battlefield.battlefield[i].length; j++) {
                JButton button = new JButton();

                button.setActionCommand(i + " " + j);
                button.addActionListener(actionListener);
                button.setBackground(Color.white);
                button.setBorderPainted(true);
                button.setBorder(BorderFactory.createLineBorder(Color.gray));
                button.setBounds(30 + i * 33,27 + j * 33, 30,30);
                button.setFont(new Font("Arial", Font.PLAIN, 13));
                button.getInsets(new Insets(0, 0, 0, 0));

                layoutButtons.add(button);

                button.setOpaque(true);

                Mech showMech = Battlefield.battlefield[i][j].getMech();

                if (Battlefield.battlefield[i][j].getStandingOnIt()) {

                    if (showMech.getOwner().equals(Table.playerOne)) {
                        if (showMech instanceof MechLight) {
                            button.setText("L");
                            button.setBackground(Color.orange);
                        } else if (showMech instanceof MechMedium) {
                            button.setText("M");
                            button.setBackground(Color.orange);
                        } else if (showMech instanceof MechHeavy) {
                            button.setText("H");
                            button.setBackground(Color.orange);
                        } else if (showMech instanceof MechAssault) {
                            button.setText("A");
                            button.setBackground(Color.orange);
                        }
                    }
                    if (showMech.getOwner().equals(Table.playerTwo)) {
                        if (showMech instanceof MechLight) {
                            button.setText("L");
                            button.setBackground(Color.green);
                        } else if (showMech instanceof MechMedium) {
                            button.setText("M");
                            button.setBackground(Color.green);
                        } else if (showMech instanceof MechHeavy) {
                            button.setText("H");
                            button.setBackground(Color.green);
                        } else if (showMech instanceof MechAssault) {
                            button.setText("A");
                            button.setBackground(Color.green);
                        }
                    }
                } else if (Battlefield.battlefield[i][j].isBarrier()) {
                    button.setText(Battlefield.battlefield[i][j].toString());
                    button.createToolTip();
                    button.setToolTipText("Sorry, this is an Barrier");
                }
            }
        }

//        layoutButtons.repaint();
    }

    @Override
    public void setSelection(Position position, boolean selection) {
        Component component = layoutButtons.getComponent(position.x * 20 + position.y);
        ((JButton) component).setBorder(BorderFactory.createLineBorder(selection ? Color.red : Color.gray));

        System.out.println(selection);
    }

    @Override
    public void showPlayers(List<Player> players) {
        layoutPlayers.removeAll();

        for (Player player : players) {
            layoutPlayers.add(new Label(player.getName()));
        }
    }

    @Override
    public void selectCurrentPlayer(Player player) {
        for (int i = 0; i < layoutPlayers.getComponentCount(); i++) {
           Label component = (Label) layoutPlayers.getComponent(i);


            if (component.getText().equals(player.getName())) {
               component.setBackground(Color.GREEN);
           } else {
               component.setBackground(null);
           }
        }

        layoutPlayers.repaint();

    }

    @Override
    public void highlightRange(Range range, Position center) {
        for (int i = range.topLeft.x; i <= range.bottomRight.x; i++) {
            for (int j = range.topLeft.y; j <= range.bottomRight.y; j++) {
                if (center == null ||
                        center.x == i || center.y == j) {
                    int index = i * 20 + j;
                    /*if (Battlefield.battlefield[i][j].getStandingOnIt()) {
                        ((JButton) layoutButtons.getComponent(index))
                                .setBorder(BorderFactory.createLineBorder(Color.cyan));
                    }*/
                }
            }
        }
    }

    @Override
    public void removeHighlight() {
        for (int i = 0; i < layoutButtons.getComponentCount(); i++) {
            ((JButton) layoutButtons.getComponent(i))
                    .setBorder(BorderFactory.createLineBorder(Color.gray));
        }
    }

    @Override
    public void highlightAttackableItem(Position position, boolean highlight) {
        JButton button = (JButton) layoutButtons.getComponent(position.x * 20 + position.y);
        button.setBorder(BorderFactory.createLineBorder(highlight ? Color.cyan : Color.gray));

        if (highlight) {
            message(2);
        }

    }

    @Override
    public void message(int messageCode) {
        switch(messageCode) {
            case 0: message.setText(" ");
            break;
            case 1: message.setText("Out of Range!");
            break;
            case 2: message.setText("<html>There is attackable Mech<br> in the near!</html>");
            break;
            case 3: message.setText("<html>Game Over!<br> The Player One Won</html>");
            break;
            case 4: message.setText("<html>Game Over!<br> The Player One Won</html>");
        }
    }

    public void images() {
        try {
            backgroundImage = ImageIO.read(new File("/Users/user/Works/Flow/Java/Projects/MechWarriors/src/com/flow/mechwarriors/images/background.jpg"));
            headerImage = ImageIO.read(new File("/Users/user/Works/Flow/Java/Projects/MechWarriors/src/com/flow/mechwarriors/images/mech-header.jpg"));
        } catch (
            IOException exp) {
            exp.printStackTrace();
        }
    }
}
