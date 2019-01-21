package com.flow.mechwarriors;

import com.flow.mechwarriors.items.BattlefieldItem;
import com.flow.mechwarriors.items.Mech;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    private List<Player> players = new ArrayList<>();

    public Battlefield battlefield = new Battlefield();
    private Position selectedPosition;

    private float currentPlayerIndex = Math.round(Math.random());

    public Game() {
        players.add(Table.playerOne);
        players.add(Table.playerTwo);
    }

    public void selectItem(Position position) {
        selectedPosition = position;
    }

    public void deselectItem() {
        selectedPosition = null;
    }

    public Position getSelectedPosition() {
        return selectedPosition;
    }

    public BattlefieldItem getBattlefieldItem(Position position) {
        return Battlefield.battlefield[position.x][position.y];
    }

    public void moveBattlefieldItem(Position from, Position to) {
        BattlefieldItem battlefieldItem = Battlefield.battlefield[from.x][from.y];
        BattlefieldItem battlefieldNextItem = Battlefield.battlefield[to.x][to.y];

        if (battlefieldItem.getStandingOnIt() &&
                !battlefieldNextItem.getStandingOnIt() &&
                !battlefieldNextItem.isBarrier()) {
            battlefieldNextItem.setMech(battlefieldItem.getMech());
            battlefieldItem.setStandingOnIt(false);
            battlefieldNextItem.setStandingOnIt(true);
        }

    }

    public Battlefield getBattlefield() {
        return battlefield;
    }

    public Player getCurrentPlayer() {
        System.out.println(currentPlayerIndex);
        return players.get((int) currentPlayerIndex);
    }

    public void nextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public boolean isValidStep(Position from, Position to) {
        BattlefieldItem startPosition = getBattlefieldItem(from);
        
        return startPosition != null &&
                (from.x == to.x || from.y == to.y) &&
                Math.abs(from.x - to.x) <= startPosition.getMech().maxStep() &&
                Math.abs(from.y - to.y) <= startPosition.getMech().maxStep();
    }

    public boolean isValidAttack(Position from, Position to) {
        BattlefieldItem mech1 = getBattlefieldItem(from);
        BattlefieldItem mech2 = getBattlefieldItem(to);

        return mech1.getStandingOnIt() && mech2.getStandingOnIt() &&
                !mech1.getMech().getOwner().equals(mech2.getMech().getOwner()) &&
                Math.abs(from.x - to.x) <= mech1.getMech().maxAttack() &&
                Math.abs(from.y - to.y) <= mech1.getMech().maxAttack();
    }

    public void attack(Position position) {

        Mech damagedMech = Battlefield.battlefield[position.x][position.y].getMech();

        int[] torso = damagedMech.getTorso();

        if (torso[0] > 0) {
            torso[0] = torso[0] - 5;
            if (torso[0] - 5 <= 0) {
                torso[0] = 0;
            }
        } else if (torso[0] == 0) {
            torso[1] = torso[1] - 5;
            if (torso[1] - 5 <= 0) {
                torso[1] = 0;
                damagedMech.setStandingOnIt(false);
                if (Table.playerOne.getUniqueMechs().contains(damagedMech)) {
                    Table.playerOne.getUniqueMechs().remove(damagedMech);
                } else {
                    Table.playerTwo.getUniqueMechs().remove(damagedMech);
                }
            }
        }

        damagedMech.setTorso(torso);

        System.out.println(Arrays.toString(damagedMech.getTorso()));

    }
}
