package com.flow.mechwarriors;

import com.flow.mechwarriors.items.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
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
    private JLabel mechProfile;


    public Main() {
        setTitle("Mech Warrior tabletop mini");
        setSize(800, 555);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        /* try {
            UIManager.setLookAndFeel(
                    UIManager.getCrossPlatformLookAndFeelClassName());
        }
        catch (UnsupportedLookAndFeelException e) {
        }
        catch (ClassNotFoundException e) {
        }
        catch (InstantiationException e) {
        }
        catch (IllegalAccessException e) {
        } */

        JPanel root = new JPanel();
        root.setLayout(null);
        add(root);

        layoutButtons = new JPanel();
        layoutButtons.setBounds(0, 0, 535, 555);
        layoutButtons.setBackground(Color.LIGHT_GRAY);
        layoutButtons.setLayout(null);
        root.add(layoutButtons);

        layoutPlayers = new JPanel();
        layoutPlayers.setBounds(560, 20, 200, 60);
        layoutPlayers.setBackground(Color.LIGHT_GRAY);
        layoutPlayers.setLayout(new GridLayout(2, 1));
        layoutPlayers.getInsets(new Insets(0,15,0,0));
        root.add(layoutPlayers);

        JLabel mechProfileTags = new JLabel();
        mechProfileTags.setVerticalAlignment(JLabel.TOP);
        mechProfileTags.setVerticalTextPosition(JLabel.TOP);
        mechProfileTags.setBounds(560,100,90, 240);
        mechProfileTags.setText("<html><font style=\"font-family: 'Arial'; font-size: 12pt;\">" +
                "Mech's type:<br>Mech's name:<br>Weapon:<br>Weapon range:<br>Step range:<br><br>" +
                "- - - - - - - - - - - -<br>Left leg:<br>Right leg:<br>Left arm:<br>Right arm:<br>" +
                "Left shoulder:<br>Right shoulder:<br>Torso:<br>Head:</html>");
        root.add(mechProfileTags);

        mechProfile = new JLabel();
        mechProfile.setVerticalAlignment(JLabel.TOP);
        mechProfile.setVerticalTextPosition(JLabel.TOP);
        mechProfile.setBounds(660,100,150,240);
        mechProfile.setText("");
        root.add(mechProfile);

        actionListener = e -> {
            String[] array = e.getActionCommand().split(" ");

            int x = Integer.valueOf(array[0]);
            int y = Integer.valueOf(array[1]);

            presenter.onTableItemClicked(new Position(x, y));

            if (Battlefield.battlefield[x][y].getStandingOnIt()) {
                mechProfile.setText(String.valueOf(Battlefield.battlefield[x][y].getMech()));
            }
        };

        presenter = new MainPresenter(this);
    }

    @Override
    public void showBattlefield(Battlefield battlefield) {
        layoutButtons.removeAll();

        for (int i = 0; i < Battlefield.battlefield.length; i++) {
            for (int j = 0; j < Battlefield.battlefield[i].length; j++) {
                JButton button = new JButton();

                button.setActionCommand(i + " " + j);
                button.addActionListener(actionListener);
                button.setBackground(Color.white);
                button.setBorderPainted(true);
                button.setBorder(BorderFactory.createLineBorder(Color.gray));
                button.setBounds(20 + i * 25,20 + j * 25, 20,20);
                button.setFont(new Font("Arial", Font.PLAIN, 9));
                button.getInsets(new Insets(0, 0, 0, 0));

                layoutButtons.add(button);

                button.setOpaque(true);

                if (Battlefield.battlefield[i][j].getStandingOnIt()) {
                    if (Battlefield.battlefield[i][j].getMech() instanceof MechLight) {
                        button.setText("L");
                        button.setBackground(Color.orange);
                    } else if (Battlefield.battlefield[i][j].getMech() instanceof MechMedium) {
                        button.setText("M");
                    } else if (Battlefield.battlefield[i][j].getMech() instanceof MechHeavy) {
                        button.setText("H");
                    } else if (Battlefield.battlefield[i][j].getMech() instanceof MechAssault) {
                        button.setText("A");
                    }
                } else {
                    button.setText(Battlefield.battlefield[i][j].toString());
                }
            }
        }
    }

    @Override
    public void setSelection(Position position, boolean selection) {
        Component component = layoutButtons.getComponent(position.x * 20 + position.y);
        component.setBackground(selection ? Color.RED : Color.white);

        System.out.println(component);
        System.out.println(position.x + " " + position.y);
    }

    @Override
    public void updateBattlefieldItem(Position position, CellItem cellItem) {
        JButton button = (JButton) layoutButtons.getComponent(position.x * 20 + position.y);

        button.setText(cellItem != null ? cellItem.toString() : null);
    }

    @Override
    public int selectFromList(String[] list) {
        return 0;
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

    }

    @Override
    public void removeHighLight() {

    }

}
