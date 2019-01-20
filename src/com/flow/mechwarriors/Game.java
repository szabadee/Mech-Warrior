package com.flow.mechwarriors;

import com.flow.mechwarriors.items.CellItem;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players = new ArrayList<>();

    private Battlefield battlefield = new Battlefield();
    private Position selectedPosition;

    private int currentPlayerIndex = 0;

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

    public CellItem getBattlefieldItem(Position position) {
        return Battlefield.battlefield[position.x][position.y];
    }

    public void moveBattlefieldItem(Position from, Position to) {
        CellItem battlefieldItem = Battlefield.battlefield[from.x][from.y];
        CellItem battlefieldNextItem = Battlefield.battlefield[to.x][to.y];

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
        return players.get(currentPlayerIndex);
    }

    public void nextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public boolean isValidStep(Position from, Position to) {
        CellItem startPosition = getBattlefieldItem(from);

        return startPosition != null &&
                (from.x == to.x || from.y == to.y) &&
                Math.abs(from.x - to.x) <= startPosition.getMech().maxStep() &&
                Math.abs(from.y - to.y) <= startPosition.getMech().maxStep();
    }

    public boolean isValidAttack(Position from, Position to) {
        CellItem mech1 = getBattlefieldItem(from);
        CellItem mech2 = getBattlefieldItem(to);

        return mech1 != null && mech2 != null &&
                !mech1.getMech().getOwner().equals(mech2.getMech().getOwner()) &&
                Math.abs(from.x - to.x) <= mech1.getMech().maxAttack() &&
                Math.abs(from.y - to.y) <= mech1.getMech().maxAttack();
    }

    public void removeItem(Position position) {
        Battlefield.battlefield[position.x][position.y].setStandingOnIt(false);

        CellItem damagedMech = Battlefield.battlefield[position.x][position.y].getMech();


    }
}
