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
import java.util.List;

public class View extends JFrame implements MainContract.View {

    private ActionListener actionListener;

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
    private JLabel mechImage;
    private JLabel mechDraftImage;
    private BufferedImage backgroundImage;
    private BufferedImage headerImage;
    private BufferedImage mechLightImage1;
    private BufferedImage mechMediumImage1;
    private BufferedImage mechHeavyImage1;
    private BufferedImage mechAssaultImage1;
    private BufferedImage mechLightImage2;
    private BufferedImage mechMediumImage2;
    private BufferedImage mechHeavyImage2;
    private BufferedImage mechAssaultImage2;
    private BufferedImage barrierImage;
    private BufferedImage mechDefaultDraftImage;
    private BufferedImage mechLeftShoulderArmDraftImage;
    private BufferedImage mechRightShoulderArmDraftImage;
    private BufferedImage mechLeftLegDraftImage;
    private BufferedImage mechRightLegDraftImage;
    private BufferedImage mechLeftArmDraftImage;
    private BufferedImage mechRightArmDraftImage;


    public View() {
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
        mechProfileTags.setBounds(750,260,120, 300);
        mechProfileTags.setFont(new Font("Arial", Font.PLAIN, 14));
        mechProfileTags.setText("<html>" +
                "Mech's type:<br>" +
                "Mech's name:<br>" +
                "Weapon:<br>" +
                "Weapon range:<br>" +
                "Attack Force:<br>" +
                "Step range:<br><br><br>" +
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
        mechProfile.setBounds(860,260,150,300);
        mechProfile.setText("");
        root.add(mechProfile);

        mechArmy = new JLabel();
        mechArmy.setVerticalAlignment(JLabel.TOP);
        mechArmy.setVerticalTextPosition(JLabel.TOP);
        mechArmy.setBounds(750,195,240,40);
        mechArmy.setFont(new Font("Arial", Font.PLAIN, 14));
        mechArmy.setText("<html>" + "Size of the Mech Army:<br>" + "- - - - - - - - - - - - - - - - - - - - - - - - - - - -<br></html>");
        root.add(mechArmy);

        mechArmySize = new JLabel();
        mechArmySize.setVerticalAlignment(JLabel.TOP);
        mechArmySize.setVerticalTextPosition(JLabel.TOP);
        mechArmySize.setBounds(905,195,150,40);
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
        message.setBounds(750,580,240,80);
        message.setBorder(new EmptyBorder(10,10,0,0));
        message.setText("");
        root.add(message);

        images();
        header = new JLabel(new ImageIcon(headerImage));
        header.setBounds(750,27,500,61);
        root.add(header);

        mechImage = new JLabel();
        mechImage.setBounds(1010,180,240,200);
        root.add(mechImage);

        mechDraftImage = new JLabel();
        mechDraftImage.setBounds(1020,365,240,240);
        root.add(mechDraftImage);


        /*images();
        layoutBackground = new JLabel(new ImageIcon(background));
        layoutBackground.setBounds(0,0,1280, 800);
        root.add(layoutBackground);*/

        actionListener = e -> {
            String[] array = e.getActionCommand().split(" ");

            int x = Integer.valueOf(array[0]);
            int y = Integer.valueOf(array[1]);

            presenter.onTableItemClicked(new Position(x, y));

            Mech showMech = Battlefield.battlefield[x][y].getMech();

            if (Battlefield.battlefield[x][y].isBarrier()) {
                mechImage.setIcon(new ImageIcon(barrierImage));
                mechProfile.setText("");
                mechArmySize.setText("");
                mechDraftImage.setIcon(null);

            } else if (Battlefield.battlefield[x][y].getStandingOnIt()) {
                mechProfile.setText(showMech.toString());
                mechArmySize.setText("<html><font style=\"color: red;\">" +
                        String.valueOf(showMech.getOwner().getUniqueMechs().size()) + "</html>");
                mechDraftImage.setIcon(new ImageIcon(mechDefaultDraftImage));

                if (showMech.getOwner().equals(Table.playerOne)) {

                    if (showMech instanceof MechLight) {
                        mechImage.setIcon(new ImageIcon(mechLightImage1));
                    } else if (showMech instanceof MechMedium) {
                        mechImage.setIcon(new ImageIcon(mechMediumImage1));
                    } else if (showMech instanceof MechHeavy) {
                        mechImage.setIcon(new ImageIcon(mechHeavyImage1));
                    } else if (showMech instanceof MechAssault) {
                        mechImage.setIcon(new ImageIcon(mechAssaultImage1));
                    }
                }

                if (showMech.getOwner().equals(Table.playerTwo)) {
                    if (showMech instanceof MechLight) {
                        mechImage.setIcon(new ImageIcon(mechLightImage2));
                    } else if (showMech instanceof MechMedium) {
                        mechImage.setIcon(new ImageIcon(mechMediumImage2));
                    } else if (showMech instanceof MechHeavy) {
                        mechImage.setIcon(new ImageIcon(mechHeavyImage2));
                    } else if (showMech instanceof MechAssault) {
                        mechImage.setIcon(new ImageIcon(mechAssaultImage2));
                    }
                }

            } else {
                mechProfile.setText("");
                mechArmySize.setText("");
                mechImage.setIcon(null);
                mechDraftImage.setIcon(null);
            }
        };

        presenter = new MainPresenter(this);
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
                button.setBounds(30 + i * 33,27 + j * 33, 28,28);
                button.setFont(new Font("Arial", Font.PLAIN, 12));
                button.getInsets(new Insets(0, 0, 0, 0));

                layoutButtons.add(button);

                button.setOpaque(true);

                Mech foundMech = Battlefield.battlefield[i][j].getMech();

                if (Battlefield.battlefield[i][j].getStandingOnIt()) {

                    if (foundMech.getOwner().equals(Table.playerOne)) {
                        if (foundMech instanceof MechLight) {
                            button.setText("L");
                            button.setBackground(Color.orange);
                        } else if (foundMech instanceof MechMedium) {
                            button.setText("M");
                            button.setBackground(Color.orange);
                        } else if (foundMech instanceof MechHeavy) {
                            button.setText("H");
                            button.setBackground(Color.orange);
                        } else if (foundMech instanceof MechAssault) {
                            button.setText("A");
                            button.setBackground(Color.orange);
                        }
                    }
                    if (foundMech.getOwner().equals(Table.playerTwo)) {
                        if (foundMech instanceof MechLight) {
                            button.setText("L");
                            button.setBackground(Color.green);
                        } else if (foundMech instanceof MechMedium) {
                            button.setText("M");
                            button.setBackground(Color.green);
                        } else if (foundMech instanceof MechHeavy) {
                            button.setText("H");
                            button.setBackground(Color.green);
                        } else if (foundMech instanceof MechAssault) {
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
    }

    @Override
    public void setSelection(Position position, boolean selection) {
        Component component = layoutButtons.getComponent(position.x * 20 + position.y);
        ((JButton) component).setBorder(BorderFactory.createLineBorder(selection ? Color.red : Color.gray));

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
        button.setBorder(BorderFactory.createLineBorder(highlight ? Color.magenta : Color.gray));

        if (highlight) {
            message(2);
        }

    }

    @Override
    public void message(int messageCode) {
        switch(messageCode) {
            case 0: message.setText(" ");
                break;
            case 1: message.setText("<html>Out of Range:<br>- invalid step or<br>- invalid attack or<br> - barrier is on the way!</html>");
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
            mechLightImage1 = ImageIO.read(new File("/Users/user/Works/Flow/Java/Projects/MechWarriors/src/com/flow/mechwarriors/images/mechLight1.png"));
            mechMediumImage1 = ImageIO.read(new File("/Users/user/Works/Flow/Java/Projects/MechWarriors/src/com/flow/mechwarriors/images/mechMedium1.png"));
            mechHeavyImage1 = ImageIO.read(new File("/Users/user/Works/Flow/Java/Projects/MechWarriors/src/com/flow/mechwarriors/images/mechHeavy1.png"));
            mechAssaultImage1 = ImageIO.read(new File("/Users/user/Works/Flow/Java/Projects/MechWarriors/src/com/flow/mechwarriors/images/mechAssault1.png"));
            mechLightImage2 = ImageIO.read(new File("/Users/user/Works/Flow/Java/Projects/MechWarriors/src/com/flow/mechwarriors/images/mechLight2.png"));
            mechMediumImage2 = ImageIO.read(new File("/Users/user/Works/Flow/Java/Projects/MechWarriors/src/com/flow/mechwarriors/images/mechMedium2.png"));
            mechHeavyImage2 = ImageIO.read(new File("/Users/user/Works/Flow/Java/Projects/MechWarriors/src/com/flow/mechwarriors/images/mechHeavy2.png"));
            mechAssaultImage2 = ImageIO.read(new File("/Users/user/Works/Flow/Java/Projects/MechWarriors/src/com/flow/mechwarriors/images/mechAssault2.png"));
            barrierImage = ImageIO.read(new File("/Users/user/Works/Flow/Java/Projects/MechWarriors/src/com/flow/mechwarriors/images/barrier.png"));
            mechDefaultDraftImage = ImageIO.read(new File("/Users/user/Works/Flow/Java/Projects/MechWarriors/src/com/flow/mechwarriors/images/mech-default-draft.png"));
            mechLeftShoulderArmDraftImage = ImageIO.read(new File("/Users/user/Works/Flow/Java/Projects/MechWarriors/src/com/flow/mechwarriors/images/mech-leftShoulderArm-draft.png"));
            mechRightShoulderArmDraftImage = ImageIO.read(new File("/Users/user/Works/Flow/Java/Projects/MechWarriors/src/com/flow/mechwarriors/images/mech-rightShoulderArm-draft.png"));
            mechLeftLegDraftImage = ImageIO.read(new File("/Users/user/Works/Flow/Java/Projects/MechWarriors/src/com/flow/mechwarriors/images/mech-leftLeg-draft.png"));
            mechRightLegDraftImage = ImageIO.read(new File("/Users/user/Works/Flow/Java/Projects/MechWarriors/src/com/flow/mechwarriors/images/mech-rightLeg-draft.png"));
            mechLeftArmDraftImage = ImageIO.read(new File("/Users/user/Works/Flow/Java/Projects/MechWarriors/src/com/flow/mechwarriors/images/mech-leftArm-draft.png"));
            mechRightArmDraftImage = ImageIO.read(new File("/Users/user/Works/Flow/Java/Projects/MechWarriors/src/com/flow/mechwarriors/images/mech-rightArm-draft.png"));
        } catch (
                IOException exp) {
            exp.printStackTrace();
        }
    }

    public void setMechDraft(int state) {
        images();
        switch (state) {
            case 0: mechDraftImage.setIcon(null);
                break;

            case 1: mechDraftImage.setIcon(new ImageIcon(mechLeftShoulderArmDraftImage));
                break;

            case 2: mechDraftImage.setIcon(new ImageIcon(mechRightShoulderArmDraftImage));
                break;

            case 3: mechDraftImage.setIcon(new ImageIcon(mechLeftLegDraftImage));
                break;

            case 4: mechDraftImage.setIcon(new ImageIcon(mechRightLegDraftImage));
                break;

            case 5: mechDraftImage.setIcon(new ImageIcon(mechLeftArmDraftImage));
                break;

            case 6: mechDraftImage.setIcon(new ImageIcon(mechRightArmDraftImage));
                break;
        }
    }
}

