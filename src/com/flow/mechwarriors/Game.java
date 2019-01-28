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

        if (battlefieldItem.getStandingOnIt() && battlefieldItem.getMech().getIsMovable() &&
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
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public boolean isValidStep(Position from, Position to) {
        BattlefieldItem startPosition = getBattlefieldItem(from);

        boolean result = startPosition != null &&
                (from.x == to.x || from.y == to.y) &&
                Math.abs(from.x - to.x) <= startPosition.getMech().maxStep() &&
                Math.abs(from.y - to.y) <= startPosition.getMech().maxStep();

        if (from.x != to.x) {
            int step = from.x < to.x ? 1 : -1;
            for (int i = from.x + step; i != to.x; i += step) {
                if (getBattlefieldItem(new Position(i, from.y)).isBarrier()) {
                    result = false;
                }
            }
        }

        if (from.y != to.y) {
            int step = from.y < to.y ? 1 : -1;
            for (int i = from.y + step; i != to.y; i += step) {
                if (getBattlefieldItem(new Position(from.x, i)).isBarrier()) {
                    result = false;
                }
            }
        }

        return result;
    }

    public boolean isValidAttack(Position from, Position to) {
        BattlefieldItem mech1 = getBattlefieldItem(from);
        BattlefieldItem mech2 = getBattlefieldItem(to);

        boolean result = mech1.getStandingOnIt() && mech2.getStandingOnIt() &&
                !mech1.getMech().getOwner().equals(mech2.getMech().getOwner()) &&
                Math.abs(from.x - to.x) <= mech1.getMech().maxAttack() &&
                Math.abs(from.y - to.y) <= mech1.getMech().maxAttack();

        if (from.x != to.x) {
            int step = from.x < to.x ? 1 : -1;
            for (int i = from.x + step; i != to.x; i += step) {
                if (getBattlefieldItem(new Position(i, from.y)).isBarrier()) {
                    result = false;
                }
            }
        }

        if (from.y != to.y) {
            int step = from.y < to.y ? 1 : -1;
            for (int i = from.y + step; i != to.y; i += step) {
                if (getBattlefieldItem(new Position(from.x, i)).isBarrier()) {
                    result = false;
                }
            }
        }

        return result;
    }

    public int attack(Position position, int attackForce) {

        Mech damagedMech = Battlefield.battlefield[position.x][position.y].getMech();

        int[] head = damagedMech.getHead();                     //5%
        int[] leftArm = damagedMech.getLeftArm();               //10%
        int[] rightArm = damagedMech.getRightArm();             //10%
        int[] leftShoulder = damagedMech.getLeftShoulder();     //13%
        int[] rightShoulder = damagedMech.getRightShoulder();   //13%
        int[] leftLeg = damagedMech.getLeftLeg();               //15%
        int[] rightLeg = damagedMech.getRightLeg();             //15%
        int[] torso = damagedMech.getTorso();                   //19%

        int random = (int) (Math.random() * (100 - 1 + 1) + 1);
        int hitChance = chance(random);

        int armor = 0;
        int hp = 1;

        switch (hitChance) {
            case 0:
                setArmorAndHpValues(head, armor, hp, attackForce);
                break;

            case 1:
                setArmorAndHpValues(leftArm, armor, hp, attackForce);
                break;

            case 2:
                setArmorAndHpValues(rightArm, armor, hp, attackForce);
                break;

            case 3:
                setArmorAndHpValues(leftShoulder, armor, hp, attackForce);
                break;

            case 4:
                setArmorAndHpValues(rightShoulder, armor, hp, attackForce);
                break;

            case 5:
                setArmorAndHpValues(leftLeg, armor, hp, attackForce);
                break;

            case 6:
                setArmorAndHpValues(rightLeg, armor, hp, attackForce);
                break;

            case 7:
                setArmorAndHpValues(torso, armor, hp, attackForce);
                break;
        }

        if (head[armor] == 0 && head[hp] == 0 || torso[armor] == 0 && torso[hp] == 0) {
            Battlefield.battlefield[position.x][position.y].setStandingOnIt(false);
            if (Table.playerOne.getUniqueMechs().contains(damagedMech)) {
                Table.playerOne.getUniqueMechs().remove(damagedMech);
            } else {
                Table.playerTwo.getUniqueMechs().remove(damagedMech);
            }
            return 0;
        }

        if (leftShoulder[armor] == 0 && leftShoulder[hp] == 0) {
            leftArm[armor] = 0;
            leftArm[hp] = 0;
            return 1;
        }

        if (rightShoulder[armor] == 0 && rightShoulder[hp] == 0) {
            rightArm[armor] = 0;
            rightArm[hp] = 0;
            damagedMech.setCanAttack(false);
            return 2;
        }

        if (leftLeg[armor] == 0 && leftLeg[hp] == 0) {
            damagedMech.setMovable(false);
            return 3;
        }

        if (rightLeg[armor] == 0 && rightLeg[hp] == 0) {
            damagedMech.setMovable(false);
            return 4;
        }

        if (leftArm[armor] == 0 && leftArm[hp] == 0) {
            return 5;
        }

        if (rightArm[armor] == 0 && rightArm[hp] == 0) {
            return 6;
        }

        return 7;

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

    public void setArmorAndHpValues(int[] bodyOfParts, int armor, int hp, int attackForce) {
        if (bodyOfParts[armor] > 0) {
            int temp = bodyOfParts[armor];
            bodyOfParts[armor] = temp - attackForce;
            if (bodyOfParts[armor] <= 0) {
                bodyOfParts[armor] = 0;
            }
        } else if (bodyOfParts[armor] == 0) {
            int temp = bodyOfParts[hp];
            bodyOfParts[hp] = temp - attackForce;
            if (bodyOfParts[hp] <= 0) {
                bodyOfParts[hp] = 0;
            }
        }
    }
}
