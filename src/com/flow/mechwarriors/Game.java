package com.flow.mechwarriors;

import com.flow.mechwarriors.items.BattlefieldItem;
import com.flow.mechwarriors.items.Mech;

import java.util.ArrayList;
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
        return players.get((int) currentPlayerIndex);
    }

    public void nextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + players.size());
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

    public void attack(Position position, int attackForce) {

        Mech damagedMech = Battlefield.battlefield[position.x][position.y].getMech();

        int[] head = damagedMech.getHead();                     //5%
        int[] leftArm = damagedMech.getLeftArm();               //10%
        int[] rightArm = damagedMech.getRightArm();             //10%
        int[] leftShoulder = damagedMech.getLeftShoulder();     //13%
        int[] rightShoulder = damagedMech.getRightShoulder();   //13%
        int[] leftLeg = damagedMech.getLeftLeg();               //15%
        int[] rightLeg = damagedMech.getLeftLeg();              //15%
        int[] torso = damagedMech.getTorso();                   //19%


        int random = (int) (Math.random() * (100 - 1 + 1) + 1);
        int hitChance = chance(random);

        switch (hitChance) {
            case 0:
                setArmorAndHpValues(head, attackForce);

            case 1:
                setArmorAndHpValues(leftArm, attackForce);

            case 2:
                setArmorAndHpValues(rightArm, attackForce);

            case 3:
                setArmorAndHpValues(leftShoulder, attackForce);

            case 4:
                setArmorAndHpValues(rightShoulder, attackForce);

            case 5:
                setArmorAndHpValues(leftLeg, attackForce);

            case 6:
                setArmorAndHpValues(rightLeg, attackForce);

            case 7:
                setArmorAndHpValues(torso, attackForce);
        }

        if (head[0] == 0 && head[1] == 0 || torso[0] == 0 && torso[1] == 0) {
            Battlefield.battlefield[position.x][position.y].setStandingOnIt(false);
            if (Table.playerOne.getUniqueMechs().contains(damagedMech)) {
                Table.playerOne.getUniqueMechs().remove(damagedMech);
            } else {
                Table.playerTwo.getUniqueMechs().remove(damagedMech);
            }
        }

        System.out.println(("Player One: " + Table.playerOne.getUniqueMechs().size()));
        System.out.println(("Player Two: " + Table.playerTwo.getUniqueMechs().size()));

    }

    public int chance(int num) {
        if (num <= 5 && num >= 0) return 0;
        if (num <= 15 && num > 5) return 1;
        if (num <= 25 && num > 15) return 2;
        if (num <= 38 && num > 25) return 3;
        if (num <= 51 && num > 38) return 4;
        if (num <= 67 && num > 51) return 5;
        if (num <= 83 && num > 68) return 6;
        if (num <= 100 && num > 84) return 7;
        return -1;
    }

    public void setArmorAndHpValues(int[] bodyOfParts, int attackForce) {
        if (bodyOfParts[0] > 0) {
            int temp = bodyOfParts[0];
            bodyOfParts[0] = temp - attackForce;
            if (bodyOfParts[0] <= 0) {
                bodyOfParts[0] = 0;
            }
        } else if (bodyOfParts[0] == 0) {
            int temp = bodyOfParts[1];
            bodyOfParts[1] = temp - attackForce;
            if (bodyOfParts[1] <= 0) {
                bodyOfParts[1] = 0;
            }
        }

    }
}
